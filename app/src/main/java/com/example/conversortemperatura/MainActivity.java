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
    private Button buttonConverter;
    private TextView textview_valorConvertido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEntrada = findViewById(R.id.editTextEntrada);
        buttonConverter = findViewById(R.id.buttonConverter);
        textview_valorConvertido = findViewById(R.id.textview_valorConvertido);

        buttonConverter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == buttonConverter){
            converter();
        }
    }

    private double getEntrada(){
        double entrada;
        try{
            entrada = Double.valueOf(editEntrada.getText().toString());
        }catch (NumberFormatException ex){
            entrada = 0;
            throw ex;
        }
        return entrada;
    }

    private void converter(){
        double valor;

        try{
            valor = getEntrada();
        }
        catch(NumberFormatException ex){
            Toast.makeText(this, "Entrada Inválida!!", Toast.LENGTH_SHORT).show();
            valor = 0;
        }

        textview_valorConvertido.setText(String.format("%.2f ºC", (valor-32)/1.8));
    }
}

