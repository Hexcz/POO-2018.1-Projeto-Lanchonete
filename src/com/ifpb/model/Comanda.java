package com.ifpb.model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Comanda{

    private List<Pedido> pedidos = new ArrayList<>();
    private int numeroComanda;
    private boolean comandaAberta;
    private LocalDate data;

    public Comanda(int numeroComanda) {
        this.numeroComanda = numeroComanda;
        this.comandaAberta = true;
        this.data = data.now();
    }

    public boolean isComandaAberta() {
        return comandaAberta;
    }

    public void setComandaAberta(boolean comandaAberta) {
        this.comandaAberta = comandaAberta;
    }

    public LocalDate getData() {
        return data;
    }

    public int getNumeroComanda(){
        return this.numeroComanda;
    }


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

    public int compareTo(LocalDate inicio, LocalDate fim){
        return fim.getDayOfMonth() - inicio.getDayOfMonth();
    }
}