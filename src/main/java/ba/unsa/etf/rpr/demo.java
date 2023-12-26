package ba.unsa.etf.rpr;

import java.util.Scanner;
import java.sql.*;
public class demo {
    //private static
    private static final  GeografijaDAO  dao = GeografijaDAO.getInstance();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
       ispisiGradove();
        glavniGrad();
    }

    public static String ispisiGradove() {
        StringBuilder result = new StringBuilder();

        // Pozivamo metodu koja vraća gradove iz baze
        for (Grad grad : dao.gradovi()) {
            String info = grad.getNaziv ()+"("+grad.getDrzava().getNaziv()+")-"+grad.getBroj_stanovnika();
            result.append(info).append("\n");
        }


        System.out.println(result.toString());
        return result.toString();
    }

    public static void glavniGrad() {
        System.out.println("Unesite naziv države:");
        String nazivDrzave = scanner.nextLine();

        Grad glavniGrad = dao.glavniGrad(nazivDrzave);

        if (glavniGrad != null) {
            System.out.println("Glavni grad države "+nazivDrzave+" je "+glavniGrad.getNaziv());
        } else {
            System.out.println("Nepostojeća država");
        }
    }
}

