package sv.edu.utec.restaurante_app.database.Entity;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DetallePedido {

    @PrimaryKey (autoGenerate = true)
    public int id;

    public String nombreProducto;
    public Double precio;
    public int cantidad;

    public DetallePedido(String nombreProducto, Double precio, int cantidad) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public Double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }
}
