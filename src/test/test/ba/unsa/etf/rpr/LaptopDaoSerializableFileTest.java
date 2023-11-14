package ba.unsa.etf.rpr;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static ba.unsa.etf.rpr.LaptopDao.laptopi;
import static org.mockito.Mockito.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LaptopDaoSerializableFileTest {

    private static ArrayList<Laptop> l;
    private File fileMock;
    @BeforeAll
    static void dodajLaptope()
    {
        l=new ArrayList<>();
        Laptop l1= new Laptop("HP", "Pavilion", 1200.0,8,1000,256,"Intel i5", "Nvidia GTX 1650", 15.6);
        Laptop l2= new Laptop("Dell","Inspiron", 1500.00,16,512,0,"AMD Ryzen 7","Amd Radeon RX 5600M", 17.3);
        l.add(l1);
        l.add(l2);
    }    
    
    @Test
    void dodajLaptopUListuTest() {
        ArrayList<Laptop> laptop=new ArrayList<>();
        LaptopDaoSerializableFile ls=new LaptopDaoSerializableFile(null);
        ls.napuniListu(laptop);
        Laptop l3=new Laptop("asus","model3",789,3,3,3,"procesor3","gk3",3);
        ls.dodajLaptopUListu(l3);
        assertEquals(1,laptop.size());
    }

    @Test
    void getLaptop() {
        LaptopDaoSerializableFile ls=mock(LaptopDaoSerializableFile.class);
        Laptop l = new Laptop("lenovo", "model4", 147, 4, 4, 4, "procesor4", "gk4", 4);
        when(ls.getLaptop("procesor4")).thenReturn(l);
        try {
            Laptop stv = ls.getLaptop("procesor4");
            assertEquals(l, stv);
        } catch (NeodgovarajuciProcesorException e) {
            e.printStackTrace();
        }
    }

    @Test
    void napuniListu() {
        LaptopDaoSerializableFile ls=new LaptopDaoSerializableFile(new File("laptop.txt"));
        ls.napuniListu(laptopi);
        for(Laptop l : laptopi){
            try{
                Laptop provj = ls.getLaptop(l.getProcesor());
                assertEquals(l,provj);
            } catch (NeodgovarajuciProcesorException e) {
                e.printStackTrace();
            }

        }

    }


    @org.junit.jupiter.api.Test
    public void testDodajLaptopUFile() throws IOException {
        // Mocking
        when(fileMock.exists()).thenReturn(true);
        LaptopDaoSerializableFile laptopDao = new LaptopDaoSerializableFile(fileMock);
        laptopDao.dodajLaptopUFile(new Laptop("Brand", "Model", 1000.0, 8, 500, 256, "Processor", "Graphics", 15.6));
        verify(fileMock, atLeastOnce()).exists();
    }
}