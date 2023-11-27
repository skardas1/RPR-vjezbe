package ba.unsa.etf.rpr;

import java.util.ArrayList;

public class KolekcijaPoruka {
    private ArrayList<Poruka> poruke;

    KolekcijaPoruka(ArrayList<Poruka> k)
    {
        this.poruke=new ArrayList<Poruka>(k);
    }
    public ArrayList<Poruka> getPoruke()
    {
        return poruke;
    }
}
