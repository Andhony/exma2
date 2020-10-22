package com.uso.exma2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class InicioJuego extends AppCompatActivity {
    public static final String ARCHIVO = "Configuracion";
    public static final String KEY_NICKNAME = "NickName";
    public static final String KEY_DIFICULTAD = "Dificultad";

    public SharedPreferences configuraciones;

    private TextView lblNickname;
    private TextView lblNivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_juego);

        this.lblNickname = findViewById(R.id.lblNickname);
        this.lblNivel = findViewById(R.id.lblNivel);

        this.configuraciones = getSharedPreferences(ARCHIVO,MODE_PRIVATE);

        //Validamos que exista una instancia de la configuración
        if(configuraciones != null){
            this.lblNickname.setText(configuraciones.getString(KEY_NICKNAME, ""));
            this.lblNivel.setText(configuraciones.getString(KEY_DIFICULTAD, ""));
        }else {
            Toast.makeText(this, "Es nulo", Toast.LENGTH_SHORT).show();
        }
    }

    private void Valida(){

    }
}