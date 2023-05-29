package sv.edu.utec.gasolinera_interfaz.other;

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

import sv.edu.utec.gasolinera_interfaz.R;

public class LoginFragment extends Fragment {

    public LoginFragment() {
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
        View vista = inflater.inflate(R.layout.fragment_login, container, false);

        EditText username = (EditText) vista.findViewById(R.id.userLogin);
        EditText password = (EditText) vista.findViewById(R.id.passLogin);
        Button loginButton = (Button) vista.findViewById(R.id.btnLogin);
        TextView textView = (TextView) vista.findViewById(R.id.txtRegistrarse);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (!user.isEmpty() && !pass.isEmpty()){
                    if (user.equals("user") && pass.equals("12345")) {
                        Toast.makeText(getActivity(), "¡Inicio de sesión exitoso!", Toast.LENGTH_SHORT).show();
                        Navigation.findNavController(view).navigate(R.id.inicioFragment);
                    } else {
                        Toast.makeText(getActivity(), "¡Error de inicio de sesión!", Toast.LENGTH_SHORT).show();
                    }
                } else{
                    Toast.makeText(getActivity(), "¡Rellene todos los campos!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.registrarseFragment);
            }
        });

        return vista;
    }
}