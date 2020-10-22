package com.uso.exma2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    private EditText numero;
    private Button jugar;
    private int aleatorio;
    private int intentos = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_juego);

        //Iniciamos variables
        this.lblNickname = findViewById(R.id.lblNickname);
        this.lblNivel = findViewById(R.id.lblNivel);
        this.numero = findViewById(R.id.txtNumber);
        this.jugar = findViewById(R.id.btnAceptar);

        //Aqui se va a generar el aleatorio
        aleatorio = crearAleatorio();

        //presionar botno jugar
        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    int numuser;

                    numuser = Integer.parseInt(numero.getText().toString());
                    if (numuser < 0 || numuser > 5) {
                        Toast.makeText(InicioJuego.this, "Este no es un numero valido", Toast.LENGTH_SHORT).show();
                    } else if (aleatorio < numuser) {
                        Toast.makeText(InicioJuego.this, "Ingrese un numero mas bajo", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(InicioJuego.this, "Ingrese un numero mas alto", Toast.LENGTH_SHORT).show();
                    }
                        if (aleatorio == numuser) {
                        jugar.setEnabled(false);
                        Toast.makeText(InicioJuego.this, "Has ganado!", Toast.LENGTH_SHORT).show();
                        Toast.makeText(InicioJuego.this, "El numero aleatorio es:" + aleatorio, Toast.LENGTH_SHORT).show();
                    }
                    intentos = intentos - 1;
                    Toast.makeText(InicioJuego.this, "Intentos restantes: " + intentos, Toast.LENGTH_SHORT).show();
                    if (intentos == 0 && aleatorio != numuser){
                        jugar.setEnabled(false);
                        Toast.makeText(InicioJuego.this, "Has perdido: ", Toast.LENGTH_SHORT).show();
                        Toast.makeText(InicioJuego.this, "El numero aleatorio es:" + aleatorio, Toast.LENGTH_SHORT).show();

                }
            }
        });
        this.configuraciones = getSharedPreferences(ARCHIVO, MODE_PRIVATE);

        //Validamos que exista una instancia de la configuración
        if(configuraciones != null){
            this.lblNickname.setText(configuraciones.getString(KEY_NICKNAME, ""));
            this.lblNivel.setText(configuraciones.getString(KEY_DIFICULTAD, ""));
        }else {
            Toast.makeText(this, "Es nulo", Toast.LENGTH_SHORT).show();
        }
    }

    private int crearAleatorio() {
        int var = 0;
        switch(this.lblNivel.getText().toString()){
            case "Fácil":
                var= (int)(Math.random()*5+1);
                break;
            case "Medio":
                var= (int)(Math.random()*10+6);
                break;
            case "Difícil":
                var= (int)(Math.random()*15+1);
                break;
            default :
                var =0;
                break;

        }
        return var;
    }


}