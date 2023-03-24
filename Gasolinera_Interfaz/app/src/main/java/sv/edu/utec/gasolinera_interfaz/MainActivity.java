package sv.edu.utec.gasolinera_interfaz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    //Var Pantallas
    LinearLayout lin_inicio, lin_estacion, lin_ubicacion, lin_horario, lin_oferta;

    //Var Circulo
    LinearLayout cir_inicio, cir_estacion, cir_ubicacion, cir_horario, cir_oferta;

    NavigationView navigationView;
    LinearLayout lin_volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Capturando Pantallas
        lin_inicio = (LinearLayout) findViewById(R.id.pantallaInicio);
        lin_estacion = (LinearLayout) findViewById(R.id.pantallaEstacion);
        lin_ubicacion = (LinearLayout) findViewById(R.id.pantallaUbicacion);
        lin_horario = (LinearLayout) findViewById(R.id.pantallaHorario);
        lin_oferta = (LinearLayout) findViewById(R.id.pantallaOferta);

        //Capturando Circulos
        cir_inicio = (LinearLayout) findViewById(R.id.circuloInicio);
        cir_estacion = (LinearLayout) findViewById(R.id.circuloEstacion);
        cir_ubicacion = (LinearLayout) findViewById(R.id.circuloUbicacion);
        cir_horario = (LinearLayout) findViewById(R.id.circuloHorario);
        cir_oferta = (LinearLayout) findViewById(R.id.circuloOferta);

        navigationView = findViewById(R.id.nav_view);
        lin_volver = (LinearLayout) findViewById(R.id.lin_volver);
    }
    public void mostrarInicio() {
        //Inicio
        lin_inicio.setVisibility(View.VISIBLE);
        cir_inicio.setVisibility(View.VISIBLE);

        //Opciones
        lin_estacion.setVisibility(View.GONE);
        cir_estacion.setVisibility(View.INVISIBLE);

        lin_ubicacion.setVisibility(View.GONE);
        cir_ubicacion.setVisibility(View.INVISIBLE);

        lin_horario.setVisibility(View.GONE);
        cir_horario.setVisibility(View.INVISIBLE);

        lin_oferta.setVisibility(View.GONE);
        cir_oferta.setVisibility(View.INVISIBLE);
    }

    public void mostrarEstacion(View view) {
        //Estacion
        lin_estacion.setVisibility(View.VISIBLE);
        cir_estacion.setVisibility(View.VISIBLE);

        //Opciones
        lin_inicio.setVisibility(View.GONE);
        cir_inicio.setVisibility(View.INVISIBLE);

        lin_ubicacion.setVisibility(View.GONE);
        cir_ubicacion.setVisibility(View.INVISIBLE);

        lin_horario.setVisibility(View.GONE);
        cir_horario.setVisibility(View.INVISIBLE);

        lin_oferta.setVisibility(View.GONE);
        cir_oferta.setVisibility(View.INVISIBLE);
    }

    public void mostrarUbicacion(View view) {
        //Ubicacion
        lin_ubicacion.setVisibility(View.VISIBLE);
        cir_ubicacion.setVisibility(View.VISIBLE);

        //Opciones
        lin_inicio.setVisibility(View.GONE);
        cir_inicio.setVisibility(View.INVISIBLE);

        lin_estacion.setVisibility(View.GONE);
        cir_estacion.setVisibility(View.INVISIBLE);

        lin_horario.setVisibility(View.GONE);
        cir_horario.setVisibility(View.INVISIBLE);

        lin_oferta.setVisibility(View.GONE);
        cir_oferta.setVisibility(View.INVISIBLE);
    }

    public void mostrarHorario(View view) {
        //Horario
        lin_horario.setVisibility(View.VISIBLE);
        cir_horario.setVisibility(View.VISIBLE);

        //Opciones
        lin_inicio.setVisibility(View.GONE);
        cir_inicio.setVisibility(View.INVISIBLE);

        lin_estacion.setVisibility(View.GONE);
        cir_estacion.setVisibility(View.INVISIBLE);

        lin_ubicacion.setVisibility(View.GONE);
        cir_ubicacion.setVisibility(View.INVISIBLE);

        lin_oferta.setVisibility(View.GONE);
        cir_oferta.setVisibility(View.INVISIBLE);
    }

    public void mostrarOferta(View view) {
        //Oferta
        lin_oferta.setVisibility(View.VISIBLE);
        cir_oferta.setVisibility(View.VISIBLE);

        //Opciones
        lin_inicio.setVisibility(View.GONE);
        cir_inicio.setVisibility(View.INVISIBLE);

        lin_estacion.setVisibility(View.GONE);
        cir_estacion.setVisibility(View.INVISIBLE);

        lin_ubicacion.setVisibility(View.GONE);
        cir_ubicacion.setVisibility(View.INVISIBLE);

        lin_horario.setVisibility(View.GONE);
        cir_horario.setVisibility(View.INVISIBLE);
    }

    public void mostrarMenu(View view){
        navigationView.setVisibility(View.VISIBLE);
        lin_volver.setVisibility(View.VISIBLE);
    }

    public void ocultarMenu(View view){
        navigationView.setVisibility(View.GONE);
        lin_volver.setVisibility(View.INVISIBLE);
    }

}