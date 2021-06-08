/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.korisnik;

import db.DBBroker;
import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.opsta.OpstaSistemskaOperacija;
import transfer.ServerskiOdgovor;
import util.ResponseStatus;

/**
 *
 * @author Danilo
 */
public class PrijaviKorisnikaSO extends OpstaSistemskaOperacija{

    @Override
    public void proveriUslove(OpstiDomenskiObjekat odo) throws Exception {
    }

    @Override
    public ServerskiOdgovor izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor serverskiOdgovor = new ServerskiOdgovor();
        List<OpstiDomenskiObjekat> lista = odo.vratiListu(DBBroker.getInstanca().select(odo));
        if(lista.isEmpty()){
            throw new Exception("Sistem nije pronašao korisnika za date podatke!");
        }
        Korisnik k = (Korisnik) lista.get(0);
        serverskiOdgovor.setResponseStatus(ResponseStatus.SUCCESS);
        serverskiOdgovor.setPodaci(k);
        serverskiOdgovor.setPoruka("Uspešno ste se prijavili!");
        return serverskiOdgovor;
    }
    
    
}
