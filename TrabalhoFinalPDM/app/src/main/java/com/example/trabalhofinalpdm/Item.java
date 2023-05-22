package com.example.trabalhofinalpdm;

public class Item {
    private String nome;
    private String descricao;
    private String preco;
    private String caminhoImg;

    public Item(String nome, String descricao, String preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.caminhoImg = "...";
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getPreco() {
        return preco;
    }

    public String getCaminhoImg() {
        return caminhoImg;
    }
}
