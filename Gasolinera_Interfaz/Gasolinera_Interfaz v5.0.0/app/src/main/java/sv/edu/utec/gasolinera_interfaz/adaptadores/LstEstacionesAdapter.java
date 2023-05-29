package sv.edu.utec.gasolinera_interfaz.adaptadores;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import sv.edu.utec.gasolinera_interfaz.R;
import sv.edu.utec.gasolinera_interfaz.entidades.EntEstaciones;

public class LstEstacionesAdapter extends RecyclerView.Adapter<LstEstacionesAdapter.EstacionesViewHolder> {
    ArrayList<EntEstaciones> listaestacion;

    public LstEstacionesAdapter(ArrayList<EntEstaciones> entEstaciones){
        this.listaestacion=entEstaciones;
    }

    @NonNull
    @Override
    public LstEstacionesAdapter.EstacionesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_listview_opcion_personalizado, null, false);
        return new EstacionesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LstEstacionesAdapter.EstacionesViewHolder holder, int position) {
        EntEstaciones entEstaciones = listaestacion.get(position);

        //Obteniendo Datos
        String nomGaso = entEstaciones.getNomb_gasolinera();
        String nomSucu = entEstaciones.getNomb_sucursal();
        String ubiSucu = entEstaciones.getUbi_sucursal();
        String tipDies = entEstaciones.getTipo_diesel();
        String tipRegu = entEstaciones.getTipo_regular();
        String tipEspe = entEstaciones.getTipo_especial();

        // Utilizamos la función equals() para comparar strings y dependiendo la condicion mostrar la imagen correspondiente de la gasolinera
        if (nomGaso.equals("PUMA")){
            holder.imgEstacion.setImageResource(R.drawable.estacion_puma);
        } else if (nomGaso.equals("UNO")){
            holder.imgEstacion.setImageResource(R.drawable.estacion_uno);
        } else if (nomGaso.equals("TEXACO")){
            holder.imgEstacion.setImageResource(R.drawable.estacion_texaco);
        }

        holder.txtTituloEstacion.setText("Gasolinera: ");
        holder.txtNombreEstacion.setText(nomGaso +", "+ nomSucu);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle datosAEnviar = new Bundle();
                datosAEnviar.putString("imgGasolinera", nomGaso);
                datosAEnviar.putString("nombreGasolineraSucursal", "Gasolinera: "+ nomGaso +", "+ nomSucu);
                datosAEnviar.putString("ubicacionGasolinera", ubiSucu);
                datosAEnviar.putString("precioDiesel", tipDies);
                datosAEnviar.putString("precioRegular", tipRegu);
                datosAEnviar.putString("precioEspecial", tipEspe);

                Navigation.findNavController(view).navigate(R.id.estacionDetalleFragment, datosAEnviar);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaestacion.size();
    }

    public class EstacionesViewHolder extends RecyclerView.ViewHolder {
        ImageView imgEstacion;
        TextView txtTituloEstacion, txtNombreEstacion;
        public EstacionesViewHolder(@NonNull View itemView) {
            super(itemView);
            imgEstacion=itemView.findViewById(R.id.imagenEstacionOpcion);
            txtTituloEstacion=itemView.findViewById(R.id.txtTituloGasolineraOpcion);
            txtNombreEstacion=itemView.findViewById(R.id.txtNombreGasolineraOpcion);
        }
    }
}
