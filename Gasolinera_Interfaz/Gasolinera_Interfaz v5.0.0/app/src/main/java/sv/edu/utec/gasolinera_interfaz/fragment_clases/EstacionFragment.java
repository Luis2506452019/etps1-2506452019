package sv.edu.utec.gasolinera_interfaz.fragment_clases;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import sv.edu.utec.gasolinera_interfaz.adaptadores.LstEstacionesAdapter;
import sv.edu.utec.gasolinera_interfaz.database.BaseHelper;
import sv.edu.utec.gasolinera_interfaz.R;
import sv.edu.utec.gasolinera_interfaz.datos.Estaciones;
import sv.edu.utec.gasolinera_interfaz.entidades.EntEstaciones;

public class EstacionFragment extends Fragment {
    BaseHelper controller;
    RecyclerView listaEstaciones;
    ArrayList<EntEstaciones> AlistEsta;
    Context context;


    public EstacionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_estacion, container, false);

        controller = new BaseHelper(getActivity());

        // Obtener un identificador de RecyclerView
        listaEstaciones = (RecyclerView) vista.findViewById(R.id.rcvLstEstaciones);
        // Damos al RecyclerView un administrador de diseño predeterminado.
        listaEstaciones.setLayoutManager(new LinearLayoutManager(context));

        Estaciones dbEsta = new Estaciones(context);

        AlistEsta = new ArrayList<>();
        //Creemos un adaptador para proporcionar los datos que se mostrarán
        LstEstacionesAdapter adapter = new LstEstacionesAdapter(dbEsta.mostrarEstacion());
        //Conectamos el adaptador con el RecyclerView
        listaEstaciones.setAdapter(adapter);

        //BOTON FLOTANTE QUE NOS REDIGIRA AL FRAGMENT DE MANTENIMIENTO
        FloatingActionButton fab = (FloatingActionButton) vista.findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment selectedFragment = null;
                selectedFragment = new MantenimientoFragment();
                if (selectedFragment != null) {
                    Navigation.findNavController(view).navigate(R.id.mantenimientoFragment);
                }
            }
        });

        return vista;
    }

}