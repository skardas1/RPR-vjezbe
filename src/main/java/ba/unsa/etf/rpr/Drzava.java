package ba.unsa.etf.rpr;

import java.sql.*;

public class Drzava {
    private int id;
    private String naziv;
    private Grad glavni_grad;

    public Drzava(String naziv, Grad grad)
    {
        this.naziv=naziv;
        this.glavni_grad=grad;
    }

    public Drzava(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Grad getGlavni_grad() {
        return glavni_grad;
    }

    public void setGlavni_grad(Grad grad) {
        this.glavni_grad = grad;
    }
}
