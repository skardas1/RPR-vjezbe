package ba.unsa.etf.rpr.lv7i8;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class KorisniciController {
    @FXML
    private TextField ime;
    @FXML
    private TextField prezime;
    @FXML
    private TextField korisnicko_ime;
    @FXML
    private TextField email;
    @FXML
    private TextField lozinka;
    @FXML
    private ListView<Korisnik> lista;
    @FXML
    private KorisniciModel m;

   public KorisniciController(){
       // m.napuni(polje_ime.getText(),polje_prezime.getText(),polje_email.getText(),polje_korisnicko_ime.getText(),polje_lozinka.getText());
    }


    public KorisniciController(KorisniciModel model) {
        //ime=new SimpleStringProperty("");
        this.m = model;
    }


    public void initialize()
    {
        if(m!=null)
     {
       /*  if(m.getTrenutniKorisnik()!=null)
        {*/


       /*  ime.textProperty().bindBidirectional(((Korisnik)m.getTrenutniKorisnik()).imeProperty());
         prezime.textProperty().bindBidirectional(((Korisnik)m.getTrenutniKorisnik()).prezimeProperty());
         lozinka.textProperty().bindBidirectional(((Korisnik)m.getTrenutniKorisnik()).lozinkaProperty());
         email.textProperty().bindBidirectional(((Korisnik)m.getTrenutniKorisnik()).emailProperty());
         korisnicko_ime.textProperty().bindBidirectional(((Korisnik)m.getTrenutniKorisnik()).korisnicko_imeProperty());*/
         lista.setCellFactory(param -> new ListCell<Korisnik>() {
             @Override
             protected void updateItem(Korisnik korisnik, boolean empty) {
                 super.updateItem(korisnik, empty);
                 if (empty || korisnik == null || korisnik.getKorisnicko_ime() == null) {
                     setText(null);
                 } else {
                     setText(korisnik.getKorisnicko_ime());
                 }
             }
         });
             lista.setItems(m.getKorisnici());

             m.getKorisnici().addListener((ListChangeListener<? super Korisnik>) obs -> {
             lista.refresh();
         });
            lista.getSelectionModel().selectedItemProperty().addListener((obs,
                                                                          oldKorisnik, newKorisnik) -> {
                m.setTrenutniKorisnik(newKorisnik);
                lista.refresh();
            });


          lista.getSelectionModel().selectedItemProperty().addListener((obs, oldKorisnik, newKorisnik) -> {
     //m.trenutniKorisnikProperty()

                     //


                 //ovo mozda ne treba prvi if
                 /*if (oldKorisnik != null) {
                     ime.textProperty().bindBidirectional(oldKorisnik.imeProperty());
                     prezime.textProperty().bindBidirectional(oldKorisnik.prezimeProperty());
                     korisnicko_ime.textProperty().bindBidirectional(oldKorisnik.korisnicko_imeProperty());
                     email.textProperty().unbindBidirectional(oldKorisnik.emailProperty());
                     lozinka.textProperty().unbindBidirectional(oldKorisnik.lozinkaProperty());
                 }
*/
                 //ovo je ok  bilo
                if (newKorisnik != null) {
                    if (oldKorisnik != null)
                    {
                        ime.textProperty().unbindBidirectional(oldKorisnik.imeProperty());
                        prezime.textProperty().unbindBidirectional(oldKorisnik.prezimeProperty());
                        korisnicko_ime.textProperty().unbindBidirectional(oldKorisnik.korisnicko_imeProperty());
                        email.textProperty().unbindBidirectional(oldKorisnik.emailProperty());
                        lozinka.textProperty().unbindBidirectional(oldKorisnik.lozinkaProperty());
                    }

                    ime.textProperty().bindBidirectional(newKorisnik.imeProperty());
                    prezime.textProperty().bindBidirectional(newKorisnik.prezimeProperty());
                    korisnicko_ime.textProperty().bindBidirectional(newKorisnik.korisnicko_imeProperty());
                    email.textProperty().bindBidirectional(newKorisnik.emailProperty());
                    lozinka.textProperty().bindBidirectional(newKorisnik.lozinkaProperty());
                 }
                 else {
                     korisnicko_ime.setText("");
                     email.setText("");
                     ime.setText("");
                     prezime.setText("");
                     lozinka.setText("");
                 }
                // m.setTrenutniKorisnik(newKorisnik);
                 //lista.refresh();

                 //obicni bind
               /*  m.setTrenutniKorisnik(newKorisnik);

                ime.textProperty().bindBidirectional(m.getTrenutniKorisnik().imeProperty());
                 prezime.textProperty().bindBidirectional(m.getTrenutniKorisnik().prezimeProperty());
                 email.textProperty().bindBidirectional(m.getTrenutniKorisnik().emailProperty());
                 korisnicko_ime.textProperty().bindBidirectional(m.getTrenutniKorisnik().korisnicko_imeProperty());
                 lozinka.textProperty().bindBidirectional(m.getTrenutniKorisnik().lozinkaProperty());
                 lista.refresh();*/
             });





             // Listener za promjenu izabranog korisnika
          /*  m.trenutniKorisnikProperty().addListener((obs, oldKorisnik, newKorisnik) -> {

                 if (oldKorisnik != null) {
                     ime.textProperty().unbindBidirectional(oldKorisnik.imeProperty());
                     prezime.textProperty().unbindBidirectional(oldKorisnik.prezimeProperty());
                     korisnicko_ime.textProperty().unbindBidirectional(oldKorisnik.korisnicko_imeProperty());
                     email.textProperty().unbindBidirectional(oldKorisnik.emailProperty());
                     lozinka.textProperty().unbindBidirectional(oldKorisnik.lozinkaProperty());
                 }
                 if (newKorisnik != null) {
                     ime.textProperty().bindBidirectional(newKorisnik.imeProperty());
                     prezime.textProperty().bindBidirectional(newKorisnik.prezimeProperty());
                     korisnicko_ime.textProperty().bindBidirectional(newKorisnik.korisnicko_imeProperty());
                     email.textProperty().bindBidirectional(newKorisnik.emailProperty());
                     lozinka.textProperty().bindBidirectional(newKorisnik.lozinkaProperty());
                 }
                 else {
                     korisnicko_ime.clear();
                     email.clear();
                     ime.clear();
                     prezime.clear();
                     lozinka.clear();
                 }
                // m.setTrenutniKorisnik(newKorisnik);
              //   lista.refresh();
             });*/

        // }
    }
    }










           /* if(m.getTrenutniKorisnik()!=null)
            {
*/
    /*
    // Dvosmjerno povezivanje polja s trenutnim korisnikom
        Korisnik t= (Korisnik) m.getTrenutniKorisnik();
         if(t!=null)
         {
             ime.textProperty().bindBidirectional(t.imeProperty());
             prezime.textProperty().bindBidirectional(t.prezimeProperty());
             korisnicko_ime.textProperty().bindBidirectional(t.korisnicko_imeProperty());
             email.textProperty().bindBidirectional(t.emailProperty());
             lozinka.textProperty().bindBidirectional(t.lozinkaProperty());

         }

         // Povezivanje ListView sa spiskom korisnika
         lista.setItems(m.getKorisnici());


            }
        }
    }
        if(m!=null)

        {  Korisnik trenutni= (Korisnik) m.getTrenutniKorisnik();
            if(trenutni!=null)
            {


                ime.textProperty().bindBidirectional(((Korisnik)m.getTrenutniKorisnik()).imeProperty());
                prezime.textProperty().bindBidirectional(trenutni.prezimeProperty());
                lozinka.textProperty().bindBidirectional(trenutni.lozinkaProperty());
                email.textProperty().bindBidirectional(trenutni.emailProperty());
                korisnicko_ime.textProperty().bindBidirectional(trenutni.korisnicko_imeProperty());

                // Povezivanje liste
                lista.setItems(m.getKorisnici());

                lista.getSelectionModel().selectedItemProperty().addListener((obs, oldKorisnik, newKorisnik) -> {
                    m.setTrenutniKorisnik(newKorisnik);
                    lista.refresh();
                });

                m.trenutniKorisnikProperty().addListener((obs,oldKorisnik, newKorisnik )->{

                    if(oldKorisnik!=null)
                    {
                        ime.textProperty().unbindBidirectional(oldKorisnik.imeProperty());
                        prezime.textProperty().unbindBidirectional(oldKorisnik.prezimeProperty());
                        lozinka.textProperty().unbindBidirectional(oldKorisnik.lozinkaProperty());
                        email.textProperty().unbindBidirectional(oldKorisnik.emailProperty());
                        korisnicko_ime.textProperty().unbindBidirectional(oldKorisnik.korisnicko_imeProperty());
                    }

                    if(newKorisnik==null)
                    {
                        ime.setText("");
                        prezime.setText("");
                        email.setText("");
                        korisnicko_ime.setText("");
                        lozinka.setText("");
                    }
                    else{
                        ime.textProperty().bindBidirectional(newKorisnik.imeProperty());
                        prezime.textProperty().bindBidirectional(newKorisnik.prezimeProperty());
                        lozinka.textProperty().bindBidirectional(newKorisnik.lozinkaProperty());
                        email.textProperty().bindBidirectional(newKorisnik.emailProperty());
                        korisnicko_ime.textProperty().bindBidirectional(newKorisnik.korisnicko_imeProperty());

                    }

                });
        }}}}

            // Podešavanje fabrike ćelija za listu
          /*  lista.setCellFactory(param -> new ListCell<Korisnik>() {
                @Override
                protected void updateItem(Korisnik korisnik, boolean empty) {
                    super.updateItem(korisnik, empty);
                    if (empty || korisnik == null || korisnik.getKorisnicko_ime() == null) {
                        setText(null);
                    } else {
                        setText(korisnik.getKorisnicko_ime());
                    }
                }
            });

            //povezivanje liste
           // lista.setItems(m.getKorisnici());



            ime.textProperty().addListener((observable, oldValue, newValue) -> odabraniKorisnik());
            prezime.textProperty().addListener((observable, oldValue, newValue) -> odabraniKorisnik());
            lozinka.textProperty().addListener((observable, oldValue, newValue) -> odabraniKorisnik());
            email.textProperty().addListener((observable, oldValue, newValue) -> odabraniKorisnik());
            korisnicko_ime.textProperty().addListener((observable, oldValue, newValue) -> odabraniKorisnik());
        }
        }
       // lista.setItems(m.getKorisnici());
/*
        // Dvosmjerno povezivanje polja s trenutnim korisnikom
        Korisnik t= (Korisnik) m.getTrenutniKorisnik();
        polje_ime.textProperty().bindBidirectional(t.imeProperty());
        polje_prezime.textProperty().bindBidirectional(t.prezimeProperty());
        polje_korisnicko_ime.textProperty().bindBidirectional(t.korisnicko_imeProperty());
        polje_email.textProperty().bindBidirectional(t.emailProperty());
        polje_lozinka.textProperty().bindBidirectional(t.lozinkaProperty());

        // Povezivanje ListView sa spiskom korisnika
        lista.setItems(m.getKorisnici());

        // Listener za promjenu izabranog korisnika
        lista.getSelectionModel().selectedItemProperty().addListener((obs, oldKorisnik, newKorisnik) -> {
            m.setTrenutniKorisnik(newKorisnik);
            lista.refresh();
        });*/


    public Korisnik odabraniKorisnik()
    {
        Korisnik novi = new Korisnik();
        novi.setIme(ime.getText());
        novi.setPrezime(prezime.getText());
        novi.setEmail(email.getText());
        novi.setKorisnicko_ime(korisnicko_ime.getText());
        novi.setLozinka(lozinka.getText());
        return novi;
    }

    public void handleDodajButton(ActionEvent kor)
    {
            Korisnik novi = new Korisnik();
            novi=odabraniKorisnik();
            m.dodajNovogKorisnika(novi);
            m.setTrenutniKorisnik(novi);
        lista.setItems(FXCollections.observableArrayList(m.getKorisnici()));
       /* Korisnik trenutniKorisnik = m.getTrenutniKorisnik();
        if (trenutniKorisnik != null) {
            lista.getSelectionModel().select(trenutniKorisnik);
        }*/
        lista.refresh();
        korisnicko_ime.setText("");
        email.setText("");
        ime.setText("");
        prezime.setText("");
        lozinka.setText("");
    }

    public void handleKrajButton(ActionEvent kraj)
    {
        System.exit(0);
    }


}