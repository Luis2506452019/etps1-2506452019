package sv.edu.utec.ejercicio4g1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etValor;
    TextView tvResultado, tvResultado2, tvResultado3, tvResultado4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etValor=findViewById(R.id.edtIngresar);
        tvResultado=findViewById(R.id.txvResultado);
        tvResultado2=findViewById(R.id.txvResultado2);
        tvResultado3=findViewById(R.id.txvResultado3);
        tvResultado4=findViewById(R.id.txvResultado4);
    }

    public void MtGenerar(View v){
        //Variable
        int N;
        N=Integer.parseInt(etValor.getText().toString());

        //Asignandole un valor
        tvResultado.setText("Valor inicial de N = "+N);

        //• Incrementando N en 77.
        N+=77;
        tvResultado2.setText("N + 77 = "+N);

        //• Decrementando en 3
        N-=3;
        tvResultado3.setText("N - 3 = "+N);

        //• Duplicando su valor
        N*=2;
        tvResultado4.setText("N * 2 = "+N);
    }
}