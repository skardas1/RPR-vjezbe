package ba.unsa.etf.rpr;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

public class LaptopDaoXMLFile implements LaptopDao {
    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoXMLFile(File file)
    {
        this.file=file;
        this.laptopi=new ArrayList<Laptop>();
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
            XMLEncoder izlaz=new XMLEncoder(new BufferedOutputStream(new FileOutputStream(file)));//OutputStream(new FileOutputStream(file));
            izlaz.writeObject(laptop);
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
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {//
        try//( XMLDecoder ulaz=new XMLDecoder(new BufferedInputStream(new FileInputStream(file)))
        {   XMLDecoder ulaz=new XMLDecoder(new BufferedInputStream(new FileInputStream(file)));
            Laptop[] obj=(Laptop[]) ulaz.readObject();
            for(Laptop l:obj)
                laptopi.add(l);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return laptopi;
    }

}
