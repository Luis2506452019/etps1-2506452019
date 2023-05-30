package sv.edu.utec.gasolinera_interfaz.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import sv.edu.utec.gasolinera_interfaz.database.BaseHelper;
import sv.edu.utec.gasolinera_interfaz.entidades.EntEstaciones;

public class Estaciones extends BaseHelper {
    Context context;

    public Estaciones(@Nullable Context context){
        super(context);
        this.context = context;
    }

    //-------------- INICIO MANTENIMIENTO ESTACIONES -------------->

    //------- INICIO -------> || Insercion de Estaciones || <-------
    public long insertEstacion(String nom_gas, String nom_suc, String ubi_suc, String tip_die, String tip_reg, String tip_esp){
        long codigo = 0;

        try {
            BaseHelper baseHelper = new BaseHelper(context);
            SQLiteDatabase bd = baseHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put(COL_NomGas, nom_gas);
            contentValues.put(COL_NomSuc, nom_suc);
            contentValues.put(COL_UbiSuc, ubi_suc);
            contentValues.put(COL_tipDie, tip_die);
            contentValues.put(COL_tipReg, tip_reg);
            contentValues.put(COL_tipEsp, tip_esp);

            codigo= bd.insert(TABLE_ST, null, contentValues);
            return codigo;
        }
        catch (Exception ex){
            ex.toString();
            return codigo = 0;
        }
    }
    // FIN ------->

    //------- INICIO -------> || Actualizacion de Estaciones || <-------
    public long updateEstacion(String nom_gas, String nom_suc, String ubi_suc, String tip_die, String tip_reg, String tip_esp){
        long codigo = 0;

        try {
            BaseHelper baseHelper = new BaseHelper(context);
            SQLiteDatabase bd = baseHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put(COL_NomGas, nom_gas);
            contentValues.put(COL_NomSuc, nom_suc);
            contentValues.put(COL_UbiSuc, ubi_suc);
            contentValues.put(COL_tipDie, tip_die);
            contentValues.put(COL_tipReg, tip_reg);
            contentValues.put(COL_tipEsp, tip_esp);

            codigo= bd.update(TABLE_ST, contentValues, COL_NomSuc+"=?", new String[]{nom_suc});
            return codigo;
        }
        catch (Exception ex){
            ex.toString();
            return codigo = 0;
        }
    }
    // FIN ------->

    //------- INICIO -------> || Eliminacion de Estaciones || <-------
    public long deleteEstacion(String nomSucu){
        BaseHelper baseHelper = new BaseHelper(context);
        SQLiteDatabase bd = baseHelper.getWritableDatabase();

        return bd.delete(TABLE_ST, COL_NomSuc+"=?", new String[]{nomSucu});
    }
    // FIN ------->

    //------- INICIO -------> || Mostrar Estaciones || <-------
    public ArrayList<EntEstaciones> mostrarEstacion(){
        BaseHelper baseHelper = new BaseHelper(context);
        SQLiteDatabase bd = baseHelper.getWritableDatabase();

        ArrayList<EntEstaciones>listaEstaciones = new ArrayList<>();
        EntEstaciones entEstaciones = null;
        Cursor cursorEstacion;

        cursorEstacion=bd.rawQuery("SELECT "+COL_NomGas+", "+COL_NomSuc+", "+COL_UbiSuc+", "+COL_tipDie+", "+COL_tipReg+", "+COL_tipEsp+" FROM "+TABLE_ST+" ORDER BY "+COL_NomGas,  null);

        if (cursorEstacion.moveToFirst()){
            do {
                entEstaciones = new EntEstaciones();

                entEstaciones.setNomb_gasolinera(cursorEstacion.getString(0));
                entEstaciones.setNomb_sucursal(cursorEstacion.getString(1));
                entEstaciones.setUbi_sucursal(cursorEstacion.getString(2));
                entEstaciones.setTipo_diesel(cursorEstacion.getString(3));
                entEstaciones.setTipo_regular(cursorEstacion.getString(4));
                entEstaciones.setTipo_especial(cursorEstacion.getString(5));

                listaEstaciones.add(entEstaciones);
            }
            while (cursorEstacion.moveToNext());
        }
        cursorEstacion.close();
        return listaEstaciones;
    }
    // FIN ------->

    //-------------- FIN MANTENIMIENTO ESTACIONES -------------->

}
