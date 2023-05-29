package sv.edu.utec.gasolinera_interfaz.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import sv.edu.utec.gasolinera_interfaz.entidades.EntEstaciones;

public class BaseHelper extends SQLiteOpenHelper {
    private static final int VERSION_BASEDATOS = 2;
    public static final String DB_NAME = "gasolinera.db";

    // TABLA ESTACIONES
    public static final String TABLE_ST = "estaciones";
    public static final String COL_IdGas = "id_estaciones";
    public static final String COL_NomGas = "nomb_gasolinera";
    public static final String COL_NomSuc = "nomb_sucursal";
    public static final String COL_UbiSuc = "ubi_sucursal";
    public static final String COL_tipDie = "tipo_diesel";
    public static final String COL_tipReg = "tipo_regular";
    public static final String COL_tipEsp = "tipo_especial";

    protected Context context;

    public BaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION_BASEDATOS);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_ST+"(" +
                ""+COL_IdGas+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ""+COL_NomGas+" TEXT, " +
                ""+COL_NomSuc+" TEXT, " +
                ""+COL_UbiSuc+" TEXT, " +
                ""+COL_tipDie+" TEXT, " +
                ""+COL_tipReg+" TEXT, " +
                ""+COL_tipEsp+" TEXT)");

        db.execSQL("INSERT INTO "+TABLE_ST+"("+COL_NomGas+", "+COL_NomSuc+", "+COL_UbiSuc+", "+COL_tipDie+", "+COL_tipReg+", "+COL_tipEsp+") " +
                "VALUES('PUMA', 'La Gloria', 'Altos De Sta Mónica Sda A No 71-A La Gloria', '4.78', '5.00', '4.80')");
        db.execSQL("INSERT INTO "+TABLE_ST+"("+COL_NomGas+", "+COL_NomSuc+", "+COL_UbiSuc+", "+COL_tipDie+", "+COL_tipReg+", "+COL_tipEsp+") " +
                "VALUES('PUMA', 'Constitución', 'Altos De Sta Mónica Sda A No 72-A Constitución', '4.78', '5.00', '4.80')");
        db.execSQL("INSERT INTO "+TABLE_ST+"("+COL_NomGas+", "+COL_NomSuc+", "+COL_UbiSuc+", "+COL_tipDie+", "+COL_tipReg+", "+COL_tipEsp+") " +
                "VALUES('PUMA', 'Rubén Darío', 'Altos De Sta Mónica Sda A No 73-A Rubén Darío', '4.78', '5.00', '4.80')");

        db.execSQL("INSERT INTO "+TABLE_ST+"("+COL_NomGas+", "+COL_NomSuc+", "+COL_UbiSuc+", "+COL_tipDie+", "+COL_tipReg+", "+COL_tipEsp+") " +
                "VALUES('UNO', 'San Salvador', 'Altos De Sta Mónica Sda A No 74-A San Salvador', '4.78', '5.00', '4.80')");
        db.execSQL("INSERT INTO "+TABLE_ST+"("+COL_NomGas+", "+COL_NomSuc+", "+COL_UbiSuc+", "+COL_tipDie+", "+COL_tipReg+", "+COL_tipEsp+") " +
                "VALUES('UNO', 'Chalatenango', 'Altos De Sta Mónica Sda A No 75-A Chalatenango', '4.78', '5.00', '4.80')");
        db.execSQL("INSERT INTO "+TABLE_ST+"("+COL_NomGas+", "+COL_NomSuc+", "+COL_UbiSuc+", "+COL_tipDie+", "+COL_tipReg+", "+COL_tipEsp+") " +
                "VALUES('UNO', 'Santa Ana', 'Altos De Sta Mónica Sda A No 76-A Santa Ana', '4.78', '5.00', '4.80')");

        db.execSQL("INSERT INTO "+TABLE_ST+"("+COL_NomGas+", "+COL_NomSuc+", "+COL_UbiSuc+", "+COL_tipDie+", "+COL_tipReg+", "+COL_tipEsp+") " +
                "VALUES('TEXACO', 'Porvenir', 'Altos De Sta Mónica Sda A No 77-A Porvenir', '4.78', '5.00', '4.80')");
        db.execSQL("INSERT INTO "+TABLE_ST+"("+COL_NomGas+", "+COL_NomSuc+", "+COL_UbiSuc+", "+COL_tipDie+", "+COL_tipReg+", "+COL_tipEsp+") " +
                "VALUES('TEXACO', 'San Vicente', 'Altos De Sta Mónica Sda A No 78-A San Vicente', '4.78', '5.00', '4.80')");
        db.execSQL("INSERT INTO "+TABLE_ST+"("+COL_NomGas+", "+COL_NomSuc+", "+COL_UbiSuc+", "+COL_tipDie+", "+COL_tipReg+", "+COL_tipEsp+") " +
                "VALUES('TEXACO', 'San Miguel', 'Altos De Sta Mónica Sda A No 79-A San Miguel', '4.78', '5.00', '4.80')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ST);

        onCreate(db);
    }

    //------- Eliminar Estaciones
    public void deleteEstaciones(String nombre){
        this.getWritableDatabase().delete(TABLE_ST, "nomb_gasolinera='"+nombre+"'", null);
    }

    //------- Actualizar Estaciones
    public void updateEstaciones (String new_nombre, String old_nombre){
        this.getWritableDatabase().execSQL("UPDATE "+TABLE_ST+" SET nombregasolinera='"+new_nombre+"' WHERE nombregasolinera='"+old_nombre+"'");
    }

}
