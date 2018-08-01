package com.ifpb.model;

import com.ifpb.model.Pedido;
import com.ifpb.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class Comanda {

    private List<Pedido> pedidos = new ArrayList<>();
    private Pedido novoPedido;

    public Comanda(Pedido novoPedido) {
        this.novoPedido = novoPedido;
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
        if(buscaCodigo(pedido.getNumPedido())){
            pedidos.add(pedido);
            return true;
        }
        return false;
    }

    //update
    public boolean atualizaPedido(Pedido numPedido){

        if(buscaCodigo(numPedido.getNumPedido())){
            int posicao = buscarPosicao(numPedido);
            pedidos.set(posicao, numPedido);
            return true;
        }
        return false;
    }

    //delete
    public boolean removePedido(Pedido pedido){
        int posicao = buscarPosicao(pedido);

        if(posicao<0){ return false; }

        pedidos.remove(posicao);
        return true;
    }

    private boolean verificaStatus(Pedido pedido){
        return pedido.isAtendido();

    }

}

