package com.example.conversortemperatura;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editEntrada;
    private Button buttonCelsius;
    private Button buttonFahrenheit;
    private TextView valorConvertido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEntrada = findViewById(R.id.edittextEntrada);
        buttonCelsius = findViewById(R.id.buttonCelsius);
        buttonFahrenheit = findViewById(R.id.buttonFahrenheit);
        valorConvertido = findViewById(R.id.textviewValorConvertido);

        buttonCelsius.setOnClickListener(this);
        buttonFahrenheit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == buttonCelsius){
            converterParaCelsius();
        }
        if(v == buttonFahrenheit){
            converterParaFahrenheit();
        }
    }

    private double getEntrada(){
        double entrada;
        try{
            entrada = Double.parseDouble(editEntrada.getText().toString());
        }
        catch(NumberFormatException ex){
            entrada = 0;
            throw ex;
        }
        return entrada;
    }

    public void converterParaCelsius(){
        double valor;
        boolean numeroInvalido = false;

        try{
            valor = getEntrada();
        }
        catch(NumberFormatException ex){
            Toast.makeText(this, "Entrada Inválida!!", Toast.LENGTH_SHORT).show();
            numeroInvalido = true;
            valor = 0;
        }
        if(!numeroInvalido){
            valorConvertido.setText(String.format("%.2f ºC", (valor-32)/1.8));
        }

    }

    public void converterParaFahrenheit(){
        double valor;
        boolean numeroInvalido = false;

        try{
            valor = getEntrada();
        }
        catch(NumberFormatException ex){
            Toast.makeText(this, "Entrada Inválida!!", Toast.LENGTH_SHORT).show();
            numeroInvalido = true;
            valor = 0;
        }

        if(!numeroInvalido){
            valorConvertido.setText(String.format("%.2f ºF", 1.8 * valor + 32));
        }
    }
}

