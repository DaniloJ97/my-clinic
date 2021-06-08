/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Dijagnoza;
import domen.Karton;
import domen.Korisnik;
import domen.Lek;
import domen.Lekar;
import domen.Pregled;
import domen.ZakazaniPregled;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.KomunikacijaSaServerom;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;
import util.Operacija;
import util.ResponseStatus;

/**
 *
 * @author Danilo
 */
public class Kontroler {
    private static Kontroler instanca;
    private Korisnik ulogovani;

    private Kontroler() {
    }

    public static Kontroler getInstanca() {
        if(instanca==null){
            instanca = new Kontroler();
        }
        return instanca;
    }

    public boolean prijaviKorisnika(Korisnik korisnik) {
        KlijentskiZahtev zahtev = new KlijentskiZahtev();
        zahtev.setOperacija(Operacija.LOGIN);
        zahtev.setPodaci(korisnik);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(zahtev);
        ServerskiOdgovor odgovor = KomunikacijaSaServerom.getInstanca().prihvatiOdgovor();
        if(odgovor.getResponseStatus()==ResponseStatus.ERROR){
            JOptionPane.showMessageDialog(null, odgovor.getPoruka(),"Greška", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        JOptionPane.showMessageDialog(null, odgovor.getPoruka(), "Poruka",JOptionPane.INFORMATION_MESSAGE);
        ulogovani = (Korisnik) odgovor.getPodaci();
        return true;
    }

    public Korisnik getUlogovani() {
        return ulogovani;
    }

    public Long vratiMaxId(Karton karton) {
        KlijentskiZahtev zahtev = new KlijentskiZahtev();
        zahtev.setOperacija(Operacija.VRATI_MAX_ID);
        zahtev.setPodaci(karton);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(zahtev);
        ServerskiOdgovor odgovor = KomunikacijaSaServerom.getInstanca().prihvatiOdgovor();
        Long max = (Long) odgovor.getPodaci();
        return max;
    }

    public ServerskiOdgovor sacuvajKarton(Karton karton) {
        KlijentskiZahtev zahtev = new KlijentskiZahtev();
        zahtev.setOperacija(Operacija.SACUVAJ_KARTON);
        zahtev.setPodaci(karton);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(zahtev);
        ServerskiOdgovor odgovor = KomunikacijaSaServerom.getInstanca().prihvatiOdgovor();
        return odgovor;
    }

    public List<Karton> vratiListuKartona(Karton karton) {
        KlijentskiZahtev zahtev = new KlijentskiZahtev();
        zahtev.setOperacija(Operacija.VRATI_LISTU_KARTONA);
        zahtev.setPodaci(karton);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(zahtev);
        ServerskiOdgovor odgovor = KomunikacijaSaServerom.getInstanca().prihvatiOdgovor();
        if(odgovor.getResponseStatus()==ResponseStatus.ERROR){
            JOptionPane.showMessageDialog(null, odgovor.getPoruka(),"Greška",JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
        List<Karton> kartoni = (List<Karton>) odgovor.getPodaci();
        return kartoni;
    }

    public ServerskiOdgovor izmeniKarton(Karton karton) {
        KlijentskiZahtev zahtev = new KlijentskiZahtev();
        zahtev.setOperacija(Operacija.IZMENI_KARTON);
        zahtev.setPodaci(karton);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(zahtev);
        ServerskiOdgovor serverskiOdgovor = KomunikacijaSaServerom.getInstanca().prihvatiOdgovor();
        return serverskiOdgovor;
    }

    public ServerskiOdgovor deaktivirajKarton(Karton k) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.DEAKTIVIRAJ_KARTON);
        kz.setPodaci(k);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().prihvatiOdgovor();
        return so;
    }

    public List<Lekar> vratiListuLekara(Korisnik k) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.VRATI_LISTU_LEKARA);
        kz.setPodaci(k);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().prihvatiOdgovor();
        if(so.getResponseStatus()==ResponseStatus.ERROR){
            JOptionPane.showMessageDialog(null, so.getPoruka(), "Greška", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
        List<Lekar> lekari = (List<Lekar>) so.getPodaci();
        return lekari;
    }

    public List<Dijagnoza> vratiListuDijagnoza(Dijagnoza dijagnoza) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.VRATI_LISTU_DIJAGNOZA);
        kz.setPodaci(dijagnoza);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().prihvatiOdgovor();
        if(so.getResponseStatus()==ResponseStatus.ERROR){
            JOptionPane.showMessageDialog(null, so.getPoruka(), "Greška", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
        List<Dijagnoza> dijagnoze = (List<Dijagnoza>) so.getPodaci();
        return dijagnoze;
    }

    public List<Lek> vratiListuLekova(Lek lek) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.VRATI_LISTU_LEKOVA);
        kz.setPodaci(lek);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().prihvatiOdgovor();
        if(so.getResponseStatus()==ResponseStatus.ERROR){
            JOptionPane.showMessageDialog(null, so.getPoruka(), "Greška", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
        List<Lek> lekovi = (List<Lek>) so.getPodaci();
        return lekovi;
    }

    public List<ZakazaniPregled> vratiListuZakazanihPregleda(ZakazaniPregled zp) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.VRATI_LISTU_ZAKAZANIH_PREGLEDA);
        kz.setPodaci(zp);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().prihvatiOdgovor();
        if(so.getResponseStatus()==ResponseStatus.ERROR){
            JOptionPane.showMessageDialog(null, so.getPoruka(), "Greška", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
        List<ZakazaniPregled> lista = (List<ZakazaniPregled>) so.getPodaci();
        return lista;
    }

    public ServerskiOdgovor sacuvajPregled(Pregled pregled) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.SACUVAJ_PREGLED);
        kz.setPodaci(pregled);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().prihvatiOdgovor();
        return so;
    }

    public ServerskiOdgovor zakaziPregled(ZakazaniPregled zp) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.ZAKAZI_PREGLED);
        kz.setPodaci(zp);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().prihvatiOdgovor();
        return so;
    }

    public ServerskiOdgovor obrisiZakazaniPregled(ZakazaniPregled zp) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.OBRISI_ZAKAZANI_PREGLED);
        kz.setPodaci(zp);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().prihvatiOdgovor();
        return so;
    }

    public ServerskiOdgovor izmeniZakazaniPregled(ZakazaniPregled zp) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.IZMENI_ZAKAZANI_PREGLED);
        kz.setPodaci(zp);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().prihvatiOdgovor();
        return so;
        
    }

   
    
    
    
    
    
}
