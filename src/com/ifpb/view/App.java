package com.ifpb.view;

import com.ifpb.model.*;

import java.time.LocalDate;

public class App {
    public static void main(String args[]){
        Comanda comanda = new Comanda();
        Produto cafe = new Produto(10,3.55, "Expresso", "Cafe de fresco", CategoriaProduto.BEBIDA);
        Produto xtudo = new Produto(4,15, "X-Tudo", "Pão, presunto, mussarela", CategoriaProduto.LANCHE);
        Pedido pedido = new Pedido(cafe, 2, 1);
        Pedido pedido1 = new Pedido(xtudo, 2, 2);
        pedido.setAtendido();
        pedido1.setAtendido();
        comanda.create(pedido);
        comanda.create(pedido1);
        System.out.println(comanda.calcTotal());
    }
}
