package sv.edu.utec.parcial4_2506452019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

import sv.edu.utec.parcial4_2506452019.adaptadores.DetalleAdapter;
import sv.edu.utec.parcial4_2506452019.entidades.DetalleEntidad;
import sv.edu.utec.parcial4_2506452019.helper.MD_Detalle;

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
        DetalleAdapter adapter=new DetalleAdapter(dbDetalle.mostrarDetalle());
        recyclerView.setAdapter(adapter);

        dbDetalle.insertDetalle("2036265", "10 K/m");

    }
}