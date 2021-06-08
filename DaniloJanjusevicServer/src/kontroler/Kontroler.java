/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.OpstiDomenskiObjekat;
import domen.ZakazaniPregled;
import so.dijagnoza.VratiListuDijagnozaSO;
import so.karton.IzmeniKartonSO;
import so.karton.DeaktivirajKartonSO;
import so.karton.SacuvajKartonSO;
import so.karton.VratiListuKartonaSO;
import so.karton.VratiMaxIdSO;
import so.korisnik.PrijaviKorisnikaSO;
import so.lek.VratiListuLekovaSO;
import so.lekar.VratiListuLekaraSO;
import so.pregled.SacuvajPregledSO;
import so.zakazanipregled.IzmeniZakazaniPregledSO;
import so.zakazanipregled.ObrisiZakazaniPregledSO;
import so.zakazanipregled.VratiListuZakazanihPregledaSO;
import so.zakazanipregled.ZakaziPregledSO;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Danilo
 */ 
public class Kontroler {
    private static Kontroler instanca;

    private Kontroler() {
    }

    public static Kontroler getInstanca() {
        if(instanca==null){
            instanca = new Kontroler();
        }
        return instanca;
    }

    public ServerskiOdgovor prijaviKorisnika(OpstiDomenskiObjekat odo) {
        return new PrijaviKorisnikaSO().izvrsiTransakciju(odo);
    }

    public ServerskiOdgovor vratiMaxId(OpstiDomenskiObjekat odo) {
        return new VratiMaxIdSO().izvrsiTransakciju(odo);
    }

    public ServerskiOdgovor sacuvajKarton(OpstiDomenskiObjekat odo) {
        return new SacuvajKartonSO().izvrsiTransakciju(odo);
    }

    public ServerskiOdgovor vratiListuKartona(OpstiDomenskiObjekat odo) {
        return new VratiListuKartonaSO().izvrsiTransakciju(odo);
    }

    public ServerskiOdgovor izmeniKarton(OpstiDomenskiObjekat odo) {
        return new IzmeniKartonSO().izvrsiTransakciju(odo);
    }

    public ServerskiOdgovor deaktivirajKarton(OpstiDomenskiObjekat odo) {
        return new DeaktivirajKartonSO().izvrsiTransakciju(odo);
    }

    public ServerskiOdgovor vratiListuLekara(OpstiDomenskiObjekat odo) {
        return new VratiListuLekaraSO().izvrsiTransakciju(odo);
    }

    public ServerskiOdgovor vratiListuDijagnoza(OpstiDomenskiObjekat odo) {
        return new VratiListuDijagnozaSO().izvrsiTransakciju(odo);
    }

    public ServerskiOdgovor vratiListuLekova(OpstiDomenskiObjekat odo) {
        return new VratiListuLekovaSO().izvrsiTransakciju(odo);
    }

    public ServerskiOdgovor vratiListuZakazanihPregleda(OpstiDomenskiObjekat odo) {
        return new VratiListuZakazanihPregledaSO().izvrsiTransakciju(odo);
    }

    public ServerskiOdgovor sacuvajPregled(OpstiDomenskiObjekat odo) {
        return new SacuvajPregledSO().izvrsiTransakciju(odo);
    }

    public ServerskiOdgovor zakaziPregled(OpstiDomenskiObjekat odo) {
        return new ZakaziPregledSO().izvrsiTransakciju(odo);
    }

    public ServerskiOdgovor obrisiZakazaniPregled(OpstiDomenskiObjekat odo) {
        return new ObrisiZakazaniPregledSO().izvrsiTransakciju(odo);
    }

    public ServerskiOdgovor izmeniZakazaniPregled(OpstiDomenskiObjekat odo) {
        return new IzmeniZakazaniPregledSO().izvrsiTransakciju(odo);
    }
    
    
    
}
