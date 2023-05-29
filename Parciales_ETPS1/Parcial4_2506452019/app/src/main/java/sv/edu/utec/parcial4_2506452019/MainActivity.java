package sv.edu.utec.parcial4_2506452019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import sv.edu.utec.parcial4_2506452019.adaptadores.DetalleAdapter;
import sv.edu.utec.parcial4_2506452019.entidades.DetalleEntidad;
import sv.edu.utec.parcial4_2506452019.helper.BaseHelper;
import sv.edu.utec.parcial4_2506452019.helper.MD_Cliente;
import sv.edu.utec.parcial4_2506452019.helper.MD_Detalle;
import sv.edu.utec.parcial4_2506452019.helper.MD_Vehiculo;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<DetalleEntidad> AlistDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.listado);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MD_Detalle dbDetalle = new MD_Detalle(this);
        MD_Cliente dbCliente = new MD_Cliente(this);
        MD_Vehiculo dbVehiculo = new MD_Vehiculo(this);

        long codiSave=dbCliente.insertCliente("Lucas", "Martinez", "San Salvador", "San Salvador");
        long codiSave2=dbVehiculo.insertVehiculo("Toyota", "2023");
        long codiSave3=dbDetalle.insertDetalle("2036265", "10 K/m");
        if(codiSave>0 || codiSave2>0 || codiSave3>0){
            Toast toast = Toast.makeText(this, "Registro insertado", Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            Toast toast = Toast.makeText(this, "Error en insertar", Toast.LENGTH_SHORT);
            toast.show();
        }

        AlistDetalle=new ArrayList<>();
        DetalleAdapter adapter=new DetalleAdapter(dbDetalle.mostrarDetalle());
        recyclerView.setAdapter(adapter);
    }
}