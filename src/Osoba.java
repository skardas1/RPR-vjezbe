public class Osoba {
    final String ime;
    final String prezime;
    public Osoba()
    {
        this.ime=null;
        this.prezime=null;
    }
    public Osoba(String ime, String prezime)
    {
        this.ime=ime;
        this.prezime=prezime;
    }
    public String toString()
    {
        return ime+" "+prezime;

    }
}
