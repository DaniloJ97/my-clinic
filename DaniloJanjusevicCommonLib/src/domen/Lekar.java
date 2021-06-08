/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class Lekar extends Korisnik{
    private String specijalnost;
    private double ocenaPacijenata;

    public Lekar() {
    }

    public Lekar(String specijalnost, boolean dezuran, double ocenaPacijenata) {
        this.specijalnost = specijalnost;
        this.ocenaPacijenata = ocenaPacijenata;
    }

    public String getSpecijalnost() {
        return specijalnost;
    }

    public void setSpecijalnost(String specijalnost) {
        this.specijalnost = specijalnost;
    }



    public double getOcenaPacijenata() {
        return ocenaPacijenata;
    }

    public void setOcenaPacijenata(double ocenaPacijenata) {
        this.ocenaPacijenata = ocenaPacijenata;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiJoin() {
        return " INNER JOIN lekar l ON l.KorisnikID=k.KorisnikID ";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> lekari = new ArrayList<>();
        while(rs.next()){
            Lekar l = new Lekar();
            l.setAdresa(rs.getString("Adresa"));
            l.setBrojTelefona(rs.getString("BrojTelefona"));
            l.setIme(rs.getString("Ime"));
            l.setJmbg(rs.getString("JMBG"));
            l.setKorisnickoIme(rs.getString("KorisnickoIme"));
            l.setKorisnikID(rs.getLong("KorisnikID"));
            l.setLozinka(rs.getString("Lozinka"));
            l.setOcenaPacijenata(rs.getDouble("OcenaPacijenata"));
            l.setPrezime(rs.getString("Prezime"));
            l.setSmena(rs.getInt("Smena"));
            l.setSpecijalnost(rs.getString("Specijalnost"));
            lekari.add(l);
        }
        return lekari;
    }

    
    
    
    
    
    
}
