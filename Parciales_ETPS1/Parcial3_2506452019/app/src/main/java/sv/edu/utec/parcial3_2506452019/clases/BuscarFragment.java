package sv.edu.utec.parcial3_2506452019.clases;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import sv.edu.utec.parcial3_2506452019.Helper.AdminSQLiteOpenHelper;
import sv.edu.utec.parcial3_2506452019.R;
public class BuscarFragment extends Fragment {

    EditText txtNombre,txtApellido, txtTelefono, txtEmail, txtBuscar;
    LinearLayout contenedorBus;
    Button btnBuscar;

    public BuscarFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_buscar, container, false);
        contenedorBus = (LinearLayout) vista.findViewById(R.id.contenedorBusqueda);

        txtNombre=(EditText)vista.findViewById(R.id.editTextNombr);
        txtApellido=(EditText)vista.findViewById(R.id.editTextApellid);
        txtTelefono=(EditText)vista.findViewById(R.id.editTextTelefon);
        txtEmail=(EditText)vista.findViewById(R.id.editTextEmai);
        txtBuscar=(EditText)vista.findViewById(R.id.editTextBuscar);
        btnBuscar=(Button)vista.findViewById(R.id.btnBuscar);
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getActivity().getApplicationContext(),"parcial",null,2);
                SQLiteDatabase bd= admin.getWritableDatabase();

                String text =txtBuscar.getText().toString();

                Cursor filas=bd.rawQuery("select * from contactos where nombre='"+text+"' OR apellidos='"+text+"' OR correoElectronico='"+text+"'",null);

                if(filas.moveToFirst()){
                    txtNombre.setText(filas.getString(0));
                    txtApellido.setText(filas.getString(1));
                    txtTelefono.setText(filas.getString(2));
                    txtEmail.setText(filas.getString(3));

                    contenedorBus.setVisibility(View.VISIBLE);
                }
                else{
                    Toast.makeText(getActivity().getApplicationContext(),"No se encontro" +
                            " el contacto",Toast.LENGTH_LONG).show();
                }
                bd.close();
            }
        });

        return vista;
    }
}