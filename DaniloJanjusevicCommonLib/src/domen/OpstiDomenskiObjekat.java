/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Danilo
 */
public interface OpstiDomenskiObjekat extends Serializable{
    
    
    public String vratiKoloneKojeSelektujes();

    public String vratiNazivTabele();

    public String vratiAlijas();

    public String vratiWhereUslovSel();

    public String vratiJoin();

    public String vratiOrderBy();

    public String vratiPrimarniKljuc();

    public String vratiNaziveKolona();

    public String vratiVrednostiZaInsert();

    public String vratiWhereUslov();

    public String vratiVrednostiZaUpdate();

    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException;
    
    
}
