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
public class Dijagnoza implements OpstiDomenskiObjekat{
    private Long dijagnozaID;
    private String naziv;
    private String oznaka;
    private String latinskiNaziv;

    public Dijagnoza() {
    }

    public Dijagnoza(Long dijagnozaID, String naziv, String oznaka, String latinskiNaziv) {
        this.dijagnozaID = dijagnozaID;
        this.naziv = naziv;
        this.oznaka = oznaka;
        this.latinskiNaziv = latinskiNaziv;
    }

    

    public Long getDijagnozaID() {
        return dijagnozaID;
    }

    public void setDijagnozaID(Long dijagnozaID) {
        this.dijagnozaID = dijagnozaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public String getLatinskiNaziv() {
        return latinskiNaziv;
    }

    public void setLatinskiNaziv(String latinskiNaziv) {
        this.latinskiNaziv = latinskiNaziv;
    }
    
    

    @Override
    public String toString() {
        return naziv;
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
        final Dijagnoza other = (Dijagnoza) obj;
        if (!Objects.equals(this.dijagnozaID, other.dijagnozaID)) {
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
        return " dijagnoza ";
    }

    @Override
    public String vratiAlijas() {
        return " d ";
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
        return "";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "DijagnozaID";
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
            Dijagnoza d = new Dijagnoza();
            d.setDijagnozaID(rs.getLong("DijagnozaID"));
            d.setLatinskiNaziv(rs.getString("LatinskiNaziv"));
            d.setNaziv(rs.getString("Naziv"));
            d.setOznaka(rs.getString("Oznaka"));
            lista.add(d);
        }
        return lista;
    }
    
    

    
    
}
