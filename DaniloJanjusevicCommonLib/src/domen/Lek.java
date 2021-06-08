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
public class Lek implements OpstiDomenskiObjekat{
    private Long lekID;
    private String jkl;
    private String inn;
    private String atc;
    private String zasticenoImeLeka;
    private String farmaceutskiOblik;
    private String pakovanjeIJacina;
    private String proizvodjac;
    private String indikacija;
    private String napomena;
    private Double ddd;
    private String jedinicaZaDDD;

    public Lek() {
    }

    public Lek(Long lekID, String jkl, String inn, String atc, String zasticenoImeLeka, String farmaceutskiOblik, String pakovanjeIJacina, String proizvodjac, String indikacija, String napomena, Double ddd, String jedinicaZaDDD) {
        this.lekID = lekID;
        this.jkl = jkl;
        this.inn = inn;
        this.atc = atc;
        this.zasticenoImeLeka = zasticenoImeLeka;
        this.farmaceutskiOblik = farmaceutskiOblik;
        this.pakovanjeIJacina = pakovanjeIJacina;
        this.proizvodjac = proizvodjac;
        this.indikacija = indikacija;
        this.napomena = napomena;
        this.ddd = ddd;
        this.jedinicaZaDDD = jedinicaZaDDD;
    }

    


    public Long getLekID() {
        return lekID;
    }

    public void setLekID(Long lekID) {
        this.lekID = lekID;
    }

    public String getJkl() {
        return jkl;
    }

    public void setJkl(String jkl) {
        this.jkl = jkl;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getAtc() {
        return atc;
    }

    public void setAtc(String atc) {
        this.atc = atc;
    }

    public String getZasticenoImeLeka() {
        return zasticenoImeLeka;
    }

    public void setZasticenoImeLeka(String zasticenoImeLeka) {
        this.zasticenoImeLeka = zasticenoImeLeka;
    }

    public String getFarmaceutskiOblik() {
        return farmaceutskiOblik;
    }

    public void setFarmaceutskiOblik(String farmaceutskiOblik) {
        this.farmaceutskiOblik = farmaceutskiOblik;
    }

    public String getPakovanjeIJacina() {
        return pakovanjeIJacina;
    }

    public void setPakovanjeIJacina(String pakovanjeIJacina) {
        this.pakovanjeIJacina = pakovanjeIJacina;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public String getIndikacija() {
        return indikacija;
    }

    public void setIndikacija(String indikacija) {
        this.indikacija = indikacija;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public Double getDdd() {
        return ddd;
    }

    public void setDdd(Double ddd) {
        this.ddd = ddd;
    }

    public String getJedinicaZaDDD() {
        return jedinicaZaDDD;
    }

    public void setJedinicaZaDDD(String jedinicaZaDDD) {
        this.jedinicaZaDDD = jedinicaZaDDD;
    }
    
    

    @Override
    public String toString() {
        return inn;
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
        final Lek other = (Lek) obj;
        if (!Objects.equals(this.lekID, other.lekID)) {
            return false;
        }
        return true;
    }

   

    @Override
    public String vratiNazivTabele() {
        return " lek ";
    }

    @Override
    public String vratiAlijas() {
        return " lek ";
    }

    @Override
    public String vratiWhereUslovSel() {
        return "";
    }

    @Override
    public String vratiJoin() {
        return "";
    }

    @Override
    public String vratiOrderBy() {
        return " ORDER BY ZasticenoImeLeka ";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "LekID";
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
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            Lek l = new Lek();
            l.setAtc(rs.getString("ATC"));
            l.setDdd(rs.getDouble("DDD"));
            l.setFarmaceutskiOblik(rs.getString("FarmaceutskiOblik"));
            l.setIndikacija(rs.getString("Indikacija"));
            l.setInn(rs.getString("INN"));
            l.setJedinicaZaDDD(rs.getString("JedinicaZaDDD"));
            l.setJkl(rs.getString("JKL"));
            l.setLekID(rs.getLong("LekID"));
            l.setNapomena(rs.getString("Napomena"));
            l.setPakovanjeIJacina(rs.getString("PakovanjeIJacina"));
            l.setProizvodjac(rs.getString("Proizvodjac"));
            l.setZasticenoImeLeka(rs.getString("ZasticenoImeLeka"));
            lista.add(l);
        }
        return lista;
    }

    @Override
    public String vratiKoloneKojeSelektujes() {
        return " * ";
    }
    
    
    
    
    
}
