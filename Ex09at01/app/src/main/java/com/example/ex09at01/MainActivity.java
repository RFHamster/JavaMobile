package com.example.ex09at01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    String texto;
    EditText num1;
    EditText num2;
    FileOutputStream outputStream;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = (EditText) findViewById(R.id.edit_message1);
        num2 = (EditText) findViewById(R.id.edit_message2);
    }
    public void writeFile(String text){
        try{
            outputStream = openFileOutput("Operacoes", Context.MODE_APPEND);
            text = text + "\n";
            outputStream.write(text.getBytes());
            outputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void read(View v){
        try{
            FileInputStream input = openFileInput("Operacoes");
            InputStreamReader inputStreamReader= new InputStreamReader(input);
            BufferedReader bufferedReader= new BufferedReader(inputStreamReader);
            String recebe_string;
            String dados = "";
            while( (recebe_string = bufferedReader.readLine()) != null) {
                dados = dados + recebe_string;
                dados = dados + "\n";
            }
            Toast.makeText(getApplicationContext(), dados, Toast.LENGTH_SHORT).show();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void delete(View v){
        getApplicationContext().deleteFile("Operacoes");
    }
    public void mais(View v){
        texto = num1.getText().toString().trim() + " + " + num2.getText().toString().trim() + " = " + Float.toString(Float.parseFloat(num1.getText().toString().trim()) + Float.parseFloat(num2.getText().toString().trim()));
        writeFile(texto);
        num1.getText().clear();
        num2.getText().clear();
    }
    public void menos(View v){
        texto = num1.getText().toString().trim() + " - " + num2.getText().toString().trim() + Float.toString(Float.parseFloat(num1.getText().toString().trim()) - Float.parseFloat(num2.getText().toString().trim()));
        writeFile(texto);
        num1.getText().clear();
        num2.getText().clear();
    }
    public void multi(View v){
        texto = num1.getText().toString().trim() + " * " + num2.getText().toString().trim() + Float.toString(Float.parseFloat(num1.getText().toString().trim()) * Float.parseFloat(num2.getText().toString().trim()));
        writeFile(texto);
        num1.getText().clear();
        num2.getText().clear();
    }
    public void div(View v){
        texto = num1.getText().toString().trim() + " / " + num2.getText().toString().trim() + Float.toString(Float.parseFloat(num1.getText().toString().trim()) / Float.parseFloat(num2.getText().toString().trim()));
        writeFile(texto);
        num1.getText().clear();
        num2.getText().clear();
    }


}