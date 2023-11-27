package ba.unsa.etf.rpr;

import java.util.ArrayList;

public class KolekcijaImena implements Kolekcija {
    ArrayList<String> imena=new ArrayList<>();

    KolekcijaImena(ArrayList<String> i)
    {
        this.imena=i;
    }


    //Kolekcija
    @Override
    public ArrayList<String> getImenaPrezimena()
    {
        return imena;
    }
    @Override
    public String getNajduzeIme()
    {
        int maxduzina=0;
        String najduza=null;
        for(String i: imena)
        {
            if(i.length()>maxduzina)
            {
                maxduzina=i.length();
                najduza=i;
            }
        }
        return najduza;
    }
}
