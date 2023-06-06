package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private ListView listView;
    private Button addButton;
    private ArrayAdapter<String> adapter;
    private List<String> itemList = new ArrayList<>();
    private int contadorPedidos = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = findViewById(R.id.listView);
        addButton = findViewById(R.id.addButton);


        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);
        listView.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 String pedidos = "Pedido "+contadorPedidos;
                itemList.add(pedidos);
                adapter.notifyDataSetChanged();
                contadorPedidos++;
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                startActivity(new Intent(MainActivity2.this, MainActivity2.class));
            }
        });
    }
    public void voltar(View view)
    {
        Intent intent2 = new Intent(this,MainActivity.class);
        startActivity(intent2);
        finish();
    }
}