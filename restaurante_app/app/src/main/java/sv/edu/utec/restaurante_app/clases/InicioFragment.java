package sv.edu.utec.restaurante_app.clases;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import sv.edu.utec.restaurante_app.R;
import sv.edu.utec.restaurante_app.database.Entity.Producto;
import sv.edu.utec.restaurante_app.database.Repository.ProductoAdapter;
import sv.edu.utec.restaurante_app.database.Repository.ProductoViewModel;

public class InicioFragment extends Fragment {

    private ProductoViewModel productoViewModel;
    public InicioFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);


        // Obtener un identificador de RecyclerView.
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.listado);
        //Creemos un adaptador para proporcionar los datos que se mostrarán.
        final ProductoAdapter adapter = new ProductoAdapter();
        recyclerView.setHasFixedSize(true);

        // Decoracion RecyclerView (Division)
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        //Conectamos el adaptador con el RecyclerView
        recyclerView.setAdapter(adapter);

        // Damos al RecyclerView un administrador de diseño predeterminado.
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        productoViewModel = new ViewModelProvider(this).get(ProductoViewModel.class);
        productoViewModel.getAllProductos().observe(getActivity(), new Observer<List<Producto>>() {
            @Override
            public void onChanged(List<Producto> productos) {
                adapter.setProductos(productos);
            }
        });


        return view;
    }
}