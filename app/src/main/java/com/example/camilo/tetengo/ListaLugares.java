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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_lugares);

        persistencia = getSharedPreferences("ubicaciones", Context.MODE_PRIVATE);
        listaLugares = (ListView) findViewById(R.id.listaLugares);

        datosLugares = new ArrayList<String>();

        String lugar1= persistencia.getString("nombreU"," ");
        String desc = persistencia.getString("descU"," ");

        String[] partsLugar = lugar1.split(", ");
        String[] partsDesc = desc.split(", ");

        for (int i =0; i<partsLugar.length;i++) {
            datosLugares.add(partsLugar[i] + " - " + partsDesc[i]);
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
        startActivity(intent);
    }




}
