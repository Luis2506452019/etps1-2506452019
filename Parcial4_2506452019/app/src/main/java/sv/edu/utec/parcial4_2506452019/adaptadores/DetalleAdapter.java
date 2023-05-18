package sv.edu.utec.parcial4_2506452019.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import sv.edu.utec.parcial4_2506452019.R;
import sv.edu.utec.parcial4_2506452019.entidades.DetalleEntidad;

public class DetalleAdapter  extends RecyclerView.Adapter<DetalleAdapter.DetalleViewHolder> {

    ArrayList<DetalleEntidad> detalleEntidad;

    public DetalleAdapter(ArrayList<DetalleEntidad> detalleEntidad){
        this.detalleEntidad = detalleEntidad;
    }

    @NonNull
    @Override
    public DetalleAdapter.DetalleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.elemento_personalizado, null, false);

        return new DetalleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetalleAdapter.DetalleViewHolder holder, int position) {
        holder.txtIdC.setText(detalleEntidad.get(position).getId_cliente());
        holder.txtIdV.setText(detalleEntidad.get(position).getId_vehiculo());
        holder.txtMat.setText(detalleEntidad.get(position).getsMatricula());
        holder.txtKil.setText(detalleEntidad.get(position).getiKilometros());
    }

    @Override
    public int getItemCount() {
        return detalleEntidad.size();
    }

    public class DetalleViewHolder extends RecyclerView.ViewHolder{
        TextView txtIdC, txtIdV, txtMat, txtKil;

        public DetalleViewHolder(@NonNull View itemView) {
            super(itemView);
            txtIdC = itemView.findViewById(R.id.txtIDCliente);
            txtIdV = itemView.findViewById(R.id.txtIDVehiculo);
            txtMat = itemView.findViewById(R.id.txtMatricula);
            txtKil = itemView.findViewById(R.id.txtKilometro);
        }
    }
}
