package com.uso.exma2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnJuego;
    Button btnPuntaje;
    Button btnConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnJuego = findViewById(R.id.btnjuego);
        this.btnPuntaje = findViewById(R.id.btnpuntaje);
        this.btnConfig = findViewById(R.id.btnconfiguracion);

        this.btnJuego.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent mIntent = new Intent(MainActivity.this,InicioJuego.class);
                startActivity(mIntent);
            }

        });

        this.btnPuntaje.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent mIntent = new Intent(MainActivity.this,ScoreActivity.class);
                startActivity(mIntent);
            }

        });

        this.btnConfig.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent mIntent = new Intent(MainActivity.this,Configuraciones.class);
                startActivity(mIntent);
            }

        });
    }
}