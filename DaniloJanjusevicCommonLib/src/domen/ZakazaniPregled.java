/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class ZakazaniPregled implements OpstiDomenskiObjekat{
    private Long zakazaniPregledID;
    private Date datumZakazanogPregleda;
    private MedicinskaSestra medicinskaSestra;
    private Pregled pregled;
    private Karton karton;
    private Lekar lekar;

    public ZakazaniPregled() {
    }

    public ZakazaniPregled(Long zakazaniPregledID, Date datumZakazanogPregleda, MedicinskaSestra medicinskaSestra, Pregled pregled, Karton karton, Lekar lekar) {
        this.zakazaniPregledID = zakazaniPregledID;
        this.datumZakazanogPregleda = datumZakazanogPregleda;
        this.medicinskaSestra = medicinskaSestra;
        this.pregled = pregled;
        this.karton = karton;
        this.lekar = lekar;
    }

    public Long getZakazaniPregledID() {
        return zakazaniPregledID;
    }

    public void setZakazaniPregledID(Long zakazaniPregledID) {
        this.zakazaniPregledID = zakazaniPregledID;
    }

    public Date getDatumZakazanogPregleda() {
        return datumZakazanogPregleda;
    }

    public void setDatumZakazanogPregleda(Date datumZakazanogPregleda) {
        this.datumZakazanogPregleda = datumZakazanogPregleda;
    }

    public MedicinskaSestra getMedicinskaSestra() {
        return medicinskaSestra;
    }

    public void setMedicinskaSestra(MedicinskaSestra medicinskaSestra) {
        this.medicinskaSestra = medicinskaSestra;
    }

    public Pregled getPregled() {
        return pregled;
    }

    public void setPregled(Pregled pregled) {
        this.pregled = pregled;
    }

    public Karton getKarton() {
        return karton;
    }

    public void setKarton(Karton karton) {
        this.karton = karton;
    }

    public Lekar getLekar() {
        return lekar;
    }

    public void setLekar(Lekar lekar) {
        this.lekar = lekar;
    }

   

    @Override
    public String vratiNazivTabele() {
        return " zakazanipregled ";
    }

    @Override
    public String vratiAlijas() {
        return " z ";
    }

    @Override
    public String vratiWhereUslovSel() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(datumZakazanogPregleda!=null && lekar!=null){
        return " WHERE DATE(z.DatumZakazanogPregleda)='"+sdf.format(datumZakazanogPregleda)+"' AND z.LekarID="+lekar.getKorisnikID()+" AND z.PregledID IS NULL ";
        }
        if(karton!=null){
        return " WHERE (k.Ime LIKE '"+karton.getIme()+"%' OR k.Prezime LIKE '"+karton.getPrezime()+"%' OR k.BrojKnjizice LIKE '"+karton.getBrojKnjizice()+"%') AND z.PregledID IS NULL";
        }
        return "";
    }

    @Override
    public String vratiJoin() {
        return " INNER JOIN karton k ON k.KartonID=z.KartonID INNER JOIN medicinskasestra m ON z.MedicinskaSestraID=m.KorisnikID INNER JOIN korisnik ko1 ON ko1.KorisnikID=m.KorisnikID INNER JOIN lekar l ON z.LekarID=l.KorisnikID INNER JOIN korisnik ko2 ON ko2.KorisnikID=l.KorisnikID ";
    }

    @Override
    public String vratiOrderBy() {
        return " ORDER BY DatumZakazanogPregleda ASC ";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return " ZakazaniPregledID ";
    }

    @Override
    public String vratiNaziveKolona() {
        return "ZakazaniPregledID,DatumZakazanogPregleda,MedicinskaSestraID,KartonID,LekarID";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return zakazaniPregledID+",'"+sdf.format(datumZakazanogPregleda)+"',"+medicinskaSestra.getKorisnikID()+","+karton.getKartonID()+","+lekar.getKorisnikID();
    }

    @Override
    public String vratiWhereUslov() {
        return " WHERE ZakazaniPregledID="+zakazaniPregledID+" ";
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(pregled!=null){
            return " PregledID= "+pregled.getPregledID()+" ";
        }
        if(lekar!=null && karton!=null){
            return " LekarID="+lekar.getKorisnikID()+",KartonID="+karton.getKartonID()+", DatumZakazanogPregleda='"+sdf.format(datumZakazanogPregleda)+"', MedicinskaSestraID="+medicinskaSestra.getKorisnikID();
        }
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            ZakazaniPregled z = new ZakazaniPregled();
            z.setDatumZakazanogPregleda(new Date(rs.getTimestamp("DatumZakazanogPregleda").getTime()));
            z.setZakazaniPregledID(rs.getLong("ZakazaniPregledID"));
            Karton k = new Karton();
            k.setAdresa(rs.getString("k.Adresa"));
            k.setBrojKnjizice(rs.getString("k.BrojKnjizice"));
            k.setBrojTelefona(rs.getString("k.BrojTelefona"));
            k.setDatumRodjenja(rs.getDate("k.DatumRodjenja"));
            k.setEmail(rs.getString("k.Email"));
            k.setIme(rs.getString("k.Ime"));
            k.setJmbg(rs.getString("k.JMBG"));
            k.setKartonID(rs.getLong("k.KartonID"));
            k.setLbo(rs.getString("LBO"));
            k.setMestoRodjenja(rs.getString("k.MestoRodjenja"));
            k.setPrezime(rs.getString("Prezime"));
            z.setKarton(k);
            Lekar l = new Lekar();
            l.setAdresa(rs.getString("ko2.Adresa"));
            l.setBrojTelefona(rs.getString("ko2.BrojTelefona"));
            l.setIme(rs.getString("ko2.Ime"));
            l.setJmbg(rs.getString("ko2.Prezime"));
            l.setKorisnickoIme(rs.getString("ko2.KorisnickoIme"));
            l.setKorisnikID(rs.getLong("ko2.KorisnikID"));
            l.setLozinka(rs.getString("ko2.Lozinka"));
            l.setPrezime(rs.getString("ko2.Prezime"));
            l.setSmena(rs.getInt("ko2.Smena"));
            l.setOcenaPacijenata(rs.getDouble("l.OcenaPacijenata"));
            l.setSpecijalnost(rs.getString("l.Specijalnost"));
            z.setLekar(l);
            MedicinskaSestra m= new MedicinskaSestra();
            m.setAdresa(rs.getString("ko1.Adresa"));
            m.setBrojTelefona(rs.getString("ko1.BrojTelefona"));
            m.setIme(rs.getString("ko1.Ime"));
            m.setJmbg(rs.getString("ko1.JMBG"));
            m.setKorisnickoIme(rs.getString("ko1.KorisnickoIme"));
            m.setKorisnikID(rs.getLong("ko1.KorisnikID"));
            m.setLozinka(rs.getString("ko1.Lozinka"));
            m.setPrezime(rs.getString("ko1.Prezime"));
            m.setSmena(rs.getInt("ko1.Smena"));
            m.setPatronazna(rs.getBoolean("m.Patronazna"));
            z.setMedicinskaSestra(m);
            lista.add(z);
        }
        return lista;
    }

    @Override
    public String vratiKoloneKojeSelektujes() {
        return " * ";
    }
    
    
    
}
