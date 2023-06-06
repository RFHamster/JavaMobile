package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.app2.MESSAGE";
    public final static String logado = "Abrindo tela";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void verificar(View view)
    {
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra(EXTRA_MESSAGE,logado);
        finish();
        Toast toast = Toast.makeText(this, logado, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
        startActivity(intent);

    }
}