package sv.edu.utec.gasolinera_interfaz.clases;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import sv.edu.utec.gasolinera_interfaz.R;
import sv.edu.utec.gasolinera_interfaz.clases.list_clases.List_adaptador;
import sv.edu.utec.gasolinera_interfaz.clases.list_clases.List_entrada;
import sv.edu.utec.gasolinera_interfaz.clases.list_clases.List_entrada_opciones;

public class EstacionOpcionFragment extends Fragment {

    private ListView lista;

    public EstacionOpcionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_estacion_opcion, container, false);

        ArrayList<List_entrada_opciones> datos = new ArrayList<List_entrada_opciones>();

        Bundle datosRecuperados = getArguments();
        int pos = datosRecuperados.getInt("posicion");

        switch (pos){
            case 0:
                datos.add(new List_entrada_opciones(R.drawable.estacion_puma, "Gasolinera:", "PUMA, La Gloria"));
                datos.add(new List_entrada_opciones(R.drawable.estacion_puma, "Gasolinera:", "PUMA, Constitución"));
                datos.add(new List_entrada_opciones(R.drawable.estacion_puma, "Gasolinera:", "PUMA, Rubén Darío"));
                break;
            case 1:
                datos.add(new List_entrada_opciones(R.drawable.estacion_uno, "Gasolinera:", "UNO, La Gloria"));
                datos.add(new List_entrada_opciones(R.drawable.estacion_uno, "Gasolinera:", "UNO, Constitución"));
                datos.add(new List_entrada_opciones(R.drawable.estacion_uno, "Gasolinera:", "UNO, Rubén Darío"));
                break;
            case 2:
                datos.add(new List_entrada_opciones(R.drawable.estacion_texaco, "Gasolinera:", "TEXACO, La Gloria"));
                datos.add(new List_entrada_opciones(R.drawable.estacion_texaco, "Gasolinera:", "TEXACO, Constitución"));
                datos.add(new List_entrada_opciones(R.drawable.estacion_texaco, "Gasolinera:", "TEXACO, Rubén Darío"));
                break;
        }

        lista = (ListView) vista.findViewById(R.id.ListView_listado);
        lista.setAdapter(new List_adaptador(getActivity(), R.layout.elemento_listview_opcion_personalizado, datos){
            @Override
            public void onEntrada(Object entrada, View view) {
                if (entrada != null) {
                    TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior);
                    if (texto_superior_entrada != null)
                        texto_superior_entrada.setText(((List_entrada_opciones) entrada).get_textoEncima());

                    TextView texto_intermedio_entrada = (TextView) view.findViewById(R.id.textView_inferior);
                    if (texto_intermedio_entrada != null)
                        texto_intermedio_entrada.setText(((List_entrada_opciones) entrada).get_textoDebajo());

                    ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen);
                    if (imagen_entrada != null)
                        imagen_entrada.setImageResource(((List_entrada_opciones) entrada).get_idImagen());
                }
            }
        });
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                List_entrada_opciones elegido = (List_entrada_opciones) pariente.getItemAtPosition(posicion);

                CharSequence textOne = elegido.get_textoEncima();
                CharSequence textTwo = elegido.get_textoDebajo();
                Toast toast = Toast.makeText(getActivity(), textOne+" "+textTwo, Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        return vista;
    }
}