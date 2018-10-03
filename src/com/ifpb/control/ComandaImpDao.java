package com.ifpb.control;

import com.ifpb.model.Comanda;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class ComandaImpDao implements ComandaDao {

    private File file;

    public ComandaImpDao() throws IOException{
        file = new File("Comanda");

        if(!file.exists()){
            file.createNewFile();
        }
    }

    private void attArchive(Set<Comanda> comandas) throws IOException {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
            out.writeObject(file);
        }
    }

    @Override
    public Set<Comanda> getComandas() throws ClassNotFoundException, IOException {
        if(file.length()>0){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
            return (Set<Comanda>) in.readObject();
        }}else{
            return new HashSet<>();
        }
    }

    @Override
    public boolean salvar(Comanda c) throws ClassNotFoundException, IOException {
        Set<Comanda> comandas = getComandas();
        if(comandas.add(c)){
            attArchive(comandas);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean atualizar(Comanda comanda) throws ClassNotFoundException, IOException {
        Set<Comanda> comandas = getComandas();
        Comanda c = new Comanda(comanda.getNumeroComanda());
        if(comandas.remove(c)){
            comandas.add(comanda);
            attArchive(comandas);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deletar(Comanda comanda) throws ClassNotFoundException, IOException {
        Set<Comanda> comandas = getComandas();
        Comanda c = new Comanda(comanda.getNumeroComanda());
        if(comandas.contains(c)){
            comanda.setComandaAberta(false);
            comandas.remove(c);
            comandas.add(comanda);
            attArchive(comandas);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Comanda buscarPorNumero(int numero) throws ClassNotFoundException, IOException {
        Set<Comanda> comandas = getComandas();
        for(Comanda comanda : comandas){
            if(comanda.getNumeroComanda() == numero){
                return comanda;
            }
        }
        return null;
    }

    @Override
    public Set<Comanda> buscarEmAberto() throws IOException, ClassNotFoundException{
        Set<Comanda> comandas = getComandas();
        Set<Comanda> comandasAbertas = new HashSet<>();
        for(Comanda c : comandas){
            if(c.isComandaAberta()){
                comandasAbertas.add(c);
            }
        }
        return comandasAbertas;
    }
}
