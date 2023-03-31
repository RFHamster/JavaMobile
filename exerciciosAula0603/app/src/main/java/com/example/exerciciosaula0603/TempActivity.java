package com.example.exerciciosaula0603;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TempActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        Intent intent = getIntent();
        String media = intent.getStringExtra(MainActivity.EXTRA_MEDIA);
        String menor = intent.getStringExtra(MainActivity.EXTRA_MENOR);
        String maior = intent.getStringExtra(MainActivity.EXTRA_MAIOR);

        TextView textView = new TextView(this);
        textView.setTextSize(20);
        textView.setPadding(60,0,0,0);
        textView.setText("Media: " + media);
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.layout01);
        layout.addView(textView);
        textView = new TextView(this);
        textView.setTextSize(20);
        textView.setPadding(60,80,0,0);
        textView.setText("Maior: " + maior);
        layout.addView(textView);
        textView = new TextView(this);
        textView.setTextSize(20);
        textView.setPadding(60,160,0,0);
        textView.setText("Menor: " + menor);
        layout.addView(textView);
    }

    public void voltaPag(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}