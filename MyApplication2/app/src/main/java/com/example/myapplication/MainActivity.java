package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    float precofinal = 4;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tview);
        textView.setText(Float.toString(precofinal));
    }

    public void onCheckBoxClicked(View v){
        boolean checked = ((CheckBox) v).isChecked();
        switch(v.getId()){
            case R.id.checkbox_alface:
                if(checked){
                    precofinal += 0.3;
                }else{
                    precofinal -= 0.3;
                }
                break;
            case R.id.checkbox_azeitonas:
                if(checked){
                    precofinal += 0.5;
                }else{
                    precofinal -= 0.5;
                }
                break;
            case R.id.checkbox_milho:
                if(checked){
                    precofinal += 0.3;
                }else{
                    precofinal -= 0.3;
                }
                break;
            case R.id.checkbox_presunto:
                if(checked){
                    precofinal += 0.7;
                }else{
                    precofinal -= 0.7;
                }
                break;
            case R.id.checkbox_peitofrango:
                if(checked){
                    precofinal += 2;
                }else{
                    precofinal -= 2;
                }
                break;
            case R.id.checkbox_peitoperu:
                if(checked){
                    precofinal += 1;
                }else{
                    precofinal -= 1;
                }
                break;
            case R.id.checkbox_tomate:
                if(checked){
                    precofinal += 0.5;
                }else{
                    precofinal -= 0.5;
                }
                break;
            case R.id.checkbox_queijo:
                if(checked){
                    precofinal += 1;
                }else{
                    precofinal -= 1;
                }
                break;
            case R.id.checkbox_ovo:
                if(checked){
                    precofinal += 0.5;
                }else{
                    precofinal -= 0.5;
                }
                break;
        }
        textView.setText(Float.toString(precofinal));
    }
}