package sv.edu.utec.restaurante_app.database.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import sv.edu.utec.restaurante_app.database.Entity.Producto;

@Dao
public interface ProductoDao {

    //Aquí estarán todas las consultas de la tabla Producto hacia la BD

    @Query("SELECT * FROM producto")
    LiveData<List<Producto>> obtenerProducto();


    //Recibira uno o muchos productos
    @Insert
    void insertarProducto(Producto... productos);

    @Update
    void actualizarProducto(Producto... productos);

    @Delete
    void eliminarProducto(Producto... productos);

    @Query("DELETE FROM Producto")
    void eliminarAllProductos();

    /*
    @Query("SELECT * FROM producto WHERE id = :id")
    Producto obtenerProducto(int id);

    @Query("UPDATE Producto SET imagen = :imagen, precio = :precio, tituloComida = :tituloComida WHERE id = :id")
    void actualizaProducto(int imagen, String precio, String tituloComida, int id);

    @Query("DELETE FROM Producto WHERE id = :id")
    void borrarProducto(int id);

    @Query("DELETE FROM Producto")
    void borrarProductos();*/

}
