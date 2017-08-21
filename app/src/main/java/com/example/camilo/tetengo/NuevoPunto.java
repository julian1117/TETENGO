package com.example.camilo.tetengo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class NuevoPunto extends AppCompatActivity {

    EditText nombreUbicacion;
    EditText descripcionU;
    Spinner colores;
    String latitud;
    String longitud;

    SharedPreferences persistencia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_punto);

        nombreUbicacion = (EditText)  findViewById(R.id.etNombreC);
        descripcionU = (EditText) findViewById(R.id.etDescripcionC);
        cargarCombo();

        persistencia = getSharedPreferences("ubicaciones", Context.MODE_PRIVATE);

        Bundle datoLati = getIntent().getExtras();
        latitud = datoLati.getString("latitud");
        Bundle datoLongi = getIntent().getExtras();
        longitud= datoLongi.getString("longitud");

    }

    public void cargarCombo(){
        colores = (Spinner) findViewById(R.id.spColor);
        String [] listaColores ={"Azul","Violeta","Amarrillo","Naranja","Rosado"};
        ArrayAdapter<String> spinnerColor = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listaColores);
        colores.setAdapter(spinnerColor);
    }


    public  void registrarUbicacion (View v){
        String nombreUb = "";
        nombreUb = persistencia.getString("nombreU", " ")+", "+ nombreUbicacion.getText().toString();
        String descripcionUb ="";
        descripcionUb = persistencia.getString("descU", " ")+", "+ descripcionU.getText().toString();

    }

}
