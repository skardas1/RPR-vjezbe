package ba.unsa.etf.rpr.lv10i11;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GradController {
    @FXML
    private TextField fieldNazivGrada;

    @FXML
    private TextField fieldBrojStanovnika;

    @FXML
    private ChoiceBox<Drzava> choiceDrzava;

    @FXML
    private Button btnOk;

    @FXML
    private Button btnCancel;
    private TableView<Grad> tableViewGradovi;
    private List<Drzava> drzave;
    private ObservableList<Grad> gradoviObservableList = FXCollections.observableArrayList();

    public void setGradoviObservableList(ObservableList<Grad> gradoviObservableList) {
        this.gradoviObservableList = gradoviObservableList;
    }

    public void setDrzave(List<Drzava> drzave) {
        this.drzave = drzave;
        choiceDrzava.getItems().setAll(drzave);
    }
    private final GeografijaDAO geografijaDAO;

    public GradController() {
        this.geografijaDAO = new GeografijaDAO();
    }

    @FXML
    public void initialize() {

        List<Drzava> drzave = geografijaDAO.drzave();


        if (choiceDrzava != null) {

            ObservableList<Drzava> observableDrzave = FXCollections.observableArrayList(drzave);


            choiceDrzava.setItems(observableDrzave);

        } else {
            System.out.println("ChoiceBox nije inicijaliziran!");
        }
    }


    @FXML
    public void handleOkButtonClick() {

        String imeGrada = fieldNazivGrada.getText();
        int brojStanovnika = Integer.parseInt(fieldBrojStanovnika.getText());
        Drzava drzava=choiceDrzava.getValue();

        Grad noviGrad = new Grad(brojStanovnika, imeGrada, drzava);


        geografijaDAO.dodajGrad(noviGrad);

        gradoviObservableList.add(noviGrad);
        tableViewGradovi.setItems(gradoviObservableList);

        tableViewGradovi.refresh();


}

    public void setTableViewGradovi(TableView<Grad> tableViewGradovi) {
        this.tableViewGradovi=tableViewGradovi;
    }


    @FXML
    private void handleCancelButtonClick() {
        fieldNazivGrada.clear();
        fieldBrojStanovnika.clear();
        choiceDrzava.setValue(null);

        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
}
