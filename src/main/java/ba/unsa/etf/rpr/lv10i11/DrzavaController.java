package ba.unsa.etf.rpr.lv10i11;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.List;

public class DrzavaController {
    @FXML
    private TextField fieldNazivDrzave;

    @FXML
    private ChoiceBox<Grad> choiceGrad;

    @FXML
    private Button btnOk;

    @FXML
    private Button btnCancel;

    private List<Grad> gradovi;
    private TableView<Grad> tableViewGradovi;
    public void setTableViewGradovi(TableView<Grad> tableViewGradovi) {
        this.tableViewGradovi=tableViewGradovi;
    }

    // private List<Drzava> drzave;
    private ObservableList<Grad> drzaveObservableList = FXCollections.observableArrayList();
    public void setDrzaveObservableList(ObservableList<Grad> drzaveObservableList) {
        this.drzaveObservableList = drzaveObservableList;
    }


    public void setGradovi(List<Grad> gradovi) {
        this.gradovi = gradovi;
        choiceGrad.getItems().setAll(gradovi);
    }

    private final GeografijaDAO geografijaDAO;

    public DrzavaController() {
        this.geografijaDAO = new GeografijaDAO();
    }



    @FXML
    private void dodajDrzavu() {
        String nazivDrzave = fieldNazivDrzave.getText();
        Grad odabraniGrad = choiceGrad.getValue();
        Drzava novaDrzava = new Drzava(nazivDrzave, odabraniGrad);

        geografijaDAO.dodajDrzavu(novaDrzava);
    }

    @FXML
    public void handleOkButtonClick() {

        String imeDrzave = fieldNazivDrzave.getText();
        //int brojStanovnika = Integer.parseInt(fieldBrojStanovnika.getText());
        Grad grad = choiceGrad.getValue();

        Drzava nova = new Drzava(imeDrzave, grad);


        geografijaDAO.dodajDrzavu(nova);

        drzaveObservableList.add(nova.getGlavni_grad());

        tableViewGradovi.setItems(drzaveObservableList);

        tableViewGradovi.refresh();
    }

    @FXML
    public void initialize() {

        List<Grad> gradovi = geografijaDAO.gradovi();


        if (choiceGrad != null) {

            ObservableList<Grad> observableGrad = FXCollections.observableArrayList(gradovi);


            choiceGrad.setItems(observableGrad);

        } else {
            System.out.println("ChoiceBox nije inicijaliziran!");
        }
    }
    @FXML
    private void handleCancelButtonClick() {

        fieldNazivDrzave.clear();
        choiceGrad.setValue(null);

        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
}
