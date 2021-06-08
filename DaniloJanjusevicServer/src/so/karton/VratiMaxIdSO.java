/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.karton;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.opsta.OpstaSistemskaOperacija;
import transfer.ServerskiOdgovor;
import util.ResponseStatus;

/**
 *
 * @author Danilo
 */
public class VratiMaxIdSO extends OpstaSistemskaOperacija{

    @Override
    public void proveriUslove(OpstiDomenskiObjekat odo) throws Exception {
    }

    @Override
    public ServerskiOdgovor izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor odgovor = new ServerskiOdgovor();
        Long max = DBBroker.getInstanca().vratiMaxId(odo);
        odgovor.setPodaci(max);
        odgovor.setResponseStatus(ResponseStatus.SUCCESS);
        return odgovor;
    }
    
    
}
