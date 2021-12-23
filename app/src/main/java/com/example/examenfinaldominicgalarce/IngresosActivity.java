package com.example.examenfinaldominicgalarce;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class IngresosActivity extends AppCompatActivity {

    private Spinner animal, enfermedad;
    private TextView texto;
    private Animales ani = new Animales();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresos);

        animal = (Spinner)findViewById(R.id.sp1);
        enfermedad = (Spinner)findViewById(R.id.sp2);
        texto= (TextView)findViewById(R.id.tx);

        ArrayAdapter adaptAni = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ani.getTipo());
        ArrayAdapter adaptEnf = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ani.getEnfermedad());

        animal.setAdapter(adaptAni);
        enfermedad.setAdapter(adaptEnf);


    }
    public void calc(View v){

        String opcion1= animal.getSelectedItem().toString();
        String opcion2= enfermedad.getSelectedItem().toString();

        int resultado1=0;
        int resultado2=0;
        int resultadoF=0;

        for(int i =0; i<opcion1.length();i++){
            if (opcion1.equals(ani.getTipo()[i])){
                resultado1 = ani.getPrecioTipo()[i];
                break;
            }
        }
        for(int e=0;e<opcion2.length();e++){
            if(opcion2.equals(ani.getEnfermedad()[e])){
                resultado2 = ani.getPrecioEnfermedad()[e];
                break;
            }
        }
        resultadoF = resultado1+resultado2;
         texto.setText("La cotización final es: " + resultadoF);


    }
    public void volver(View view){
        Intent i = new Intent(getBaseContext(), HomeActivity.class);
        startActivity(i);
    }
}