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
public class MedicinskaSestra extends Korisnik implements OpstiDomenskiObjekat{
    private boolean patronazna;

    public MedicinskaSestra() {
    }

    public MedicinskaSestra(boolean patronazna) {
        this.patronazna = patronazna;
    }

    public boolean isPatronazna() {
        return patronazna;
    }

    public void setPatronazna(boolean patronazna) {
        this.patronazna = patronazna;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiJoin() {
        return " INNER JOIN medicinskasestra m ON m.KorisnikID=k.KorisnikID ";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> medicinskeSestre = new ArrayList<>();
        while(rs.next()){
            MedicinskaSestra m = new MedicinskaSestra();
            m.setAdresa(rs.getString("Adresa"));
            m.setBrojTelefona(rs.getString("BrojTelefona"));
            m.setIme(rs.getString("Ime"));
            m.setJmbg(rs.getString("JMBG"));
            m.setKorisnickoIme(rs.getString("KorisnickoIme"));
            m.setKorisnikID(rs.getLong("KorisnikID"));
            m.setLozinka(rs.getString("Lozinka"));
            m.setPatronazna(rs.getBoolean("Patronazna"));
            m.setPrezime(rs.getString("Prezime"));
            m.setSmena(rs.getInt("Smena"));
            medicinskeSestre.add(m);
            System.out.println("Uspešno dodata");
        }
        return medicinskeSestre;
    }

    
    
    
    
    
    
    
}
