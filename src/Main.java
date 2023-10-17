import java.util.Scanner;


public class Main {
    public static int sumaCifara(int n){
    int suma=0,c=0;

    while(n!=0)
    {      c=c%10;
        suma=suma+c;
        n=n/10;
    }
    return suma;
}
    public static void main(String[] args) {
    Scanner ulaz=new Scanner (System.in);
    System.out.println("Unesite broj: ");
    int n=ulaz.nextInt();
    System.out.println("Brojevi djeljivi sa sumom svojih cifara: ");
        for (int i = 1; i <= n; i++) {
            if(i%sumaCifara(i)==0)
                System.out.println("i = " + i);
        }
    }
}