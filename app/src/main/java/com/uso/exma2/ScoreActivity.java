package com.uso.exma2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    //Variables a utilizar para el SharedPreferences
    public static final String ARCHIVO = "Historial";
    public static final String KEY_NICKNAME1 = "NickName1";
    public static final String KEY_SCORE1 = "Score1";
    public static final String KEY_NICKNAME2 = "NickName2";
    public static final String KEY_SCORE2 = "Score2";
    public static final String KEY_NICKNAME3 = "NickName3";
    public static final String KEY_SCORE3 = "Score3";

    public SharedPreferences historial;

    //Inicializamos las variables para la GUI
    private TextView lblTop1Nickname;
    private TextView lblTop2Nickname;
    private TextView lblTop3Nickname;
    private TextView lblTop1Score;
    private TextView lblTop2Score;
    private TextView lblTop3Score;
    private TextView lblNickname1;
    private TextView lblNickname2;
    private TextView lblNickname3;
    private TextView lblPuntaje1;
    private TextView lblPuntaje2;
    private TextView lblPuntaje3;
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private TextView lblDefecto;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        this.lblTop1Nickname = findViewById(R.id.lblTop1Nickname);
        this.lblTop2Nickname = findViewById(R.id.lblTop2Nickname);
        this.lblTop3Nickname = findViewById(R.id.lblTop3Nickname);
        this.lblTop1Score = findViewById(R.id.lblTop1Score);
        this.lblTop2Score = findViewById(R.id.lblTop2Score);
        this.lblTop3Score = findViewById(R.id.lblTop3Score);
        this.lblNickname1 = findViewById(R.id.lblNickName1);
        this.lblNickname2 = findViewById(R.id.lblNickName2);
        this.lblNickname3 = findViewById(R.id.lblNickName3);
        this.lblPuntaje1 = findViewById(R.id.lblPuntaje1);
        this.lblPuntaje2 = findViewById(R.id.lblPuntaje2);
        this.lblPuntaje3 = findViewById(R.id.lblPuntaje3);
        this.img1 = findViewById(R.id.IMG1);
        this.img2 = findViewById(R.id.IMG2);
        this.img3 = findViewById(R.id.IMG3);
        this.lblDefecto = findViewById(R.id.lblDefecto);

        //Cargamos datos al historial y cargamos los datos del Shared Preferences
        CargarHistorial();

        //Definimos que su posición es vertical
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    private void CargarHistorial() {
        if(this.historial != null){

            this.lblDefecto.setVisibility(View.INVISIBLE);

            this.lblTop1Nickname.setText(this.historial.getString(KEY_NICKNAME1,""));
            this.lblTop1Score.setText(this.historial.getString(KEY_SCORE1,""));

            this.lblTop2Nickname.setText(this.historial.getString(KEY_NICKNAME2,""));
            this.lblTop2Score.setText(this.historial.getString(KEY_SCORE2,""));

            this.lblTop3Nickname.setText(this.historial.getString(KEY_NICKNAME3,""));
            this.lblTop3Score.setText(this.historial.getString(KEY_SCORE3,""));

            if (!this.historial.getString(KEY_NICKNAME3,"").trim().isEmpty()){
                cargarElementosVisuales(3);
            }else if (!this.historial.getString(KEY_NICKNAME2,"").trim().isEmpty()){
                cargarElementosVisuales(2);
            }else if(!this.historial.getString(KEY_NICKNAME1,"").trim().isEmpty()){
                cargarElementosVisuales(1);
            }
        }
    }
    private void cargarElementosVisuales(int num){
        if (num == 3){
            this.lblTop1Score.setVisibility(View.VISIBLE);
            this.lblTop1Nickname.setVisibility(View.VISIBLE);
            this.lblPuntaje1.setVisibility(View.VISIBLE);
            this.lblNickname1.setVisibility(View.VISIBLE);
            this.img1.setVisibility(View.VISIBLE);

            this.lblTop2Score.setVisibility(View.VISIBLE);
            this.lblTop2Nickname.setVisibility(View.VISIBLE);
            this.lblPuntaje2.setVisibility(View.VISIBLE);
            this.lblNickname2.setVisibility(View.VISIBLE);
            this.img2.setVisibility(View.VISIBLE);

            this.lblTop3Score.setVisibility(View.VISIBLE);
            this.lblTop3Nickname.setVisibility(View.VISIBLE);
            this.lblPuntaje3.setVisibility(View.VISIBLE);
            this.lblNickname3.setVisibility(View.VISIBLE);
            this.img3.setVisibility(View.VISIBLE);
        }else if(num == 2){
            this.lblTop1Score.setVisibility(View.VISIBLE);
            this.lblTop1Nickname.setVisibility(View.VISIBLE);
            this.lblPuntaje1.setVisibility(View.VISIBLE);
            this.lblNickname1.setVisibility(View.VISIBLE);
            this.img1.setVisibility(View.VISIBLE);

            this.lblTop2Score.setVisibility(View.VISIBLE);
            this.lblTop2Nickname.setVisibility(View.VISIBLE);
            this.lblPuntaje2.setVisibility(View.VISIBLE);
            this.lblNickname2.setVisibility(View.VISIBLE);
            this.img2.setVisibility(View.VISIBLE);
        } else if(num == 1) {
            this.lblTop1Score.setVisibility(View.VISIBLE);
            this.lblTop1Nickname.setVisibility(View.VISIBLE);
            this.lblPuntaje1.setVisibility(View.VISIBLE);
            this.lblNickname1.setVisibility(View.VISIBLE);
            this.img1.setVisibility(View.VISIBLE);
        }
    }
}