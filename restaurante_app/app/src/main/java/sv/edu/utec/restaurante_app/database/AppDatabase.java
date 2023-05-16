package sv.edu.utec.restaurante_app.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import sv.edu.utec.restaurante_app.R;
import sv.edu.utec.restaurante_app.database.DAO.DetallePedidoDao;
import sv.edu.utec.restaurante_app.database.DAO.ProductoDao;
import sv.edu.utec.restaurante_app.database.Entity.DetallePedido;
import sv.edu.utec.restaurante_app.database.Entity.Producto;

@Database(
        //Definimos Entidades
        entities = {Producto.class, DetallePedido.class}, version = 2
)
public abstract class AppDatabase extends RoomDatabase {
    public static AppDatabase INSTANCE;

    //Usamos un método abstracto para llamar a nuestro DAO
    public abstract ProductoDao productoDao();
    public abstract DetallePedidoDao detallePedidoDao();

    public static synchronized AppDatabase getInstance(Context context){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "dbRestaurante")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{
        private ProductoDao productoDao;
        private PopulateDbAsyncTask(AppDatabase db){
            productoDao = db.productoDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            productoDao.insertarProducto(new Producto(R.drawable.pizza_the_works,"THE WORKS", 17.99));
            productoDao.insertarProducto(new Producto(R.drawable.pizza_papas_favorite,"PAPA'S FAVORITE", 17.99));
            productoDao.insertarProducto(new Producto(R.drawable.pizza_carnivora,"CARNÍVORA", 17.99));
            productoDao.insertarProducto(new Producto(R.drawable.pizza_tuscan_6cheese,"TUSCAN SIX CHEESE", 17.99));
            productoDao.insertarProducto(new Producto(R.drawable.pizza_hawaiana_clasica,"HAWAIANA CLÁSICA", 11.99));
            productoDao.insertarProducto(new Producto(R.drawable.pizza_hawaiana_pepperoni,"HAWAIANA PEPPERONI", 11.99));
            productoDao.insertarProducto(new Producto(R.drawable.pizza_hawaiana_spice,"HAWAIANA SPICE", 11.99));
            productoDao.insertarProducto(new Producto(R.drawable.pizza_hawaiana_volcano,"HAWAIANA VOLCANO", 11.99));
            productoDao.insertarProducto(new Producto(R.drawable.pizza_vegan_royal,"VEGAN ROYAL", 18.99));
            productoDao.insertarProducto(new Producto(R.drawable.pizza_vegan_queen,"VEGAN QUEEN", 18.99));

            return null;
        }
    }
}
