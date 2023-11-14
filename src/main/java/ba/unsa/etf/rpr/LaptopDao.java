package ba.unsa.etf.rpr;

import java.util.ArrayList;

public interface LaptopDao {
    ArrayList<Laptop> laptopi = null;
     void dodajLaptopUFile(Laptop laptop);
     void dodajLaptopUListu(Laptop laptop);
     Laptop getLaptop(String procesor);
     void napuniListu(ArrayList<Laptop> laptopi);
    ArrayList<Laptop> vratiPodatkeIzDatoteke();


}
