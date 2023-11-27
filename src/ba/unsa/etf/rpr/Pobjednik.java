package ba.unsa.etf.rpr;

import java.util.ArrayList;

public class Pobjednik {
    private String ime;
    private String prezime;
    private int brojZnakova;
    KolekcijaImena kolekcijaImena;


    Pobjednik(Kolekcija k)
    {
        ArrayList<String>imenaprezimena=k.getImenaPrezimena();
        String najduze=k.getNajduzeIme();
        postaviAtribute(najduze);
    }

    public void postaviAtribute(String i)
    {
        String[] dio=i.split(" ");
        this.ime=dio[0];
        this.prezime=dio[1];
        this.brojZnakova=i.length();
    }

    public KolekcijaImena getKolekcijaImena() {
        return kolekcijaImena;
    }

    public void setKolekcijaImena(KolekcijaImena kolekcijaImena) {
        this.kolekcijaImena = kolekcijaImena;
    }

    public int getBrojZnakova() {
        return brojZnakova;
    }

    public void setBrojZnakova(int brojZnakova) {
        this.brojZnakova = brojZnakova;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }
}
