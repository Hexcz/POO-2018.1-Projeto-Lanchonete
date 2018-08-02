package com.ifpb.model;


import java.util.ArrayList;
import java.util.List;

public class Comanda{

    private List<Pedido> pedidos = new ArrayList<>();

    public boolean create (Pedido pedido){
        return pedidos.add(pedido);
    }

    public Pedido read (int codPedido){
        for (Pedido p: pedidos) {
            if (codPedido == p.getNumPedido()) {
                return p;
            }
        }
        return null;
    }

    public boolean update (Pedido pedido){
        for (int i = 0; i < pedidos.size(); i++){
            Pedido atualPedido1 = pedidos.get(i);
            if (atualPedido1.getNumPedido()==pedido.getNumPedido()){
                if (!atualPedido1.isAtendido()){
                    pedidos.set(i, pedido);
                    return true;
                }else return false;
            }
        }
        return false;
    }

    public boolean delete(Pedido pedido){
        for (int i = 0; i < pedidos.size(); i++){
            Pedido atualPedido1 = pedidos.get(i);
            if (atualPedido1.getNumPedido()==pedido.getNumPedido()){
                if (!atualPedido1.isAtendido()){
                    pedidos.remove(pedido);
                    return true;
                }else return false;
            }
        }
        return false;
    }

    public List<Pedido> list(){
        return pedidos;
    }

    public double calcTotal(){
        double total = 0;
        for (Pedido p: pedidos) {
            if(p.isAtendido()){
                total += p.calcSubTotal();
            }
        }
        return total;
    }
}