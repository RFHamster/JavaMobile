package com.example.trabalhofinalpdm;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TelaCatalogo extends AppCompatActivity {
    public final static String DESCRICAO = "com.example.trabalhofinalpdm.descricao";
    public final static String TOTAL = "com.example.trabalhofinalpdm.total";
    ArrayList<Item> prodList;
    ItemAdapter adapter;
    String idPedido;
    String prevTotal;
    String prevDesc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_catalogo);
        Intent intent = getIntent();
        idPedido = intent.getStringExtra(TelaPedidos.ID_PEDIDO);
        prevTotal = intent.getStringExtra(TelaPedidos.TOTAL_PREV);
        prevDesc = intent.getStringExtra(TelaPedidos.DESC_PREV);
        //ComandosBancos.inserirItem( new FeedReaderDbHelper(getApplicationContext()),"X-Batata","15.80","Sanduiche","...");
        ArrayList<String> Itens = ComandosBancos.lerItem(new FeedReaderDbHelper(getApplicationContext()));
        prodList = new ArrayList<Item>();
        for(String s : Itens){
            String[] arrayItem = s.split(",");
            Item aux = new Item(arrayItem[0],arrayItem[1],arrayItem[2],arrayItem[3]);
            prodList.add(aux);
        }

        ListView lv = (ListView) findViewById(R.id.list_items);
        adapter = new ItemAdapter(TelaCatalogo.this, prodList);
        lv.setAdapter(adapter);
    }

    public void salvar(View v){
        String s = declaracaoItens() + prevDesc;
        float total = getTotal() + Float.parseFloat(prevTotal);
        ComandosBancos.alterarPedido(new FeedReaderDbHelper(getApplicationContext()), idPedido, s, String.valueOf(total),"pendente");
        Intent intent = new Intent(this, TelaPedidos.class);
        startActivity(intent);
    }

    public void voltar(View v){
        Intent intent = new Intent(this, TelaPedidos.class);
        startActivity(intent);
    }

    public void pedir(View v){
        String s = declaracaoItens();
        float total = getTotal();
        Intent intent = new Intent(this, FecharConta.class);
        intent.putExtra(TelaPedidos.ID_PEDIDO, idPedido);
        intent.putExtra(DESCRICAO, prevDesc);
        intent.putExtra(TOTAL, prevTotal);
        startActivity(intent);
    }
    public String declaracaoItens(){
        if(prodList.isEmpty()){
            return null;
        }
        String declaracao = "";
        for(int i = 0; i<prodList.size();i++){
            Item item = prodList.get(i);
            float valorItem = Float.parseFloat(item.getPreco());
            int qtd = Integer.parseInt(adapter.valores.get(i));
            valorItem = valorItem * qtd;
            if(qtd != 0){
                declaracao += String.valueOf(qtd) + "x " + item.getNome() + " = " + String.valueOf(valorItem) + "\n";
            }
        }
        if(declaracao.equals("")){
            return null;
        }
        return declaracao;
    }

    public float getTotal(){
        if(prodList.isEmpty()){
            return 0;
        }
        float total = 0;
        for(int i = 0; i<prodList.size();i++){
            Item item = prodList.get(i);
            float valorItem = Float.parseFloat(item.getPreco());
            float qtd = Float.parseFloat(adapter.valores.get(i).trim());
            if(qtd != 0){
                total += qtd * valorItem;
            }
        }
        return total;
    }
}