package ba.unsa.etf.rpr;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class ImenikTest {

    private static Imenik imenik=new Imenik();

    @BeforeAll
    public static void setup()
    {
        imenik.dodaj("Sara",new FiksniBroj(Grad.SARAJEVO,"111-111"));
        imenik.dodaj("Ana",new MobilniBroj(61,"222-222"));
        imenik.dodaj("Enes", new MedunarodniBroj("+33","333-333") );
    }


    @Test
    public void dodaj()
    {
        TelefonskiBroj broj= new MedunarodniBroj("+55","555-555");
        imenik.dodaj("Mirza",broj);

        String broji=imenik.dajBroj("Mirza");
        assertEquals(broji,"+55(555-555)");
    }
    @Test
    public void dodajFiksni()
    {
       assertThrows(VlastitiIzuzetak.class, new Executable() {
           @Override
           public void execute() throws Throwable {
               new FiksniBroj(null,"123-123");
           }
       });
    }


    @Test
    void dajBrojPronadjen()
    {
        String broj=imenik.dajBroj("Sara");
        assertEquals(broj,"033/111-111");
    }

    @Test
    void dajBrojNijePronadjen()
    {
        String broj=imenik.dajBroj("Monika");
        assertNull(broj);
    }
}