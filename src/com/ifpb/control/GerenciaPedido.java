package com.ifpb.control;

import com.ifpb.model.Pedido;
import com.ifpb.model.Produto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GerenciaPedido {

    private List<Pedido> pedidos = new ArrayList<>();
    private Pedido novoPedido;
    private int quantidadeProduto;

    public GerenciaPedido(int quantidadeProduto, Pedido pedido) {
        this.quantidadeProduto = quantidadeProduto;
        this.novoPedido = pedido;
    }

    private int buscarPosicao(Pedido pedido){
          return pedidos.indexOf(pedido);
    }

    private boolean buscaCodigo(int codigo){
        for(Pedido p : pedidos){
            if(p.getNPedido() == codigo){
                return true;
            }
        }
        return false;
    }

    public double calculaSubTotal(){
        return (novoPedido.getProduto().getPreço())*quantidadeProduto;
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
         if(buscaCodigo(pedido.getNPedido())){
             pedidos.add(pedido);
             return true;
         }
         return false;
    }

    //update
    public boolean atualizaPedido(Pedido npedido){
        int posicao = buscarPosicao(npedido);

        if(posicao<0){
            return false;
        }

        pedidos.set(posicao, npedido);
        return true;
    }

    //delete
    public boolean removePedido(Pedido pedido){
        int posicao = buscarPosicao(pedido);

        if(posicao<0){ return false; }

        pedidos.remove(posicao);
        return true;
    }

    private boolean verificaStatus(Pedido pedido){
        return pedido.getStatus();

    }

}

