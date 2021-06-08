/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;

/**
 *
 * @author Danilo
 */
public interface Operacija extends Serializable{
    public static final int LOGIN=1;
    public static final int VRATI_MAX_ID=2;
    public static final int SACUVAJ_KARTON=3;
    public static final int VRATI_LISTU_KARTONA=4;
    public static final int IZMENI_KARTON=5;
    public static final int DEAKTIVIRAJ_KARTON=6;
    public static final int VRATI_LISTU_LEKARA=7;
    public static final int VRATI_LISTU_DIJAGNOZA=8;
    public static final int VRATI_LISTU_LEKOVA=9;
    public static final int VRATI_LISTU_ZAKAZANIH_PREGLEDA=10;
    public static final int SACUVAJ_PREGLED=11;
    public static final int ZAKAZI_PREGLED=12;
    public static final int OBRISI_ZAKAZANI_PREGLED=13;
    public static final int IZMENI_ZAKAZANI_PREGLED=14;
    
}
