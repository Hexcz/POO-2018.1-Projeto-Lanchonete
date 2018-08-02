package com.ifpb.model;

import java.util.List;
import java.util.ArrayList;

public class Cardapio {
    private List<Produto> produtos = new ArrayList<>();

    public List<Produto> list(){
        return produtos;
    }

    public boolean create(Produto produto){
        return produtos.add(produto);
    }

    public Produto read(int codigo){
        for (Produto p: produtos) {
            if (codigo == p.getCodigo()) {
                return p;
            }
        }
        return null;
    }

    public boolean update(Produto produto){
        for (int i = 0; i < produtos.size(); i++){
            if (produto.getCodigo() == produtos.get(i).getCodigo()) {
                produtos.set(i, produto);
                return true;
            }
        }
        return false;
    }

    public boolean delete(Produto produto){
        return produtos.remove(produto);
    }
}
