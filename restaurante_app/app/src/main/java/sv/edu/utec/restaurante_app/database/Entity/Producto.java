package sv.edu.utec.restaurante_app.database.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Producto {
    @PrimaryKey (autoGenerate = true)
    public int id;

    public String tituloComida;
    public double precio;
    public int imagen;

    public Producto(int imagen, String tituloComida, double precio) {
        this.imagen = imagen;
        this.tituloComida = tituloComida;
        this.precio = precio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTituloComida() {
        return tituloComida;
    }

    public double getPrecio() {
        return precio;
    }

    public int getImagen() {
        return imagen;
    }
}
