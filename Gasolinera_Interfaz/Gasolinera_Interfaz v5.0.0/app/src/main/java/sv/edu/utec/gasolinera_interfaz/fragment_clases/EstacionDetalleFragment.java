package sv.edu.utec.gasolinera_interfaz.fragment_clases;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import sv.edu.utec.gasolinera_interfaz.R;

public class EstacionDetalleFragment extends Fragment {
    public EstacionDetalleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_estacion_detalle, container, false);

        //OBTENIENDO IDENTIFICADORES
        TextView txtGasolineraEstacion = vista.findViewById(R.id.tituloDetalleEstacion);
        ImageView imgListEstacion = vista.findViewById(R.id.imagenDetalleEstacion);
        TextView txtUbicacionEstacion = vista.findViewById(R.id.ubicacionDetalleEstacion);
        TextView txtPrecioEstacion1 = vista.findViewById(R.id.precioEstacion1);
        TextView txtPrecioEstacion2 = vista.findViewById(R.id.precioEstacion2);
        TextView txtPrecioEstacion3 = vista.findViewById(R.id.precioEstacion3);

        //RECUPERAMOS DATOS A TRAVES DE BUNDLE
        Bundle datosRecuperados = getArguments();
        String imgGasolinera = datosRecuperados.getString("imgGasolinera");
        String nomGasolinera = datosRecuperados.getString("nombreGasolineraSucursal");
        String ubiGasolinera = datosRecuperados.getString("ubicacionGasolinera");
        String precioDiesel = datosRecuperados.getString("precioDiesel");
        String precioRegular = datosRecuperados.getString("precioRegular");
        String precioEspecial = datosRecuperados.getString("precioEspecial");


        // Utilizamos la función equals() para comparar strings y dependiendo la condicion mostrar la imagen correspondiente de la gasolinera
        if (imgGasolinera.equals("PUMA")){
            imgListEstacion.setImageResource(R.drawable.estacion_puma);
        } else if (imgGasolinera.equals("UNO")){
            imgListEstacion.setImageResource(R.drawable.estacion_uno);
        } else if (imgGasolinera.equals("TEXACO")){
            imgListEstacion.setImageResource(R.drawable.estacion_texaco);
        }

        txtGasolineraEstacion.setText(nomGasolinera);
        txtUbicacionEstacion.setText(ubiGasolinera);
        txtPrecioEstacion1.setText("$"+precioDiesel);
        txtPrecioEstacion2.setText("$"+precioRegular);
        txtPrecioEstacion3.setText("$"+precioEspecial);

        return vista;
    }
}