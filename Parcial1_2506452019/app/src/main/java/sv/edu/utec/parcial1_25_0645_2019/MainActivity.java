package sv.edu.utec.parcial1_25_0645_2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.edtValor);
        password = findViewById(R.id.edtValor2);
        result = findViewById(R.id.tvAlerta);
    }

    public void segundaPantalla(View view) {
        String key =password.getText().toString();
        String user =username.getText().toString();

        if (user.equals("parcialETps1") && key.equals("p4rC14l#tp$")) {
            Intent intento = new Intent(this, activity_IMC.class);
            startActivity(intento);
        } else {
            result.setText("Contraseña y Usuario no son correctos");
        }
    }

}