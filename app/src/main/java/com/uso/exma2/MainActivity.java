package com.uso.exma2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void configuraciones_onClick(View v){
        Intent frmConfiguracion = new Intent(this, Configuraciones.class);
        startActivity(frmConfiguracion);
    }

    public void iniciarJuego_onClick(View v){
        Intent frmIniciar = new Intent(this, InicioJuego.class);
        startActivity(frmIniciar);
    }
}