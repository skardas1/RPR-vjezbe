package ba.unsa.etf.rpr;
import java.util.*;

public class Imenik {

    private Map<String, TelefonskiBroj> brojevi; //map<key, values>

    //preko konstruktora inicijalizirano na hashmapu
    public Imenik()
    {
        this.brojevi=new HashMap<String, TelefonskiBroj>();
    }

    //getteri i setteri
    public Map<String, TelefonskiBroj> getBrojevi()
    {
        return brojevi;
    }
    public void setBrojevi(Map<String, TelefonskiBroj> brojevi)
    {
        this.brojevi=brojevi;
    }

    void dodaj(String ime, TelefonskiBroj broj)
    {
        this.brojevi.put(ime,broj); //povezuje kljuc i vrijednost i dodaje u mapu
    }

    public String dajBroj(String ime)
    {
        TelefonskiBroj broj=this.brojevi.get(ime); //daje vrijednost a ukoliko je nema vraca null
        if(broj!=null)
            return broj.ispisi();
        return null;
    }

    public String dajIme(TelefonskiBroj broj)
    {
        //rasponska petlja
        for(Map.Entry<String, TelefonskiBroj> mapa: this.brojevi.entrySet())
        {
            if(mapa.getValue().ispisi().equals(broj.ispisi())) //poredi brojeve tj vrijednosti po ispisu jer nema metode za tu provheru
                return mapa.getKey();
        }
        return null;
    }

    public String naSlovo(char s)
    {
        // korisit se StringBuilder za manipulaciju stringa
        StringBuilder sb=new StringBuilder();
        int brojac=1;
        for(Map.Entry<String, TelefonskiBroj> mapa: this.brojevi.entrySet())
        {

            if(mapa.getKey().startsWith(String.valueOf(s))) //string.valueof(s) pretvara char u string
            {
                sb.append(brojac).append(". ")
                        .append(mapa.getKey()) //ispisuje ime
                        .append(" - ")
                        .append(mapa.getValue().ispisi()) //ispisuje broj
                        .append(System.lineSeparator()); //prelazak u novi red
            }
            brojac++;
        }
        return sb.toString();
    }

    public Set<String> izGrada(Grad g) {
        Set<String> ss = new TreeSet<String>();//sortirano abecedno
        for (Map.Entry<String, TelefonskiBroj> mapa : this.brojevi.entrySet()) {
            if (mapa.getValue() instanceof FiksniBroj && g.equals(((FiksniBroj) mapa.getValue()).getGrad()))
            {
                ss.add(mapa.getKey());
            }
        }
        return ss;
    }
    public Set<TelefonskiBroj> izGradaBrojevi(Grad g)
    {
         Set<TelefonskiBroj> stb=new TreeSet<TelefonskiBroj>(new Comparator<TelefonskiBroj>() {
             @Override
             public int compare(TelefonskiBroj o1, TelefonskiBroj o2) {
                 return o1.ispisi().compareTo(o2.ispisi());
             }
         });
        for (Map.Entry<String, TelefonskiBroj> mapa : this.brojevi.entrySet()) {
            if (mapa.getValue() instanceof FiksniBroj && g.equals(((FiksniBroj) mapa.getValue()).getGrad()))
            {
                stb.add(mapa.getValue());
            }else continue;
        }
        return stb;
    }

    @Override
    public String toString()
    {
        StringBuilder sb=new StringBuilder();
        int brojac=1;
        for(Map.Entry<String, TelefonskiBroj> mapa: this.brojevi.entrySet())
        {
                sb.append(brojac).append(". ")
                        .append(mapa.getKey()) //ispisuje ime
                        .append(" - ")
                        .append(mapa.getValue().ispisi()) //ispisuje broj
                        .append(System.lineSeparator()); //prelazak u novi red
            brojac++;
        }
        return sb.toString();
    }
}
