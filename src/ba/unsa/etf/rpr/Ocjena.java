package ba.unsa.etf.rpr;

public class Ocjena implements MozeOcijeniti{

    LicneInformacije osoba;
    int ocjena;

    Ocjena(LicneInformacije osoba, int ocjena)
    {
        this.ocjena=ocjena;
        setOcjena(ocjena); //odmah provjerava velicinu ocjene
    }

    public LicneInformacije getOsoba() {
        return osoba;
    }

    public int getOcjena() {
        return ocjena;
    }

    public void setOcjena(int ocjena) {
        if(ocjena<=0 || ocjena>10)
            throw new IllegalArgumentException("Nepravlno unesena ocjena!");
        else this.ocjena = ocjena;
    }

    @Override
    public Ocjena ocijeni(int x) {
        setOcjena(x);
        return this;
    }

    @Override
    public String toString()
    {
        return ""+this.getOcjena();
    }
}
