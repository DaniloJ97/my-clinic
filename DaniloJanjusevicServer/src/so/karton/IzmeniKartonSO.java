/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.karton;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import java.sql.SQLException;
import java.sql.SQLWarning;
import so.opsta.OpstaSistemskaOperacija;
import transfer.ServerskiOdgovor;
import util.ResponseStatus;

/**
 *
 * @author Danilo
 */
public class IzmeniKartonSO extends OpstaSistemskaOperacija{

    @Override
    public void proveriUslove(OpstiDomenskiObjekat odo) throws Exception {
        
    }

    @Override
    public ServerskiOdgovor izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            DBBroker.getInstanca().update(odo);
            so.setResponseStatus(ResponseStatus.SUCCESS);
            so.setPoruka("Sistem je izmenio karton!");
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
            throw new Exception("Sistem nije izmenio karton!");
        }
        return so;
    }
    
    
}
