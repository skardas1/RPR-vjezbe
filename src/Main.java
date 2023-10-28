import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    Scanner ulaz= new Scanner(System.in);
    List<Double> lista=new ArrayList<Double>();
    for(;;)
    {
        System.out.print("Unesite elemente liste (za kraj unesite: stop): ");
        String el=ulaz.nextLine();
        if("stop".equalsIgnoreCase(el))
            break;
        try{
            Double n= Double.parseDouble(el);
            lista.add(n);
        }
        catch(Exception e)
        {
            System.out.println("Niste unijeli broj!");
            continue;
        }
    }
    System.out.println("Min: "+Racun.min(lista));
    System.out.println("Max: "+Racun.max(lista));
    System.out.println("Mean: "+Racun.mean(lista));
    System.out.println("Standardna devijacija: "+Racun.standardnaDevijacija(lista));
    }
}
