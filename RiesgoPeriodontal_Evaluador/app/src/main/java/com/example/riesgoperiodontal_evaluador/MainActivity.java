package com.example.riesgoperiodontal_evaluador;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText sangrado,ausencia,perdida,diabetes,tabaco,profundidad,edad;
    private TextView eva1,eva2,eva3,eva4,eva5,eva6,evafinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eva1=findViewById(R.id.eva1);
        eva2=findViewById(R.id.eva2);
        eva3=findViewById(R.id.eva3);
        eva4=findViewById(R.id.eva4);
        eva5=findViewById(R.id.eva5);
        eva6=findViewById(R.id.eva6);
        evafinal=findViewById(R.id.evafinal);

        sangrado=findViewById(R.id.sangrado);
        ausencia=findViewById(R.id.ausencia);
        perdida=findViewById(R.id.perdida);
        diabetes=findViewById(R.id.diabetes);
        tabaco=findViewById(R.id.tabaco);
        profundidad=findViewById(R.id.profundidad);
        edad=findViewById(R.id.edad);
    }

    public void sangrado(View view){
        String resultado="";
        String valor1= sangrado.getText().toString();
        int num1=Integer.parseInt(valor1);
        if(num1==0){
            resultado="Sin riesgo";
        }
        else if(num1>0&&num1<10){
            resultado="Riesgo bajo";
        }
        else if(num1==10&&num1<26){
            resultado="Riesgo moderado";
        }
        else{
            resultado="Riesgo alto";
        }
        eva1.setText(resultado);
    }

    public void ausencia(View view){
        String resultado="";
        String valor1= ausencia.getText().toString();
        int num1=Integer.parseInt(valor1);
        if(num1==0){
            resultado="Sin riesgo";
        }
        else if(num1>0&&num1<5){
            resultado="Riesgo bajo";
        }
        else if(num1==5&&num1<12){
            resultado="Riesgo moderado";
        }
        else{
            resultado="Riesgo alto";
        }
        eva2.setText(resultado);
    }
    public void perdida(View view){
        String resultado="";
        String valor1= perdida.getText().toString();
        String valor2= edad.getText().toString();
        int num1=Integer.parseInt(valor1);
        int num2=Integer.parseInt(valor2);
        double media=num1/num2;
        if(media==0||media<0.5){
            resultado="Sin riesgo";
        }
        else if(media==0.5||media<1){
            resultado="Riesgo bajo";
        }
        else if(media==1){
            resultado="Riesgo moderado";
        }
        else{
            resultado="Riesgo alto";
        }
        eva3.setText(resultado);
    }
    public void diabetes(View view){
        String resultado="";
        Boolean diab=false;
        String valor1= diabetes.getText().toString();
        if(valor1.equalsIgnoreCase("si")){
            diab=true;
        }
        else {
            diab=false;
        }
        if (diab==false){
            resultado="Sin riesgo";
        }
        else{
            resultado="Riesgo alto";
        }
        eva4.setText(resultado);
    }
    public void tabaco(View view){
        String resultado="";
        String valor1= tabaco.getText().toString();
        if(valor1.equalsIgnoreCase("si")){
            resultado="Riesgo moderado";
        }
        else if (valor1.equalsIgnoreCase("no")){
            resultado="Sin riesgo";
        }
        else{
            resultado="Riesgo alto";
        }
        eva5.setText(resultado);
    }
    public void profundidad(View view){
        String resultado="";
        String valor1= profundidad.getText().toString();
        int num1=Integer.parseInt(valor1);
        if(num1==0){
            resultado="Sin riesgo";
        }
        else if(num1>0&&num1<5){
            resultado="Riesgo bajo";
        }
        else if(num1==5&&num1<9){
            resultado="Riesgo moderado";
        }
        else{
            resultado="Riesgo alto";
        }
        eva6.setText(resultado);
    }
    public void resfinal(View view){
        String resfinal="";
        int sumatoriaRiesgo=0;
        String resultados[];
        resultados= new String[6];
        resultados[0]= eva1.getText().toString();
        resultados[1]= eva2.getText().toString();
        resultados[2]= eva3.getText().toString();
        resultados[3]= eva4.getText().toString();
        resultados[4]= eva5.getText().toString();
        resultados[5]= eva6.getText().toString();

        for (int i = 0; i <resultados.length; i++) {
            if (resultados[i].equalsIgnoreCase("Sin riesgo")) {
                sumatoriaRiesgo += 0; // Sin riesgo agrega 0
            } else if (resultados[i].equalsIgnoreCase("Riesgo bajo")) {
                sumatoriaRiesgo += 1; // Riesgo bajo agrega 1
            } else if (resultados[i].equalsIgnoreCase("Riesgo moderado")) {
                sumatoriaRiesgo += 2; // Riesgo moderado agrega 2
            } else if (resultados[i].equalsIgnoreCase("Riesgo alto")) {
                sumatoriaRiesgo += 3; // Riesgo alto agrega 3
            }
        }
        double porcentajeRiesgo = (sumatoriaRiesgo / (6.0 * 3.0)) * 100;

        if (porcentajeRiesgo == 0) {
            resfinal = "0% Sin riesgo";
        } else if (porcentajeRiesgo > 0 && porcentajeRiesgo <= 25) {
            resfinal = "0-25% Riesgo Bajo";
        } else if (porcentajeRiesgo > 25 && porcentajeRiesgo <= 50) {
            resfinal = "25-50% Riesgo Moderado";
        } else if (porcentajeRiesgo > 50) {
            resfinal = ">50% Riesgo Alto";
        }

        evafinal.setText(resfinal);
    }
    public void limpiarCampos(View view) {
        sangrado.setText("");
        ausencia.setText("");
        perdida.setText("");
        diabetes.setText("");
        tabaco.setText("");
        profundidad.setText("");
        edad.setText("");

        eva1.setText("Sin evaluar");
        eva2.setText("Sin evaluar");
        eva3.setText("Sin evaluar");
        eva4.setText("Sin evaluar");
        eva5.setText("Sin evaluar");
        eva6.setText("Sin evaluar");
        evafinal.setText("Sin evaluar");
    }

}