package com.example.ex09at02;

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
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String texto;
    EditText num1;
    FileOutputStream outputStream;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = (EditText) findViewById(R.id.edit_message1);
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
    public ArrayList<String> read(){
        ArrayList<String> palavras = new ArrayList<>();
        try{
            FileInputStream input = openFileInput("Operacoes");
            InputStreamReader inputStreamReader= new InputStreamReader(input);
            BufferedReader bufferedReader= new BufferedReader(inputStreamReader);
            String recebe_string = bufferedReader.readLine();
            while(recebe_string != null) {
                String fields[] = recebe_string.split(" ");
                for(int i = 0; i < fields.length; i++){
                    if(fields[i].compareTo(" ") != 0){
                        palavras.add(fields[i].trim());
                    }
                }
                recebe_string = bufferedReader.readLine();
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return palavras;
    }
    public void delete(View v){
        getApplicationContext().deleteFile("Operacoes");
    }
    public void submit(View v){
        writeFile(num1.getText().toString());
        num1.getText().clear();
    }
    public void contador(View v){
        ArrayList<String> palavras = read();
        System.out.println(palavras);
        System.out.println(palavras.size());
        Toast.makeText(getApplicationContext(), Integer.toString(palavras.size()), Toast.LENGTH_SHORT).show();
    }
    public void vogal(View v){
        ArrayList<String> palavras = read();
        int contarVogais = 0;
        for(String texto:palavras){
            texto.toLowerCase();
            for (int i = 0; i < texto.length(); i++){
                char c = texto.charAt(i);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                    contarVogais++;
            }
        }
        System.out.println(palavras);
        System.out.println(contarVogais);
        Toast.makeText(getApplicationContext(), Integer.toString(contarVogais), Toast.LENGTH_SHORT).show();
    }

    public void palavra(View v){
        ArrayList<String> palavras = read();
        EditText p = (EditText) findViewById(R.id.edit_message2);
        String palavraEncontrar = p.getText().toString().trim();
        for(String texto:palavras){
                if (texto.equals(palavraEncontrar)){
                    Toast.makeText(getApplicationContext(), "Palavra Encontrada", Toast.LENGTH_SHORT).show();
                    return;
                }
        }
        Toast.makeText(getApplicationContext(), "Palavra Nao Encontrada", Toast.LENGTH_SHORT).show();
    }


}