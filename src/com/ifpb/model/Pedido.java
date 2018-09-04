package com.ifpb.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Pedido {

    private Produto produto;
    private final LocalDate data;
    private final LocalTime hora;
    private boolean atendido;
    private int quantidade;
    private int numPedido;

    /**
     * CONSTRUTORES.
     * */

    public Pedido(Produto produto, int quantidade, int numPedido) {
        this.produto = produto;
        this.data = LocalDate.now();
        this.hora = LocalTime.now();
        this.atendido = false;
        this.quantidade = quantidade;
        this.numPedido = numPedido;
    }

    /**
     * GETTERS AND SETTERS.
     * */

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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

    public void setAtendido() {
        this.atendido = true;
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

    public double calcSubTotal(){
        return produto.getPreco()*quantidade;
    }

    /**
     * MÉTODOS SOBRESCRITOS.
     * */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido)) return false;
        Pedido pedido = (Pedido) o;
        return isAtendido() == pedido.isAtendido() &&
                getQuantidade() == pedido.getQuantidade() &&
                getNumPedido() == pedido.getNumPedido() &&
                Objects.equals(getProduto(), pedido.getProduto()) &&
                Objects.equals(getData(), pedido.getData()) &&
                Objects.equals(getHora(), pedido.getHora());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getProduto(), getData(), getHora(), isAtendido(), getQuantidade(), getNumPedido());
    }

    @Override
    public String toString() {
        return ":.:.:.:.:Pedido:.:.:.:.:" +
                "\nproduto: " + produto +
                "\ndata: " + data +
                "\nhora: " + hora +
                "\natendido: " + atendido +
                "\nquantidade: " + quantidade +
                "\nnumPedido: " + numPedido;
    }
}
