package com.uso.exma2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Configuraciones extends AppCompatActivity {

    //Variables a utilizar para el SharedPreferences
    public static final String ARCHIVO = "Configuracion";
    public static final String KEY_NICKNAME = "NickName";
    public static final String KEY_DIFICULTAD = "Dificultad";

    public SharedPreferences configuraciones;

    //Variables a utilizar para el GUI
    private EditText txbNickname;
    private Spinner spDificultad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuraciones);

        //Inicializamos las variables
        this.txbNickname = findViewById(R.id.txbNickname);
        this.spDificultad = findViewById(R.id.spDificultad);
        this.configuraciones = getSharedPreferences(ARCHIVO,MODE_PRIVATE);

        //Cargamos datos al Spinner y cargamos los datos del Shared Preferences
        CargarNivelesConfiguraciones();

        //Definimos que su posición es vertical
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    private void CargarNivelesConfiguraciones(){
        ArrayList<String> niveles = new ArrayList<>();

        niveles.add("Seleccione un Nivel...");
        niveles.add("Fácil");
        niveles.add("Medio");
        niveles.add("Difícil");

        ArrayAdapter adp = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,niveles);
        spDificultad.setAdapter(adp);

        //Validamos que exista una instancia de la configuración
        if(this.configuraciones != null){
            this.txbNickname.setText(this.configuraciones.getString(KEY_NICKNAME, ""));
            this.spDificultad.setSelection(opcSeleccionada());
        }
    }

    public int opcSeleccionada(){
        int opc = 0;
        switch (this.configuraciones.getString(KEY_DIFICULTAD, "")){
            case "Fácil" :
                opc = 1;
                break;
            case "Medio":
                opc = 2;
                break;
            case "Difícil":
                opc = 3;
                break;
            default:
                opc = 0;
                break;
        }
        return opc;
    }

    public void btnGuardarConfiguracion_Click(View v){
        //Validamos que existe el objeto de configuración
        if(this.configuraciones != null){
            //Validamos que exista una configuración previa
            if(validarConfiguracion()){
                //Obtenemos el editor
                SharedPreferences.Editor editor = this.configuraciones.edit();

                editor.putString(KEY_NICKNAME, this.txbNickname.getText().toString());
                editor.putString(KEY_DIFICULTAD, this.spDificultad.getSelectedItem().toString());

                //Guardado en SharedPreferences
                if(editor.commit()){
                    Toast.makeText(this, "Configuración Guardada con Éxito", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(this, "Error al guardar la Configuración", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "Es necesario establecer nombre y dificultad antes de guardar", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean validarConfiguracion() {
        boolean bandera = true;
            if (this.txbNickname.getText().toString().trim().isEmpty() || this.spDificultad.getSelectedItemPosition() == 0){
                bandera = false;
            }
        return bandera;
    }
}