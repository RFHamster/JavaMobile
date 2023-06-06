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

public class ItemAdapter extends ArrayAdapter<Item> {

    private Context mContext;
    private ArrayList<Item> ItemList;
    public ArrayList<String> valores;

    public ItemAdapter(Context context, ArrayList<Item> list) {
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
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_row,parent,false);

        Item currentItem = ItemList.get(position);

        TextView nome = listItem.findViewById(R.id.nome);
        nome.setText(currentItem.getNome());

        TextView descricao = listItem.findViewById(R.id.descricao);

        descricao.setText(currentItem.getDescricao());

        TextView preco = listItem.findViewById(R.id.preco);

        preco.setText(currentItem.getPreco());

        Button buttonMais = (Button) listItem.findViewById(R.id.btn_mais);
        Button buttonMenos = (Button) listItem.findViewById(R.id.btn_menos);

        TextView quantidade = (TextView) listItem.findViewById(R.id.qtd);
        buttonMais.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int x = Integer.parseInt(quantidade.getText().toString());
                x++;
                quantidade.setText(String.valueOf(x));
                valores.set(position, quantidade.getText().toString());
            }
        });

        buttonMenos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int x = Integer.parseInt(quantidade.getText().toString());
                if(x != 0) {
                    x--;
                    valores.set(position, quantidade.getText().toString());
                    quantidade.setText(String.valueOf(x));
                }
            }
        });

        return listItem;
    }

    public ArrayList<String> getValores(){
        return this.valores;
    }


}

