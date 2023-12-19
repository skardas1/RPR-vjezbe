package ba.unsa.etf.rpr.lv7i8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KorisniciModelTest {

    @Test
    void setTrenutniKorisnik() {
        KorisniciModel m=new KorisniciModel();
        Korisnik korisnik=new Korisnik("Ana","Anic","aanic@etf.unsa.ba","aanic1","123456*");
        m.setTrenutniKorisnik(korisnik);
        assertEquals(korisnik, m.getTrenutniKorisnik());
    }

    @Test
    void dodajPraznogKorisnika() {
        KorisniciModel m=new KorisniciModel();
        Korisnik korisnik=new Korisnik();
        m.setTrenutniKorisnik(korisnik);
        assertEquals(korisnik, m.getTrenutniKorisnik());
    }

    @Test
    void dodajNovogKorisnika() {
        KorisniciModel m=new KorisniciModel();
        Korisnik korisnik=new Korisnik("Ana","Anic","aanic@etf.unsa.ba","aanic1","123456*");
        m.dodajNovogKorisnika(korisnik);
        assertTrue(m.getKorisnici().contains(korisnik));
    }
}