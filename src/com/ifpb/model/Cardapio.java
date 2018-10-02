package com.ifpb.model;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

/**
 * @author David
 * @author Lethícia
 * @version 1.0
 * @since 1.0
 * */

public class Cardapio {

    private Set<Produto> produtos;

    /**
     * CONSTRUTORES.
     * */

    public Cardapio(){
        produtos = new HashSet<>();
    }

    /**
     * Esta função tem por função retorna a lista de produtos, cardápio.
     * @return List - esta função retorna uma lista de objetos do tipo Produto.
     * */

    public Set<Produto> list(){
        return produtos;
    }

    /**
     * Esta função tem por objetivo criar e adicionar um novo produto à Lista.
     * @param produto - esta função recebe um parâmetro do tipo Produto que será inserido.
     * @return boolean - esta função retorna um booleano para verificar se a crianção teve sucesso ou não.
     * */

    public boolean create(Produto produto){
        return produtos.add(produto);
    }

    /**
     * Esta função tem por objetivo ler as informações de um produto.
     * @param codigo - recebe um parâmetro do tipo String que identifica o produto que será lido.
     * @return Produto - retorna um objeto do tipo Produto que corresponde ao código informado.
     * */

    public Produto read(String codigo){
        for (Produto p : produtos) {
            if (p.getCodigo().equals(codigo)) {
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
            if(p.getCodigo().equals(produto.getCodigo())){
                produtos.remove(p);
                return produtos.add(produto);
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
        return produtos.remove(produto);
    }
}
