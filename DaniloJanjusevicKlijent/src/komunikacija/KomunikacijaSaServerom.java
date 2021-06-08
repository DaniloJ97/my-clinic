/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Danilo
 */
public class KomunikacijaSaServerom {
    private static KomunikacijaSaServerom instanca;
    private Socket socket;

    private KomunikacijaSaServerom() {
        try {
            socket = new Socket("localhost",9000);
        } catch (IOException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static KomunikacijaSaServerom getInstanca() {
        if(instanca==null){
            instanca = new KomunikacijaSaServerom();
        }
        return instanca;
    }
    
    public void posaljiZahtev(KlijentskiZahtev zahtev){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(zahtev);
        } catch (IOException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ServerskiOdgovor prihvatiOdgovor(){
        ServerskiOdgovor odgovor = new ServerskiOdgovor();
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            odgovor = (ServerskiOdgovor) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        }
        return odgovor;
    }
    
    
    
    
    
}
