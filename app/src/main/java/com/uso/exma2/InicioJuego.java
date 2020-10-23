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
    //Variables a utilizar para el SharedPreferences
    public static final String ARCHIVO1 = "Historial";
    public static final String KEY_NICKNAME1 = "NickName1";
    public static final String KEY_SCORE1 = "Score1";
    public static final String KEY_NICKNAME2 = "NickName2";
    public static final String KEY_SCORE2 = "Score2";
    public static final String KEY_NICKNAME3 = "NickName3";
    public static final String KEY_SCORE3 = "Score3";

    public SharedPreferences historial;

    public SharedPreferences configuraciones;

    private TextView lblNickname;
    private TextView lblNivel;
    private EditText numero;
    private Button jugar;
    private TextView mensaje1, mensaje2, mensaje3;
    private int aleatorio;
    private int intentos = 1;
    private int intentosRestantes = 0;
    private String dificultad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_juego);


        //Iniciamos variables
        this.lblNickname = findViewById(R.id.lblNickname);
        this.lblNivel = findViewById(R.id.lblNivel);
        this.numero = findViewById(R.id.txtNumber);
        this.jugar = findViewById(R.id.btnAceptar);
        this.mensaje1 = findViewById(R.id.lblMessage1);
        this.mensaje2 = findViewById(R.id.lblMessage2);
        this.mensaje3 = findViewById(R.id.lblMessage3);
        this.configuraciones = getSharedPreferences(ARCHIVO, MODE_PRIVATE);
        this.historial = getSharedPreferences(ARCHIVO1, MODE_PRIVATE);

        //Validamos que exista una instancia de la configuración
        if (configuraciones != null) {
            this.lblNickname.setText(configuraciones.getString(KEY_NICKNAME, ""));
            this.lblNivel.setText(configuraciones.getString(KEY_DIFICULTAD, ""));
        } else {
            Toast.makeText(this, "Es nulo", Toast.LENGTH_SHORT).show();
        }

        this.dificultad = lblNivel.getText().toString();


        //Aqui se va a generar el aleatorio
        aleatorio = crearAleatorio();

        //presionar botón jugar
        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int numuser;

                numuser = Integer.parseInt(numero.getText().toString());

                if (dificultad.equals("Fácil")) {
                    intentosRestantes = 0;
                    if (numuser == aleatorio) {
                        mensaje1.setText("Felicitaciones Has Ganado!");
                        mensaje2.setText("Intentos restantes: " + intentos);
                        mensaje3.setText("El numero ganador es: " + aleatorio);
                        if (historial != null) {
                            //Validamos que exista una configuración previa

                            //Obtenemos el editor
                            SharedPreferences.Editor editor = historial.edit();

                            editor.putString(KEY_NICKNAME1, lblNickname.getText().toString());
                            editor.putString(KEY_SCORE1, Integer.toString(intentos));
                            editor.commit();
                            //finish();
                        }
                    } else if (numuser < 1 || numuser > 50) {
                        Toast.makeText(InicioJuego.this, "Ingrese un número válido", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(InicioJuego.this, "Sigue intentandolo", Toast.LENGTH_SHORT).show();
                    }
                    intentosRestantes--;
                    intentos = intentos + 1;

                } else if (dificultad.equals("Medio")) {
                    intentosRestantes = 0;
                    if (numuser == aleatorio) {
                        mensaje1.setText("Felicitaciones Has Ganado!");
                        mensaje2.setText("Intentos restantes: " + intentos);
                        mensaje3.setText("El numero ganador es: " + aleatorio);
                        if (historial != null) {
                            //Validamos que exista una configuración previa

                            //Obtenemos el editor
                            SharedPreferences.Editor editor = historial.edit();

                            editor.putString(KEY_NICKNAME2, lblNickname.getText().toString());
                            editor.putString(KEY_SCORE2, Integer.toString(intentos));
                            editor.commit();
                            //finish();
                        } else if (numuser < 1 || numuser > 100) {
                            Toast.makeText(InicioJuego.this, "Ingrese un número válido", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(InicioJuego.this, "Sigue intentandolo", Toast.LENGTH_SHORT).show();
                        }
                        intentosRestantes--;
                        intentos = intentos + 1;

                    } else if (dificultad.equals("Difícil")) {
                        intentosRestantes = 0;
                        if (numuser == aleatorio) {
                            mensaje1.setText("Felicitaciones Has Ganado!");
                            mensaje2.setText("Intentos restantes: " + intentos);
                            mensaje3.setText("El numero ganador es: " + aleatorio);
                            if (historial != null) {
                                //Validamos que exista una configuración previa

                                //Obtenemos el editor
                                SharedPreferences.Editor editor = historial.edit();

                                editor.putString(KEY_NICKNAME3, lblNickname.getText().toString());
                                editor.putString(KEY_SCORE3, Integer.toString(intentos));
                                editor.commit();
                                //finish();
                            } else if (numuser < 1 || numuser > 150) {
                                Toast.makeText(InicioJuego.this, "Ingrese un número válido", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(InicioJuego.this, "Sigue intentandolo", Toast.LENGTH_SHORT).show();
                            }
                            intentosRestantes--;
                            intentos = intentos + 1;

                        }





           /* if (numuser < 0 || numuser > 5 &&  == "Fácil") {
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

                }*/
                    }
                }
                ;
            }

            private int crearAleatorio() {
                int var = 0;
                switch (dificultad) {
                    case "Fácil":
                        var = (int) (Math.random() * 50) + 1;
                        break;
                    case "Medio":
                        var = (int) (Math.random() * 100) + 1;
                        break;
                    case "Difícil":
                        var = (int) (Math.random() * 150) + 1;
                        break;
                    default:
                        break;
                }
                Toast.makeText(InicioJuego.this, "El num es: " + var, Toast.LENGTH_SHORT).show();
                return var;
            }


        });

    }
}