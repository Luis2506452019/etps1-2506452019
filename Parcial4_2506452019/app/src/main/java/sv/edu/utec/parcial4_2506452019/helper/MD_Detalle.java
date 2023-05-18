package sv.edu.utec.parcial4_2506452019.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import sv.edu.utec.parcial4_2506452019.entidades.DetalleEntidad;

public class MD_Detalle extends BaseHelper {

    Context context;
    public MD_Detalle( Context context) {
        super(context);
        this.context = context;
    }

    public long insertDetalle(String sMatricula, String iKilometro){
        long codigo = 0;

        try {
            BaseHelper baseHelp = new BaseHelper(context);
            SQLiteDatabase bd = baseHelp.getWritableDatabase();

            ContentValues vDetalle = new ContentValues();
            vDetalle.put("sMatricula", sMatricula);
            vDetalle.put("iKilometros", iKilometro);

            codigo= bd.insert(NOMBRE_TABLClVh, null, vDetalle);
            return codigo;
        }
        catch (Exception ex){
            ex.toString();
            return codigo=0;
        }
    }

    public ArrayList<DetalleEntidad> mostrarDetalle(){
        BaseHelper baseHelp = new BaseHelper(context);
        SQLiteDatabase bd = baseHelp.getWritableDatabase();

        ArrayList<DetalleEntidad>listaDetalle=new ArrayList<>();
        DetalleEntidad detalleEntidad=null;
        Cursor cursorDetalle;

        cursorDetalle=bd.rawQuery("SELECT IDCliente, IDVehiculo, sMatricula, iKilometros from "+NOMBRE_TABLClVh,null);
        if(cursorDetalle.moveToFirst())
        {
            do{
                detalleEntidad = new DetalleEntidad();
                detalleEntidad.setId_cliente(cursorDetalle.getInt(0));
                detalleEntidad.setId_vehiculo(cursorDetalle.getInt(1));
                detalleEntidad.setsMatricula(cursorDetalle.getString(2));
                detalleEntidad.setiKilometros(cursorDetalle.getString(3));
                listaDetalle.add(detalleEntidad);
            }
            while(cursorDetalle.moveToNext());
        }
        cursorDetalle.close();
        return listaDetalle;
    }
}
