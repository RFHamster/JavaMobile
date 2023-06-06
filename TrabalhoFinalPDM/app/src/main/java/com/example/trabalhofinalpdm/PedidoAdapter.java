package com.example.trabalhofinalpdm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PedidoAdapter extends ArrayAdapter<Pedido> {
    private Context mContext;
    private ArrayList<Pedido> ItemList;
    public ArrayList<String> valores;

    public PedidoAdapter(Context context, ArrayList<Pedido> list) {
        super(context, 0 , list);
        mContext = context;
        ItemList = list;
        valores = new ArrayList<String>();
        for(int i = 0; i < list.size();i++){
            valores.add("0");
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItem = convertView;

        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_pedidos,parent,false);

        Pedido currentItem = ItemList.get(position);

        TextView aux = listItem.findViewById(R.id.nomeId);
        aux.setText("Pedido: " + currentItem.getNomeId());
        valores.add(currentItem.getNomeId());

        aux = listItem.findViewById(R.id.mesa);
        aux.setText("Mesa: " + currentItem.getMesa());

        aux = listItem.findViewById(R.id.descricao);
        aux.setText(currentItem.getDescricao());

        aux = listItem.findViewById(R.id.estado);
        aux.setText("Estado: " + currentItem.getEstado());

        aux = listItem.findViewById(R.id.total);
        aux.setText("Total = " + currentItem.getTotal());

        return listItem;
    }

    public ArrayList<String> getValores(){
        return this.valores;
    }


}

