package com.ifpb.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Pedido {

    private final Produto produto;
    private final LocalDate data;
    private final LocalTime hora;
    private boolean atendido;
    private int quantidade;
    private int numPedido;

    public Pedido(Produto produto, int quantidade, int numPedido) {
        this.produto = produto;
        this.data = LocalDate.now();
        this.hora = LocalTime.now();
        this.atendido = false;
        this.quantidade = quantidade;
        this.numPedido = numPedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public boolean isAtendido() {
        return atendido;
    }

    public void setAtendido(boolean atendido) {
        this.atendido = atendido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public double getSubTotal(){
        return produto.getPreco()*quantidade;
    }
}
