package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        InformacijeONastavniku nastavnik=new InformacijeONastavniku("Nikola", "Nikolic", "Profesor");
        InformacijeOStudentu student=new InformacijeOStudentu("Ana","Anic", "2", "19152");
        LicneInformacije osoba=new LicneInformacije("Ena","Enic");
        Predmet predmet= new Predmet("Razvoj programskih rjesenja","Programski jezik Java");

        ArrayList<Poruka> poruke=new ArrayList<>();
        poruke.add(nastavnik);
        poruke.add(student);
        poruke.add(osoba);
        poruke.add(predmet);

        KolekcijaPoruka kolekcija=new KolekcijaPoruka(poruke);

        for(Poruka p: kolekcija.getPoruke())
        {
            System.out.println(p.predstavi());
        }


        //zadatak 2
        Scanner ulaz=new Scanner(System.in);
        int n;
        System.out.println("Unesite ocjenu za nastavnika: ");
        n=ulaz.nextInt();
        nastavnik.ocijeni(n);
        //nastavnik.ocijeni(7);
        //nastavnik.ocijeni(10);
        System.out.print("Ocjena za nastavnika "+nastavnik.getIme()+" " +nastavnik.getPrezime()+": ");
        for(Ocjena o: nastavnik.getOcjene())
        {
            System.out.print(o+" ");
        }
        int p;
        System.out.println("\nUnesite ocjenu za predmet: ");;
        p=ulaz.nextInt();
        predmet.ocijeni(p);
        System.out.println("Ocjena za predmet "+predmet.getNaziv()+" ");
        for(Ocjena o: predmet.getOcjene())
        {
            System.out.print(o+" ");
        }


        //zadatak3
        ArrayList<String> kolekime=new ArrayList<>();
        kolekime.add("Sara Kardas");
        kolekime.add("Mijo Mijic");
        kolekime.add("Monika Monic");
        KolekcijaImena prva=new KolekcijaImena(kolekime);
        Pobjednik p1=new Pobjednik(prva);

        System.out.println("\nPobjednik 1:");
        System.out.println("Ime i prezime: "+p1.getIme()+" "+p1.getPrezime());
        System.out.println("Broj znakova: "+p1.getBrojZnakova());


        ArrayList<String> ime=new ArrayList<>();
        ArrayList<String> prezime=new ArrayList<>();
        ime.add("Sara");
        prezime.add("Kardas");
        ime.add("Mijo");
        prezime.add("Mijic");
        KolekcijaImenaIPrezimena druga=new KolekcijaImenaIPrezimena(ime,prezime);
        Pobjednik p2=new Pobjednik(druga);

        System.out.println("\nPobjednik 2:");
        System.out.println("Ime i prezime: "+p2.getIme()+" "+p2.getPrezime());
        System.out.println("Broj znakova: "+p2.getBrojZnakova());
        int indeks=druga.getIndexNajduzegPara();
        System.out.println("\nNajduze ime i prezime u ovoj kolekciji: "+druga.getImeiPrezime(indeks));
/*U trecem zadatku dodala sam novi interfejs Kolekcija sa dvije metode
* i izmijenila konstruktor u klasi Pobjednik kako bi mogao primati razlicite kolekije imena i prezimena*/

    }
}
