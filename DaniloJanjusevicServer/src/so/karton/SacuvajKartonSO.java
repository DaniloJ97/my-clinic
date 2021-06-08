/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.karton;

import db.DBBroker;
import domen.Karton;
import domen.OpstiDomenskiObjekat;
import java.sql.SQLException;
import java.util.List;
import so.opsta.OpstaSistemskaOperacija;
import transfer.ServerskiOdgovor;
import util.ResponseStatus;

/**
 *
 * @author Danilo
 */
public class SacuvajKartonSO extends OpstaSistemskaOperacija{

    @Override
    public void proveriUslove(OpstiDomenskiObjekat odo) throws Exception {
    }

    @Override
    public ServerskiOdgovor izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor odgovor = new ServerskiOdgovor();
        try {
            DBBroker.getInstanca().insert(odo);
            odgovor.setResponseStatus(ResponseStatus.SUCCESS);
            odgovor.setPoruka("Sistem je sačuvao karton!");
            
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
            throw new Exception("Sistem nije sačuvao karton!");
        }
        return odgovor;
    }
    
}
