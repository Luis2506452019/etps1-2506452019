package sv.edu.utec.gasolinera_interfaz.clases;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import sv.edu.utec.gasolinera_interfaz.R;
import sv.edu.utec.gasolinera_interfaz.clases.list_clases.List_entrada_detalle;
import sv.edu.utec.gasolinera_interfaz.clases.list_clases.List_entrada_opciones;

public class EstacionDetalleFragment extends Fragment {
    public EstacionDetalleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_estacion_detalle, container, false);

        TextView textView = vista.findViewById(R.id.tituloGasolineraEstacion);
        ImageView imageView = vista.findViewById(R.id.imagenListEstacion);

        ArrayList<List_entrada_detalle> datos = new ArrayList<List_entrada_detalle>();

        Bundle datosRecuperados = getArguments();
        //int pos = datosRecuperados.getInt("pos");
        String nom = datosRecuperados.getString("nom");
        int img = datosRecuperados.getInt("img");

        /*switch (pos){
            case 0:
                textView.setText(nom);
                break;
        }*/

        textView.setText(nom);
        imageView.setImageResource(img);

        return vista;
    }
}