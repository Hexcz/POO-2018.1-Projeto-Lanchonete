package com.ifpb.model;

import java.util.List;
import java.util.ArrayList;

/**
 * @author David
 * @author Lethícia
 * @version 1.0
 * */

public class Cardapio {

    private List<Produto> produtos;

    public Cardapio(){
        produtos = new ArrayList<>();
    }

    /**
     * Esta função tem por função retorna a lista de produtos, cardápio.
     * @return List - esta função retorna uma lista de objetos do tipo Produto.
     * */

    public List<Produto> list(){
        return produtos;
    }

    /**
     * Esta função tem por objetivo criar e adicionar um novo produto à Lista.
     * @param produto - esta função recebe um parâmetro do tipo Produto que será inserido.
     * @return boolean - esta função retorna um booleano para verificar se a crianção teve sucesso ou não.
     * */

    public boolean create(Produto produto){

        if(produtos.indexOf(produto)<0){
            return produtos.add(produto);
        }

        return false;
    }

    /**
     * Esta função tem por objetivo ler as informações de um produto.
     * @param codigo - recebe um parâmetro do tipo inteiro que identifica o produto que será lido.
     * @return Produto - retorna um objeto do tipo Produto que corresponde ao código informado.
     * */

    public Produto read(int codigo){
        for (Produto p : produtos) {
            if (codigo == p.getCodigo()) {
                return p;
            }
        }
        return null;
    }

    /**
     * Esta função tem por objetivo atualizar as informações sobre um produto.
     * @param produto - recebe um parâmetro do tipo Produto que será atualizado.
     * @return boolean - retorna um boolean de forma a verificar se a atualização foi feita com sucesso ou não.
     * */

    public boolean update(Produto produto){
        for(Produto p : produtos){
            if(p.getCodigo() == produto.getCodigo()){
                produtos.set(produtos.indexOf(p), produto);
                return true;
            }
        }
                return false;
    }

    /**
     * Esta função tem por objetivo deletar um produto do cardápio.
     * @param produto - recebe um parâmetro do tipo Produto que será deletado.
     * @return boolean - retorna um boolean de forma a verficar se a exclusão foi feita com sucesso.
     * */

    public boolean delete(Produto produto){

        if(produtos.indexOf(produto)<0){
            return false;
        }else {
            return produtos.remove(produto);
        }
    }
}
