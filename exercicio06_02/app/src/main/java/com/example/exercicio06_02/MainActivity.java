package com.example.exercicio06_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_NOME = "com.example.myapplication.MESSAGE1";
    public final static String EXTRA_IDADE = "com.example.myapplication.MESSAGE2";
    public final static String EXTRA_ALTURA = "com.example.myapplication.MESSAGE3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View v){
        EditText nome = (EditText) findViewById(R.id.nome);
        EditText idade = (EditText) findViewById(R.id.idade);
        EditText altura = (EditText) findViewById(R.id.altura);
        Intent intent = new Intent(this,confere.class);
        intent.putExtra(EXTRA_NOME, nome.getText().toString().trim());
        intent.putExtra(EXTRA_IDADE, idade.getText().toString().trim());
        intent.putExtra(EXTRA_ALTURA, altura.getText().toString().trim());
        startActivity(intent);


    }
}