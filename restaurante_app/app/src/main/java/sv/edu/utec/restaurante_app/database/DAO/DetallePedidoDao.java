package sv.edu.utec.restaurante_app.database.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import sv.edu.utec.restaurante_app.database.Entity.DetallePedido;
import sv.edu.utec.restaurante_app.database.Entity.Producto;

@Dao
public interface DetallePedidoDao {
    //Aquí estarán todas las consultas de la tabla DetallePedido hacia la BD

    @Query("SELECT * FROM detallepedido")
    List<DetallePedido> obtenerDetalle();

    @Query("SELECT * FROM detallepedido WHERE id = :id")
    DetallePedido obtenerDetalle(int id);

    //Recibira uno o muchos productos
    @Insert
    void insertarDetalle(DetallePedido... detallepedidos);

    @Update
    void actualizarDetalle(DetallePedido... detallepedidos);

    @Delete
    void eliminarDetalle(DetallePedido... detallepedidos);

    @Query("DELETE FROM DetallePedido")
    void eliminarAllDetalle();
}
