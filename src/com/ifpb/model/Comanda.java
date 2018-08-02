package com.ifpb.model;

import com.ifpb.model.Pedido;
import com.ifpb.model.Produto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Comanda{

    private List<Pedido> pedidos = new ArrayList<>();
    private int numeroComanda;
    private boolean comandaAberta;
    private LocalDate data;

    public Comanda(int numeroComanda, LocalDate data) {
        this.numeroComanda = numeroComanda;
        this.comandaAberta = true;
        this.data = data;
    }

    public LocalDate getData() {
        return data;
    }

    public int getNumeroComanda(){
        return this.numeroComanda;
    }

    public void setComandaAberta(boolean c) {
        this.comandaAberta = c;
    }

    public boolean isComandaAberta(Comanda Comanda){
        return this.comandaAberta;
    }

    private int buscarPosicao(Pedido pedido){
        return pedidos.indexOf(pedido);
    }

    private Pedido buscaCodigo(int codigo){
        for(Pedido p : pedidos){
            if(p.getNumPedido() == codigo){
                return p;
            }
        }
        return null;
    }

    //read
    public Pedido verPedido(Produto produto){
        int codigo = produto.getCodigo();

        for(Pedido p : pedidos){
            if(codigo == p.getProduto().getCodigo()){
                return p;
            }
        }
        return null;
    }

    //create
    public boolean criaPedido(Pedido pedido){
        if(buscaCodigo(pedido.getNumPedido()) == null){
            pedidos.add(pedido);
            return true;
        }
        return false;
    }

    //update
    public boolean atualizaPedido(Pedido novoPedido){

        Pedido pedidoAnterior = buscaCodigo(novoPedido.getNumPedido());

        if(pedidoAnterior == null){
            return false;
        }

        int posicaoDeInsercao = buscarPosicao(pedidoAnterior);
        pedidos.set(posicaoDeInsercao, novoPedido);
        return true;

    }

    //delete
    public boolean removePedido(Pedido pedido){
        int posicao = buscarPosicao(pedido);

        if(posicao<0){ return false; }

        pedidos.remove(posicao);
        return true;
    }

    public boolean fecharStatus(Pedido pedido){
        if(!verificaStatus(pedido)){
            pedido.setAtendido(true);
            return true;
        }
        return false;
    }

    public boolean verificaStatus(Pedido pedido){
        return pedido.isAtendido();

    }

    public double calculaValor(){
        double soma = 0;

        for(Pedido p : pedidos){
            soma = soma + p.getSubTotal();
        }

        return soma;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comanda)) return false;
        Comanda comanda = (Comanda) o;
        return getNumeroComanda() == comanda.getNumeroComanda() &&
                comandaAberta == comanda.comandaAberta &&
                Objects.equals(pedidos, comanda.pedidos);
    }


    public int compareTo(LocalDate começo, LocalDate fim) {
        return fim.getDayOfMonth()-começo.getDayOfMonth();
    }
}

