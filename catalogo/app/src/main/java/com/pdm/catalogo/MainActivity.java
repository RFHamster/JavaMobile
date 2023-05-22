package com.pdm.catalogo;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.EditText;
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
        setContentView(R.layout.activity_main);
        ComandosBancos.inserirItem(new FeedReaderDbHelper(getApplicationContext()),"Misto Quente","5.00","1 presunto, 1 mussarela ...","...");
        ComandosBancos.inserirItem(new FeedReaderDbHelper(getApplicationContext()),"Pizza de Camarao","50.00","Camarao, molho ...","...");
        ComandosBancos.inserirItem(new FeedReaderDbHelper(getApplicationContext()),"Pizza de Churrasco","50.00","Picanha, molho ...","...");
        ComandosBancos.inserirItem(new FeedReaderDbHelper(getApplicationContext()),"X-Tudo","20.00","1 carne, ovo ...","...");
        ComandosBancos.inserirItem(new FeedReaderDbHelper(getApplicationContext()),"X-Bacon","20.00","1 carne, bacon ...","...");
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
        ListAdapter adapter = new SimpleAdapter(MainActivity.this, prodList, R.layout.list_row,
                new String[]{"nome","descricao","preco"}, new int[]{R.id.nome, R.id.descricao, R.id.preco});
        lv.setAdapter(adapter);



    }
}
