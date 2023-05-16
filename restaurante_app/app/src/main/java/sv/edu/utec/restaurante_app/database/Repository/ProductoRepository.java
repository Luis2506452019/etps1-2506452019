package sv.edu.utec.restaurante_app.database.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import sv.edu.utec.restaurante_app.database.AppDatabase;
import sv.edu.utec.restaurante_app.database.DAO.ProductoDao;
import sv.edu.utec.restaurante_app.database.Entity.Producto;

public class ProductoRepository {
    private ProductoDao productoDao;
    private LiveData<List<Producto>> allProductos;

    public ProductoRepository(Application application){
        AppDatabase database = AppDatabase.getInstance(application);
        productoDao = database.productoDao();
        allProductos = productoDao.obtenerProducto();
    }

    public void insert (Producto producto){
        new InsertProductoAsyncTask(productoDao).execute(producto);
    }

    public void update (Producto producto){
        new UpdateProductoAsyncTask(productoDao).execute(producto);
    }

    public void delete (Producto producto){
        new DeleteProductoAsyncTask(productoDao).execute(producto);
    }

    public void deleteAllProductos (){
        new DeleteAllProductosAsyncTask(productoDao).execute();
    }

    public LiveData<List<Producto>> getAllProductos(){
        return allProductos;
    }
    public static class UpdateProductoAsyncTask extends AsyncTask<Producto, Void, Void>{
        private ProductoDao productoDao;
        private UpdateProductoAsyncTask(ProductoDao productoDao){
            this.productoDao = productoDao;
        }
        @Override
        protected Void doInBackground(Producto... productos) {
            productoDao.actualizarProducto(productos[0]);
            return null;
        }
    }
    public static class DeleteProductoAsyncTask extends AsyncTask<Producto, Void, Void>{
        private ProductoDao productoDao;
        private DeleteProductoAsyncTask(ProductoDao productoDao){
            this.productoDao = productoDao;
        }
        @Override
        protected Void doInBackground(Producto... productos) {
            productoDao.eliminarProducto(productos[0]);
            return null;
        }
    }
    public static class DeleteAllProductosAsyncTask extends AsyncTask<Void, Void, Void>{
        private ProductoDao productoDao;
        private DeleteAllProductosAsyncTask(ProductoDao productoDao){
            this.productoDao = productoDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            productoDao.eliminarAllProductos();
            return null;
        }
    }
    public static class InsertProductoAsyncTask extends AsyncTask<Producto, Void, Void>{
        private ProductoDao productoDao;
        private InsertProductoAsyncTask(ProductoDao productoDao){
            this.productoDao = productoDao;
        }
        @Override
        protected Void doInBackground(Producto... productos) {
            productoDao.insertarProducto(productos[0]);
            return null;
        }
    }
}
