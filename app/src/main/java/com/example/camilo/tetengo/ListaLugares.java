package com.example.camilo.tetengo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListaLugares extends AppCompatActivity {

    ListView  listaLugares;

    private ArrayList<String> datosLugares;
    private ArrayAdapter<String> adaptador;

    SharedPreferences persistencia;

    String nombres,descripciones,latitudes,longitudes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_lugares);

        persistencia = getSharedPreferences("ubicaciones", Context.MODE_PRIVATE);
        listaLugares = (ListView) findViewById(R.id.listaLugares);

        datosLugares = new ArrayList<String>();

        String usuario = persistencia.getString("nombreUsuario"," ");
        String lugar1= persistencia.getString("nombreU"," ");
        String desc = persistencia.getString("descU"," ");
        String lat = persistencia.getString("lati"," ");
        String lon = persistencia.getString("long"," ");

        String[] partsUs = usuario.split(", ");
        String[] partsLugar = lugar1.split(", ");
        String[] partsDesc = desc.split(", ");
        String[] partLa = lat.split(", ");
        String[] partsLong = lon.split(", ");

        for (int i =1; i<partsUs.length;i++) {
            if (partsUs[i].equals(MainActivity.nombreUsuario)) {
            //    for (int j =0; j<partsLugar.length;j++) {
                    datosLugares.add(partsLugar[i] + " - " + partsDesc[i]);
                    nombres = partsLugar[i];
                    descripciones = partsDesc[i];
                    latitudes = partLa[i];
                    longitudes = partsLong[i];
              //  }
            }
        }


        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datosLugares);
        listaLugares.setAdapter(adaptador);

        listaLugares.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String a = adaptador.getItem(position);


                ir(view);
            }
        });


    }

    public void ir(View v){
        Intent intent = new Intent(this,DetalleUbicacion.class);
        intent.putExtra("nombreU", nombres);
        intent.putExtra("descU", descripciones);
        intent.putExtra("lati", latitudes);
        intent.putExtra("long", longitudes);
        startActivity(intent);
    }




}
