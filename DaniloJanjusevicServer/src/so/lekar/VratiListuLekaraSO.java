/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.lekar;

import db.DBBroker;
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
public class VratiListuLekaraSO extends OpstaSistemskaOperacija{

    @Override
    public void proveriUslove(OpstiDomenskiObjekat odo) throws Exception {
    }

    @Override
    public ServerskiOdgovor izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            List<OpstiDomenskiObjekat> lista = odo.vratiListu(DBBroker.getInstanca().select(odo));
            if(lista.isEmpty()){
                throw new Exception("Sistem nije pronašao listu lekara!");
            }
            so.setResponseStatus(ResponseStatus.SUCCESS);
            so.setPodaci(lista);
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
            throw new Exception("Sistem nije pronašao listu lekara!!");
        }
        return so;
    }
    
    
}
