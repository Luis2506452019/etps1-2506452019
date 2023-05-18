package sv.edu.utec.parcial4_2506452019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

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
    }
}