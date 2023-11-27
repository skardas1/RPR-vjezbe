package ba.unsa.etf.rpr;

import java.util.ArrayList;

public class InformacijeONastavniku extends LicneInformacije implements Poruka,MozeOcijeniti{
    private String ime;
    private String prezime;
    private String titula;
    private ArrayList<Ocjena> ocjene=new ArrayList<>();

    InformacijeONastavniku(String i, String p, String titula)
    {
        super(i,p);
        ime=i;
        prezime=p;
        this.titula=titula;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getTitula() {
        return titula;
    }

    public void setTitula(String titula) {
        this.titula = titula;
    }

    public ArrayList<Ocjena> getOcjene() {
        return ocjene;
    }

    @Override
    public String predstavi()
    {
        return "Ime i prezime: "+this.getIme()+" " +this.getPrezime()+", Titula: "+this.getTitula();
    }

    @Override
    public Ocjena ocijeni(int x) {
        Ocjena nova=new Ocjena(this, x);
        ocjene.add(nova);
        return nova;
    }


}
