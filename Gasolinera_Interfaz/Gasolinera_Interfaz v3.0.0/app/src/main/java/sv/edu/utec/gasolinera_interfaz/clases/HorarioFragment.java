package sv.edu.utec.gasolinera_interfaz.clases;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import sv.edu.utec.gasolinera_interfaz.R;
public class HorarioFragment extends Fragment {

    public HorarioFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_horario, container, false);

        Spinner spin1 = (Spinner) vista.findViewById(R.id.spinner1);
        Spinner spin2 = (Spinner) vista.findViewById(R.id.spinner2);
        Spinner spin3 = (Spinner) vista.findViewById(R.id.spinner3);
        Spinner spin4 = (Spinner) vista.findViewById(R.id.spinner4);
        Spinner spin5 = (Spinner) vista.findViewById(R.id.spinner5);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.gasolinera_array, R.layout.elemento_spinner_personalizado);
        adapter.setDropDownViewResource( R.layout.elemento_lista_spinner_personalizado);
        spin1.setAdapter(adapter);
        spin2.setAdapter(adapter);
        spin3.setAdapter(adapter);
        spin4.setAdapter(adapter);
        spin5.setAdapter(adapter);

        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = (String) spin1.getItemAtPosition(position);
                Toast.makeText(getActivity(), selected, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = (String) spin2.getItemAtPosition(position);
                Toast.makeText(getActivity(), selected, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = (String) spin3.getItemAtPosition(position);
                Toast.makeText(getActivity(), selected, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spin4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = (String) spin4.getItemAtPosition(position);
                Toast.makeText(getActivity(), selected, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spin5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = (String) spin5.getItemAtPosition(position);
                Toast.makeText(getActivity(), selected, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        return vista;
    }
}