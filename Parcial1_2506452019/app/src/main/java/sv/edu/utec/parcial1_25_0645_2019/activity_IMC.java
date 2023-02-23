package sv.edu.utec.parcial1_25_0645_2019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class activity_IMC extends AppCompatActivity {
    EditText peso, altura;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        peso = findViewById(R.id.edtPeso);
        altura = findViewById(R.id.edtAltura);
        resultado = findViewById(R.id.tvResultado);
    }

    public void Mostrar(View v) {
        //Variables
        String mensaje = "";
        double vPeso, vAltura;
        double vIMC = 0;
        vPeso = Double.parseDouble(peso.getText().toString());
        vAltura = Double.parseDouble(altura.getText().toString());

        //Formula
        vIMC = vPeso / (vAltura * vAltura);

        //Condiciones
        if (vIMC < 10.5) {
            mensaje = "\"Críticamente Bajo de Peso\"";
        } else if (vIMC < 15.9) {
            mensaje = "\"Severamente Bajo de Peso\"";
        } else if (vIMC < 25) {
            mensaje = "\"Normal (peso saludable)\"";
        } else if (vIMC < 30) {
            mensaje = "\"Sobrepeso\"";
        }else if (vIMC < 35) {
            mensaje = "\"Obesidad Clase 1 - Moderadamente Obeso\"";
        }else if (vIMC < 40) {
            mensaje = "\"Obesidad Clase 2 - Severamente Obeso\"";
        }else if (vIMC > 50) {
            mensaje = "\"Obesidad Clase 3 - Críticamente Obeso\"";
        }

        //Texto a mostrar en Textview
        resultado.setText(mensaje);
    }
}