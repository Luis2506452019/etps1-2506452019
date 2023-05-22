package sv.edu.utec.gasolinera_interfaz.clases;

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

        TextView txtGasolineraEstacion = vista.findViewById(R.id.tituloDetalleEstacion);
        ImageView imgListEstacion = vista.findViewById(R.id.imagenDetalleEstacion);
        TextView txtUbicacionEstacion = vista.findViewById(R.id.ubicacionDetalleEstacion);
        TextView txtPrecioEstacion1 = vista.findViewById(R.id.precioEstacion1);
        TextView txtPrecioEstacion2 = vista.findViewById(R.id.precioEstacion2);
        TextView txtPrecioEstacion3 = vista.findViewById(R.id.precioEstacion3);

        Bundle datosRecuperados = getArguments();
        int imgGasolinera = datosRecuperados.getInt("imgGasolinera");
        String nomGasolinera = datosRecuperados.getString("nombreGasolineraSucursal");
        String ubiGasolinera = datosRecuperados.getString("ubicacionGasolinera");
        String precioDiesel = datosRecuperados.getString("precioDiesel");
        String precioRegular = datosRecuperados.getString("precioRegular");
        String precioEspecial = datosRecuperados.getString("precioEspecial");

        txtGasolineraEstacion.setText(nomGasolinera);
        imgListEstacion.setImageResource(imgGasolinera);
        txtUbicacionEstacion.setText(ubiGasolinera);
        txtPrecioEstacion1.setText(precioDiesel);
        txtPrecioEstacion2.setText(precioRegular);
        txtPrecioEstacion3.setText(precioEspecial);

        return vista;
    }
}