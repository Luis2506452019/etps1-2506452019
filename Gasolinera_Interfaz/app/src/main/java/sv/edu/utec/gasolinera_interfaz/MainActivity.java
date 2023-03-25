package sv.edu.utec.gasolinera_interfaz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    //Var Pantallas
    LinearLayout lin_inicio, lin_estacion, lin_ubicacion, lin_horario, lin_oferta;

    //Var Circulo
    LinearLayout cir_inicio, cir_estacion, cir_ubicacion, cir_horario, cir_oferta;

    //Var Menu
    NavigationView navigationView;
    LinearLayout lin_menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Pantallas
        lin_inicio = (LinearLayout) findViewById(R.id.pantallaInicio);
        lin_estacion = (LinearLayout) findViewById(R.id.pantallaEstacion);
        lin_ubicacion = (LinearLayout) findViewById(R.id.pantallaUbicacion);
        lin_horario = (LinearLayout) findViewById(R.id.pantallaHorario);
        lin_oferta = (LinearLayout) findViewById(R.id.pantallaOferta);

        //Circulos
        cir_inicio = (LinearLayout) findViewById(R.id.circuloInicio);
        cir_estacion = (LinearLayout) findViewById(R.id.circuloEstacion);
        cir_ubicacion = (LinearLayout) findViewById(R.id.circuloUbicacion);
        cir_horario = (LinearLayout) findViewById(R.id.circuloHorario);
        cir_oferta = (LinearLayout) findViewById(R.id.circuloOferta);

        //Menu
        lin_menu = findViewById(R.id.lin_volver);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.inicio_item:
                    {
                        mostrarInicio();
                        break;
                    }
                    case R.id.estacion_item:
                    {
                        mostrarEstacion();
                        break;
                    }
                    case R.id.ubicacion_item:
                    {
                        mostrarUbicacion();
                        break;
                    }
                    case R.id.horario_item:
                    {
                        mostrarHorario();
                        break;
                    }
                    case R.id.oferta_item:
                    {
                        mostrarOferta();
                        break;
                    }
                }
                return false;
            }
        });

    }

    //Metodo para ir cambiando entre pantallas
    public void mostrarDatos(View view){
        switch (view.getId()){
            case R.id.LayoutInicio:
            {
                mostrarInicio();
                break;
            }
            case R.id.LayoutEstacion:
            {
                mostrarEstacion();
                break;
            }
            case R.id.LayoutUbicacion:
            {
                mostrarUbicacion();
                break;
            }
            case R.id.LayoutHorario:
            {
                mostrarHorario();
                break;
            }
            case R.id.LayoutOferta:
            {
                mostrarOferta();
                break;
            }
        }
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

        navigationView.setVisibility(View.INVISIBLE);
        lin_menu.setVisibility(View.INVISIBLE);
    }
    public void mostrarEstacion() {
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

        navigationView.setVisibility(View.INVISIBLE);
        lin_menu.setVisibility(View.INVISIBLE);
    }

    public void mostrarUbicacion() {
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

        navigationView.setVisibility(View.INVISIBLE);
        lin_menu.setVisibility(View.INVISIBLE);
    }

    public void mostrarHorario() {
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

        navigationView.setVisibility(View.INVISIBLE);
        lin_menu.setVisibility(View.INVISIBLE);
    }

    public void mostrarOferta() {
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

        navigationView.setVisibility(View.INVISIBLE);
        lin_menu.setVisibility(View.INVISIBLE);
    }

    public void mostrarMenu(View view){
        navigationView.setVisibility(View.VISIBLE);
        lin_menu.setVisibility(View.VISIBLE);
    }

    public void ocultarMenu(View view){
        navigationView.setVisibility(View.INVISIBLE);
        lin_menu.setVisibility(View.INVISIBLE);
    }


}