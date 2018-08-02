package com.ifpb.model;

import com.ifpb.model.Pedido;
import com.ifpb.model.Produto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Comanda{

    //lista para armazenar varios pedidos
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

    //procura na lista 'pedidos' o pedido com o numero do pedido
    private Pedido buscaCodigo(int numPedido){
        for(Pedido p : pedidos){
            if(p.getNumPedido() == numPedido){
                return p;
            }
        }
        return null;
    }

    //retorna o pedido a partir de um produto a partir do codigo do produto
    public Pedido verPedido(int codigoPedido){

        for(Pedido p : pedidos){
            if(codigoPedido == p.getProduto().getCodigo()){
                return p;
            }
        }
        return null;
    }

    //cria um novo pedido e o adiciona ao array de pedidos, a comanda
    public boolean criaPedido(Pedido pedido){
        if(buscaCodigo(pedido.getNumPedido()) == null){
            pedidos.add(pedido);
            return true;
        }
        return false;
    }

    //atualizaçao de pedido
    public boolean atualizaPedido(Pedido novoPedido){

        Pedido pedidoAnterior = buscaCodigo(novoPedido.getNumPedido());

        if(pedidoAnterior == null){
            return false;
        }

        int posicaoDeInsercao = buscarPosicao(pedidoAnterior);
        pedidos.set(posicaoDeInsercao, novoPedido);
        return true;

    }

    //deleta um pedido da lista
    public boolean removePedido(Pedido pedido){
        int posicao = buscarPosicao(pedido);

        if(posicao<0){ return false; }

        pedidos.remove(posicao);
        return true;
    }

    //encerra um pedido, modificando o seu status
    public boolean fecharStatus(Pedido pedido){
        if(!verificaStatus(pedido)){
            pedido.setAtendido(true);
            return true;
        }
        return false;
    }

    //retorna o status (aberto ou fechado) do pedido
    public boolean verificaStatus(Pedido pedido){
        return pedido.isAtendido();

    }

    //calcula o valor total da comanda
    public double calculaValor(){
        double soma = 0;

        for(Pedido p : pedidos){
            soma = soma + p.getSubTotal();
        }

        return soma;

    }

    //reescrita do metodo equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comanda)) return false;
        Comanda comanda = (Comanda) o;
        return getNumeroComanda() == comanda.getNumeroComanda() &&
                comandaAberta == comanda.comandaAberta &&
                Objects.equals(pedidos, comanda.pedidos);
    }


    //implementaçao do metodo compareTo
    public int compareTo(LocalDate começo, LocalDate fim) {
        return fim.getDayOfMonth()-começo.getDayOfMonth();
    }
}

