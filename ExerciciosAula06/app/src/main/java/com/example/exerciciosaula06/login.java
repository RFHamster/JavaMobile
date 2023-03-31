package com.example.exerciciosaula06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = new TextView(this);
        textView.setTextSize(20);
        textView.setPadding(60,0,0,0);
        textView.setText(message);
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.layout01);
        layout.addView(textView);
    }

    public void voltaPag(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}