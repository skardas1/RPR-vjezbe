package ba.unsa.etf.rpr;

import java.io.Serializable;

public class Laptop  implements Serializable {
    private String brend;
    private String model;
    private double cijena;
    private int ram;
    private int hdd;
    private int ssd;
    private String procesor;
    private String grafickaKartica;
    private double velicinaEkrana;


    public Laptop(String brend, String model, double cijena, int ram, int hdd, int ssd, String procesor, String grafickaKartica, double velicinaEkrana)
    {
        this.brend = brend;
        this.model = model;
        this.cijena = cijena;
        this.ram = ram;
        this.hdd = hdd;
        this.ssd = ssd;
        this.procesor = procesor;
        this.grafickaKartica = grafickaKartica;
        this.velicinaEkrana = velicinaEkrana;
    }
    public String getBrend() {
        return brend;
    }

    public String getModel() {
        return model;
    }

    public double getCijena() {
        return cijena;
    }

    public int getRam() {
        return ram;
    }

    public int getHdd() {
        return hdd;
    }

    public String getProcesor(){return procesor;}

    public int getSsd() {
        return ssd;
    }

    public String getGrafickaKartica() {
        return grafickaKartica;
    }

    public double getVelicinaEkrana() {
        return velicinaEkrana;
    }

    public void setBrend(String brend) {
        this.brend = brend;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public void setSsd(int ssd) {
        this.ssd = ssd;
    }

    public void setProcesor(String procesor) {
        this.procesor = procesor;
    }

    public void setGrafickaKartica(String grafickaKartica) {
        this.grafickaKartica = grafickaKartica;
    }

    public void setVelicinaEkrana(double velicinaEkrana) {
        this.velicinaEkrana = velicinaEkrana;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brend='" + brend + '\'' +
                ", model='" + model + '\'' +
                ", cijena=" + cijena +
                ", ram=" + ram +
                ", hdd=" + hdd +
                ", ssd=" + ssd +
                ", procesor='" + procesor + '\'' +
                ", grafickaKartica='" + grafickaKartica + '\'' +
                ", velicinaEkrana=" + velicinaEkrana +
                '}';
    }

    /*JavaBeans specifikacije su:
    * klasa mora imati:
    *   javne gettere i settere
    *   podrazumijevani konstruktor
    *   klasa mora biti serializable   import java.io.Serializable;
     *   mora se koristiti camelCase
     *  json file:
     *  <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.13.0</version> <!-- Use the latest version -->
    </dependency>
     *
    * */
}
