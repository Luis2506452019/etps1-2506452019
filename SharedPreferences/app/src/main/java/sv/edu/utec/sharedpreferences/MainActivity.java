package sv.edu.utec.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.util.Log;

import java.sql.SQLData;

import sv.edu.utec.sharedpreferences.Helper.AdminSQLiteOpenHelper;

public class MainActivity extends AppCompatActivity {
EditText txtcodPrd,txtDesc,txtPrecio;
Button  btnInserts,btnUpdates,btnDeletes,btnsBuscar,btnsBuscarDes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtcodPrd=findViewById(R.id.editTextTextPersonName);
        txtDesc=findViewById(R.id.editTextTextPersonName2);
        txtPrecio=findViewById(R.id.editTextNumberDecimal);
        btnInserts=findViewById(R.id.btnInsert);
        btnUpdates=findViewById(R.id.btnUpdate);
        btnDeletes=findViewById(R.id.btnDelete);
        btnsBuscar=findViewById(R.id.btnBuscar);
        btnDeletes=findViewById(R.id.btnDelete);
        btnsBuscarDes=findViewById(R.id.btnBuscarDes);
        btnInserts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(),"bodega",null,2);
             SQLiteDatabase bd= admin.getWritableDatabase();
             String cod=txtcodPrd.getText().toString();
             String des=txtDesc.getText().toString();
             String pre=txtPrecio.getText().toString();

                ContentValues informacion =new ContentValues();
                informacion.put("codProducto",cod);
                informacion.put("descripProd",des);
                informacion.put("precioProd",pre);
try {
    bd.insert("productos", null, informacion);

    Toast.makeText(getApplicationContext(), "Se inserto el producto", Toast.LENGTH_LONG).show();
    bd.close();

} catch (Exception e){
    //pendiente imprimir error
    Toast.makeText(getApplicationContext(), ""+e.getCause(), Toast.LENGTH_LONG).show();
}

            }
        });
        btnDeletes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(),"bodega",null,2);
                SQLiteDatabase bd= admin.getWritableDatabase();
                String cod=txtcodPrd.getText().toString();

                int cat=bd.delete("productos",
                        "codProducto="+cod,null);
                bd.close();
                txtcodPrd.setText("");
                txtDesc.setText("");
                txtPrecio.setText("");

                if(cat==1){
                    Toast.makeText(getApplicationContext(),"Se borro el producto",Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(getApplicationContext(),"No se borro el producto",Toast.LENGTH_LONG).show();

                }
            }
        });
        btnUpdates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(),"bodega",null,2);
                SQLiteDatabase bd= admin.getWritableDatabase();
                String cod=txtcodPrd.getText().toString();
                String des=txtDesc.getText().toString();
                String pre=txtPrecio.getText().toString();
                ContentValues informacion =new ContentValues();
                informacion.put("codProducto",cod);
                informacion.put("descripProd",des);
                informacion.put("precioProd",pre);

                int cat=bd.update("productos",informacion,
                        "codProducto="+cod,null);
                bd.close();
                if(cat==1){
                    Toast.makeText(getApplicationContext(),"Se modifico el producto",Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(getApplicationContext(),"No se modifico el producto",Toast.LENGTH_LONG).show();

                }
            }
        });


        btnsBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AdminSQLiteOpenHelper admin = new
                        AdminSQLiteOpenHelper(getApplicationContext(),
                        "bodega",null,2);
                SQLiteDatabase bd= admin.getWritableDatabase();

                String cod=txtcodPrd.getText().toString();

                Cursor filas=bd.rawQuery("select descripProd,precioProd " +
                        "from productos where codProducto="+cod,null);

                if(filas.moveToFirst()){
                    txtDesc.setText(filas.getString(0));
                    txtPrecio.setText(filas.getString(1));
                }
                else{
                    Toast.makeText(getApplicationContext(),"No se encontro" +
                            " el producto",Toast.LENGTH_LONG).show();

                }
                bd.close();

            }
        });



        btnsBuscarDes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AdminSQLiteOpenHelper admin = new
                        AdminSQLiteOpenHelper(getApplicationContext(),
                        "bodega",null,2);
                SQLiteDatabase bd= admin.getWritableDatabase();

                String des=txtDesc.getText().toString();

                Cursor filas=bd.rawQuery("select codProducto,descripProd,precioProd " +
                        "from productos where descripProd='"+des+"'",null);

                if(filas.moveToFirst()){
                    txtcodPrd.setText(filas.getString(0));
                    txtDesc.setText(filas.getString(1));
                    txtPrecio.setText(filas.getString(2));
                }
                else{
                    Toast.makeText(getApplicationContext(),"No se encontro" +
                            " el producto",Toast.LENGTH_LONG).show();

                }
                bd.close();

            }
        });
    }
}