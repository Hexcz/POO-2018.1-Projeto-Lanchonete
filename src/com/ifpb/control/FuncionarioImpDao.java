package com.ifpb.control;

import com.ifpb.model.Funcionario;
import com.sun.corba.se.spi.legacy.interceptor.ORBInitInfoExt;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class FuncionarioImpDao implements FuncionarioDao {

    private File file;

    public FuncionarioImpDao() throws IOException{
        file = new File("Funcionarios");

        if(!file.exists()){
            file.createNewFile();
        }
    }

    @Override
    public boolean salvar(Funcionario f) throws IOException, ClassNotFoundException {
        Set<Funcionario> funcionarios = getFuncionarios();

        if (funcionarios.add(f)) {
            attArchive(funcionarios);
            return true;
        } else {
            return false;
        }
    }

    private void attArchive(Set<Funcionario> f) throws IOException, FileNotFoundException{
        try(ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(file)
        )){
            out.writeObject(f);
        }
    }

    @Override
    public Funcionario buscarPorUsername(String username) throws IOException, ClassNotFoundException {
        Set<Funcionario> funcionarios = getFuncionarios();
        for(Funcionario f : funcionarios){
            if(f.getUsername().equals(username)){
                return f;
            }
        }
        return null;
    }

    @Override
    public Funcionario buscarPorCpf(String cpf) throws IOException, ClassNotFoundException {
        Set<Funcionario> funcionarios = getFuncionarios();
        for(Funcionario f : funcionarios){
            if(f.getCpf().equals(cpf)){
                return f;
            }
        }
        return null;
    }

    @Override
    public Funcionario buscarPorEmail(String email) throws IOException, ClassNotFoundException {
        Set<Funcionario> funcionarios = getFuncionarios();
        for(Funcionario f : funcionarios){
            if(f.getEmail().equals(email)){
                return f;
            }
        }
        return null;
    }

    @Override
    public boolean atualizar(Funcionario funcionario) throws IOException, ClassNotFoundException {
        Set<Funcionario> funcionarios = getFuncionarios();

        Funcionario func = buscarPorUsername(funcionario.getUsername());

        if(funcionarios.remove(func)){
            funcionarios.add(funcionario);
            attArchive(funcionarios);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deletarPorUsername(String username) throws IOException, ClassNotFoundException{
        Set<Funcionario> funcionarios = getFuncionarios();

        Funcionario func = buscarPorUsername(username);
        if(funcionarios.remove(func)){
            attArchive(funcionarios);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Set<Funcionario> getFuncionarios() throws IOException, ClassNotFoundException{
        if(file.length()>0){
            try(ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(file)
            )){
                return (Set<Funcionario>) in.readObject();
            }
        }else{
            return new HashSet<>();
        }
    }
}
