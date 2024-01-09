package ba.unsa.etf.rpr.lv10i11;

import javafx.beans.property.*;

import java.sql.*;

public class Grad {
    private  final IntegerProperty id= new SimpleIntegerProperty();
    private  final IntegerProperty broj_stanovnika= new SimpleIntegerProperty();
    private  final ObjectProperty<Drzava> drzava=new SimpleObjectProperty<>();
    private  final StringProperty naziv= new SimpleStringProperty();

    public Grad() {
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getBroj_stanovnika() {
        return broj_stanovnika.get();
    }

    public IntegerProperty broj_stanovnikaProperty() {
        return broj_stanovnika;
    }

    public void setBroj_stanovnika(int broj_stanovnika) {
        this.broj_stanovnika.set(broj_stanovnika);
    }

    public Drzava getDrzava() {
        return drzava.get();
    }

    public ObjectProperty<Drzava> drzavaProperty() {
        return drzava;
    }

    public void setDrzava(Drzava drzava) {
        this.drzava.set(drzava);
    }

    public String getNaziv() {
        return naziv.get();
    }

    public StringProperty nazivProperty() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv.set(naziv);
    }


    public Grad(int broj_stanovnika, String naziv,Drzava drzava) {
        this.broj_stanovnika.set(broj_stanovnika);
        this.naziv.set(naziv);
        this.drzava.set(drzava);
        if(drzava!=null)
        {
            drzava.setGlavni_grad(this);
        }
    }
    @Override
    public String toString() {
        return  getNaziv();
    }


    /*
    public Grad(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBroj_stanovnika() {
        return broj_stanovnika;
    }

    public void setBroj_stanovnika(int broj_stanovnika) {
        this.broj_stanovnika = broj_stanovnika;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Drzava getDrzava() {
        return drzava;
    }

    public void setDrzava(Drzava drzava) {
        this.drzava = drzava;
    }*/
}
