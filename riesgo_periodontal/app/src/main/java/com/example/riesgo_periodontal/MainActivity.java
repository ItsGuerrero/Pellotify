package com.example.riesgo_periodontal;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText etsangrado, etausencia, etperdida, etedad, etdiabetes, ettabaco, etbolsa;
    private TextView tvsangrado,resangrado, tvausencia, reausencia, tvperdida, reperdida, tvdiabetes, rediabetes, tvtabaco, retabaco, tvbolsa, rebolsa, refinal;
    private Button btnsangrado, btnausencia, btnperdida, btndiabetes, btntabaco, btnbolsa, btnfinal;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etsangrado= findViewById(R.id.etsangrado);
        tvsangrado= findViewById(R.id.tvsangrado);
        resangrado= findViewById(R.id.resangrado);
        btnsangrado= findViewById(R.id.btnsangrado);
        etausencia = findViewById(R.id.etausencia);
        tvausencia = findViewById(R.id.tvausencia);
        reausencia = findViewById(R.id.reausencia);
        btnausencia = findViewById(R.id.btnausencia);
        etperdida = findViewById(R.id.etperdida);
        tvperdida = findViewById(R.id.tvperdida);
        reperdida = findViewById(R.id.reperdida);
        btnperdida = findViewById(R.id.btnperdida);
        etedad = findViewById(R.id.etedad);
        etdiabetes = findViewById(R.id.etdiabetes);
        tvdiabetes = findViewById(R.id.tvdiabetes);
        rediabetes = findViewById(R.id.rediabetes);
        btndiabetes = findViewById(R.id.btndiabetes);
        ettabaco = findViewById(R.id.ettabaco);
        tvtabaco = findViewById(R.id.tvtabaco);
        retabaco = findViewById(R.id.retabaco);
        btntabaco = findViewById(R.id.btntabaco);
        etbolsa = findViewById(R.id.etbolsa);
        tvbolsa = findViewById(R.id.tvbolsa);
        rebolsa = findViewById(R.id.rebolsa);
        btnbolsa = findViewById(R.id.btnbolsa);
        refinal = findViewById(R.id.refinal);
        btnfinal = findViewById(R.id.btnfinal);
    }
    public void sangrado (View view){
        String valor1= etsangrado.getText().toString();
        int valor1int=Integer.parseInt(valor1);
        String resultadosangrado="";
        if (valor1int==0){
            resultadosangrado="Sin riesgo";
        }
        else if(valor1int<=9){
            resultadosangrado="Riesgo bajo";
        }else if (valor1int==10||valor1int<=25) {
            resultadosangrado="Riesgo moderado";
        }
        else{
            resultadosangrado="Riesgo alto";
        }
        resangrado.setText(resultadosangrado);
    }
    public void ausencia (View view){
        String valor2 = etausencia.getText().toString();
        int valor2int = Integer.parseInt(valor2);
        String resultadoausencia = "";
        if (valor2int == 0){
            resultadoausencia = "Sin riesgo";
        } else if (valor2int <= 4){
            resultadoausencia = "Riesgo bajo";
        } else if (valor2int == 5 || valor2int <= 10) {
            resultadoausencia = "Riesgo moderado";
        } else{
            resultadoausencia = "Riesgo alto";
        }
        reausencia.setText(resultadoausencia);
    }
    public void perdida (View view){
        String valor3 = etperdida.getText().toString();
        double valor3int = Double.parseDouble(valor3);
        String valoredad = etedad.getText().toString();
        Double edadint = Double.parseDouble(valoredad);
        Double valor3res = valor3int / edadint;
        String resultadoperdida = "";
        if (valor3res == 0.0){
            resultadoperdida = "Sin riesgo";
        } else if (valor3res < 1.0) {
            resultadoperdida = "Riesgo bajo";
        } else{
            resultadoperdida = "Riesgo alto";
        }
        reperdida.setText(resultadoperdida);
    }
    public void diabetes(View view) {
        String valor4 = etdiabetes.getText().toString();
        Boolean valor4boo;
        String resultadodiabetes = "";
        if (valor4.equalsIgnoreCase("Si")) {
            valor4boo = true;
        } else if (valor4.equalsIgnoreCase("No")) {
            valor4boo = false;
        } else {
            resultadodiabetes = "Valor no válido";
            rediabetes.setText(resultadodiabetes);
            return;
        }

        if (valor4boo) {
            resultadodiabetes = "Riesgo alto";
        } else {
            resultadodiabetes = "Sin riesgo";
        }

        rediabetes.setText(resultadodiabetes);
    }
    public void tabaco (View view){
        String valor5 = ettabaco.getText().toString();
        int valor5int = Integer.parseInt(valor5);
        String resultadotabaco = "";
        if (valor5int == 1){
            resultadotabaco = "Sin riesgo";
        } else if (valor5int == 2){
            resultadotabaco = "Riesgo moderado";
        } else if (valor5int == 3){
            resultadotabaco = "Riesgo Alto";
        } else{
            resultadotabaco = "Valor no válido";
            retabaco.setText(resultadotabaco);
            return;
        }
        retabaco.setText(resultadotabaco);
        Toast.makeText(getApplicationContext(),
                "Si fumas entre 0 y 20 eres fumador ocasional",
                Toast.LENGTH_LONG).show();
    }
    public void bolsa (View view){
        String valor6 = etbolsa.getText().toString();
        int valor6int = Integer.parseInt(valor6);
        String resultadobolsa = "";
        if (valor6int == 0){
            resultadobolsa = "Sin riesgo";
        } else if(valor6int > 0 && valor6int <=4){
            resultadobolsa = "Riesgo bajo";
        } else if(valor6int > 4 && valor6int <=8){
            resultadobolsa = "Riesgo moderado";
        } else if (valor6int > 8) {
            resultadobolsa = "Riesgo alto";
        } else {
            resultadobolsa = "Valor no válido";
            rebolsa.setText(resultadobolsa);
            return;
        }
        rebolsa.setText(resultadobolsa);
    }
    public void resfinal (View view){
        String resfinal="";
        int sumaRiesgo=0;
        String resultados[];
        resultados = new String[6];
        resultados[0]= resangrado.getText().toString();
        resultados[1]= reausencia.getText().toString();
        resultados[2]= reperdida.getText().toString();
        resultados[3]= rediabetes.getText().toString();
        resultados[4]= retabaco.getText().toString();
        resultados[5]= rebolsa.getText().toString();

        for (int i = 0; i <resultados.length; i++) {
            if (resultados[i].equalsIgnoreCase("Sin riesgo")) {
                sumaRiesgo += 0;
            } else if (resultados[i].equalsIgnoreCase("Riesgo bajo")) {
                sumaRiesgo += 1;
            } else if (resultados[i].equalsIgnoreCase("Riesgo moderado")) {
                sumaRiesgo += 2;
            } else if (resultados[i].equalsIgnoreCase("Riesgo alto")) {
                sumaRiesgo += 3;
            }
        }

        double porcentajeRiesgo = (sumaRiesgo / (6.0 * 3.0)) * 100;

        if (porcentajeRiesgo == 0) {
            resfinal = "0% Sin riesgo";
        } else if (porcentajeRiesgo > 0 && porcentajeRiesgo <= 25) {
            resfinal = "0-25% Riesgo Bajo";
        } else if (porcentajeRiesgo > 25 && porcentajeRiesgo <= 50) {
            resfinal = "25-50% Riesgo Moderado";
        } else if (porcentajeRiesgo > 50) {
            resfinal = ">50% Riesgo Alto";
        }
        refinal.setText(resfinal);
    }
}