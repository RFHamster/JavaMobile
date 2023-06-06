package com.example.trabalhofinalpdm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class FeedReaderDbHelper extends SQLiteOpenHelper {
    //TRestaurante
    public static final String DATABASE_NAME = "RestauranteGRW.db";
    public static final int DATABASE_VERSION = 1;

    public FeedReaderDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(FeedReaderContract.Tabela_Pedidos.SQL_CREATE_ENTRIES);
        db.execSQL(FeedReaderContract.Tabela_Itens.SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(FeedReaderContract.Tabela_Pedidos.SQL_DELETE_ENTRIES);
        db.execSQL(FeedReaderContract.Tabela_Itens.SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
