package sv.edu.utec.restaurante_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

import sv.edu.utec.restaurante_app.database.Entity.Producto;
import sv.edu.utec.restaurante_app.database.Repository.ProductoAdapter;
import sv.edu.utec.restaurante_app.database.Repository.ProductoViewModel;

public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    private ProductoViewModel productoViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtener un identificador de RecyclerView.
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.listado);
        //Creemos un adaptador para proporcionar los datos que se mostrarán.
        final ProductoAdapter adapter = new ProductoAdapter();
        recyclerView.setHasFixedSize(true);

        // Decoracion RecyclerView (Division)
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        //Conectamos el adaptador con el RecyclerView
        recyclerView.setAdapter(adapter);

        // Damos al RecyclerView un administrador de diseño predeterminado.
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productoViewModel = new ViewModelProvider(this).get(ProductoViewModel.class);
        productoViewModel.getAllProductos().observe(this, new Observer<List<Producto>>() {
            @Override
            public void onChanged(List<Producto> productos) {
                adapter.setProductos(productos);
            }
        });

        //Apartado de Toolbar y Navegación
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.inicioFragment, R.id.pedidoFragment, R.id.perfilFragment)
                .setOpenableLayout(drawer).build();

        NavController navController = Navigation.findNavController(this, R.id.contenedorFragments);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        BottomNavigationView bottom_nav_view = findViewById(R.id.bottom_navigation);
        NavigationUI.setupWithNavController(bottom_nav_view, navController);
    }

    //Creacion de menu derecha superior
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_main, menu);
        menuIconColor(menu, R.color.cafe);
        return true;
    }

    //Color Icono menu derecha superior
    public void menuIconColor(Menu menu, int color){
        for(int i=0; i<menu.size(); i++){
            Drawable drawable = menu.getItem(i).getIcon();
            if(drawable != null){
                drawable.mutate();
                drawable.setColorFilter(getResources().getColor(color), PorterDuff.Mode.SRC_ATOP);
            }
        }
    }

    //Eventos menu derecha superior
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.promoFragment) {
            Toast.makeText(this, "Próximamente", Toast.LENGTH_LONG).show();
            return true;
        }     return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.contenedorFragments);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}