package ba.unsa.etf.rpr.lv10i11;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HelloController  {
    @FXML
    private TableView<Grad> tableViewGradovi;

    @FXML
    private TableColumn<Grad, Integer> colGradId;

    @FXML
    private TableColumn<Grad, String> colNazivGrad;

    @FXML
    private TableColumn<Grad, Integer> colGradStanovnika;

    @FXML
    private TableColumn<Grad, Drzava> colGradDrzava;

    @FXML
    private Button btnDodajDrzavu;

    @FXML
    private Button btnDodajGrad;


    private DrzavaController drzavaController;
    private GradController gradController;
    private GeografijaDAO geografijaDAO;
    private ChoiceBox<Drzava> choiceDrzava;
    private ObservableList<Grad> gradoviObservableList = FXCollections.observableArrayList();
    private ObservableList<Grad> drzaveObservableList = FXCollections.observableArrayList();


    public HelloController()
    {
        this.geografijaDAO=new GeografijaDAO();
    }

    public void setDrzavaController(DrzavaController drzavaController)
    {
        this.drzavaController=drzavaController;
    }

    public void setGradController(GradController gradController)
    {
        this.gradController=gradController;
    }


    public void setGradovi(List<Grad> gradovi) {
        tableViewGradovi.getItems().setAll(gradovi);
    }
    @FXML
    public void handleDodajDrzavuButton(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("drzava.fxml"));
            Parent root = loader.load();

            DrzavaController drzavaController = loader.getController();
            drzavaController.setDrzaveObservableList(drzaveObservableList);
            drzavaController.setTableViewGradovi(tableViewGradovi);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleDodajIliIzmijeniGradButton(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("grad.fxml"));
            Parent root = loader.load();

            GradController gradController = loader.getController();
            gradController.setGradoviObservableList(gradoviObservableList);
            gradController.setTableViewGradovi(tableViewGradovi);

            Stage stage = new Stage();
            stage.setTitle("Grad");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    // Metoda koja će se pozvati kada se inicijalizuje kontroler
    @FXML
    public void initialize() {
        // Inicijalizacija kolona
        colNazivGrad.setCellValueFactory(cellData -> cellData.getValue().nazivProperty());
        colGradStanovnika.setCellValueFactory(cellData -> cellData.getValue().broj_stanovnikaProperty().asObject());
        colGradId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colGradDrzava.setCellValueFactory(cellData ->
                Bindings.select(
                        cellData.getValue().drzavaProperty(),
                        "naziv"
                )
        );

        inicijalizujPodatkeIzBaze();
        tableViewGradovi.refresh();
    }


    public void inicijalizujPodatkeIzBaze() {
            ArrayList<Grad> gradovi = geografijaDAO.gradovi();
            tableViewGradovi.getItems().addAll(gradovi);
    }

    @FXML
    private void handleDeleteButtonClick() {
        Grad selektovanaDrzava = tableViewGradovi.getSelectionModel().getSelectedItem();

        if (selektovanaDrzava != null) {
            geografijaDAO.obrisiGrad(selektovanaDrzava);
            gradoviObservableList.remove(selektovanaDrzava);
            tableViewGradovi.refresh();
        } else {
            System.out.println("Nije selektovan red za brisanje.");
        }
    }

}