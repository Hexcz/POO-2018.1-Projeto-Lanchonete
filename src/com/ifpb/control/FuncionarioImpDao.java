package com.ifpb.control;

import com.ifpb.exceptions.CampoNuloException;
import com.ifpb.exceptions.IdadeInvalidaException;
import com.ifpb.model.Funcionario;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;

public class FuncionarioImpDao implements FuncionarioDao {

    private File file;

    public FuncionarioImpDao() throws IOException{
        file = new File("arquivos"+File.separator+"Funcionarios");

        if(!file.exists()){
            file.createNewFile();
        }
    }

    @Override
    public boolean salvar(Funcionario f) throws IOException, ClassNotFoundException, CampoNuloException, IdadeInvalidaException {
        Set<Funcionario> funcionarios = getFuncionarios();
        if(ChronoUnit.YEARS.between(f.getDataNascimento(), LocalDate.now())<16 | ChronoUnit.YEARS.between(f.getDataNascimento(), LocalDate.now())>100){
            throw new IdadeInvalidaException("Idade inválida (Idade mínima: 16 anos, Idade máxima: 100 anos).");
        }
        if (f.getNome().equals("") | f.getCpf().equals("   .   .   -  ") | f.getUsername().equals("") | f.getSenha().equals("")){
           throw new CampoNuloException("Campos com * são obrigatórios!");
        }
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
    public boolean atualizar(Funcionario funcionario) throws IOException, ClassNotFoundException, CampoNuloException {
        Set<Funcionario> funcionarios = getFuncionarios();
        if(funcionario.getNome().equals("") | funcionario.getSenha().equals("")){
            throw new CampoNuloException("Campos com * não podem ficar nulos!");
        }
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
