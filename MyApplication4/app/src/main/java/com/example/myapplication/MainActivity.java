package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ComandosBancos db = new ComandosBancos(this);
        setContentView(R.layout.activity_main);
        ArrayList<HashMap<String, String>> userList = db.GetUsers();
        ListView lv = (ListView) findViewById(R.id.list_items);
        ListAdapter adapter = new SimpleAdapter(MainActivity.this, userList, R.layout.list_row,
                              new String[]{"nome","descricao","preco"}, new int[]{R.id.nome, R.id.descricao, R.id.preco});
        lv.setAdapter(adapter);


}

