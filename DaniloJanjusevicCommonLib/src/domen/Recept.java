/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class Recept implements OpstiDomenskiObjekat{
    private Long receptID;
    private Date datumPropisivanja;
    private boolean hitno;
    private boolean neZamenjuj;
    private int kolicina;
    private double doza;
    private MernaJedinica mernaJedinica;
    private String napomena;
    private Lek lek;
    private Pregled pregled;

    public Recept() {
    }

    public Recept(Long receptID, Date datumPropisivanja, boolean hitno, boolean neZamenjuj, int kolicina, double doza, MernaJedinica mernaJedinica, String napomena, Lek lek, Pregled pregled) {
        this.receptID = receptID;
        this.datumPropisivanja = datumPropisivanja;
        this.hitno = hitno;
        this.neZamenjuj = neZamenjuj;
        this.kolicina = kolicina;
        this.doza = doza;
        this.mernaJedinica = mernaJedinica;
        this.napomena = napomena;
        this.lek = lek;
        this.pregled = pregled;
    }
    
    


    public Long getReceptID() {
        return receptID;
    }

    public void setReceptID(Long receptID) {
        this.receptID = receptID;
    }

    public Date getDatumPropisivanja() {
        return datumPropisivanja;
    }

    public void setDatumPropisivanja(Date datumPropisivanja) {
        this.datumPropisivanja = datumPropisivanja;
    }

    public boolean isHitno() {
        return hitno;
    }

    public void setHitno(boolean hitno) {
        this.hitno = hitno;
    }

    public boolean isNeZamenjuj() {
        return neZamenjuj;
    }

    public void setNeZamenjuj(boolean neZamenjuj) {
        this.neZamenjuj = neZamenjuj;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getDoza() {
        return doza;
    }

    public void setDoza(double doza) {
        this.doza = doza;
    }

    public MernaJedinica getMernaJedinica() {
        return mernaJedinica;
    }

    public void setMernaJedinica(MernaJedinica mernaJedinica) {
        this.mernaJedinica = mernaJedinica;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public Lek getLek() {
        return lek;
    }

    public void setLek(Lek lek) {
        this.lek = lek;
    }

    public Pregled getPregled() {
        return pregled;
    }

    public void setPregled(Pregled pregled) {
        this.pregled = pregled;
    }
    
     
    
    

    


    @Override
    public String vratiNazivTabele() {
        return " recept ";
    }

    @Override
    public String vratiAlijas() {
        return " r ";
    }

    @Override
    public String vratiWhereUslovSel() {
        return "";
    }

    @Override
    public String vratiJoin() {
        return "";
    }
    

    @Override
    public String vratiOrderBy() {
        return "";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "";
    }

    @Override
    public String vratiNaziveKolona() {
        return "PregledID,DatumPropisivanja,Napomena,LekID,Hitno,NeZamenjuj,Kolicina,Doza,Jedinica";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int hitnoInt=0;
        int neZamenjujInt=0;
        if(hitno){
            hitnoInt=1;
        }
        if(neZamenjuj){
            neZamenjujInt=1;
        }
        return pregled.getPregledID()+",'"+sdf.format(datumPropisivanja)+"','"+napomena+"',"+lek.getLekID()+","+hitno+","+neZamenjuj+","+kolicina+","+doza+",'"+String.valueOf(mernaJedinica)+"' ";
    }

    @Override
    public String vratiWhereUslov() {
        return "";
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        return null;
    }

    @Override
    public String vratiKoloneKojeSelektujes() {
        return "";
    }
    
    
    
}
