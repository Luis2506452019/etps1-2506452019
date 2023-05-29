package sv.edu.utec.parcial4_2506452019;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.utec.parcial4_2506452019.helper.BaseHelper;
import sv.edu.utec.parcial4_2506452019.helper.MD_Cliente;
import sv.edu.utec.parcial4_2506452019.helper.MD_Vehiculo;

public class AgregarRegistro extends AppCompatActivity {

    EditText txtNombreC, txtApellidoC, txtDireccionC, txtCiudadC;
    EditText txtMarcaV, txtModeloV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_registro);

        txtNombreC = findViewById(R.id.edtNombresCliente);
        txtApellidoC = findViewById(R.id.edtApellidosCliente);
        txtDireccionC = findViewById(R.id.edtDireccionCliente);
        txtCiudadC = findViewById(R.id.edtCiudadCliente);
        txtMarcaV = findViewById(R.id.edtMarcaVehiculo);
        txtModeloV = findViewById(R.id.edtModeloVehiculo);

        MD_Cliente dbCliente = new MD_Cliente(this);
        MD_Vehiculo dbVehiculo = new MD_Vehiculo(this);

        long codiSave=dbCliente.insertCliente(txtNombreC.getText().toString(), txtApellidoC.getText().toString(), txtDireccionC.getText().toString(), txtCiudadC.getText().toString());
        if(codiSave>0){
            Toast toast = Toast.makeText(this, "Registro insertado", Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            Toast toast = Toast.makeText(this, "Error en insertar", Toast.LENGTH_SHORT);
            toast.show();
        }

        long codiSave2=dbVehiculo.insertVehiculo(txtMarcaV.getText().toString(), txtModeloV.getText().toString());
        if(codiSave2>0){
            Toast toast = Toast.makeText(this, "Registro insertado", Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            Toast toast = Toast.makeText(this, "Error en insertar", Toast.LENGTH_SHORT);
            toast.show();
        }

    }
}