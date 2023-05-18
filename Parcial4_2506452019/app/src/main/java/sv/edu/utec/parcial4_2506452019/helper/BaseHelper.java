package sv.edu.utec.parcial4_2506452019.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
public class BaseHelper extends SQLiteOpenHelper {

    private static final int VERSION_BASEDATOS=1;
    private static  final String NOMBRE_BASE="PARCIAL4.db";
    public static final String NOMBRE_TABLAcl="MD_Clientes";
    public static final String NOMBRE_TABLVh="MD_Vehiculos";
    public static final String NOMBRE_TABLClVh="MD_Detalle";


    public BaseHelper(@Nullable Context context) {
        super(context, NOMBRE_BASE, null, VERSION_BASEDATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+NOMBRE_TABLAcl+" ("+
                "IDCliente INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                "sNombreCliente TEXT NOT NULL ,"+
                "sApellidoCliente TEXT NOT NULL ,"+
                "sDireccionCliente TEXT NOT NULL ,"+
                "sCiudadCliente TEXT NOT NULL)");

        db.execSQL("CREATE TABLE "+NOMBRE_TABLVh+" ("+
                "IDVehiculo INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                "sMarca TEXT NOT NULL ,"+
                "sModelo TEXT NOT NULL)");

        db.execSQL("CREATE TABLE "+NOMBRE_TABLClVh+" ("+
                "IDCliente INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                "IDVehiculo INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                "sMatricula TEXT NOT NULL,"+
                "iKilometros TEXT NOT NULL, " +
                "FOREIGN KEY (IDCliente) REFERENCES "+NOMBRE_TABLAcl+"(IDCliente)," +
                "FOREIGN KEY (IDVehiculo) REFERENCES "+NOMBRE_TABLVh+"(IDVehiculo))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+NOMBRE_TABLAcl);
        onCreate(db);
    }
}
