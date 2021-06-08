/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.lek;

import db.DBBroker;
import domen.Lek;
import domen.OpstiDomenskiObjekat;
import java.sql.SQLException;
import java.util.List;
import so.opsta.OpstaSistemskaOperacija;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Danilo
 */
public class VratiListuLekovaSO extends OpstaSistemskaOperacija{

    @Override
    public void proveriUslove(OpstiDomenskiObjekat odo) throws Exception {
    }

    @Override
    public ServerskiOdgovor izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();        
        try {
            List<OpstiDomenskiObjekat> lekovi = odo.vratiListu(DBBroker.getInstanca().select(odo));
            if(lekovi.isEmpty()){
                throw new Exception("Sistem nije pronašao listu lekova!");
            }
            so.setPodaci(lekovi);
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
            throw new Exception("Sistem nije pronašao listu lekova!");
        }
        return so;
    }
    
    
}
