package com.example.trabalhofinalpdm;

import android.provider.BaseColumns;

public class FeedReaderContract {

        public FeedReaderContract(){}
        public static abstract class Tabela_Pedidos implements BaseColumns {
            public static final String TABLE_NAME = "Pedidos";
            public static final String COLUMN_NAME_ID = "id";
            public static final String COLUMN_NAME_MESA = "mesa";
            public static final String COLUMN_NAME_TOTAL = "total";
            public static final String COLUMN_NAME_DESCRICAO = "descricao";
            public static final String COLUMN_NAME_ESTADO = "estado";

            public static final String TEXT_TYPE = " TEXT";
            public static final String COMMA_SEP = ",";
            public static final String SQL_CREATE_ENTRIES =
                    "CREATE TABLE " + Tabela_Pedidos.TABLE_NAME +
                    " (" + Tabela_Pedidos._ID + " INTEGER PRIMARY KEY," +
                    Tabela_Pedidos.COLUMN_NAME_ID + TEXT_TYPE + COMMA_SEP +
                    Tabela_Pedidos.COLUMN_NAME_MESA + TEXT_TYPE + COMMA_SEP +
                    Tabela_Pedidos.COLUMN_NAME_TOTAL + TEXT_TYPE + COMMA_SEP +
                    Tabela_Pedidos.COLUMN_NAME_DESCRICAO + TEXT_TYPE + COMMA_SEP +
                    Tabela_Pedidos.COLUMN_NAME_ESTADO + TEXT_TYPE + " )";

            public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + Tabela_Pedidos.TABLE_NAME;
        }

    public static abstract class Tabela_Itens implements BaseColumns {
        public static final String TABLE_NAME = "Itens";
        public static final String COLUMN_NAME_NOME = "nome";
        public static final String COLUMN_NAME_DESCRICAO = "descricao";
        public static final String COLUMN_NAME_PRECO = "preco";
        public static final String COLUMN_NAME_CAMINHO_IMG = "caminhoIMG";

        public static final String TEXT_TYPE = " TEXT";
        public static final String COMMA_SEP = ",";
        public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " +
                Tabela_Itens.TABLE_NAME + " (" + Tabela_Itens._ID + " INTEGER PRIMARY KEY," +
                Tabela_Itens.COLUMN_NAME_NOME + TEXT_TYPE + COMMA_SEP +
                Tabela_Itens.COLUMN_NAME_PRECO + TEXT_TYPE + COMMA_SEP +
                Tabela_Itens.COLUMN_NAME_DESCRICAO + TEXT_TYPE + COMMA_SEP +
                Tabela_Itens.COLUMN_NAME_CAMINHO_IMG + TEXT_TYPE + " )";

        public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + Tabela_Itens.TABLE_NAME;
    }
}
