package ba.unsa.etf.rpr;

public class LicneInformacije implements Poruka{
    private String ime;
    private String prezime;

    LicneInformacije(String ime, String prezime){
        this.ime=ime;
        this.prezime=prezime;
    }
    public String getIme() {
        return this.ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return this.prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    public String predstavi()
    {
        return "Ime i prezime osobe: "+this.getIme()+" "+this.getPrezime();
    }
}
