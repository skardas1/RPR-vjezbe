package ba.unsa.etf.rpr;

import java.io.File;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        File files=new File("laptop.txt");
        File filex=new File("laptop.xml");
        File filej=new File ("laptop.json");
       Laptop l1= new Laptop("HP", "Pavilion", 1200.0,8,1000,256,"Intel i5", "Nvidia GTX 1650", 15.6);
       Laptop l2= new Laptop("Dell","Inspiron", 1500.00,16,512,0,"AMD Ryzen 7","Amd Radeon RX 5600M", 17.3);

        ArrayList<Laptop> laptopi=new ArrayList<>();
        laptopi.add(l1);
        laptopi.add(l2);
       //serializable

       LaptopDaoSerializableFile laptopDaos=new LaptopDaoSerializableFile(files);
       laptopDaos.napuniListu(laptopi);
       laptopDaos.dodajLaptopUListu(l1);
      // laptopDaos.dodajLaptopUListu(l2);

       System.out.println("Laptopi(serializable): ");
      for(Laptop l: laptopDaos.vratiPodatkeIzDatoteke())
      {
          System.out.println(l);
      }

          ;//.forEach(System.out::println);

        String prcsr="Intel i5";
        try
        {
           Laptop noviLaptop=laptopDaos.getLaptop(prcsr);
           System.out.println("Trazeni laptop: "+noviLaptop.toString());
        }
        catch(NeodgovarajuciProcesorException e)
        {
            System.out.println("aa:"+e.getMessage());
        }



        LaptopDaoXMLFile laptopDaox=new LaptopDaoXMLFile(filex);
        laptopDaox.napuniListu(laptopi);
        laptopDaox.dodajLaptopUListu(l1);
        //laptopDaox.dodajLaptopUListu(l2);

        System.out.println("Laptopi(XML): ");
        for(Laptop l: laptopDaox.vratiPodatkeIzDatoteke())
        {
            System.out.println(l);
        }
        //String prcsr="Intel i5";
        try
        {
            Laptop noviLaptop=laptopDaox.getLaptop(prcsr);
            System.out.println("Trazeni laptop: "+noviLaptop.toString());
        }
        catch(NeodgovarajuciProcesorException e)
        {
            System.out.println("aa:"+e.getMessage());
        }

        LaptopDaoJSONFile laptopDaoj=new LaptopDaoJSONFile(filej);
        laptopDaoj.napuniListu(laptopi);
        laptopDaoj.dodajLaptopUListu(l1);
        //laptopDaoj.dodajLaptopUListu(l2);

        System.out.println("Laptopi(JSON): ");
        for(Laptop l: laptopDaoj.vratiPodatkeIzDatoteke())
        {
            System.out.println(l);
        }
        //String prcsr="Intel i5";
        try
        {
            Laptop noviLaptop=laptopDaoj.getLaptop(prcsr);
            System.out.println("Trazeni laptop: "+noviLaptop.toString());
        }
        catch(NeodgovarajuciProcesorException e)
        {
            System.out.println("aa:"+e.getMessage());
        }

    }
}
