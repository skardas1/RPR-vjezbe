package ba.unsa.etf.rpr;
import java.util.Objects;

public class MobilniBroj extends TelefonskiBroj {
    private int mobilna_mreza;
    private String broj;

    public MobilniBroj(int mobilna_mreza, String broj)
    {
        this.mobilna_mreza=mobilna_mreza;
        this.broj=broj;
    }
    @Override
    public String ispisi()
    {
        if(broj!=null)
            return "0"+mobilna_mreza+"/"+broj;
        return "Nema tog mobilnog broja.";
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(mobilna_mreza,broj);
    }

}
