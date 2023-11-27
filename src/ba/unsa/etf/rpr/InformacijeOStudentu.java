package ba.unsa.etf.rpr;

public class InformacijeOStudentu implements Poruka{
    private String ime;
    private String prezime;
    private String godinaStudija;
    private String brojIndexa;

    InformacijeOStudentu(String ime, String prezime, String godinaStudija, String brojIndexa)
    {
        this.ime=ime;
        this.prezime=prezime;
        this.godinaStudija=godinaStudija;
        this.brojIndexa=brojIndexa;
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

    public String getGodinaStudija() {
        return godinaStudija;
    }

    public void setGodinaStudija(String godinaStudija) {
        this.godinaStudija = godinaStudija;
    }

    public String getBrojIndexa() {
        return brojIndexa;
    }

    public void setBrojIndexa(String brojIndexa) {
        this.brojIndexa = brojIndexa;
    }
    public String predstavi()
    {
        return "Ime i prezime: "+this.getIme()+" "+this.getPrezime()+", Broj indeksa: "+this.getBrojIndexa()+", Godina studija: "+this.getGodinaStudija();

    }

}
