package sv.edu.utec.gasolinera_interfaz.adaptadores;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import sv.edu.utec.gasolinera_interfaz.R;
import sv.edu.utec.gasolinera_interfaz.database.BaseHelper;
import sv.edu.utec.gasolinera_interfaz.datos.Estaciones;
import sv.edu.utec.gasolinera_interfaz.entidades.EntEstaciones;

public class LstEstacionesAdapter extends RecyclerView.Adapter<LstEstacionesAdapter.EstacionesViewHolder> {
    ArrayList<EntEstaciones> listaestacion;

    public LstEstacionesAdapter(ArrayList<EntEstaciones> entEstaciones){
        this.listaestacion=entEstaciones;
    }

    // DEVOLVEMOS LA VISTA DEL VIEW HOLDER
    @NonNull
    @Override
    public LstEstacionesAdapter.EstacionesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_recyclerview_personalizado, null, false);
        return new EstacionesViewHolder(view);
    }

    // ASIGNAMOS SEGUN POSICION PARA MOSTRAR
    @Override
    public void onBindViewHolder(@NonNull LstEstacionesAdapter.EstacionesViewHolder holder, int position) {
        EntEstaciones entEstaciones = listaestacion.get(position);

        // VALOR A COMPROBAR
        switch (entEstaciones.getNomb_gasolinera()){
            // VALOR A COMPARAR
            case "PUMA":
                // SI SE CUMPLE MOSTRAR IMG GASO.PUMA
                holder.imgEstacion.setImageResource(R.drawable.estacion_puma);
                break;
            // VALOR A COMPARAR
            case "UNO":
                // SI SE CUMPLE MOSTRAR IMG GASO.UNO
                holder.imgEstacion.setImageResource(R.drawable.estacion_uno);
                break;
            // VALOR A COMPARAR
            case "TEXACO":
                // SI SE CUMPLE MOSTRAR IMG GASO.TEXACO
                holder.imgEstacion.setImageResource(R.drawable.estacion_texaco);
                break;
        }

        holder.txtTituloEstacion.setText("Gasolinera: ");
        holder.txtNombreEstacion.setText(entEstaciones.getNomb_gasolinera() +", "+ entEstaciones.getNomb_sucursal());

        // EVENTOS ONCLICK
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle datosAEnviar = new Bundle();
                datosAEnviar.putString("imgGasolinera", entEstaciones.getNomb_gasolinera());
                datosAEnviar.putString("nombreGasolineraSucursal", "Gasolinera: "+ entEstaciones.getNomb_gasolinera() +", "+ entEstaciones.getNomb_sucursal());
                datosAEnviar.putString("ubicacionGasolinera", entEstaciones.getUbi_sucursal());
                datosAEnviar.putString("precioDiesel", entEstaciones.getTipo_diesel());
                datosAEnviar.putString("precioRegular", entEstaciones.getTipo_regular());
                datosAEnviar.putString("precioEspecial", entEstaciones.getTipo_especial());

                // ABRIR FRAGMENT -> "ESTACION DETALLE" -> PASAR POR PARAMETRO -> "BUNDLE"
                Navigation.findNavController(view).navigate(R.id.estacionDetalleFragment, datosAEnviar);
            }
        });

        // EVENTO ONCLICK PARA ELIMINAR REGISTRO DESDE RECYCLER VIEW
        holder.iconST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // UBICAMOS LA POSICION DEL ELEMENTO EN EL DISEÑO
                int modPos = holder.getAdapterPosition();
                // CREAMOS OBJETO PARA REALIZAR CONSULTA
                Estaciones baseEst = new Estaciones(view.getContext());
                long codidelete = baseEst.deleteEstacion(entEstaciones.getNomb_sucursal());
                // CONDICIONALES SI SE CUMPLE O NO LA ACCION
                if(codidelete>0){
                    // NOTIFICAMOS AL RECYCLERVIEW PARA QUE ACTUALICE LA VISTA
                    notifyItemRemoved (modPos);
                    Toast.makeText(view.getContext().getApplicationContext(),"Registro eliminado",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(view.getContext().getApplicationContext(),"Error al eliminar",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    // OBTENER TAMAÑO DEL CONJUNTO DE DATOS
    @Override
    public int getItemCount() {
        return listaestacion.size();
    }

    public class EstacionesViewHolder extends RecyclerView.ViewHolder {
        ImageView imgEstacion, iconST;
        TextView txtTituloEstacion, txtNombreEstacion;
        public EstacionesViewHolder(@NonNull View itemView) {
            super(itemView);

            // ASIGNANDO IDENTIFICADORES
            imgEstacion=itemView.findViewById(R.id.imagenEstacionOpcion);
            iconST=itemView.findViewById(R.id.iconDelete);
            txtTituloEstacion=itemView.findViewById(R.id.txtTituloGasolineraOpcion);
            txtNombreEstacion=itemView.findViewById(R.id.txtNombreGasolineraOpcion);
        }
    }
}
