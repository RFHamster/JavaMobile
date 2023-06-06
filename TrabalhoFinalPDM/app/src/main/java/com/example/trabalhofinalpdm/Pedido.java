package com.example.trabalhofinalpdm;

public class Pedido {
    String nomeId;
    String mesa;
    String descricao;
    String total;
    String estado;

    public Pedido(String nomeId, String mesa, String descricao, String total, String estado) {
        this.nomeId = nomeId;
        this.mesa = mesa;
        this.descricao = descricao;
        this.total = total;
        this.estado = estado;
    }

    public String getNomeId() {
        return nomeId;
    }

    public String getMesa() {
        return mesa;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTotal() {
        return total;
    }

    public String getEstado() {
        return estado;
    }
}
