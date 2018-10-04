package com.ifpb.control;

import com.ifpb.exceptions.CampoNuloException;
import com.ifpb.exceptions.PrecoInvalidoException;
import com.ifpb.model.Produto;

import java.io.IOException;
import java.util.Set;

public interface ProdutoDao {
    boolean salvar(Produto p) throws ClassNotFoundException, IOException, CampoNuloException, PrecoInvalidoException;
    boolean deletarPorCodigo(String codigo) throws ClassNotFoundException, IOException;
    boolean atualizar(Produto p) throws ClassNotFoundException, IOException, CampoNuloException, PrecoInvalidoException;
    Produto buscarPorCodigo(String codigo) throws ClassNotFoundException, IOException;
    Set<Produto> getProdutos() throws ClassNotFoundException, IOException;
}
