package com.ifpb.control;

import com.ifpb.model.Funcionario;
import com.ifpb.model.Produto;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class ProdutoImpDao implements ProdutoDao {

    private File file;

    public ProdutoImpDao() throws IOException{
        file = new File("Cardapio");

        if(!file.exists()){
            file.createNewFile();
        }
    }

    private void attArchive(Set<Produto> cardapio) throws IOException{
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
            out.writeObject(cardapio);
        }
    }

    @Override
    public Set<Produto> getProdutos() throws ClassNotFoundException, IOException {
        if(file.length()>0){
            try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
                return (Set<Produto>) in.readObject();
            }
        }else{
            return new HashSet<>();
        }
    }

    @Override
    public boolean salvar(Produto p) throws ClassNotFoundException, IOException {
        Set<Produto> cardapio = getProdutos();
        if(cardapio.add(p)){
            attArchive(cardapio);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deletarPorCodigo(int codigo) throws ClassNotFoundException, IOException {
        Set<Produto> cardapio = getProdutos();
        Produto prod = new Produto(codigo);
        if(cardapio.remove(prod)){
            attArchive(cardapio);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean atualizar(Produto p) throws ClassNotFoundException, IOException {
        Set<Produto> cardapio = getProdutos();
        Produto prod1 = new Produto(p.getCodigo());
        if(cardapio.remove(prod1)){
            cardapio.add(p);
            attArchive(cardapio);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Produto buscarPorCodigo(int codigo) throws ClassNotFoundException, IOException {
        Set<Produto> cardapio = getProdutos();
        for(Produto p : cardapio){
            if(p.getCodigo() == codigo){
                return p;
            }
        }
        return null;
    }

}
