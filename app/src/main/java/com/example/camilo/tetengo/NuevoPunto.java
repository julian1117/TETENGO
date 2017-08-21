package com.example.camilo.tetengo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class NuevoPunto extends AppCompatActivity {

    EditText nombreUbicacion;
    EditText descripcionU;
    EditText latitudCampo;
    EditText longitudCampo;
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
        latitudCampo = (EditText) findViewById(R.id.etLatitud);
        longitudCampo =(EditText) findViewById(R.id.etLongitud);


        Bundle datoLati = getIntent().getExtras();
        latitud = String.valueOf(datoLati.getDouble("latitud"));
        latitudCampo.setText(latitud);

        Bundle datoLongi = getIntent().getExtras();
        longitud= String.valueOf(datoLongi.getDouble("longitud"));
        longitudCampo.setText(longitud);

        persistencia = getSharedPreferences("ubicaciones", Context.MODE_PRIVATE);

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

        String la ="";
        la = persistencia.getString("lati", " ")+", "+ latitudCampo.getText();

        String lon = "";
        lon = persistencia.getString("long"," ")+", "+ longitudCampo.getText();

        persistencia = getSharedPreferences("ubicaciones", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = persistencia.edit();
        editor.putString("nombreU", nombreUb);
        editor.putString("descU", descripcionUb);
        editor.putString("lati", la);
        editor.putString("long", lon);

        editor.commit();

        Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show();
    }

}
