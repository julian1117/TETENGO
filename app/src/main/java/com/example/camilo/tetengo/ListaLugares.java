package com.example.camilo.tetengo;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_lugares);

        listaLugares = (ListView) findViewById(R.id.listaLugares);








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
