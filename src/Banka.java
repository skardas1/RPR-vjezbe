import java.util.ArrayList;
import java.util.List;

public class Banka {
    private Long brojRacuna;
    protected List<Korisnik> korisnici;
    protected List<Uposlenik> uposlenici;


    public Banka(){
        this.korisnici=new ArrayList<Korisnik>();
        this.uposlenici=new ArrayList<Uposlenik>();
    }

    public  Korisnik kreirajNovogKorisnika(String ime, String prezime)
    {
        Korisnik k=new Korisnik(ime, prezime);
        this.korisnici.add(k);
        return  k;
    }
    public Uposlenik kreirajNovogUposlenika(String ime, String prezime)
    {
        Uposlenik u=new Uposlenik(ime, prezime);
        this.uposlenici.add(u);
        return u;
    }
    public Racun kreirajRacunZaKorisnika(Korisnik a)
    {
        Racun r=new Racun(a.racun.brojRacuna, new Osoba(a.ime,a.prezime));

        for(int i=0;i< korisnici.size();i++)
        {
            if(korisnici.get(i)==a)
            {
                a.dodajRacun(r);
            }
        }
        return r;
    }
}
