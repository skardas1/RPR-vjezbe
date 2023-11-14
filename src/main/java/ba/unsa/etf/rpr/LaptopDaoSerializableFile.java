package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.io.*;

public class LaptopDaoSerializableFile implements LaptopDao {
    File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoSerializableFile(File file)
    {
        this.file=file;
        this.laptopi=new ArrayList<>();
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
        try(ObjectOutputStream izlaz=new ObjectOutputStream(new FileOutputStream(file)))
        {
            izlaz.writeObject(laptop);

        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }
    @Override
    public Laptop getLaptop(String procesor) throws NeodgovarajuciProcesorException{
        for (Laptop l : laptopi) {
            if (l.getProcesor().equals(procesor)){
                return  l;}
        }
        throw new NeodgovarajuciProcesorException("Nema laptopa sa trazenim procesorom.");
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi.addAll(laptopi);
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {
        ArrayList<Laptop> rez=new ArrayList<>();
        try(ObjectInputStream ulaz=new ObjectInputStream(new FileInputStream(file)))
        {

            //rez.clear();
            while(true)
            {
                Laptop l = (Laptop) ulaz.readObject();
                rez.add(l);
            }

        }
        catch(EOFException e)
        {

        }
        catch (IOException  | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return rez;
    }
}
