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
public class VratiListuKartonaSO extends OpstaSistemskaOperacija{

    @Override
    public void proveriUslove(OpstiDomenskiObjekat odo) throws Exception {
    }

    @Override
    public ServerskiOdgovor izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor odgovor = new ServerskiOdgovor();
        try {
            List<OpstiDomenskiObjekat> kartoni = odo.vratiListu(DBBroker.getInstanca().select(odo));
            if(kartoni.isEmpty()){
                throw new Exception("Sistem nije pronašao listu kartona!");
            }
            odgovor.setResponseStatus(ResponseStatus.SUCCESS);
            odgovor.setPodaci(kartoni);
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
            throw new Exception("Sistem nije pronašao listu kartona!");
        }
        return odgovor;
    }
    
    
    
}
