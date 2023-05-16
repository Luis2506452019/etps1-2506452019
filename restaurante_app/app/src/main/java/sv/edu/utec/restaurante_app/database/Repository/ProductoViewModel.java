package sv.edu.utec.restaurante_app.database.Repository;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import sv.edu.utec.restaurante_app.database.Entity.Producto;

public class ProductoViewModel extends AndroidViewModel {
    private ProductoRepository repository;
    private LiveData<List<Producto>> allProductos;

    public ProductoViewModel(@NonNull Application application) {
        super(application);
        repository = new ProductoRepository(application);
        allProductos = repository.getAllProductos();
    }

    public void insert (Producto producto){
        repository.insert(producto);
    }

    public void update (Producto producto){
        repository.update(producto);
    }

    public void delete (Producto producto){
        repository.delete(producto);
    }

    public void deleteAllProductos (){
        repository.deleteAllProductos();
    }

    public LiveData<List<Producto>> getAllProductos() {
        return allProductos;
    }
}
