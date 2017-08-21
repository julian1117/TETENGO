package com.example.camilo.tetengo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    TextView nombre;
    TextView apellido;
    TextView usuario;
    TextView contrasena;

    SharedPreferences persistencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombre = (TextView) findViewById(R.id.tvNombre);
        apellido = (TextView) findViewById(R.id.tvApellido);
        usuario = (TextView) findViewById(R.id.tvNombreUs);
        contrasena = (TextView) findViewById(R.id.tvContrasena);

        persistencia = getSharedPreferences("usuarios", Context.MODE_PRIVATE);

       // String lis = persistencia.getString("nombre", " ");
       // Toast.makeText(this, lis, Toast.LENGTH_SHORT).show();


    }


    public void registrar(View v) {


        String nom = "";
        nom = persistencia.getString("nombre", " ") + ", " + nombre.getText().toString();

        String ape = "";
        ape = persistencia.getString("apellido", " ") + ", " + apellido.getText().toString();

        String us = "";
        us = persistencia.getString("usuario", " ") + ", " + usuario.getText().toString();

        String contra = "";
        contra = persistencia.getString("contraseña", " ") + ", " + contrasena.getText().toString();

        persistencia = getSharedPreferences("usuarios", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = persistencia.edit();
        editor.putString("nombre", nom);
        editor.putString("apellido", ape);
        editor.putString("usuario", us);
        editor.putString("contraseña", contra);

        editor.commit();

        Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show();

    }


}
