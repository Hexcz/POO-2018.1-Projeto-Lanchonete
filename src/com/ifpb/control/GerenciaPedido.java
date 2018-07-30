package com.ifpb.control;

import com.ifpb.Lanchonete.model.Produto;
import com.ifpb.model.Pedido;

import java.util.Arrays;

public class GerenciaPedido {

    private Produto[] Pedido;
    private int quantidadeProduto;
    private int quantidade;

    public GerenciaPedido(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
        quantidade = 0;
        Pedido = new Produto[2];
    }

    private boolean isFull(){
        if(quantidade>Pedido.length){
            return true;
        }
        return false;
    }

    private Produto[] aumentarArray(){
        return Arrays.copyOfRange(Pedido, 0, quantidade);
    }

    private int buscarPosicao(Produto pedido){
        for(int i = 0; i<quantidade; i++){
            if(Pedido[i].equals(pedido)){
                return i;
            }
        }
        return -1;
    }

    public float calculaSubValor(float valor, int quantidade){
        return valor*quantidade;
    }

    public boolean addPedido(Produto pedido){
        if(isFull()){
            aumentarArray();
        }
        Pedido[quantidade++] = pedido;
        return true;
    }

    public Produto findPedido(Produto pedido){
        int posicao = buscarPosicao(pedido);
        if(posicao<0){
            return null;
        }
            return pedido;
    }

    public boolean atualizarPedido(Produto pedido){
        int posicao = buscarPosicao(pedido);

        if(posicao<0){
            return false;
        }
        Pedido[posicao] = pedido;
        return false;
    }

    public boolean removerPedido(Produto pedido){
        int posicao = buscarPosicao(pedido);

        if(posicao<0){
            return false;
        }

        for(int j = posicao; j<quantidade; j--){
            Pedido[j] = Pedido[j+1];
        }
        quantidade--;
        return true;
    }

    public Produto[] listarPedido(){
        return Arrays.copyOfRange(Pedido, 0, quantidade);
    }
}
