package sv.edu.utec.ejercicio2g3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Variables
    EditText numero;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero = findViewById(R.id.edtIngresar);
        resultado = findViewById(R.id.tvResultado);
    }

    public void Calcular(View v) {
        //Variables
        String mensaje = "";
        int res = 0;
        res = Integer.parseInt(numero.getText().toString());

        //Condiciones
        if (res < 10) {
            mensaje = "\"Tiene un dígito\"";
        } else if (res < 100) {
            mensaje = "\"Tiene dos dígitos\"";
        } else if (res < 1000) {
            mensaje = "\"Tiene tres dígitos\"";
        } else {
            mensaje = "\"Error en la entrada de datos.\"";
        }

        //Texto a mostrar en Textview
        resultado.setText(mensaje);
    }
}