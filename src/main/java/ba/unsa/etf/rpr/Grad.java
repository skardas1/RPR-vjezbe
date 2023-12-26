package ba.unsa.etf.rpr;

import java.sql.*;

public class Grad {
    private int id;
    private int broj_stanovnika;
    private Drzava drzava;
    private String naziv;


    public Grad(int broj_stanovnika, String naziv, Drzava drzava) {
        this.broj_stanovnika=broj_stanovnika;
        this.naziv=naziv;
        this.drzava=drzava;
        if(drzava!=null)
        {
            drzava.setGlavni_grad(this);
        }
    }
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
    }
}
