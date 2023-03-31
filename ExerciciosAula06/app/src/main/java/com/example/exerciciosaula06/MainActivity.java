package com.example.exerciciosaula06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myapplication.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void confereLogin(View v){
        EditText login = (EditText) findViewById(R.id.edit_message1);
        EditText senha = (EditText) findViewById(R.id.edit_message2);
        String message = "Usuario e/ou senha Invalido";
        Intent intent = new Intent(this,login.class);
        if(login.getText().toString().trim().equals("alex") && senha.getText().toString().trim().equals("123")){
            message = "Login realizado com sucesso";
        }else if(login.getText().toString().trim().equals("ana") && senha.getText().toString().trim().equals("abc")){
            message = "Login realizado com sucesso";
        }
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}