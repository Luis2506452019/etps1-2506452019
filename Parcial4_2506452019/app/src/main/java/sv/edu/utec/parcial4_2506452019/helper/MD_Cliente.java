package sv.edu.utec.parcial4_2506452019.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class MD_Cliente extends BaseHelper {
    Context context;

    public MD_Cliente(@Nullable Context context) {
        super(context);
    }

    public long insertCliente(String sMatricula, String iKilometro){
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
}
