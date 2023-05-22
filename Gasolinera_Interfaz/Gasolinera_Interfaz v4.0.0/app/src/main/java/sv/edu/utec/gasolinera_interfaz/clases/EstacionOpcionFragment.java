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
import sv.edu.utec.gasolinera_interfaz.clases.list_estacion.List_adaptador;
import sv.edu.utec.gasolinera_interfaz.clases.list_estacion.List_entrada_opciones;

public class
EstacionOpcionFragment extends Fragment {

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
        int posEstacion = datosRecuperados.getInt("posEstacion");
        int imgGasolinera = datosRecuperados.getInt("imgGasolinera");
        String textGasolinera = datosRecuperados.getString("textGasolinera");
        String nombreGasolinera = datosRecuperados.getString("nomGasolinera");

        switch (posEstacion){
            case 0:
                datos.add(new List_entrada_opciones("La Gloria", "Altos De Sta Mónica Sda A No 71-A La Gloria",
                        "$4.78", "$5.00", "$4.80"));
                datos.add(new List_entrada_opciones("Constitución", "Altos De Sta Mónica Sda A No 72-A Constitución",
                        "$4.78", "$5.00", "$4.80"));
                datos.add(new List_entrada_opciones("Rubén Darío", "Altos De Sta Mónica Sda A No 73-A Rubén Darío",
                        "$4.78", "$5.00", "$4.80"));
                break;
            case 1:
                datos.add(new List_entrada_opciones("San Salvador", "Altos De Sta Mónica Sda A No 74-A San Salvador",
                        "$4.78", "$5.00", "$4.80"));
                datos.add(new List_entrada_opciones("Chalatenango", "Altos De Sta Mónica Sda A No 75-A Chalatenango",
                        "$4.78", "$5.00", "$4.80"));
                datos.add(new List_entrada_opciones("Santa Ana", "Altos De Sta Mónica Sda A No 76-A Santa Ana",
                        "$4.78", "$5.00", "$4.80"));
                break;
            case 2:
                datos.add(new List_entrada_opciones("Porvenir", "Altos De Sta Mónica Sda A No 77-A Porvenir",
                        "$4.78", "$5.00", "$4.80"));
                datos.add(new List_entrada_opciones("San Vicente", "Altos De Sta Mónica Sda A No 78-A San Vicente",
                        "$4.78", "$5.00", "$4.80"));
                datos.add(new List_entrada_opciones("San Miguel", "Altos De Sta Mónica Sda A No 79-A San Miguel",
                        "$4.78", "$5.00", "$4.80"));
                break;
        }

        lista = (ListView) vista.findViewById(R.id.ListView_listado);
        lista.setAdapter(new List_adaptador(getActivity(), R.layout.elemento_listview_opcion_personalizado, datos){
            @Override
            public void onEntrada(Object entrada, View view) {
                if (entrada != null) {
                    TextView texto_titulo_entrada = (TextView) view.findViewById(R.id.txtTituloGasolineraOpcion);
                    if (texto_titulo_entrada != null)
                        texto_titulo_entrada.setText(textGasolinera);

                    TextView texto_nombre_entrada = (TextView) view.findViewById(R.id.txtNombreGasolineraOpcion);
                    if (texto_nombre_entrada != null)
                        texto_nombre_entrada.setText(nombreGasolinera+", "+((List_entrada_opciones) entrada).get_txtSucursalGasolinera());

                    ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imagenEstacionOpcion);
                    if (imagen_entrada != null)
                        imagen_entrada.setImageResource(imgGasolinera);
                }
            }
        });
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                Bundle datosAEnviar = new Bundle();
                datosAEnviar.putInt("imgGasolinera", imgGasolinera);
                datosAEnviar.putString("nombreGasolineraSucursal",textGasolinera+" "+nombreGasolinera+", "+datos.get(posicion).get_txtSucursalGasolinera());
                datosAEnviar.putString("ubicacionGasolinera", datos.get(posicion).get_txtUbicacionGasolinera());
                datosAEnviar.putString("precioDiesel", datos.get(posicion).get_txtPrecioDiesel());
                datosAEnviar.putString("precioRegular", datos.get(posicion).get_txtPrecioRegular());
                datosAEnviar.putString("precioEspecial", datos.get(posicion).get_txtPrecioEspecial());

                Navigation.findNavController(view).navigate(R.id.estacionDetalleFragment, datosAEnviar);
            }
        });

        return vista;
    }
}