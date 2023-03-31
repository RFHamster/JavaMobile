package com.example.exerciciosaula0603;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    int contador;
    float media;
    float menor;
    float maior;
    EditText editText;
    public final static String EXTRA_MENOR = "com.example.myapplication.MENOR";
    public final static String EXTRA_MAIOR = "com.example.myapplication.MAIOR";
    public final static String EXTRA_MEDIA = "com.example.myapplication.MEDIA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contador = 9;
        menor = 9999;
        maior = -9999;
        media = 0;
        editText = (EditText) findViewById(R.id.edit_message1);
    }

    public void click(View v){
        if(contador>=0){
            contador--;
            float number = Float.parseFloat(editText.getText().toString().trim());
            if(number<menor){
                menor = number;
            }
            if(number>maior){
                maior = number;
            }
            media += number;
            editText.getText().clear();
        }
        if(contador < 0){
            contador = 9;
            media = media/10;
            Intent intent = new Intent(this,TempActivity.class);
            intent.putExtra(EXTRA_MEDIA, Float.toString(media));
            intent.putExtra(EXTRA_MAIOR, Float.toString(maior));
            intent.putExtra(EXTRA_MENOR, Float.toString(menor));
            media = 0;
            menor = 9999;
            maior = -9999;
            startActivity(intent);
        }
    }
}