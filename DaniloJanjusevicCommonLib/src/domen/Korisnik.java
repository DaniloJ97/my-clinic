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
import java.util.Objects;

/**
 *
 * @author Danilo
 */
public class Korisnik implements OpstiDomenskiObjekat{
    private Long korisnikID;
    private String korisnickoIme;
    private String lozinka;
    private String ime;
    private String prezime;
    private String jmbg;
    private String brojTelefona;
    private String adresa;
    private int smena;

    public Korisnik() {
    }

    public Korisnik(Long korisnikID, String korisnickoIme, String lozinka, String ime, String prezime, String jmbg, String brojTelefona, String adresa, int smena) {
        this.korisnikID = korisnikID;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.brojTelefona = brojTelefona;
        this.adresa = adresa;
        this.smena = smena;
    }

    public Long getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(Long korisnikID) {
        this.korisnikID = korisnikID;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getSmena() {
        return smena;
    }

    public void setSmena(int smena) {
        this.smena = smena;
    }

    @Override
    public String toString() {
        return ime+" "+prezime;
    }

  

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Korisnik other = (Korisnik) obj;
        if (!Objects.equals(this.korisnikID, other.korisnikID)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String vratiKoloneKojeSelektujes() {
        return " * ";
    }

    @Override
    public String vratiNazivTabele() {
        return " korisnik ";
    }

    @Override
    public String vratiAlijas() {
        return " k ";
    }

    @Override
    public String vratiWhereUslovSel() {
        if(korisnickoIme!=null && lozinka!=null){
        return " WHERE KorisnickoIme='"+korisnickoIme+"' AND Lozinka='"+lozinka+"'";
        }
        return "";
    }

    @Override
    public String vratiJoin() {
        return "";
    }
    

    @Override
    public String vratiOrderBy() {
        return "";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "";
    }

    @Override
    public String vratiNaziveKolona() {
        return "";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "";
    }

    @Override
    public String vratiWhereUslov() {
        return "";

    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        return null;
    }
    
    

  
}
