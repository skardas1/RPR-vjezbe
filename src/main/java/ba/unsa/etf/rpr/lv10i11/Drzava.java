package ba.unsa.etf.rpr.lv10i11;


import javafx.beans.property.*;

import java.sql.*;

public class Drzava {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty naziv = new SimpleStringProperty();
    private final ObjectProperty<Grad> glavni_grad = new SimpleObjectProperty<>();

    public Drzava(String naziv, Grad grad)
    {
        setNaziv(naziv);
        setGlavni_grad(grad);
    }

    public Drzava(){
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

    public String getNaziv() {
        return naziv.get();
    }

    public StringProperty nazivProperty() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv.set(naziv);
    }

    public Grad getGlavni_grad() {
        return glavni_grad.get();
    }

    public ObjectProperty<Grad> glavni_gradProperty() {
        return glavni_grad;
    }

    public void setGlavni_grad(Grad glavni_grad) {
        this.glavni_grad.set(glavni_grad);
    }

    @Override
    public String toString() {
        return  getNaziv();
    }
}
    /*


    private final IntegerProperty id;
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
}*/
