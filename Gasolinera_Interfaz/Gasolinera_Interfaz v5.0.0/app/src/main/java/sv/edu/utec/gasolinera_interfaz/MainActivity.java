package sv.edu.utec.gasolinera_interfaz;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.inicioFragment, R.id.estacionFragment, R.id.ubicacionFragment, R.id.horarioFragment, R.id.ofertaFragment, R.id.loginFragment, R.id.registrarseFragment)
                .setOpenableLayout(drawer).build();

        NavController navController = Navigation.findNavController(this, R.id.contenedorFragments);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        BottomNavigationView bottom_nav_view = findViewById(R.id.bottom_navigation);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller,
                    @NonNull NavDestination destination, @Nullable Bundle arguments) {
                switch (destination.getId()){
                    case R.id.loginFragment:
                        bottom_nav_view.setVisibility(View.GONE);
                        break;
                    case R.id.registrarseFragment:
                        bottom_nav_view.setVisibility(View.GONE);
                        break;
                    case R.id.mantenimientoFragment:
                        bottom_nav_view.setVisibility(View.GONE);
                        break;
                    default:
                        bottom_nav_view.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

        NavigationUI.setupWithNavController(bottom_nav_view, navController);
    }

    //Creacion de Option Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_main, menu);
        return true;
    }

    // Gestionamos la navegación del Option Menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        NavController navController = Navigation.findNavController(this, R.id.contenedorFragments);
        return NavigationUI.onNavDestinationSelected(item, navController)
                || super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.contenedorFragments);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}

