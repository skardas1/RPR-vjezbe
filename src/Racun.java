public class Racun
{
    protected long brojRacuna;
    protected Osoba korisnikRacuna;
    protected boolean odobrenjePrekoracenja;
    protected double stanjeRacuna;
    protected double prekoracenje;
    public Racun(Long  r, Osoba o)
    {
        korisnikRacuna=new Osoba(o.ime,o.prezime);
        brojRacuna=r;
        stanjeRacuna=0;
        prekoracenje=200; //proizvoljno
    }

    private boolean provjeriOdobrenjePrekoracenja(double p)
    {
        if(odobrenjePrekoracenja || prekoracenje<p)
            return false;
        return true;
    }
    public boolean izvrsiUplatu(double k)
    {
        if(!odobrenjePrekoracenja && stanjeRacuna+k<stanjeRacuna+prekoracenje)
        {
            stanjeRacuna=stanjeRacuna+k;
            return true;
        }
        return false;
    }
    public boolean izvrsiIsplatu(double k)
    {
        if (!odobrenjePrekoracenja)
        {
            stanjeRacuna=stanjeRacuna-k;
            return true;
        }
        return false;
    }
    public void odobriPrekoracenje(double k)
    {
        odobrenjePrekoracenja=true;
        stanjeRacuna=stanjeRacuna+k;
    }


}
