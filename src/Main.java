public class Main {

    public static void main(String[] args) {
	Osoba o=new Osoba("Sara", "Kardas");
    System.out.println(o.toString());
    Racun k=new Racun((long)0 ,o);
    double novac=100;
    boolean uplata=k.izvrsiUplatu(100);
    if(uplata)
        System.out.println("Uplata od "+novac+" dobro izvrsena");
    else
        System.out.println("Uplata nije moguca");
    }
}
