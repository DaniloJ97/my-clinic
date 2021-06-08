/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validacija;

import javax.swing.JTextField;

/**
 *
 * @author Danilo
 */
public class OpstaValidacija {
    private static OpstaValidacija instanca;
    private String poruka="";

    private OpstaValidacija() {
    }

    public static OpstaValidacija getInstanca() {
        if(instanca==null){
            instanca = new OpstaValidacija();
        }
        return instanca;
    }
    
    public boolean daLiSuPoljaPopunjena(JTextField... polja){
        boolean svePopunjeno=true;
        int ukupno=0;
        for (JTextField jTextField : polja) {
            if(jTextField.getText().isEmpty()){
                ukupno++;
                svePopunjeno=false;
            }
        }
        if(!svePopunjeno){
            if(ukupno==1){
                poruka="Polje ne sme biti prazno!";
            }
            else{
                poruka="Polja ne smeju biti prazna!";
            }
        }
        return svePopunjeno;
    }

    public String getPoruka() {
        return poruka;
    }
    
    
    
}
