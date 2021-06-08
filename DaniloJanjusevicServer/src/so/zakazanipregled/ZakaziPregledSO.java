/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.zakazanipregled;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.ZakazaniPregled;
import java.sql.SQLException;
import so.opsta.OpstaSistemskaOperacija;
import transfer.ServerskiOdgovor;
import util.ResponseStatus;

/**
 *
 * @author Danilo
 */
public class ZakaziPregledSO extends OpstaSistemskaOperacija{

    @Override
    public void proveriUslove(OpstiDomenskiObjekat odo) throws Exception {
    }

    @Override
    public ServerskiOdgovor izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        Long max = DBBroker.getInstanca().vratiMaxId(odo);
        ZakazaniPregled zp = (ZakazaniPregled) odo;
        zp.setZakazaniPregledID(max);
        try {
            DBBroker.getInstanca().insert(zp);
            so.setResponseStatus(ResponseStatus.SUCCESS);
            so.setPoruka("Sistem je zakazao pregled!");
        } catch (Exception sQLException) {
            sQLException.printStackTrace();
            throw new Exception("Sistem nije zakazao pregled!");
        }
        return so;
    }
    
    
}
