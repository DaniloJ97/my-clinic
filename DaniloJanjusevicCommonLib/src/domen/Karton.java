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
import java.util.Objects;

/**
 *
 * @author Danilo
 */
public class Karton implements OpstiDomenskiObjekat{
    private Long kartonID;
    private String ime;
    private String prezime;
    private String jmbg;
    private String lbo;
    private String brojKnjizice;
    private Date datumRodjenja;
    private String mestoRodjenja;
    private String adresa;
    private String brojTelefona;
    private String email;
    private MedicinskaSestra medicinskaSestra;

    public Karton() {
    }

    public Karton(Long kartonID, String ime, String prezime, String jmbg, String lbo, String brojKnjizice, Date datumRodjenja, String mestoRodjenja, String adresa, String brojTelefona, String email, MedicinskaSestra medicinskaSestra) {
        this.kartonID = kartonID;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.lbo = lbo;
        this.brojKnjizice = brojKnjizice;
        this.datumRodjenja = datumRodjenja;
        this.mestoRodjenja = mestoRodjenja;
        this.adresa = adresa;
        this.brojTelefona = brojTelefona;
        this.email = email;
        this.medicinskaSestra = medicinskaSestra;
    }



    

    public Long getKartonID() {
        return kartonID;
    }

    public void setKartonID(Long kartonID) {
        this.kartonID = kartonID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getLbo() {
        return lbo;
    }

    public void setLbo(String lbo) {
        this.lbo = lbo;
    }

    public String getBrojKnjizice() {
        return brojKnjizice;
    }

    public void setBrojKnjizice(String brojKnjizice) {
        this.brojKnjizice = brojKnjizice;
    }
    
    

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getMestoRodjenja() {
        return mestoRodjenja;
    }

    public void setMestoRodjenja(String mestoRodjenja) {
        this.mestoRodjenja = mestoRodjenja;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MedicinskaSestra getMedicinskaSestra() {
        return medicinskaSestra;
    }

    public void setMedicinskaSestra(MedicinskaSestra medicinskaSestra) {
        this.medicinskaSestra = medicinskaSestra;
    }
    
    

    @Override
    public String toString() {
        return ime+" "+prezime; 
    }

  

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Karton other = (Karton) obj;
        if (!Objects.equals(this.kartonID, other.kartonID)) {
            return false;
        }
        return true;
    }

   

    @Override
    public String vratiNazivTabele() {
        return " karton ";
    }

    @Override
    public String vratiAlijas() {
        return " k ";
    }

    @Override
    public String vratiWhereUslovSel() {
        if(ime!=null && prezime!=null && lbo!=null){
        return " WHERE k.Ime LIKE '%"+ime+"%' OR k.Prezime LIKE '%"+prezime+"%' OR k.LBO LIKE '"+lbo+"%'";
        }
        return "";
    }

    @Override
    public String vratiJoin() {
        return " INNER JOIN medicinskasestra m ON m.KorisnikID=k.MedicinskaSestra INNER JOIN korisnik ko ON ko.KorisnikID=m.KorisnikID ";
    }

    @Override
    public String vratiOrderBy() {
        return "";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return " KartonID ";
    }

    @Override
    public String vratiNaziveKolona() {
        return "KartonID, Ime, Prezime, JMBG, LBO, BrojKnjizice, DatumRodjenja, MestoRodjenja, Adresa, BrojTelefona, Email, MedicinskaSestra";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return kartonID+",'"+ime+"','"+prezime+"','"+jmbg+"','"+lbo+"','"+brojKnjizice+"','"+sdf.format(datumRodjenja)+"','"+mestoRodjenja+"','"+adresa+"','"+brojTelefona+"','"+email+"',"+medicinskaSestra.getKorisnikID();
    }

    @Override
    public String vratiWhereUslov() {
        return " WHERE KartonID="+kartonID;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return " Ime='"+ime+"', Prezime='"+prezime+"', JMBG='"+jmbg+"', LBO='"+lbo+"', BrojKnjizice='"+brojKnjizice+"', DatumRodjenja='"+sdf.format(datumRodjenja)+"', MestoRodjenja='"+mestoRodjenja+"', Adresa='"+adresa+"', BrojTelefona='"+brojTelefona+"', Email='"+email+"' ";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> kartoni = new ArrayList<>();
        while(rs.next()){
            Karton k = new Karton();
            k.setAdresa(rs.getString("k.Adresa"));
            k.setBrojKnjizice(rs.getString("BrojKnjizice"));
            k.setBrojTelefona(rs.getString("k.BrojTelefona"));
            k.setDatumRodjenja(new Date(rs.getDate("DatumRodjenja").getTime()));
            k.setEmail(rs.getString("Email"));
            k.setIme(rs.getString("k.Ime"));
            k.setJmbg(rs.getString("k.JMBG"));
            k.setKartonID(rs.getLong("KartonID"));
            k.setLbo(rs.getString("LBO"));
            MedicinskaSestra medicinskaSestra = new MedicinskaSestra();
            medicinskaSestra.setAdresa(rs.getString("ko.Adresa"));
            medicinskaSestra.setBrojTelefona(rs.getString("ko.BrojTelefona"));
            medicinskaSestra.setIme(rs.getString("ko.Ime"));
            medicinskaSestra.setJmbg(rs.getString("ko.JMBG"));
            medicinskaSestra.setKorisnickoIme(rs.getString("KorisnickoIme"));
            medicinskaSestra.setKorisnikID(rs.getLong("KorisnikID"));
            medicinskaSestra.setLozinka(rs.getString("Lozinka"));
            medicinskaSestra.setPatronazna(rs.getBoolean("Patronazna"));
            medicinskaSestra.setPrezime(rs.getString("ko.Prezime"));
            medicinskaSestra.setSmena(rs.getInt("Smena"));
            k.setMedicinskaSestra(medicinskaSestra);
            k.setMestoRodjenja(rs.getString("k.MestoRodjenja"));
            k.setPrezime(rs.getString("k.Prezime"));
            kartoni.add(k);
        }
        return kartoni;
    }

    @Override
    public String vratiKoloneKojeSelektujes() {
        return " * ";
    }
    
    
    
    

  
    
}
