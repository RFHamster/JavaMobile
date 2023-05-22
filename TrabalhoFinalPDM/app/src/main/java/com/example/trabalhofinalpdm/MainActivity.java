package com.example.trabalhofinalpdm;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> Itens = ComandosBancos.lerItem(new FeedReaderDbHelper(getApplicationContext()));
        ArrayList<HashMap<String, String>> prodList = new ArrayList<HashMap<String,String>>();
        for(String s : Itens){
            String[] arrayItem = s.split(",");
            HashMap<String,String> aux = new HashMap<String,String>();
            aux.put("nome", arrayItem[0]);
            aux.put("descricao", arrayItem[2]);
            aux.put("preco", arrayItem[1]);
            prodList.add(aux);
        }
        ListView lv = (ListView) findViewById(R.id.list_items);
        ListAdapter adapter = new SimpleAdapter(MainActivity.this,
                prodList,
                R.layout.list_row,
                new String[]{"nome","descricao","preco"},
                new int[]{R.id.nome, R.id.descricao, R.id.preco});
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Manipular o evento onClick do botão dentro da ListView
                Button buttonMenos = view.findViewById(R.id.btn_menos);
                Button buttonMais = view.findViewById(R.id.btn_mais);
                TextView textView = view.findViewById(R.id.qtd);

                buttonMenos.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Atualizar o texto do TextView quando o botão for clicado
                        int x = Integer.parseInt(textView.getText().toString().trim());
                        if(x>0){
                            x--;
                        }
                        textView.setText(String.valueOf(x));
                    }
                });

                buttonMais.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Atualizar o texto do TextView quando o botão for clicado
                        int x = Integer.parseInt(textView.getText().toString().trim());
                        x++;
                        textView.setText(String.valueOf(x));
                    }
                });
            }
        });
    }
}
