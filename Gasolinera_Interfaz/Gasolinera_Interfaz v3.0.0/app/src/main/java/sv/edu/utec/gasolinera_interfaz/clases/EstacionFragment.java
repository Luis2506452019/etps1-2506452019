package sv.edu.utec.gasolinera_interfaz.clases;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import sv.edu.utec.gasolinera_interfaz.R;
import sv.edu.utec.gasolinera_interfaz.clases.list_clases.List_adaptador;
import sv.edu.utec.gasolinera_interfaz.clases.list_clases.List_entrada;

public class EstacionFragment extends Fragment {
    private ListView lista;

    public EstacionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_estacion, container, false);

        ArrayList<List_entrada> datos = new ArrayList<List_entrada>();

        datos.add(new List_entrada(R.drawable.estacion_puma, "Gasolinera:", "PUMA"));
        datos.add(new List_entrada(R.drawable.estacion_uno, "Gasolinera:", "UNO"));
        datos.add(new List_entrada(R.drawable.estacion_texaco, "Gasolinera:", "TEXACO"));

        lista = (ListView) vista.findViewById(R.id.ListView_listado);
        lista.setAdapter(new List_adaptador(getActivity(), R.layout.elemento_listview_personalizado, datos){
            @Override
            public void onEntrada(Object entrada, View view) {
                if (entrada != null) {
                    TextView texto_superior_entrada = (TextView) view.findViewById(R.id.txtTituloGasolineraList);
                    if (texto_superior_entrada != null)
                        texto_superior_entrada.setText(((List_entrada) entrada).get_txtGasolinera()+" "+((List_entrada) entrada).get_txtNombreGasolinera());

                    ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imagenEstacionList);
                    if (imagen_entrada != null)
                        imagen_entrada.setImageResource(((List_entrada) entrada).get_idImagen());
                }
            }
        });
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                Bundle datosAEnviar = new Bundle();
                datosAEnviar.putInt("posEstacion", posicion);
                datosAEnviar.putString("textGasolinera", datos.get(posicion).get_txtGasolinera());
                datosAEnviar.putString("nomGasolinera", datos.get(posicion).get_txtNombreGasolinera());
                datosAEnviar.putInt("imgGasolinera", datos.get(posicion).get_idImagen());

                Navigation.findNavController(view).navigate(R.id.estacionOpcionFragment, datosAEnviar);
            }
        });

        return vista;
    }
}