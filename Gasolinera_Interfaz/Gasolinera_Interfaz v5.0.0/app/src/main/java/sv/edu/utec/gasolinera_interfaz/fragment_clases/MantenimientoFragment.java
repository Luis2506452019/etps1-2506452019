package sv.edu.utec.gasolinera_interfaz.fragment_clases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import sv.edu.utec.gasolinera_interfaz.database.BaseHelper;
import sv.edu.utec.gasolinera_interfaz.R;
import sv.edu.utec.gasolinera_interfaz.datos.Estaciones;

public class MantenimientoFragment extends Fragment {
    BaseHelper controller;
    Spinner spnNomEsta;
    String nGasolinera;
    EditText nomSucu, ubiSucu, preDies, preRegu, preEspe;
    Button btBuscar, btGuardar, btEditar, btEliminar;

    Context context;

    public MantenimientoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_mantenimiento, container, false);

        controller = new BaseHelper(getActivity());

        spnNomEsta = (Spinner) vista.findViewById(R.id.spnNombreEstacion);
        nomSucu = (EditText) vista.findViewById(R.id.edtNombreSucursal);
        ubiSucu = (EditText) vista.findViewById(R.id.edtUbicacionSucursal);
        preDies = (EditText) vista.findViewById(R.id.edtTipoDiesel);
        preRegu = (EditText) vista.findViewById(R.id.edtTipoRegular);
        preEspe = (EditText) vista.findViewById(R.id.edtTipoEspecial);

        btBuscar = (Button) vista.findViewById(R.id.btnBuscar);
        btGuardar = (Button) vista.findViewById(R.id.btnGuardar);
        btEditar = (Button) vista.findViewById(R.id.btnEditar);
        btEliminar = (Button) vista.findViewById(R.id.btnEliminar);

        // Personalizacion del Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.nombreEstacion_array, R.layout.elemento_spinner_personalizado);
        adapter.setDropDownViewResource( R.layout.elemento_spinner_lista_personalizado);

        // Llenando Spinner
        spnNomEsta.setAdapter(adapter);

        // Evento para Opciones con Toast
        spnNomEsta.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                if (position == 0){
                    nGasolinera = "";
                } else if (position == 1){
                    nGasolinera = "PUMA";
                } else if (position == 2) {
                    nGasolinera = "TEXACO";
                } else if (position == 3) {
                    nGasolinera = "UNO";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SQLiteDatabase db = controller.getWritableDatabase();
                String nom = nomSucu.getText().toString();

                if(!nom.isEmpty()){
                    Cursor cursor = db.rawQuery("SELECT * FROM estaciones WHERE nomb_sucursal = '"+nom+"'",null);
                    if (cursor.moveToFirst()){
                        spnNomEsta.setSelection(cursor.getInt(2));
                        ubiSucu.setText(cursor.getString(3));
                        preDies.setText(cursor.getString(4));
                        preRegu.setText(cursor.getString(5));
                        preEspe.setText(cursor.getString(6));
                    }else {
                        Toast.makeText(context, "No existe registro", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(context, "Rellene campo para buscar", Toast.LENGTH_LONG).show();
                }
            }
        });

        btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Estaciones baseEst = new Estaciones(context);

                if (nGasolinera.isEmpty() || nomSucu.getText().toString().isEmpty() || ubiSucu.getText().toString().isEmpty() ||
                        preDies.getText().toString().isEmpty() || preRegu.getText().toString().isEmpty() || preDies.getText().toString().isEmpty()){

                    Toast.makeText(context, "Rellene todos los campos", Toast.LENGTH_LONG).show();

                } else {
                    long codisave = baseEst.insertEstacion(nGasolinera, nomSucu.getText().toString(), ubiSucu.getText().toString(),
                            preDies.getText().toString(), preRegu.getText().toString(), preEspe.getText().toString());

                    if(codisave>0){
                        Toast.makeText(getActivity().getApplicationContext(),"Registro insertado",Toast.LENGTH_LONG).show();
                        limpiar();
                    } else {
                        Toast.makeText(getActivity().getApplicationContext(),"Error al insertar",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Estaciones baseEst = new Estaciones(context);

                if (nGasolinera.isEmpty() || nomSucu.getText().toString().isEmpty() || ubiSucu.getText().toString().isEmpty() ||
                        preDies.getText().toString().isEmpty() || preRegu.getText().toString().isEmpty() || preDies.getText().toString().isEmpty()){

                    Toast.makeText(context, "Rellene todos los campos", Toast.LENGTH_LONG).show();

                } else {
                    long codiupdate = baseEst.updateEstacion(nGasolinera, nomSucu.getText().toString(), ubiSucu.getText().toString(),
                            preDies.getText().toString(), preRegu.getText().toString(), preEspe.getText().toString());

                    if(codiupdate>0){
                        Toast.makeText(getActivity().getApplicationContext(),"Registro actualizado",Toast.LENGTH_LONG).show();
                        limpiar();
                    } else {
                        Toast.makeText(getActivity().getApplicationContext(),"Error al actualizar",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        btEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Estaciones baseEst = new Estaciones(context);

                String nom = nomSucu.getText().toString();

                if (nomSucu.getText().toString().isEmpty()){

                    Toast.makeText(context, "Campo \"Sucursal\" vacio", Toast.LENGTH_LONG).show();

                } else {
                    long codidelete = baseEst.deleteEstacion(nom);
                    limpiar();

                    if(codidelete>0){
                        Toast.makeText(getActivity().getApplicationContext(),"Registro eliminado",Toast.LENGTH_LONG).show();
                        limpiar();
                    } else {
                        Toast.makeText(getActivity().getApplicationContext(),"Error al eliminar",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        return vista;
    }

    public void limpiar(){
        spnNomEsta.setSelection(0);

        nomSucu.setText("");
        ubiSucu.setText("");
        preDies.setText("");
        preRegu.setText("");
        preEspe.setText("");
    }
}