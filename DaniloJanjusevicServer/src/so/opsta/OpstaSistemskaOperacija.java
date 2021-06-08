/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.opsta;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.ServerskiOdgovor;
import util.ResponseStatus;

/**
 *
 * @author Danilo
 */
public abstract class OpstaSistemskaOperacija {
    
    public ServerskiOdgovor izvrsiTransakciju(OpstiDomenskiObjekat odo){
        ServerskiOdgovor odgovor = new ServerskiOdgovor();
        try {
            DBBroker.getInstanca().ucitajDrajver();
            DBBroker.getInstanca().otvoriKonekciju();
            proveriUslove(odo);
            odgovor = izvrsiOperaciju(odo);
            DBBroker.getInstanca().commit();
        } catch (Exception ex) {
            Logger.getLogger(OpstaSistemskaOperacija.class.getName()).log(Level.SEVERE, null, ex);
            DBBroker.getInstanca().rollback();
            odgovor.setPoruka(ex.getMessage());
            odgovor.setResponseStatus(ResponseStatus.ERROR);
        }finally{
             try {
                 DBBroker.getInstanca().zatvoriKonekciju();
             } catch (SQLException ex) {
                 odgovor.setPoruka(ex.getMessage());
                 odgovor.setResponseStatus(ResponseStatus.ERROR);
             }
        
        }
        return odgovor;
    }
    
    public abstract void proveriUslove(OpstiDomenskiObjekat odo) throws Exception;
    
    public abstract ServerskiOdgovor izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception;
    
    
}
