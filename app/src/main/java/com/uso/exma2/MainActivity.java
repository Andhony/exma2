package com.uso.exma2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnJuego;
    Button btnConfig;
    Button btnPuntaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btnJuego = findViewById(R.id.btnjuego);
        this.btnConfig = findViewById(R.id.btnconfiguracion);
        this.btnPuntaje = findViewById(R.id.btnpuntaje);
    }

    public void configuraciones_onClick(View v){
        Intent frmConfiguracion = new Intent(this, Configuraciones.class);
        startActivity(frmConfiguracion);
    }

    public void iniciarJuego_onClick(View v){
        Intent frmIniciar = new Intent(this, InicioJuego.class);
        startActivity(frmIniciar);
    }

    public void score_onClick(View v){
        Intent frmScore = new Intent (this, ScoreActivity.class);
        startActivity(frmScore);
    }
}