/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Recept;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Danilo
 */
public class ReceptTabelaModel extends AbstractTableModel{
    private String[] imenaKolona = new String[]{"Naziv leka","Datum propisivanja","Hitno","Ukupna dnevna doza","Jedinica"};
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
    private List<Recept> recepti;

    public ReceptTabelaModel() {
        recepti = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return recepti.size();
    }

    @Override
    public int getColumnCount() {
        return imenaKolona.length;
    }

    @Override
    public Object getValueAt(int i, int j) {
        Recept r = recepti.get(i);
        switch(j){
            case 0:
                return r.getLek();
            case 1:
                return sdf.format(r.getDatumPropisivanja());
            case 2:
                return r.isHitno();
            case 3:
                return r.getKolicina()*r.getDoza();
            case 4:
                return r.getMernaJedinica();
            default:
                return "n/a";

        }
    }

    @Override
    public String getColumnName(int i) {
        return imenaKolona[i];
    }

    public void dodajRecept(Recept r){
        recepti.add(r);
        fireTableDataChanged();
    }

    @Override
    public Class<?> getColumnClass(int i) {
        if(i==2){
            return Boolean.class;
        }
        return Object.class;
    }

    public void obrisiRecept(int red) {
        recepti.remove(red);
        fireTableDataChanged();
    }

    public List<Recept> getRecepti() {
        return recepti;
    }

    public void setRecepti(List<Recept> recepti) {
        this.recepti = recepti;
        fireTableDataChanged();
    }
    
    
    
    
    
}
