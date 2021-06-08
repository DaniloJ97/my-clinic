/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.OpstiDomenskiObjekat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Konstante;
import properties.PropertyReader;

/**
 *
 * @author Danilo
 */
public class DBBroker {
    private static DBBroker instanca;
    private Connection connection;

    private DBBroker() {
    }

    public static DBBroker getInstanca() {
        if(instanca==null){
            instanca = new DBBroker();
        }
        return instanca;
    }
    
    public void ucitajDrajver() throws ClassNotFoundException{
        Class.forName(PropertyReader.getInstanca().vratiVrednostaZaKljuc(Konstante.DRIVER));
    }
    
    public void otvoriKonekciju() throws SQLException{
        connection = DriverManager.getConnection(PropertyReader.getInstanca().vratiVrednostaZaKljuc(Konstante.URL), PropertyReader.getInstanca().vratiVrednostaZaKljuc(Konstante.USERNAME), PropertyReader.getInstanca().vratiVrednostaZaKljuc(Konstante.PASSWORD));
        connection.setAutoCommit(false);
    }
    
    public void zatvoriKonekciju() throws SQLException{
        connection.close();
    }
    
    public void commit(){
        try {
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void rollback(){
        try {
            connection.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet select(OpstiDomenskiObjekat odo) throws SQLException{
        String upit ="SELECT "+odo.vratiKoloneKojeSelektujes()+"FROM"+odo.vratiNazivTabele()+"as"+odo.vratiAlijas()+odo.vratiJoin()+odo.vratiWhereUslovSel()+odo.vratiOrderBy();
        System.out.println(upit);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(upit);
        return rs;
    }

    public Long vratiMaxId(OpstiDomenskiObjekat odo) throws SQLException {
        Long max=new Long(0);
        String upit ="SELECT MAX("+odo.vratiPrimarniKljuc()+") as max FROM "+odo.vratiNazivTabele();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(upit);
        while(rs.next()){
            max = rs.getLong("max");
        }
        return ++max;
    }

    public void insert(OpstiDomenskiObjekat odo) throws SQLException {
        String upit ="INSERT INTO"+odo.vratiNazivTabele()+"("+odo.vratiNaziveKolona()+") VALUES("+odo.vratiVrednostiZaInsert()+")";
        System.out.println(upit);
        Statement statement = connection.createStatement();
        statement.executeUpdate(upit);
        statement.close();
    }
    
    public void update(OpstiDomenskiObjekat odo) throws SQLException{
        String upit ="UPDATE"+odo.vratiNazivTabele()+" SET "+odo.vratiVrednostiZaUpdate()+odo.vratiWhereUslov();
        System.out.println(upit);
        Statement statement = connection.createStatement();
        statement.executeUpdate(upit);
        statement.close();
    }

    public void delete(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "DELETE FROM"+odo.vratiNazivTabele()+odo.vratiWhereUslov();
        System.out.println(upit);
        Statement statement = connection.createStatement();
        statement.executeUpdate(upit);
        statement.close();
    }
    
}
