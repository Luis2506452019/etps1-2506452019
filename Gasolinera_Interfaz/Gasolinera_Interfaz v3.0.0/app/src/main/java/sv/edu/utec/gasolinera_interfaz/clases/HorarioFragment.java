package sv.edu.utec.gasolinera_interfaz.clases;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import sv.edu.utec.gasolinera_interfaz.R;
public class HorarioFragment extends Fragment {
    private boolean bandera = false;

    public HorarioFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_horario, container, false);

        // Variables Spinner (ComboBox)
        Spinner spin1 = (Spinner) vista.findViewById(R.id.spinner1);
        Spinner spin2 = (Spinner) vista.findViewById(R.id.spinner2);
        Spinner spin3 = (Spinner) vista.findViewById(R.id.spinner3);
        Spinner spin4 = (Spinner) vista.findViewById(R.id.spinner4);
        Spinner spin5 = (Spinner) vista.findViewById(R.id.spinner5);

        // Personalizacion del Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.gasolinera_array, R.layout.elemento_spinner_personalizado);
        adapter.setDropDownViewResource( R.layout.elemento_lista_spinner_personalizado);

        // Llenando Spinner
        spin1.setAdapter(adapter);
        spin2.setAdapter(adapter);
        spin3.setAdapter(adapter);
        spin4.setAdapter(adapter);
        spin5.setAdapter(adapter);

        // Evento para Opciones con Toast
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                if (!bandera) { bandera = true; return; }
                Toast.makeText(getActivity(), parent.getSelectedItem().toString(),
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        return vista;
    }
}