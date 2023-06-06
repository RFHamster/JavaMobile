package com.example.trabalhofinalpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FecharConta extends AppCompatActivity {
    String idPedido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fechar_conta);
        Intent intent = getIntent();
        String total = intent.getStringExtra(TelaCatalogo.TOTAL);
        String descricao = intent.getStringExtra(TelaCatalogo.DESCRICAO);
        idPedido = intent.getStringExtra(TelaPedidos.ID_PEDIDO);
        TextView tv = (TextView) findViewById(R.id.descricao);
        tv.setText(descricao);
        tv = (TextView) findViewById(R.id.total);
        tv.setText("Total = " + total);
        tv = (TextView) findViewById(R.id.pedido);
        tv.setText("Pedido: " + idPedido);
    }
    public void finalizar(View v){
        Intent intent = new Intent(this, TelaPedidos.class);
        //Futuramente na tela do ADMIN, alterar o estado de pedido para concluido
        //e upar em outra tabela PedidosConcluidos
        ComandosBancos.deletarPedido(new FeedReaderDbHelper(getApplicationContext()), idPedido);

        startActivity(intent);
    }
}