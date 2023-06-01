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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import sv.edu.utec.gasolinera_interfaz.database.BaseHelper;
import sv.edu.utec.gasolinera_interfaz.R;
import sv.edu.utec.gasolinera_interfaz.datos.Estaciones;

public class MantenimientoFragment extends Fragment {
    Spinner spnNomEsta;
    String nomOld;
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

        // ASIGNANDO IDENTIFICADOR PARA SPINNER Y EDITEXTS
        spnNomEsta = (Spinner) vista.findViewById(R.id.spnNombreEstacion);
        nomSucu = (EditText) vista.findViewById(R.id.edtNombreSucursal);
        ubiSucu = (EditText) vista.findViewById(R.id.edtUbicacionSucursal);
        preDies = (EditText) vista.findViewById(R.id.edtTipoDiesel);
        preRegu = (EditText) vista.findViewById(R.id.edtTipoRegular);
        preEspe = (EditText) vista.findViewById(R.id.edtTipoEspecial);

        // ASIGNANDO IDENTIFICADOR PARA BUTTONS
        btBuscar = (Button) vista.findViewById(R.id.btnBuscar);
        btGuardar = (Button) vista.findViewById(R.id.btnGuardar);
        btEditar = (Button) vista.findViewById(R.id.btnEditar);
        btEliminar = (Button) vista.findViewById(R.id.btnEliminar);

        // PERSONALIZANDO SPINNER
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.nombreEstacion_array, R.layout.elemento_spinner_personalizado);
        adapter.setDropDownViewResource( R.layout.elemento_spinner_lista_personalizado);

        // LLENANDO SPINNER
        spnNomEsta.setAdapter(adapter);

        // |||||||||||||||| ----------------------- INICIO EVENTOS ONCLICK ----------------------- ||||||||||||||||

        // -------------------- ||| BUSCAR ESTACION ||| -------------------->
        btBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // CONEXION CON BD
                BaseHelper controller = new BaseHelper(getActivity());
                SQLiteDatabase db = controller.getReadableDatabase();

                // VALIDACION CAMPOS VACIOS
                if(!nomSucu.getText().toString().isEmpty()){
                    // CONSULTA HACIA BD
                    Cursor cursor = db.rawQuery("SELECT * FROM estaciones WHERE nomb_sucursal = '"+nomSucu.getText().toString()+"'",null);
                    if (cursor.moveToFirst()){
                        // COMPARAMOS CADENA -> REGISTRO == SPINNER -> PARA SELECCIONAR OPCION
                        switch (cursor.getString(1)){
                            case "PUMA":
                                spnNomEsta.setSelection(1);
                                break;
                            case "TEXACO":
                                spnNomEsta.setSelection(2);
                                break;
                            case "UNO":
                                spnNomEsta.setSelection(3);
                                break;
                        }
                        // ALMACENAMOS EL "NOMBRE DE SUCURSAL" EN UNA VARIABLE STRING POR SI SE QUIERE ACTUALIZAR
                        nomOld = cursor.getString(2);
                        ubiSucu.setText(cursor.getString(3));
                        preDies.setText(cursor.getString(4));
                        preRegu.setText(cursor.getString(5));
                        preEspe.setText(cursor.getString(6));
                        cursor.close();
                    }else {
                        Toast.makeText(context, "No existe registro", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(context, "Rellene campo \"Sucursal\" para buscar", Toast.LENGTH_SHORT).show();
                }
                db.close();
            }
        });
        // FIN ------->

        // -------------------- ||| GUARDAR ESTACION ||| -------------------->
        btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Estaciones baseEst = new Estaciones(context);

                // VALIDACION DE CAMPOS VACIOS
                if (spnNomEsta.getSelectedItem().toString().equals("SELECCIONAR...") || nomSucu.getText().toString().isEmpty() || ubiSucu.getText().toString().isEmpty() ||
                        preDies.getText().toString().isEmpty() || preRegu.getText().toString().isEmpty() || preEspe.getText().toString().isEmpty()){
                    Toast.makeText(context, "Rellene todos los campos", Toast.LENGTH_LONG).show();
                } else {
                    // EJECUTANDO CONSULTA PARA INSERTAR
                    long codisave = baseEst.insertEstacion(spnNomEsta.getSelectedItem().toString(), nomSucu.getText().toString(), ubiSucu.getText().toString(),
                            preDies.getText().toString(), preRegu.getText().toString(), preEspe.getText().toString());

                    if(codisave>0){
                        Toast.makeText(getActivity().getApplicationContext(),"Registro insertado",Toast.LENGTH_SHORT).show();
                        limpiar();
                    } else {
                        Toast.makeText(getActivity().getApplicationContext(),"Error al insertar",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        // FIN ------->

        // -------------------- ||| EDITAR ESTACION ||| -------------------->
        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Estaciones baseEst = new Estaciones(context);

                // VALIDACION DE CAMPOS VACIOS
                if (spnNomEsta.getSelectedItem().toString().equals("SELECCIONAR...") || nomSucu.getText().toString().isEmpty() || ubiSucu.getText().toString().isEmpty() ||
                        preDies.getText().toString().isEmpty() || preRegu.getText().toString().isEmpty() || preEspe.getText().toString().isEmpty()){
                    Toast.makeText(context, "Rellene todos los campos", Toast.LENGTH_LONG).show();
                } else {
                    // EJECUTANDO CONSULTA PARA ACTUALIZAR
                    long codiupdate = baseEst.updateEstacion(spnNomEsta.getSelectedItem().toString(), nomOld, nomSucu.getText().toString(), ubiSucu.getText().toString(),
                            preDies.getText().toString(), preRegu.getText().toString(), preEspe.getText().toString());

                    if(codiupdate>0){
                        Toast.makeText(getActivity().getApplicationContext(),"Registro actualizado",Toast.LENGTH_SHORT).show();
                        limpiar();
                    } else {
                        Toast.makeText(getActivity().getApplicationContext(),"Error al actualizar",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        // FIN ------->

        // -------------------- ||| ELIMINAR ESTACION ||| -------------------->
        btEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Estaciones baseEst = new Estaciones(context);

                // VALIDACION DE CAMPOS VACIOS
                if (nomSucu.getText().toString().isEmpty()){
                    Toast.makeText(context, "Campo \"Sucursal\" vacio", Toast.LENGTH_LONG).show();
                } else {
                    // EJECUTANDO CONSULTA PARA ELIMINAR
                    long codidelete = baseEst.deleteEstacion(nomSucu.getText().toString());

                    if(codidelete>0){
                        Toast.makeText(getActivity().getApplicationContext(),"Registro eliminado",Toast.LENGTH_SHORT).show();
                        limpiar();
                    } else {
                        Toast.makeText(getActivity().getApplicationContext(),"Error al eliminar",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        // FIN ------->

        // |||||||||||||||| ----------------------- FIN EVENTOS ONCLICK ----------------------- ||||||||||||||||

        return vista;
    }


    // METODO PARA LIMPIAR EDITEXT Y SPINNER --->
    public void limpiar(){
        spnNomEsta.setSelection(0);

        nomSucu.setText("");
        ubiSucu.setText("");
        preDies.setText("");
        preRegu.setText("");
        preEspe.setText("");
    }
    // FIN ------->
}