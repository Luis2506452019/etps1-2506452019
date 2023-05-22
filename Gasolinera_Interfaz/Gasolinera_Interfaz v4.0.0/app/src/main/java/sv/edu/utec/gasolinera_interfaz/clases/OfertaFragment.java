package sv.edu.utec.gasolinera_interfaz.clases;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import sv.edu.utec.gasolinera_interfaz.R;
public class OfertaFragment extends Fragment {

    Button btnRegistrar;
    ImageView imgPuma, imgTexaco;

    public OfertaFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_oferta, container, false);

        btnRegistrar = (Button) vista.findViewById(R.id.btnRegistraCupon);
        imgPuma = (ImageView) vista.findViewById(R.id.imagenIconPuma);
        imgTexaco = (ImageView) vista.findViewById(R.id.imagenIconTexaco);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "Registrar Cupón", Toast.LENGTH_SHORT).show();
            }
        });

        imgPuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "Gasolinera Puma", Toast.LENGTH_SHORT).show();
            }
        });

        imgTexaco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "Gasolinera Texaco", Toast.LENGTH_SHORT).show();
            }
        });

        return vista;
    }
}