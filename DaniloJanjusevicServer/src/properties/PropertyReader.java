/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danilo
 */
public class PropertyReader {
    private static PropertyReader instanca;
    private Properties properties;

    private PropertyReader() {
        FileInputStream fis=null;
        try {
            properties=new Properties();
            fis = new FileInputStream("db.properties");
            properties.load(fis);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PropertyReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PropertyReader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(PropertyReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static PropertyReader getInstanca() {
        if(instanca==null){
            instanca = new PropertyReader();
        }
        return instanca;
    }
    
    public String vratiVrednostaZaKljuc(String kljuc){
        return properties.getProperty(kljuc);
    }
    
    
    
}
