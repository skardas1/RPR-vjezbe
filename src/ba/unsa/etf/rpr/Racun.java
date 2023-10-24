package ba.unsa.etf.rpr;

public class Racun{
    public static int factBroja(int n){
       /* if (n<0)
           throw IllegalArgumentException("Nije dobar argument");
        else*/ if(n==0)
            return 1;
        else
        {
            int f=1;
            for(int i=1;i<=n;i++)
                f*=i;
            return f;
        }
    }

    public static double sinusBroja(int n)
    {
        return Math.sin(n);
    }

}
