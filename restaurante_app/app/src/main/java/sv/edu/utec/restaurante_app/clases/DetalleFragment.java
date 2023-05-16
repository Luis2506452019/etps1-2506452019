package sv.edu.utec.restaurante_app.clases;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import sv.edu.utec.restaurante_app.R;
public class DetalleFragment extends Fragment {
    public DetalleFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_detalle, container, false);

        TextView txtNombreComida = vista.findViewById(R.id.nomComida);
        ImageView imgComid = vista.findViewById(R.id.imgComi);
        TextView txtPrecioComida = vista.findViewById(R.id.preComida);

        Bundle datosRecuperados = getArguments();
        int imgComida = datosRecuperados.getInt("imgComida");
        String nombreComida = datosRecuperados.getString("nombreComida");
        Double precioComida = datosRecuperados.getDouble("precioComida");

        txtNombreComida.setText(nombreComida);
        imgComid.setImageResource(imgComida);
        txtPrecioComida.setText("$"+precioComida);

        Button btnAgregar = vista.findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getActivity(), "Agregado", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        return vista;
    }
}