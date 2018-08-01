package com.ifpb.model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Pedido {

    private Produto Produto;
    private LocalDate Data;
    private LocalDateTime Hora;
    private boolean status;
    private int Quantidade;
    private int NPedido;

    public Pedido(Produto Produto, LocalDate Data, LocalDateTime Hora, int Quantidade, int NPedido){
        this.Produto = Produto;
        this.Data = Data;
        this.Hora = Hora;
        this.Quantidade = Quantidade;
        this.status = true;
        this.NPedido = NPedido;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int quantidade) {
        Quantidade = quantidade;
    }

    public LocalDate getData() {
        return Data;
    }

    public void setData(LocalDate data) {
        Data = data;
    }

    public LocalDateTime getHora() {
        return Hora;
    }

    public void setHora(LocalDateTime hora) {
        Hora = hora;
    }

    public Produto getProduto() { return this.Produto; }

    public void setProduto(Produto Produto) { this.Produto = Produto; }

    public boolean getStatus() { return this.status; }

    public void setStatus(boolean s) { this.status = s; }

    public int getNPedido() { return this.NPedido; }

    public void setNPedido(int codigo) { this.NPedido = codigo; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido)) return false;
        Pedido pedido = (Pedido) o;
        return status == pedido.status &&
                getQuantidade() == pedido.getQuantidade() &&
                Objects.equals(getProduto(), pedido.getProduto()) &&
                Objects.equals(getData(), pedido.getData()) &&
                Objects.equals(getHora(), pedido.getHora());
    }

}
