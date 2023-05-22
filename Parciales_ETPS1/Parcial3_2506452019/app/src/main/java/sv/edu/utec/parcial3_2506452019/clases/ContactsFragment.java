package sv.edu.utec.parcial3_2506452019.clases;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import sv.edu.utec.parcial3_2506452019.Helper.AdminSQLiteOpenHelper;
import sv.edu.utec.parcial3_2506452019.R;
public class ContactsFragment extends Fragment {

    ListView listViewPersons;
    public ContactsFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_contacts, container, false);

        listViewPersons = (ListView) vista.findViewById(R.id.listViewPersonas);

        consultarListaPersonas();

        return vista;
    }

    private void consultarListaPersonas() {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getActivity().getApplicationContext(),"parcial",null,2);
        SQLiteDatabase bd= admin.getWritableDatabase();

        ArrayList array_list = admin.getAllRegistros();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, array_list);
        listViewPersons.setAdapter(arrayAdapter);

        listViewPersons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String informacion = array_list.get(i).toString();
                Toast.makeText(getActivity().getApplicationContext(),informacion, Toast.LENGTH_SHORT).show();
            }
        });
    }
}