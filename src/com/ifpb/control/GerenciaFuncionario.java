package com.ifpb.control;
import com.ifpb.model.Funcionario;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

/**
 * Esta classe controla a entrada e saída de informações referentes ao cadastro de um funcionário.
 * @author Hexcz
 * @author lethiciacl
 * @version 1.0
 * @since 1.0
 * */

public class GerenciaFuncionario {

    private Set<Funcionario> funcionarios;


    /**
     * CONSTRUTORES.
     * */
    public GerenciaFuncionario(){
        funcionarios = new HashSet<>();
    }

    /**
     * Esta função tem por objetivo verificar se um username já foi cadastrado anteriormente.
     * @param username - recebe um parâmetro do tipo String que corresponde ao nome de usuário.
     * @return true - se o username já existir na lista.
     * @return false - se o username não existir na lista.
     * */

    public boolean searchUsername(String username){
        for(Funcionario f : funcionarios){
            if(f.getUsername().equals(username)){
                return true;
            }
        }
                return false;
    }

    /**
     * Esta função tem por objetivo criar um novo funcionário no conjunto.
     * @param funcionario - recebe um parâmetro do tipo Funcionário.
     * @return true - se foi possível criar o funcionário.
     * @return false - se não foi possível criar o funcionário.
     * */
    public boolean create(Funcionario funcionario){
       return funcionarios.add(funcionario);
    }


    /**
     * Esta função tem por objetivo deletar um funcionário na lista.
     * @param funcionario - recebe um parâmetro do tipo Funcionário.
     * @return true - se foi possível deletar o funcionário.
     * @return false - se não foi possível deletar o funcionário.
     * */

    public boolean delete(Funcionario funcionario){
        return funcionarios.remove(funcionario);
    }

    /**
     * Esta função tem por objetivo buscar um funcionário na lista.
     * @param username - recebe um parâmetro do tipo String.
     * @return f - retorna o funcionário cujo cpf corresponde ao informado.
     * @return null - se não houver funcionário com o cpf informado.
     * */

    public Funcionario read(String username){

        for(Funcionario f : funcionarios){
            if(f.getUsername().equals(username)){
                return f;
            }
        }
        return null;
    }


    /**
     * Esta função tem por objetivo atualizar um funcionário na lista.
     * @param funcionario - recebe um parâmetro do tipo Funcionário.
     * @return true - se foi possível atualizar o funcionário.
     * @return false - se não foi possível atualizar o funcionário.
     * */

    public boolean update(Funcionario funcionario){
        for(Funcionario f : funcionarios){
            if(f.getCpf() == funcionario.getCpf()){
                funcionarios.remove(f);
                return funcionarios.add(funcionario);
            }
        }
        return false;
    }


    /**
     * Esta função tem por objetivo listar os funcionários da lista.
     * @return List - retorna uma lista de funcionários.
     * */

    public Set<Funcionario> list(){
        return funcionarios;
    }

}
