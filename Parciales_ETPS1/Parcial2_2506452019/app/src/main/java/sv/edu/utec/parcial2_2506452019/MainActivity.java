package sv.edu.utec.parcial2_2506452019;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<List_entrada> datos = new ArrayList<List_entrada>();

        datos.add(new List_entrada(R.drawable.lead_photo_1, "Alexander Pierrot","CEO", "Insures S.O."));
        datos.add(new List_entrada(R.drawable.lead_photo_2, "Carlos Lopez", "Asistente","Hospital Blue"));
        datos.add(new List_entrada(R.drawable.lead_photo_3, "Sara Bonz", "Directora de Marketing","Electrical Parts Itd"));
        datos.add(new List_entrada(R.drawable.lead_photo_4, "Liliana Clarence", "Diseñadora de Producto","Creativa App"));
        datos.add(new List_entrada(R.drawable.lead_photo_5, "Benito Peralta", "Supervisor de Ventas","Neumáticos Press"));
        datos.add(new List_entrada(R.drawable.lead_photo_6, "Juan Jaramillo", "CEO","Banco Nacional"));
        datos.add(new List_entrada(R.drawable.lead_photo_7, "Christian Steps", "CTO","Cooperativa Verde"));
        datos.add(new List_entrada(R.drawable.lead_photo_8, "Alexa Giraldo", "Lead Programmer","Frutisofy"));
        datos.add(new List_entrada(R.drawable.lead_photo_9, "Linda Murillo", "Directora de Marketing","Seguros Boliver"));
        datos.add(new List_entrada(R.drawable.lead_photo_10, "Lizeth Astrada", "CEO","Concesionario Motolox"));

        lista = (ListView) findViewById(R.id.ListView_listado);
        lista.setAdapter(new List_adaptador(this, R.layout.datos, datos){
            @Override
            public void onEntrada(Object entrada, View view) {
                if (entrada != null) {
                    TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior);
                    if (texto_superior_entrada != null)
                        texto_superior_entrada.setText(((List_entrada) entrada).get_textoEncima());

                    TextView texto_intermedio_entrada = (TextView) view.findViewById(R.id.textView_intermedio);
                    if (texto_intermedio_entrada != null)
                        texto_intermedio_entrada.setText(((List_entrada) entrada).get_textoIntermedio());

                    TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior);
                    if (texto_inferior_entrada != null)
                        texto_inferior_entrada.setText(((List_entrada) entrada).get_textoDebajo());

                    ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen);
                    if (imagen_entrada != null)
                        imagen_entrada.setImageResource(((List_entrada) entrada).get_idImagen());
                }
            }
        });
        lista.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                List_entrada elegido = (List_entrada) pariente.getItemAtPosition(posicion);

                CharSequence texto = "Seleccionado: " + elegido.get_textoEncima();
                Toast toast = Toast.makeText(MainActivity.this, texto, Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

}