/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Lek;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Danilo
 */
public class LekTabelaModel extends AbstractTableModel{
    private String[] imenaKolona = new String[]{"JKL","ATC","Zaštićeno ime","Pakovanje i jačina"};
    private List<Lek> lekovi;

    public LekTabelaModel() {
        lekovi = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return lekovi.size();
    }

    @Override
    public int getColumnCount() {
        return imenaKolona.length;
    }

    @Override
    public Object getValueAt(int i, int j) {
        Lek l = lekovi.get(i);
        switch(j){
            case 0:
                return l.getJkl();
            case 1:
                return l.getAtc();
            case 2:
                return l.getZasticenoImeLeka();
            case 3:
                return l.getPakovanjeIJacina();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int i) {
        return imenaKolona[i];
    }

    public void setLekovi(List<Lek> lekovi) {
        this.lekovi = lekovi;
        fireTableDataChanged();
    }

    public List<Lek> getLekovi() {
        return lekovi;
    }
    
    
    public Lek vratiLek(int red){
        return lekovi.get(red);
    }
    
    
    
    
}
