/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.ZakazaniPregled;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Danilo
 */
public class ZakazaniPregledTabelaModel extends AbstractTableModel{
    private String[] imenaKolona = new String[]{"Datum i vreme pregleda","Pacijent","Lekar"};
    private List<ZakazaniPregled> pregledi;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy. HH:mm");

    public ZakazaniPregledTabelaModel() {
        pregledi = new ArrayList<>();
    }

    
    
    @Override
    public int getRowCount() {
        return pregledi.size();
    }

    @Override
    public int getColumnCount() {
        return imenaKolona.length;
    }

    @Override
    public Object getValueAt(int i, int j) {
        ZakazaniPregled z = pregledi.get(i);
        switch(j){
            case 0:
                return sdf.format(z.getDatumZakazanogPregleda());
            case 1:
                return z.getKarton();
            case 2:
                return z.getLekar();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int i) {
        return imenaKolona[i];
    }

    public void setPregledi(List<ZakazaniPregled> pregledi) {
        this.pregledi = pregledi;
        fireTableDataChanged();
    }

    public List<ZakazaniPregled> getPregledi() {
        return pregledi;
    }
    
    public ZakazaniPregled vratiZakazaniPregled(int red){
        return pregledi.get(red);
    }
    
    
    
}
