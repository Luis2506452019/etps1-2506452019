package sv.edu.utec.parcial3_2506452019.clases;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.utec.parcial3_2506452019.Helper.AdminSQLiteOpenHelper;
import sv.edu.utec.parcial3_2506452019.R;
public class AddFragment extends Fragment {
    private EditText txtNombre,txtApellido, txtTelefono, txtEmail;
    public AddFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_add, container, false);
        txtNombre=(EditText)vista.findViewById(R.id.editTextNombre);
        txtApellido=(EditText)vista.findViewById(R.id.editTextApellido);
        txtTelefono=(EditText)vista.findViewById(R.id.editTextTelefono);
        txtEmail=(EditText)vista.findViewById(R.id.editTextEmail);

        return vista;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.nav_main,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getActivity().getApplicationContext(),"parcial",null,2);
            SQLiteDatabase bd= admin.getWritableDatabase();

            String nom =txtNombre.getText().toString();
            String ape =txtApellido.getText().toString();
            String tel =txtTelefono.getText().toString();
            String email =txtEmail.getText().toString();

            ContentValues informacion =new ContentValues();
            informacion.put("nombre",nom);
            informacion.put("apellidos",ape);
            informacion.put("telefono",tel);
            informacion.put("correoElectronico",email);

            switch (item.getItemId()) {
                case R.id.editar:
                    int cat = bd.update("contactos", informacion, "nombre='" + nom + "'", null);
                    bd.close();
                    if (cat == 1) {
                        Toast.makeText(getActivity().getApplicationContext(), "Se modifico el contacto", Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "No se modifico el contacto", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.guardar:
                    if (!nom.isEmpty() && !ape.isEmpty() && !tel.isEmpty() && !email.isEmpty()) {
                        bd.insert("contactos", null, informacion);
                        bd.close();

                        txtNombre.setText("");
                        txtApellido.setText("");
                        txtTelefono.setText("");
                        txtEmail.setText("");

                        Toast.makeText(getActivity().getApplicationContext(), "Se inserto el contacto", Toast.LENGTH_LONG).show();
                        bd.close();
                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "Debe rellenar todos los campos", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.eliminar:
                    int cat2 = bd.delete("contactos", "nombre='" + nom + "'", null);
                    bd.close();
                    txtApellido.setText("");
                    txtTelefono.setText("");
                    txtEmail.setText("");

                    if (cat2 == 1) {
                        Toast.makeText(getActivity().getApplicationContext(), "Se borro el contacto", Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "No se borro el contacto", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        return super.onOptionsItemSelected(item);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
}