/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.pregled;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Pregled;
import domen.Recept;
import domen.ZakazaniPregled;
import java.sql.SQLException;
import java.util.List;
import so.opsta.OpstaSistemskaOperacija;
import transfer.ServerskiOdgovor;
import util.ResponseStatus;

/**
 *
 * @author Danilo
 */
public class SacuvajPregledSO extends OpstaSistemskaOperacija{

    @Override
    public void proveriUslove(OpstiDomenskiObjekat odo) throws Exception {
    }

    @Override
    public ServerskiOdgovor izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor serverskiOdgovor = new ServerskiOdgovor();
        try {
            Pregled pregled = (Pregled) odo;
            Long max = DBBroker.getInstanca().vratiMaxId(odo);
            pregled.setPregledID(max);
            DBBroker.getInstanca().insert(odo);
            if(pregled.getZakazaniPregled()!=null){
                ZakazaniPregled zp = pregled.getZakazaniPregled();
                zp.setPregled(pregled);
                DBBroker.getInstanca().update(pregled.getZakazaniPregled());
            }
            List<Recept> recepti = pregled.getRecepti();
            for (Recept recept : recepti) {
                recept.setPregled(pregled);
                DBBroker.getInstanca().insert(recept);
            }
            serverskiOdgovor.setResponseStatus(ResponseStatus.SUCCESS);
            serverskiOdgovor.setPoruka("Sistem je sačuvao pregled!");
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
            throw new Exception("Sistem nije sačuvao pregled!");
        }
        return serverskiOdgovor;
    }
    
    
}
