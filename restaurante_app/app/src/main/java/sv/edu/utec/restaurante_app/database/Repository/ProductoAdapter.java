package sv.edu.utec.restaurante_app.database.Repository;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import sv.edu.utec.restaurante_app.R;
import sv.edu.utec.restaurante_app.database.Entity.Producto;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoHolder> {
    private List<Producto> productos = new ArrayList<>();
    @NonNull
    @Override
    // Infla el diseño del elemento y crea el titular
    public ProductoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.elemento_listview_personalizado, parent, false);

        return new ProductoHolder(view);
    }

    //Establecer los atributos de vista en función de los datos
    @Override
    public void onBindViewHolder(@NonNull ProductoHolder holder, int position) {
        Producto currentProducto = productos.get(position);

        holder.imageView.setImageResource(currentProducto.getImagen());
        holder.tvNombre.setText(currentProducto.getTituloComida());
        holder.tvPrecio.setText("$"+(Double) currentProducto.getPrecio());

        holder.btnDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle datosAEnviar = new Bundle();
                datosAEnviar.putInt("imgComida", currentProducto.getImagen());
                datosAEnviar.putString("nombreComida", currentProducto.getTituloComida());
                datosAEnviar.putDouble("precioComida", currentProducto.getPrecio());

                Navigation.findNavController(view).navigate(R.id.detalleFragment, datosAEnviar);
            }
        });
    }
    @Override
    //Determinar la cantidad de elementos
    public int getItemCount() {
        return productos.size();
    }

    public void setProductos(List<Producto> productos){
        this.productos = productos;
        notifyDataSetChanged();
    }
    public class ProductoHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView tvNombre, tvPrecio;
        private Button btnDetalle;

        public ProductoHolder(View view){
            super(view);
            imageView = view.findViewById(R.id.imagenComida);
            tvNombre = view.findViewById(R.id.txtNombreComida);
            tvPrecio = view.findViewById(R.id.txtPrecioComida);
            btnDetalle = view.findViewById(R.id.btnPedirComida);
        }
    }
}
