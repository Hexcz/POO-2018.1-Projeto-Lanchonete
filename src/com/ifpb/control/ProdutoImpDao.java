package com.ifpb.control;

import com.ifpb.exceptions.CampoNuloException;
import com.ifpb.exceptions.PrecoInvalidoException;
import com.ifpb.model.Produto;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class ProdutoImpDao implements ProdutoDao {

    private File file;

    public ProdutoImpDao() throws IOException{
        file = new File("Produtos");

        if(!file.exists()){
            file.createNewFile();
        }
    }

    @Override
    public boolean salvar(Produto p) throws IOException, ClassNotFoundException, CampoNuloException, PrecoInvalidoException {
        Set<Produto> produtos = getProdutos();
        if (p.getCodigo().equals("") | p.getNome().equals("") | p.getDescricao().equals("")){
            throw new CampoNuloException("Campos com * são obrigatórios!");
        }
        if(p.getPreco() <= 0){
            throw new PrecoInvalidoException("O preço não pode ser menor ou igual a zero!");
        }
        if (produtos.add(p)) {
            attArchive(produtos);
            return true;
        } else {
            return false;
        }
    }

    private void attArchive(Set<Produto> p) throws IOException, FileNotFoundException{
        try(ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(file)
        )){
            out.writeObject(p);
        }
    }

    @Override
    public Produto buscarPorCodigo(String codigo) throws IOException, ClassNotFoundException {
        Set<Produto> produtos = getProdutos();
        for(Produto p : produtos){
            if(p.getCodigo().equals(codigo)){
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean atualizar(Produto p) throws IOException, ClassNotFoundException {
        Set<Produto> produtos = getProdutos();

        Produto prod = buscarPorCodigo(p.getCodigo());

        if(produtos.remove(prod)){
            produtos.add(p);
            attArchive(produtos);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deletarPorCodigo(String codigo) throws IOException, ClassNotFoundException{
        Set<Produto> produtos = getProdutos();

        Produto prod= buscarPorCodigo(codigo);
        if(produtos.remove(prod)){
            attArchive(produtos);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Set<Produto> getProdutos() throws IOException, ClassNotFoundException{
        if(file.length()>0){
            try(ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(file)
            )){
                return (Set<Produto>) in.readObject();
            }
        }else{
            return new HashSet<>();
        }
    }
}
