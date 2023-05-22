package sv.edu.utec.parcial3_2506452019;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

import sv.edu.utec.parcial3_2506452019.Helper.AdminSQLiteOpenHelper;
import sv.edu.utec.parcial3_2506452019.clases.AddFragment;
import sv.edu.utec.parcial3_2506452019.clases.BuscarFragment;
import sv.edu.utec.parcial3_2506452019.clases.ContactsFragment;
import sv.edu.utec.parcial3_2506452019.clases.InicioFragment;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), android.R.color.transparent));
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragments, new InicioFragment()).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                int itemId = item.getItemId();

                switch (itemId){
                    case R.id.inicio:
                    {
                        selectedFragment = new InicioFragment();
                        break;
                    }
                    case R.id.buscar:
                    {
                        selectedFragment = new BuscarFragment();
                        break;
                    }
                    case R.id.contactos:
                    {
                        selectedFragment = new ContactsFragment();
                        break;
                    }
                }

                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragments, selectedFragment).commit();
                }
                return true;
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment selectedFragment = null;
                selectedFragment = new AddFragment();
                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragments, selectedFragment).commit();
                    bottomNavigationView.setSelectedItemId(R.id.flo);
                }
            }
        });
    }
}