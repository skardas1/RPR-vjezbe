package ba.unsa.etf.rpr.lv7i8;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KorisniciModel{
    private ObservableList<Korisnik> korisnici= FXCollections.observableArrayList();
    private final ObjectProperty<Korisnik> trenutniKorisnik;

    public KorisniciModel() {
        this.trenutniKorisnik=new SimpleObjectProperty<>();
        this.korisnici= FXCollections.observableArrayList();
    }

    public KorisniciModel(ObservableList<Korisnik> korisnici, ObjectProperty<Korisnik> trenutniKorisnik) {
        this.korisnici = korisnici;
        this.trenutniKorisnik = trenutniKorisnik;
    }

    public ObservableList<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(ObservableList<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik.get();
    }

    public ObjectProperty<Korisnik> trenutniKorisnikProperty() {
        return trenutniKorisnik;
    }


    public void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
        this.trenutniKorisnik.set(trenutniKorisnik);
    }

    void napuni()
    {
        korisnici.add(new Korisnik("Sara", "Kardas", "skardas1@etf.unsa.ba", "skardas1", "123456*"));
    }
    public Korisnik dodajPraznogKorisnika()
    {
        Korisnik novi=new Korisnik(" "," "," "," "," ");
        korisnici.add(novi);
        return novi;
    }
    public void dodajNovogKorisnika(Korisnik novi)
    {
        korisnici.add(novi);
    }
}

