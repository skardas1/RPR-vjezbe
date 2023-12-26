package ba.unsa.etf.rpr;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;

public class GeografijaDAO {

    private static GeografijaDAO instance;
    private Connection konekcija;

    private GeografijaDAO()
    {
        try
        {
            String url="jdbc:sqlite:/C:/Users/merim/Desktop/baza.db";
            this.konekcija= DriverManager.getConnection(url);

            if(!bazaPostoji())
            {
                popuniBazu();
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    public boolean bazaPostoji()
    {
        File baza=new File("/C:/Users/merim/Desktop/baza.db");
        return baza.exists();
    }
    public void popuniBazu()
    {
        try {
            Statement s = konekcija.createStatement();


            //zamijeniti izvrsenje tab1 i stringa tab2
            String tabela1="CREATE TABLE IF NOT EXISTS Drzava (id INTEGER PRIMARY KEY, naziv TEXT NOT NULL, glavni_grad INTEGER, FOREIGN KEY (glavni_grad) REFERENCES Drzava(id))";
            s.executeUpdate(tabela1);
            String tabela2="CREATE TABLE IF NOT EXISTS GRAD (id INTEGER PRIMARY KEY, naziv TEXT NOT NULL, drzava INTEGER, FOREIGN KEY (drzava) REFERENCES Grad(id))";
            s.executeUpdate(tabela2);

            Drzava francuska = new Drzava("Francuska", null);
            Drzava velikaBritanija = new Drzava("Velika Britanija", null);
            Drzava austrija = new Drzava("Austrija", null);

            Grad pariz = new Grad(2000000, "Pariz", francuska);
            Grad london = new Grad(3000000, "London", velikaBritanija);
            Grad bec = new Grad(500000, "Beč", austrija);
            Grad manchester = new Grad(600000, "Manchester", velikaBritanija);
            Grad graz = new Grad(300000, "Graz", austrija);

            dodajDrzavu(francuska);
            dodajDrzavu(velikaBritanija);
            dodajDrzavu(austrija);

            dodajGrad(pariz);
            dodajGrad(london);
            dodajGrad(bec);
            dodajGrad(manchester);
            dodajGrad(graz);



            s.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

    }

    public void dodajDrzavu(Drzava drzava) {
        try {
            String upit = "INSERT INTO Drzava (naziv, glavni_grad) VALUES (?, ?);";
            PreparedStatement ps = konekcija.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, drzava.getNaziv());
            // Ako glavni_grad nije null, postavi odgovarajući ključ
            if (drzava.getGlavni_grad() != null) {
                ps.setInt(2, drzava.getGlavni_grad().getId());
            } else {
                ps.setNull(2, Types.INTEGER);
            }

            int promijenjeni_redovi = ps.executeUpdate();
            if (promijenjeni_redovi == 0) {
                throw new SQLException("Dodavanje države nije uspjelo");
            }

            // Postavi ID nakon dodavanja
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next())
                    drzava.setId(rs.getInt(1));
                else
                    throw new SQLException("Dodavanje države nije uspjelo (ID)");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }}
        public void dodajGrad(Grad grad) {
            try {
                String upit = "INSERT INTO Grad (naziv, drzava) VALUES (?, ?);";
                PreparedStatement ps = konekcija.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, grad.getNaziv());

                // Postavljamo referencu na državu
                if (grad.getDrzava() != null) {
                    ps.setInt(2, grad.getDrzava().getId());
                } else {
                    throw new IllegalArgumentException("Država ne može biti null za grad.");
                }

                int promijenjeniRedovi = ps.executeUpdate();
                if (promijenjeniRedovi == 0) {
                    throw new SQLException("Dodavanje grada nije uspjelo");
                }

                // Postavljanje ID nakon dodavanja
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next())
                        grad.setId(rs.getInt(1));
                    else
                        throw new SQLException("Dodavanje grada nije uspjelo (ID)");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    public static  GeografijaDAO getInstance()
    {
        if(instance==null)
            instance=new GeografijaDAO();
        return instance;
    }
    public ArrayList<Grad> gradovi()
    {
        ArrayList<Grad> gradovi=new ArrayList<>();

        try{
            String upit="SELECT g.id, g.naziv, g.broj_stanovnika, d.naziv AS drzava FROM Grad g JOIN Drzava d ON g.drzava=d.id ORDER BY g.broj_stanovnika DESC";
            PreparedStatement ps=konekcija.prepareStatement(upit);
            ResultSet rs=ps.executeQuery();

            while(rs.next())
            {
                Grad grad=new Grad();
                grad.setId(rs.getInt("id"));
                grad.setNaziv(rs.getString("naziv"));
                grad.setBroj_stanovnika(rs.getInt("broj_stanovnika"));

                Drzava drzava=new Drzava();
                drzava.setNaziv(rs.getString("drzava"));
                grad.setDrzava(drzava);

                gradovi.add(grad);
            }
            rs.close();
            ps.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return gradovi;
    }

    public Grad glavniGrad(String drzava)
    {
        try{

            String upit="SELECT g.id, g.naziv, g.broj_stanovnika, d.naziv "+
                    "FROM grad g " +
                    "JOIN drzava d " +
                    "ON g.drzava=d.id " +
                    "WHERE d.naziv=? " +
                    "ORDER BY g.broj_stanovnika ASC";
            PreparedStatement ps=konekcija.prepareStatement(upit);
            ps.setString(1,drzava);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                    Grad grad=new Grad();
                    grad.setId(rs.getInt("id"));
                    grad.setNaziv(rs.getString("naziv"));
                    grad.setBroj_stanovnika(rs.getInt("broj_stanovnika"));

                    Drzava drzave=new Drzava();
                    drzave.setNaziv(rs.getString("naziv"));
                    grad.setDrzava(drzave);

                   return grad;
                }
            rs.close();;
            ps.close();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public void obrisiDrzavu(String drzava)
    {
        try{
            konekcija.setAutoCommit(false);
            String upitgrad="DELETE FROM Grad WHERE drzava=(SELECT id FROM Drzava WHERE naziv=?);";
            try(PreparedStatement ps=konekcija.prepareStatement(upitgrad))
            {
                ps.setString(1,drzava);
                ps.executeUpdate();
            }

            String upitdrzava="DELETE FROM Drzava WHERE naziv=?;";
            try(PreparedStatement ps=konekcija.prepareStatement(upitdrzava))
            {
                ps.setString(1,drzava);
                ps.executeUpdate();
            }
            konekcija.commit();
        }
        catch (SQLException e)
        {
            try{
                konekcija.rollback();
            }
            catch(SQLException s)
            {
                s.printStackTrace();
            }
            e.printStackTrace();
        }
        finally {
            try{
                konekcija.setAutoCommit(true);
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void izmijeniGrad(Grad grad)
    {
        try{
            String upit="UPDATE Grad SET naziv=?, broj_stanovnika=?, drzava=(SELECT id FROM Drzava WHERE naziv=?" +
                    "WHERE id=?;";
            try(PreparedStatement ps=konekcija.prepareStatement(upit))
            {
                ps.setString(1,grad.getNaziv());
                ps.setInt(2, grad.getBroj_stanovnika());
                ps.setString(3,grad.getDrzava().getNaziv());
                ps.setInt(4,grad.getId());
                ps.executeUpdate();
            }

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public Drzava nadjiDrzavu(String drzava)
    {
        try{
            String upit="SELECT id, naziv FROM Drzava WHERE naziv=?;";
            try(PreparedStatement ps=konekcija.prepareStatement(upit))
            {
                ps.setString(1,drzava);

                ResultSet rs=ps.executeQuery();

                if(rs.next())
                {
                    Drzava dr=new Drzava();
                    dr.setId(rs.getInt("id"));
                    dr.setNaziv(rs.getString("naziv"));

                    return dr;
                }
                rs.close();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
