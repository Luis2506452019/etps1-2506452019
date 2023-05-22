package sv.edu.utec.gasolinera_interfaz.clases;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import sv.edu.utec.gasolinera_interfaz.R;

public class RegistrarseFragment extends Fragment {

    public RegistrarseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem item=menu.findItem(R.id.loginFragment);
        item.setVisible(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_registrarse, container, false);

        EditText username = (EditText) vista.findViewById(R.id.userRegistrar);
        EditText correo = (EditText) vista.findViewById(R.id.mailRegistrar);
        EditText password = (EditText) vista.findViewById(R.id.passRegistrar);
        EditText passwordConfi = (EditText) vista.findViewById(R.id.passConfRegistrar);
        Button registrarButton = (Button) vista.findViewById(R.id.btnRegistrarCuenta);
        TextView textView = (TextView) vista.findViewById(R.id.txtLogin);

        registrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String mail = correo.getText().toString().trim();;
                String pass = password.getText().toString();
                String passconfi = passwordConfi.getText().toString();

                //Comprobando campos vacios
                if (!user.isEmpty() && !mail.isEmpty() && !pass.isEmpty() && !passconfi.isEmpty()){

                    //Comprobando contraseñas sean iguales
                    if (Objects.equals(pass, passconfi)) {
                        Toast.makeText(getActivity(), "¡Registro exitoso!", Toast.LENGTH_SHORT).show();
                        Navigation.findNavController(view).navigate(R.id.inicioFragment);
                    } else {
                        Toast.makeText(getActivity(), "¡Contraseñas no coinciden!", Toast.LENGTH_SHORT).show();
                    }

                } else{
                    //Notificando al usuario que los campos estan vacios
                    Toast.makeText(getActivity(), "¡Rellene todos los campos!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.loginFragment);
            }
        });

        return vista;
    }
}