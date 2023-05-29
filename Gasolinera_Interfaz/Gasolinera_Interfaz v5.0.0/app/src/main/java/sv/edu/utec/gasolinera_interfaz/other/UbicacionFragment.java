package sv.edu.utec.gasolinera_interfaz.other;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import sv.edu.utec.gasolinera_interfaz.R;
public class UbicacionFragment extends Fragment {

    public UbicacionFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_ubicacion, container, false);

        TextView textView = (TextView) vista.findViewById(R.id.txtLista);

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