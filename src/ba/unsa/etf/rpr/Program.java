package ba.unsa.etf.rpr;
import java.util.Scanner;
import java.util.Set;

public class Program {

  public static  Scanner ulaz=new Scanner (System.in);
   public static Imenik imenik=new Imenik();
    public static void main(String[] args) {

	// write your code here
        imenik.dodaj("Sara",new FiksniBroj(Grad.SARAJEVO,"111-111"));
        imenik.dodaj("Ana",new MobilniBroj(61,"222-222"));
        imenik.dodaj("Enes", new MedunarodniBroj("+33","333-333") );


    while(true)
    {
        System.out.println("Unesite naredbu (dodaj, dajBroj, dajIme, naSlovo, izGrada, izGradaBrojevi, imenik, kraj): ");
        String naredba=ulaz.nextLine();

        switch(naredba)
        {
            case "dodaj":
                dodajBroj();
                break;
            case "dajBroj":
                dajBroj();
                break;
            case "dajIme":
                dajIme();
                break;
            case "naSlovo":
                naSlovo();
                break;
            case "izGrada":
                izGrada();
                break;
            case "izGradaBrojevi":
                izGradaBrojevi();
                break;
            case "imenik":
                ispisiImenik();
                break;
            case "kraj":
                System.exit(0);
                break;
            default:
                System.out.println("Pogresna naredba");

        };

    }
    }

    private static void dodajBroj()
    {
        System.out.println("Unesite ime: ");
        String ime=ulaz.nextLine();
        TelefonskiBroj broj=unesiBrTelefona();
        imenik.dodaj(ime,broj);
    }

    private static void dajBroj()
    {
        System.out.println("Unesite ime: ");
        String ime=ulaz.nextLine();
        String broj=imenik.dajBroj(ime);
        if(broj==null)
            System.out.println("Nema broja");
        else
            System.out.println(broj);
    }
//daje brojeve
    private static void izGradaBrojevi()
    {
        System.out.println("Unesite ime grada: ");
        String grad=ulaz.nextLine();
        try
        {
            Grad g=Grad.valueOf(grad); //string pretvara u enum i u set stavlja brojeve odg gradova
            Set<TelefonskiBroj> stb =imenik.izGradaBrojevi(g);
            for(TelefonskiBroj br: stb)
                System.out.println(br.ispisi());
        }
        catch(Exception e)
        {
            System.out.println("Pogresan grad!");
            return;
        }
    }
    //daje imena
    private static void izGrada()
    {
        System.out.println("Unesite ime grada: ");
        String grad=ulaz.nextLine();
        try
        {
            Grad g=Grad.valueOf(grad);
            Set<String > stb =imenik.izGrada(g);
            System.out.println(stb);
        }
        catch(Exception e)
        {
            System.out.println("Pogresan grad!");
            return;
        }
    }
    private static void ispisiImenik()
    {
        System.out.println(imenik.toString());
    }
    private static void naSlovo()
    {
        System.out.println("Unesite prvo slovo imena: ");
        String c=ulaz.nextLine();
        String ime=imenik.naSlovo(c.toCharArray()[0]);
        System.out.println(ime);
    }
    private static void dajIme()
    {
        TelefonskiBroj broj=unesiBrTelefona();
        String ime=imenik.dajIme(broj);
        if(ime==null)
        {
            System.out.println("Nema osobe u imeniku");
        }
        else{
            System.out.println("Vlasnik broja "+broj.ispisi()+" je "+ime);
        }
    }
    private static TelefonskiBroj unesiBrTelefona()
    {
        System.out.println("Unesite tip broja(mobilni, fiksni, medjunarodni): ");
        String tip=ulaz.nextLine();
        switch(tip)
        {
            case "fiksni":
                System.out.println("Unesite pozivni: ");
                String pozivni=ulaz.nextLine();
                System.out.println("Unesite broj: ");
                String broj=ulaz.nextLine();
                return new FiksniBroj(Grad.izPozivnog(pozivni),broj);
            case "mobilni":
                System.out.println("Unesite mrezu: ");
                int mreza=ulaz.nextInt();
                System.out.println("Unesite broj: ");
                String mbroj=ulaz.nextLine();
                return new MobilniBroj(mreza,mbroj);
            case "medjunarodni":
                System.out.println("Unesite broj drzave(+387): ");
                String brojd=ulaz.nextLine();
                System.out.println("Unesite broj: ");
                String mnbroj=ulaz.nextLine();
                return new MedunarodniBroj(brojd,mnbroj);
        }
        return null;
    }








}