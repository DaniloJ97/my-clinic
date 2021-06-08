/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;
import util.ResponseStatus;

/**
 *
 * @author Danilo
 */
public class ServerskiOdgovor implements Serializable{
    private String poruka;
    private Object podaci;
    private ResponseStatus responseStatus;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(String poruka, Object podaci, ResponseStatus responseStatus) {
        this.poruka = poruka;
        this.podaci = podaci;
        this.responseStatus = responseStatus;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public Object getPodaci() {
        return podaci;
    }

    public void setPodaci(Object podaci) {
        this.podaci = podaci;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
    
    
    
}
