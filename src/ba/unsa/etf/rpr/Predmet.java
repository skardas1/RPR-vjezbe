package ba.unsa.etf.rpr;

import java.util.ArrayList;

public class Predmet implements Poruka,MozeOcijeniti{
    private String naziv;
    private String opis;
    private ArrayList<Ocjena> ocjene=new ArrayList<>();

    Predmet(String naziv, String opis)
    {
        this.naziv=naziv;
        this.opis=opis;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public ArrayList<Ocjena> getOcjene() {
        return ocjene;
    }

    @Override
    public String predstavi()
    {
        return "Predmet: "+ this.getNaziv()+", Opis: "+this.getOpis();
    }

    @Override
    public Ocjena ocijeni(int x) {

        Ocjena nova=new Ocjena(null,x);
        ocjene.add(nova);
        return nova;
    }
}
