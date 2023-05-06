package sv.edu.utec.gasolinera_interfaz.clases;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import sv.edu.utec.gasolinera_interfaz.R;
public class UbicacionFragment extends Fragment {
    TextView textView;

    public UbicacionFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_ubicacion, container, false);

        textView = (TextView) vista.findViewById(R.id.txtLista);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "Modo " +
                        "Lista", Toast.LENGTH_SHORT).show();
            }
        });

        return vista;
    }
}