package ba.unsa.etf.rpr;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class LaptopDaoJSONFile implements LaptopDao {

    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoJSONFile(File file)
    {
        this.laptopi=new ArrayList<Laptop>();
        this.file=file;
        napuniListu(vratiPodatkeIzDatoteke());
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop)
    {
        laptopi.add(laptop);
        dodajLaptopUFile(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop)
    {
        try
        {
            ObjectMapper izlaz=new ObjectMapper();//OutputStream(new FileOutputStream(file));
            izlaz.writeValue(file,laptop);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public Laptop getLaptop(String procesor)
    {
        for(Laptop l:laptopi)
        {
            if(l.getProcesor().equals(procesor))
                return l;
        }
        throw new NeodgovarajuciProcesorException("Nema laptopa sa trazenim procesorom.");
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi.addAll(laptopi);
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {
        ArrayList<Laptop>ispis = new ArrayList<>();

        try
        {
            ObjectMapper ulaz=new ObjectMapper();//InputStream(new FileInputStream(file));
            Laptop[] niz=ulaz.readValue(file,Laptop[].class);
            ispis.addAll(Arrays.asList(niz)); //poput rasponske petlje
        }
        catch (IOException e) {
            //return new ArrayList<Laptop>();
        }
        return ispis;
}
}
