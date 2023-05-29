package sv.edu.utec.parcial4_2506452019.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class MD_Vehiculo extends BaseHelper{
    Context context;

    public MD_Vehiculo(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertVehiculo(String sMarca, String sModelo){
        long codigo = 0;

        try {
            BaseHelper baseHelp = new BaseHelper(context);
            SQLiteDatabase bd = baseHelp.getWritableDatabase();

            ContentValues vVehiculo = new ContentValues();
            vVehiculo.put("sMarca", sMarca);
            vVehiculo.put("sModelo", sModelo);

            codigo= bd.insert(NOMBRE_TABLAcl, null, vVehiculo);
            return codigo;
        }
        catch (Exception ex){
            ex.toString();
            return codigo=0;
        }
    }
}
