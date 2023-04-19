package sv.edu.utec.gasolinera_interfaz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;

import sv.edu.utec.gasolinera_interfaz.clases.EstacionFragment;
import sv.edu.utec.gasolinera_interfaz.clases.HorarioFragment;
import sv.edu.utec.gasolinera_interfaz.clases.InicioFragment;
import sv.edu.utec.gasolinera_interfaz.clases.OfertaFragment;
import sv.edu.utec.gasolinera_interfaz.clases.UbicacionFragment;

public class MainActivity extends AppCompatActivity {
    //Var Pantallas
    FragmentTransaction transaction;
    Fragment fragment_inicio, fragment_estacion, fragment_ubicacion, fragment_horario, fragment_oferta;

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
        fragment_inicio = new InicioFragment();
        fragment_estacion = new EstacionFragment();
        fragment_ubicacion = new UbicacionFragment();
        fragment_horario = new HorarioFragment();
        fragment_oferta = new OfertaFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragments, fragment_inicio).commit();

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
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                transaction=getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()){
                    case R.id.inicio_item:
                    {
                        transaction.replace(R.id.contenedorFragments,fragment_inicio);
                        transaction.addToBackStack(null);
                        mostrarCirInicio();
                        break;
                    }
                    case R.id.estacion_item:
                    {
                        transaction.replace(R.id.contenedorFragments,fragment_estacion);
                        transaction.addToBackStack(null);
                        mostrarCirEstacion();
                        break;
                    }
                    case R.id.ubicacion_item:
                    {
                        transaction.replace(R.id.contenedorFragments,fragment_ubicacion);
                        transaction.addToBackStack(null);
                        mostrarCirUbicacion();
                        break;
                    }
                    case R.id.horario_item:
                    {
                        transaction.replace(R.id.contenedorFragments,fragment_horario);
                        transaction.addToBackStack(null);
                        mostrarCirHorario();
                        break;
                    }
                    case R.id.oferta_item:
                    {
                        transaction.replace(R.id.contenedorFragments,fragment_oferta);
                        transaction.addToBackStack(null);
                        mostrarCirOferta();
                        break;
                    }
                }
                transaction.commit();
                return false;
            }
        });
    }

    //Metodo para ir cambiando entre pantallas menu abajo
    public void mostrarDatos(View view){
        transaction=getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
            case R.id.LayoutInicio:
            {
                transaction.replace(R.id.contenedorFragments,fragment_inicio);
                transaction.addToBackStack(null);
                mostrarCirInicio();
                break;
            }
            case R.id.LayoutEstacion:
            {
                transaction.replace(R.id.contenedorFragments,fragment_estacion);
                transaction.addToBackStack(null);
                mostrarCirEstacion();
                break;
            }
            case R.id.LayoutUbicacion:
            {
                transaction.replace(R.id.contenedorFragments,fragment_ubicacion);
                transaction.addToBackStack(null);
                mostrarCirUbicacion();
                break;
            }
            case R.id.LayoutHorario:
            {
                transaction.replace(R.id.contenedorFragments,fragment_horario);
                transaction.addToBackStack(null);
                mostrarCirHorario();
                break;
            }
            case R.id.LayoutOferta:
            {
                transaction.replace(R.id.contenedorFragments,fragment_oferta);
                transaction.addToBackStack(null);
                mostrarCirOferta();
                break;
            }
        }
        transaction.commit();
    }

    public void mostrarCirInicio() {
        //Inicio
        cir_inicio.setVisibility(View.VISIBLE);

        //Opciones
        cir_estacion.setVisibility(View.INVISIBLE);
        cir_ubicacion.setVisibility(View.INVISIBLE);
        cir_horario.setVisibility(View.INVISIBLE);
        cir_oferta.setVisibility(View.INVISIBLE);

        //OcultarMenu
        navigationView.setVisibility(View.INVISIBLE);
        lin_menu.setVisibility(View.INVISIBLE);
    }
    public void mostrarCirEstacion() {
        //Estacion
        cir_estacion.setVisibility(View.VISIBLE);

        //Opciones
        cir_inicio.setVisibility(View.INVISIBLE);
        cir_ubicacion.setVisibility(View.INVISIBLE);
        cir_horario.setVisibility(View.INVISIBLE);
        cir_oferta.setVisibility(View.INVISIBLE);

        //OcultarMenu
        navigationView.setVisibility(View.INVISIBLE);
        lin_menu.setVisibility(View.INVISIBLE);
    }

    public void mostrarCirUbicacion() {
        //Ubicacion
        cir_ubicacion.setVisibility(View.VISIBLE);

        //Opciones
        cir_inicio.setVisibility(View.INVISIBLE);
        cir_estacion.setVisibility(View.INVISIBLE);
        cir_horario.setVisibility(View.INVISIBLE);
        cir_oferta.setVisibility(View.INVISIBLE);

        //OcultarMenu
        navigationView.setVisibility(View.INVISIBLE);
        lin_menu.setVisibility(View.INVISIBLE);
    }

    public void mostrarCirHorario() {
        //Horario
        cir_horario.setVisibility(View.VISIBLE);

        //Opciones
        cir_inicio.setVisibility(View.INVISIBLE);
        cir_estacion.setVisibility(View.INVISIBLE);
        cir_ubicacion.setVisibility(View.INVISIBLE);
        cir_oferta.setVisibility(View.INVISIBLE);

        //OcultarMenu
        navigationView.setVisibility(View.INVISIBLE);
        lin_menu.setVisibility(View.INVISIBLE);
    }

    public void mostrarCirOferta() {
        //Oferta
        cir_oferta.setVisibility(View.VISIBLE);

        //Opciones
        cir_inicio.setVisibility(View.INVISIBLE);
        cir_estacion.setVisibility(View.INVISIBLE);
        cir_ubicacion.setVisibility(View.INVISIBLE);
        cir_horario.setVisibility(View.INVISIBLE);

        //OcultarMenu
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