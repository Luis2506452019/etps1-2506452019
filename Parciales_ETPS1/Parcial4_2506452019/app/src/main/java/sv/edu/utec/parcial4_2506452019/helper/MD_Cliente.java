package sv.edu.utec.parcial4_2506452019.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class MD_Cliente extends BaseHelper {
    Context context;

    public MD_Cliente(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertCliente(String sNombreCliente, String sApellidoCliente, String sDireccionCliente, String sCiudadCliente){
        long codigo = 0;

        try {
            BaseHelper baseHelp = new BaseHelper(context);
            SQLiteDatabase bd = baseHelp.getWritableDatabase();

            ContentValues vCliente = new ContentValues();
            vCliente.put("sNombreCliente", sNombreCliente);
            vCliente.put("sApellidoCliente", sApellidoCliente);
            vCliente.put("sDireccionCliente", sDireccionCliente);
            vCliente.put("sCiudadCliente", sCiudadCliente);

            codigo= bd.insert(NOMBRE_TABLAcl, null, vCliente);
            return codigo;
        }
        catch (Exception ex){
            ex.toString();
            return codigo=0;
        }
    }
}
