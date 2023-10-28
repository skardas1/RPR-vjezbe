public class Korisnik extends Osoba
{
    protected Racun racun;

    public Korisnik(String ime, String prezime)
    {
        new Osoba(ime,prezime);
    }
    public void dodajRacun (Racun r)
    {
        racun=new Racun(r.brojRacuna, r.korisnikRacuna);
    }
}
