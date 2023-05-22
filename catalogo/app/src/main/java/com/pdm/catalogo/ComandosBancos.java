package com.pdm.catalogo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ComandosBancos {

    //Funções para Inserir em qualquer um dos bancos
    public static void inserirItem(FeedReaderDbHelper AppContext, String nome, String preco, String descricao, String caminhoIMG){
        FeedReaderDbHelper mDbHelper = AppContext;
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.Tabela_Itens.COLUMN_NAME_NOME, nome);
        values.put(FeedReaderContract.Tabela_Itens.COLUMN_NAME_DESCRICAO, descricao);
        values.put(FeedReaderContract.Tabela_Itens.COLUMN_NAME_CAMINHO_IMG, caminhoIMG);
        values.put(FeedReaderContract.Tabela_Itens.COLUMN_NAME_PRECO, preco);

        long newRowId;
        newRowId = db.insert(FeedReaderContract.Tabela_Pedidos.TABLE_NAME, null, values);
    }
    public static void inserirPedido(FeedReaderDbHelper AppContext, String idPedidos, String mesa){
        FeedReaderDbHelper mDbHelper = AppContext;
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        String descricao = "";
        String total = "0";
        String status = "pendente";

        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.Tabela_Pedidos.COLUMN_NAME_ID, idPedidos);
        values.put(FeedReaderContract.Tabela_Pedidos.COLUMN_NAME_DESCRICAO, descricao);
        values.put(FeedReaderContract.Tabela_Pedidos.COLUMN_NAME_ESTADO, status);
        values.put(FeedReaderContract.Tabela_Pedidos.COLUMN_NAME_MESA, mesa);
        values.put(FeedReaderContract.Tabela_Pedidos.COLUMN_NAME_TOTAL, total);

        long newRowId;
        newRowId = db.insert(FeedReaderContract.Tabela_Pedidos.TABLE_NAME, null, values);
    }

    //Deletar do banco com as chaves primarias
    public static void deletarItem(FeedReaderDbHelper AppContext, String nome){
        FeedReaderDbHelper mDbHelper = AppContext;
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        String selection = FeedReaderContract.Tabela_Itens.COLUMN_NAME_NOME + " LIKE ?";
        String selectionArgs[] = {nome};

        db.delete(FeedReaderContract.Tabela_Itens.TABLE_NAME, selection, selectionArgs);
    }
    public static void deletarPedido(FeedReaderDbHelper AppContext, String idPedido){
        FeedReaderDbHelper mDbHelper = AppContext;
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        String selection = FeedReaderContract.Tabela_Pedidos.COLUMN_NAME_ID + " LIKE ?";
        String selectionArgs[] = {idPedido};

        db.delete(FeedReaderContract.Tabela_Pedidos.TABLE_NAME, selection, selectionArgs);
    }

    //alterar comandos do banco atraves das chaves primarias
    public static void alterarItem(FeedReaderDbHelper AppContext, String nome, String preco, String descricao, String caminhoIMG){
        FeedReaderDbHelper mDbHelper = AppContext;
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        if(preco != null){
            values.put(FeedReaderContract.Tabela_Itens.COLUMN_NAME_PRECO, preco);
        }
        if(descricao != null){
            values.put(FeedReaderContract.Tabela_Itens.COLUMN_NAME_DESCRICAO, descricao);
        }
        if(caminhoIMG != null){
            values.put(FeedReaderContract.Tabela_Itens.COLUMN_NAME_CAMINHO_IMG, caminhoIMG);
        }

        String selection = FeedReaderContract.Tabela_Itens.COLUMN_NAME_NOME + " LIKE ?";
        String selectionArgs[] = {nome};

        db.update(FeedReaderContract.Tabela_Itens.TABLE_NAME, values, selection, selectionArgs);
    }
    public static void alterarPedido(FeedReaderDbHelper AppContext, String idPedidos, String descricao, String total, String status){
        FeedReaderDbHelper mDbHelper = AppContext;
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        if(total != null){
            values.put(FeedReaderContract.Tabela_Pedidos.COLUMN_NAME_TOTAL, total);
        }
        if(descricao != null){
            values.put(FeedReaderContract.Tabela_Pedidos.COLUMN_NAME_DESCRICAO, descricao);
        }
        if(status != null){
            values.put(FeedReaderContract.Tabela_Pedidos.COLUMN_NAME_ESTADO, status);
        }

        String selection = FeedReaderContract.Tabela_Pedidos.COLUMN_NAME_ID + " LIKE ?";
        String selectionArgs[] = {idPedidos};

        db.update(FeedReaderContract.Tabela_Pedidos.TABLE_NAME, values, selection, selectionArgs);
    }


    public static ArrayList<String> lerItem(FeedReaderDbHelper AppContext){
        FeedReaderDbHelper mDbHelper = AppContext;
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                FeedReaderContract.Tabela_Itens.COLUMN_NAME_NOME,
                FeedReaderContract.Tabela_Itens.COLUMN_NAME_PRECO,
                FeedReaderContract.Tabela_Itens.COLUMN_NAME_DESCRICAO,
                FeedReaderContract.Tabela_Itens.COLUMN_NAME_CAMINHO_IMG
        };


        Cursor c = db.query(
                FeedReaderContract.Tabela_Itens.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        ArrayList<String> s = new ArrayList<String>();
        c.moveToFirst();
        s.add(c.getString(c.getColumnIndexOrThrow(FeedReaderContract.Tabela_Itens.COLUMN_NAME_NOME)) + "," +
                c.getString(c.getColumnIndexOrThrow(FeedReaderContract.Tabela_Itens.COLUMN_NAME_PRECO)) + "," +
                c.getString(c.getColumnIndexOrThrow(FeedReaderContract.Tabela_Itens.COLUMN_NAME_DESCRICAO)) + "," +
                c.getString(c.getColumnIndexOrThrow(FeedReaderContract.Tabela_Itens.COLUMN_NAME_CAMINHO_IMG)));


        while(c.moveToNext()){
            s.add(c.getString(c.getColumnIndexOrThrow(FeedReaderContract.Tabela_Itens.COLUMN_NAME_NOME)) + "," +
                    c.getString(c.getColumnIndexOrThrow(FeedReaderContract.Tabela_Itens.COLUMN_NAME_PRECO)) + "," +
                    c.getString(c.getColumnIndexOrThrow(FeedReaderContract.Tabela_Itens.COLUMN_NAME_DESCRICAO)) + "," +
                    c.getString(c.getColumnIndexOrThrow(FeedReaderContract.Tabela_Itens.COLUMN_NAME_CAMINHO_IMG)));
        }

        return s;
    }
    public static ArrayList<String> lerPedido(FeedReaderDbHelper AppContext){
        FeedReaderDbHelper mDbHelper = AppContext;
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                FeedReaderContract.Tabela_Pedidos.COLUMN_NAME_ID,
                FeedReaderContract.Tabela_Pedidos.COLUMN_NAME_MESA,
                FeedReaderContract.Tabela_Pedidos.COLUMN_NAME_DESCRICAO,
                FeedReaderContract.Tabela_Pedidos.COLUMN_NAME_TOTAL,
                FeedReaderContract.Tabela_Pedidos.COLUMN_NAME_ESTADO
        };


        Cursor c = db.query(
                FeedReaderContract.Tabela_Pedidos.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        ArrayList<String> s = new ArrayList<String>();
        c.moveToFirst();
        s.add(c.getString(c.getColumnIndexOrThrow(FeedReaderContract.Tabela_Pedidos.COLUMN_NAME_ID)) + "," +
                c.getString(c.getColumnIndexOrThrow(FeedReaderContract.Tabela_Pedidos.COLUMN_NAME_MESA)) + "," +
                c.getString(c.getColumnIndexOrThrow(FeedReaderContract.Tabela_Pedidos.COLUMN_NAME_DESCRICAO)) + "," +
                c.getString(c.getColumnIndexOrThrow(FeedReaderContract.Tabela_Pedidos.COLUMN_NAME_TOTAL)) + "," +
                c.getString(c.getColumnIndexOrThrow(FeedReaderContract.Tabela_Pedidos.COLUMN_NAME_ESTADO)));


        while(c.moveToNext()){
            s.add(c.getString(c.getColumnIndexOrThrow(FeedReaderContract.Tabela_Pedidos.COLUMN_NAME_ID)) + "," +
                    c.getString(c.getColumnIndexOrThrow(FeedReaderContract.Tabela_Pedidos.COLUMN_NAME_MESA)) + "," +
                    c.getString(c.getColumnIndexOrThrow(FeedReaderContract.Tabela_Pedidos.COLUMN_NAME_DESCRICAO)) + "," +
                    c.getString(c.getColumnIndexOrThrow(FeedReaderContract.Tabela_Pedidos.COLUMN_NAME_TOTAL)) + "," +
                    c.getString(c.getColumnIndexOrThrow(FeedReaderContract.Tabela_Pedidos.COLUMN_NAME_ESTADO)));
        }

        return s;
    }
}

