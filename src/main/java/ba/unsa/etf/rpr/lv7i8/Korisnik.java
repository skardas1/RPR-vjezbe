package ba.unsa.etf.rpr.lv7i8;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Korisnik {//implements ObservableArray<Korisnik> {
    private final StringProperty ime;
    private final StringProperty prezime;
    private final StringProperty email;
    private final StringProperty korisnicko_ime;
    private final StringProperty lozinka;

    public Korisnik(String ime, String prezime, String email, String ki, String loz)
    {
        this.ime=new SimpleStringProperty (ime);
        this.prezime=new SimpleStringProperty(prezime);
        this.email=new SimpleStringProperty(email);
        this.korisnicko_ime=new SimpleStringProperty(ki);
        this.lozinka=new SimpleStringProperty(loz);
    }
    public Korisnik()
    {
        this.ime=new SimpleStringProperty ("");
        this.prezime=new SimpleStringProperty("");
        this.email=new SimpleStringProperty("");
        this.korisnicko_ime=new SimpleStringProperty("");
        this.lozinka=new SimpleStringProperty("");
    }
    public String getIme() {
        return ime.get();
    }

    public  StringProperty imeProperty() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime.set(ime);
    }

    public String getPrezime() {
        return prezime.get();
    }

    public StringProperty prezimeProperty() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getKorisnicko_ime() {
        return korisnicko_ime.get();
    }

    public StringProperty korisnicko_imeProperty() {
        return korisnicko_ime;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime.set(korisnicko_ime);
    }

    public String getLozinka() {
        return lozinka.get();
    }

    public StringProperty lozinkaProperty() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka.set(lozinka);
    }

    @Override
    public String toString()
    {
        return korisnicko_ime.get();
    }
}
