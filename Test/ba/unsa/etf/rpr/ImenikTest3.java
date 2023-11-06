package ba.unsa.etf.rpr;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;

class ImenikTest3 {

    private static Imenik imenik=new Imenik();

    @BeforeAll
    public static void setup()
    {
        imenik.dodaj("Sara",new FiksniBroj(Grad.SARAJEVO,"111-111"));
        imenik.dodaj("Ana",new MobilniBroj(61,"222-222"));
        imenik.dodaj("Enes", new MedunarodniBroj("+33","333-333") );
    }

    @Test
    public void testMockExternal()
    {/*
        //Imenik i=Mockito.mock(Imenik.class);
        //Mockito.when(i.dajBroj("Sara").thenReturn("Nema nista"));

        String test=i.dajBroj("Sara");
        assertEquals(test,"Nema nista");*/
    }

}