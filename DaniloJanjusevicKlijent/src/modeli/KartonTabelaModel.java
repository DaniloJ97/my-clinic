/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Karton;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Danilo
 */
public class KartonTabelaModel extends AbstractTableModel{
    private String[] imenaKolona = new String[]{"Ime","Prezime","LBO","Broj knjižice","Adresa","Broj telefona"};
    private List<Karton> kartoni;

    public KartonTabelaModel() {
        kartoni = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return kartoni.size();
    }

    @Override
    public int getColumnCount() {
        return imenaKolona.length;
    }

    @Override
    public Object getValueAt(int i, int j) {
        Karton k = kartoni.get(i);
        switch(j){
            case 0:
                return k.getIme();
            case 1:
                return k.getPrezime();
            case 2:
                return k.getLbo();
            case 3:
                return k.getBrojKnjizice();
            case 4:
                return k.getAdresa();
            case 5:
                return k.getBrojTelefona();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int i) {
        return imenaKolona[i];
    }

    public List<Karton> getKartoni() {
        return kartoni;
    }

    public void setKartoni(List<Karton> kartoni) {
        this.kartoni = kartoni;
        fireTableDataChanged();
    }
    
    public Karton vratiKarton(int red){
        return kartoni.get(red);
    }
    
    
    
}
