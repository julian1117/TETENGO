package com.example.camilo.tetengo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvusuario;

    TextView tcontrasena;

    public static String nombreUsuario;

    SharedPreferences persistencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvusuario = (TextView) findViewById(R.id.tvNombreUsuario);
        tcontrasena = (TextView) findViewById(R.id.tvContrasenaInicio);


    }

    public void iniciar(View v) {

        persistencia = getSharedPreferences("usuarios", Context.MODE_PRIVATE);

        String usuario = persistencia.getString("usuario", " ");
        String cont = persistencia.getString("contraseña", " ");

        String[] partsUs = usuario.split(", ");
        String[] partsCont = cont.split(", ");

        int ban=0;

        for (int i = 0; i < partsUs.length; i++) {
            if (partsUs[i].equals(tvusuario.getText().toString()) &&
                    partsCont[i].equals(tcontrasena.getText().toString())) {
                nombreUsuario=partsUs[i];
                Intent intent = new Intent(this, MapsActivity.class);
                startActivity(intent);
            }else {
                ban++;
            }
        }

        if(ban == partsUs.length){
            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
        }

    }

    public void registro(View v) {
        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);
    }
}
