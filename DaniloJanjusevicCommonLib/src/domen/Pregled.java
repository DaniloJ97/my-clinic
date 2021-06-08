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
public class Pregled implements OpstiDomenskiObjekat{
    private Long pregledID;
    private Date datumObavljanjaPregleda;
    private String simptomi;
    private Lekar lekar;
    private Karton karton;
    private Dijagnoza dijagnoza;
    private ZakazaniPregled zakazaniPregled;
    private List<Recept> recepti;

    public Pregled() {
    }

    public Pregled(Long pregledID, Date datumObavljanjaPregleda, String simptomi, Lekar lekar, Karton karton, Dijagnoza dijagnoza, ZakazaniPregled zakazaniPregled, List<Recept> recepti) {
        this.pregledID = pregledID;
        this.datumObavljanjaPregleda = datumObavljanjaPregleda;
        this.simptomi = simptomi;
        this.lekar = lekar;
        this.karton = karton;
        this.dijagnoza = dijagnoza;
        this.zakazaniPregled = zakazaniPregled;
        this.recepti = recepti;
    }

    public Long getPregledID() {
        return pregledID;
    }

    public void setPregledID(Long pregledID) {
        this.pregledID = pregledID;
    }

    public Date getDatumObavljanjaPregleda() {
        return datumObavljanjaPregleda;
    }

    public void setDatumObavljanjaPregleda(Date datumObavljanjaPregleda) {
        this.datumObavljanjaPregleda = datumObavljanjaPregleda;
    }

    public String getSimptomi() {
        return simptomi;
    }

    public void setSimptomi(String simptomi) {
        this.simptomi = simptomi;
    }

    public Lekar getLekar() {
        return lekar;
    }

    public void setLekar(Lekar lekar) {
        this.lekar = lekar;
    }

    public Karton getKarton() {
        return karton;
    }

    public void setKarton(Karton karton) {
        this.karton = karton;
    }

    public Dijagnoza getDijagnoza() {
        return dijagnoza;
    }

    public void setDijagnoza(Dijagnoza dijagnoza) {
        this.dijagnoza = dijagnoza;
    }

    public ZakazaniPregled getZakazaniPregled() {
        return zakazaniPregled;
    }

    public void setZakazaniPregled(ZakazaniPregled zakazaniPregled) {
        this.zakazaniPregled = zakazaniPregled;
    }

    public List<Recept> getRecepti() {
        return recepti;
    }

    public void setRecepti(List<Recept> recepti) {
        this.recepti = recepti;
    }

    

    @Override
    public String vratiNazivTabele() {
        return " pregled ";
    }

    @Override
    public String vratiAlijas() {
        return " p ";
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
        return "PregledID";
    }

    @Override
    public String vratiNaziveKolona() {
        String zakazani="";
        if(zakazaniPregled!=null){
            zakazani =",ZakazaniPregledID";
        }
        return "PregledID, DatumObavljanjaPregleda,Simptomi,LekarID,KartonID,DijagnozaID"+zakazani ;
    }

    @Override
    public String vratiVrednostiZaInsert() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String zakazani="";
        if(zakazaniPregled!=null){
            zakazani = ","+zakazaniPregled.getZakazaniPregledID();
        }
        return pregledID+",'"+sdf.format(datumObavljanjaPregleda)+"','"+simptomi+"',"+lekar.getKorisnikID()+","+karton.getKartonID()+","+dijagnoza.getDijagnozaID()+zakazani;
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
