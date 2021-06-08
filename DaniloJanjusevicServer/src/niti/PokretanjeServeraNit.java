/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import forme.GlavnaForma;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danilo
 */
public class PokretanjeServeraNit extends Thread{
    private GlavnaForma gf;
    private ServerSocket serverSocket;
    private Socket socket;

    public PokretanjeServeraNit(GlavnaForma gf) {
        this.gf = gf;
    }
    
    
    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(9000);
            gf.uspesnoPokretanje();
            System.out.println("Uspešno pokrenut server!");
            while(true){
                socket = serverSocket.accept();
                System.out.println("Klijent se povezao!");
                ObradaZahtevaNit obrada = new ObradaZahtevaNit(socket);
                obrada.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(PokretanjeServeraNit.class.getName()).log(Level.SEVERE, null, ex);
            gf.neuspesnoPokretanje();
        }
        
    }
    
    
    
    
    
}
