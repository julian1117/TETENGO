package com.example.camilo.tetengo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class DetalleUbicacion extends AppCompatActivity {

    EditText nom, descirocion, latitud,longitud;
    SharedPreferences persistencia;
    String nombre,des,la,lo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_ubicacion);

        nom = (EditText) findViewById(R.id.etNombreLugar);
        descirocion = (EditText) findViewById(R.id.etDescripcionLugar);
        latitud = (EditText) findViewById(R.id.etLatitudLugar);
        longitud = (EditText) findViewById(R.id.etLongitudLugar);

        Bundle datonom = getIntent().getExtras();
        nombre = datonom.getString("nombreU");
        nom.setText(nombre);

        Bundle datodes = getIntent().getExtras();
        des = datodes.getString("descU");
        descirocion.setText(des);

        Bundle datolatitud = getIntent().getExtras();
        la = datolatitud.getString("lati");
        latitud.setText(la);

        Bundle datolongitud = getIntent().getExtras();
        lo = datolongitud.getString("long");
        longitud.setText(lo);


    }


}
