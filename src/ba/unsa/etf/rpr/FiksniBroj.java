package ba.unsa.etf.rpr;
import java.util.Objects;

public class FiksniBroj extends TelefonskiBroj {
    private String telefonski_broj;
   private Grad grad;

    public FiksniBroj(Grad grad, String broj)
    {
        if(grad==null)
            throw new VlastitiIzuzetak("Nisu proslijedjeni odgovarajuci parametri;");
        this.grad=grad;
        telefonski_broj=broj;
    }
    public String getTelefonski_broj()
    {
        return telefonski_broj;
    }
    public Grad getGrad()
    {
        return grad;
    }

    @Override
    public String ispisi()
    {
        if(grad!=null && telefonski_broj!=null)
            return grad.getPozivniBroj()+"/"+telefonski_broj;
        return "Nema tog broja.";
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(grad,telefonski_broj);
    }
};
