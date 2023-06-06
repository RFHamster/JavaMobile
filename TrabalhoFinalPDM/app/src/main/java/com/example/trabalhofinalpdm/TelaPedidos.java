package com.example.trabalhofinalpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TelaPedidos extends AppCompatActivity {
    public final static String ID_PEDIDO = "com.example.trabalhofinalpdm.idPedido";
    public final static String TOTAL_PREV = "com.example.trabalhofinalpdm.totalPrev";
    public final static String DESC_PREV = "com.example.trabalhofinalpdm.totalDesc";
    private ListView listView;
    private Button addButton;
    private ArrayAdapter adapter;

    private ArrayList<String> pedidosList;
    private ArrayList<Pedido> listaPedidos;
    private int contadorPedidos = 1;
    private int auxiliar = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pedidos);
        listView = findViewById(R.id.listView2);
        addButton = findViewById(R.id.addButton);
        ArrayList<String> pedidosList = new ArrayList<String>();
        listaPedidos = new ArrayList<Pedido>();

        pedidosList = ComandosBancos.lerPedido(new FeedReaderDbHelper(getApplicationContext()));
        if(!(pedidosList.isEmpty())){
            for(String s : pedidosList){
                String[] ArrayPedidos = s.split(",");
                Pedido aux = new Pedido(ArrayPedidos[0],ArrayPedidos[1],ArrayPedidos[2],ArrayPedidos[3],ArrayPedidos[4]);
                listaPedidos.add(aux);
            }
            contadorPedidos = Integer.parseInt(listaPedidos.get(listaPedidos.size()-1).getNomeId()) + 1;

            adapter = new PedidoAdapter(TelaPedidos.this,listaPedidos);
            listView.setAdapter(adapter);
        }else{
            auxiliar = 0;
        }

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText mesaCriar = (EditText) findViewById(R.id.mesaCriar);
                ComandosBancos.inserirPedido(new FeedReaderDbHelper(getApplicationContext()), String.valueOf(contadorPedidos), mesaCriar.getText().toString().trim());
                if(auxiliar == 0){
                    recreate();
                }else{
                    Pedido aux = new Pedido(String.valueOf(contadorPedidos),mesaCriar.getText().toString(),"","0","pendente");
                    contadorPedidos++;
                    listaPedidos.add(aux);
                    adapter.notifyDataSetChanged();
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TelaPedidos.this,TelaCatalogo.class);
                intent.putExtra(ID_PEDIDO, listaPedidos.get(position).getNomeId());
                intent.putExtra(TOTAL_PREV, listaPedidos.get(position).getTotal());
                intent.putExtra(DESC_PREV, listaPedidos.get(position).getDescricao());
                startActivity(intent);
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