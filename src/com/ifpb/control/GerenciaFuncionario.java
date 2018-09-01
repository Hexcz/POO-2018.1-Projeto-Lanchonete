package com.ifpb.control;
import com.ifpb.model.Funcionario;
import java.util.List;
import java.util.ArrayList;

public class GerenciaFuncionario {

    private List<Funcionario> funcionarios;

    public GerenciaFuncionario(){
        funcionarios = new ArrayList<>();
    }

    private int searchIndex(Funcionario funcionario){
        return funcionarios.indexOf(funcionario);
    }

    public boolean create(Funcionario funcionario){
        if(searchIndex(funcionario)<0){
           funcionarios.add(funcionario);
            return true;
        }
        return false;
    }

    public boolean delete(Funcionario funcionario){
       int posicao = searchIndex(funcionario);

       if(posicao<0) {
           return false;
       }

       funcionarios.remove(funcionario);
       return true;
    }

    public Funcionario read(String cpf){

        for(Funcionario f : funcionarios){
            if(f.getCpf().equals(cpf)){
                return f;
            }
        }
        return null;
    }

    public boolean update(Funcionario funcionario){
        for(Funcionario f : funcionarios){
            if(f.getCpf() == funcionario.getCpf()){
                funcionarios.set(funcionarios.indexOf(f), funcionario);
                return true;
            }
        }
        return false;
    }

    public List<Funcionario> list(){
        return funcionarios;
    }

}
