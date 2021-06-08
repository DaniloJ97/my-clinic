/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.OpstiDomenskiObjekat;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontroler.Kontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;
import util.Operacija;

/**
 *
 * @author Danilo
 */
public class ObradaZahtevaNit extends Thread{
    private Socket socket;
    private boolean kraj=false;

    public ObradaZahtevaNit(Socket socket) {
        this.socket = socket;
    }
    
    

    @Override
    public void run() {
        while(!kraj){
            KlijentskiZahtev zahtev = prihvatiZahtev();
            int operacija = zahtev.getOperacija();
            System.out.println("Operacija broj: "+operacija);
            OpstiDomenskiObjekat odo = (OpstiDomenskiObjekat) zahtev.getPodaci();
            ServerskiOdgovor odgovor = new ServerskiOdgovor();
            switch(operacija){
                case Operacija.LOGIN:
                    odgovor = Kontroler.getInstanca().prijaviKorisnika(odo);
                    break;
                case Operacija.VRATI_MAX_ID:
                    odgovor = Kontroler.getInstanca().vratiMaxId(odo);
                    break;
                case Operacija.SACUVAJ_KARTON:
                    odgovor = Kontroler.getInstanca().sacuvajKarton(odo);
                    break;
                case Operacija.VRATI_LISTU_KARTONA:
                    odgovor = Kontroler.getInstanca().vratiListuKartona(odo);
                    break;
                case Operacija.IZMENI_KARTON:
                    odgovor = Kontroler.getInstanca().izmeniKarton(odo);
                    break;
                case Operacija.DEAKTIVIRAJ_KARTON:
                    odgovor = Kontroler.getInstanca().deaktivirajKarton(odo);
                    break;
                case Operacija.VRATI_LISTU_LEKARA:
                    odgovor = Kontroler.getInstanca().vratiListuLekara(odo);
                    break;
                case Operacija.VRATI_LISTU_DIJAGNOZA:
                    odgovor = Kontroler.getInstanca().vratiListuDijagnoza(odo);
                    break;
                case Operacija.VRATI_LISTU_LEKOVA:
                    odgovor = Kontroler.getInstanca().vratiListuLekova(odo);
                    break;
                case Operacija.VRATI_LISTU_ZAKAZANIH_PREGLEDA:
                    odgovor = Kontroler.getInstanca().vratiListuZakazanihPregleda(odo);
                    break;
                case Operacija.SACUVAJ_PREGLED:
                    odgovor = Kontroler.getInstanca().sacuvajPregled(odo);
                    break;
                case Operacija.ZAKAZI_PREGLED:
                    odgovor = Kontroler.getInstanca().zakaziPregled(odo);
                    break;
                case Operacija.OBRISI_ZAKAZANI_PREGLED:
                    odgovor = Kontroler.getInstanca().obrisiZakazaniPregled(odo);
                    break;
                case Operacija.IZMENI_ZAKAZANI_PREGLED:
                    odgovor = Kontroler.getInstanca().izmeniZakazaniPregled(odo);
                    break;
            }
            posaljiOdgovor(odgovor);
        }
    }

    private KlijentskiZahtev prihvatiZahtev() {
        KlijentskiZahtev klijentskiZahtev = new KlijentskiZahtev();
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            klijentskiZahtev = (KlijentskiZahtev) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ObradaZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObradaZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return klijentskiZahtev;
    }

    private void posaljiOdgovor(ServerskiOdgovor odgovor) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(odgovor);
        } catch (IOException ex) {
            Logger.getLogger(ObradaZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
