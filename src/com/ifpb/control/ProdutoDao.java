package com.ifpb.control;

import com.ifpb.model.Produto;

import java.io.IOException;
import java.util.Set;

public interface ProdutoDao {
    boolean salvar(Produto p) throws ClassNotFoundException, IOException;
    boolean deletarPorCodigo(int codigo) throws ClassNotFoundException, IOException;
    boolean atualizar(Produto p) throws ClassNotFoundException, IOException;
    Produto buscarPorCodigo(int codigo) throws ClassNotFoundException, IOException;
    Set<Produto> getProdutos() throws ClassNotFoundException, IOException;
}