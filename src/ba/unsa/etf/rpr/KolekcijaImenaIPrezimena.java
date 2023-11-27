package ba.unsa.etf.rpr;

import java.util.ArrayList;

public class KolekcijaImenaIPrezimena implements Kolekcija{
    private ArrayList<String> imena=new ArrayList<>();
    private ArrayList<String> prezimena=new ArrayList<>();

    KolekcijaImenaIPrezimena(ArrayList<String>i, ArrayList<String>p)
    {
        imena=i;
        prezimena=p;
    }
    public int getIndexNajduzegPara()
    {
        int indeks=0;
        int maxduzina=0;
        for(int i=0;i< imena.size();i++)
        {
            String imeprezime=imena.get(i)+prezimena.get(i);
            if(imeprezime.length()>maxduzina)
            {
                indeks=i;
                maxduzina=imeprezime.length();
            }
        }
        return indeks;
    }
    public String getImeiPrezime(int i)
    {
        return imena.get(i)+" "+prezimena.get(i);
    }


    //Kolekcija
    @Override
    public ArrayList<String> getImenaPrezimena()
    {
        ArrayList<String>nova=new ArrayList<>();
        for(int i=0;i< imena.size();i++)
            nova.add(imena.get(i)+"  "+prezimena.get(i));

        return nova;
    }

    @Override
    public String getNajduzeIme() {
        int indeks=0;
        int maxduzina=0;
        for(int i=0;i< imena.size();i++)
        {
            String imeprezime=imena.get(i)+prezimena.get(i);
            if(imeprezime.length()>maxduzina)
            {
                indeks=i;
                maxduzina=imeprezime.length();
            }
        }
        return imena.get(indeks)+" "+prezimena.get(indeks);
    }


}
