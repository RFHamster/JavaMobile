package com.example.aula07ex03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tview);
    }

    public void onRadioButtonClicked(View v){
        boolean checked = ((RadioButton) v).isChecked();

        switch(v.getId()) {
            case R.id.radio_fundamental:
                if (checked) {
                    textView.setText("Fundamental");
                }
                break;
            case R.id.radio_medio:
                if (checked) {
                    textView.setText("Medio");
                }
                break;
            case R.id.radio_superiorIncompleto:
                if (checked) {
                    textView.setText("Superior Incompleto");
                }
                break;
            case R.id.radio_superiorCompleto:
                if (checked) {
                    textView.setText("Superior Completo");
                }
                break;
            case R.id.radio_especializacaoIncompleto:
                if (checked) {
                    textView.setText("Especialização Incompleto");
                }
                break;
            case R.id.radio_especializaçãoCompleto:
                if (checked) {
                    textView.setText("Especialização Completo");
                }
                break;
            case R.id.radio_mestradoCompleto:
                if (checked) {
                    textView.setText("Mestrado Completo");
                }
                break;
            case R.id.radio_mestradoIncompleto:
                if (checked) {
                    textView.setText("Mestrado Incompleto");
                }
                break;
            case R.id.radio_doutoradoCompleto:
                if (checked) {
                    textView.setText("Doutorado Completo");
                }
                break;
            case R.id.radio_doutoradoIncompleto:
                if (checked) {
                    textView.setText("Doutorado Incompleto");
                }
                break;
        }
    }
}