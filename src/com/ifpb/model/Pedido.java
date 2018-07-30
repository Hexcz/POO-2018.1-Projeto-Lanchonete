package com.ifpb.model;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import com.ifpb.Lanchonete.model.Produto;

public class Pedido {

    private int Quantidade;
    private int qtd;
    private LocalDate Data;
    private LocalDateTime Hora;
    private boolean status;

    public Pedido(Produto novoProduto, LocalDate Data, LocalDateTime Hora, int Quantidade){
        this.Data = Data;
        this.Hora = Hora;
        this.Quantidade = Quantidade;
        this.status = true;
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



}
