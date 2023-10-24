package ba.unsa.etf.rpr;

public class Main {
    public static void main(String[] args) {
	if(args.length!=1)
    {
        System.out.println("Unesite jedan argument");
    }
    else
    {
        int n=Integer.parseInt(args[0]);
        try
        {
           int f= Racun.factBroja(n);
            double s= Racun.sinusBroja(n);
            System.out.println("Faktorijel: "+f);
            System.out.println("Sinus: "+s);
        }
       catch(IllegalArgumentException e)
       {
           System.out.println("Doslo je do izuzetka: "+e.getMessage());
       }
    }
    }
}
