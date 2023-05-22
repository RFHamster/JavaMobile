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
    private List<Item> pessoasList;

    public PessoasAdapter(Context context, ArrayList<Item> list) {
        super(context, 0 , list);
        mContext = context;
        pessoasList = list;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItem = convertView;

        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.pessoa_list,parent,false);

        Item currentPessoa = pessoasList.get(position);

        TextView nome = listItem.findViewById(R.id.textViewNome);
        nome.setText(currentPessoa.getNome());

        TextView telefone = listItem.findViewById(R.id.textViewTelefone);

        telefone.setText(currentPessoa.getTelefone());

        TextView endereco = listItem.findViewById(R.id.textViewEndereco);

        endereco.setText(currentPessoa.getEndereco());

        Button imprimeNome = (Button) listItem.findViewById(R.id.button01);
        imprimeNome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                CharSequence text = currentPessoa.getNome();
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(getContext(), text, duration);
                toast.show();
            }
        });

        return listItem;
    }


}

