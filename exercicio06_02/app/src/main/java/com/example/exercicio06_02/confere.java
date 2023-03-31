package com.example.exercicio06_02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class confere extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confere);

        Intent intent = getIntent();
        String nome = intent.getStringExtra(MainActivity.EXTRA_NOME);
        String idade = intent.getStringExtra(MainActivity.EXTRA_IDADE);
        String altura = intent.getStringExtra(MainActivity.EXTRA_ALTURA);
        TextView textView;
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.layout01);
        if(Integer.parseInt(idade)>=18 && Integer.parseInt(idade)<=35 && Float.parseFloat(altura)>1.86){
            textView = new TextView(this);
            textView.setTextSize(20);
            textView.setText(nome);
            textView.setPadding(60,0,0,0);
            layout.addView(textView);
        }else{
            textView = new TextView(this);
            textView.setTextSize(20);
            textView.setText(idade);
            textView.setPadding(60,0,0,0);
            layout.addView(textView);

            textView = new TextView(this);
            textView.setTextSize(20);
            textView.setText(altura);
            textView.setPadding(60,80,0,0);
            layout.addView(textView);
        }

    }
}