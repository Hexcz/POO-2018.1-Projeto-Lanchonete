package com.ifpb.Lanchonete.control;
import com.ifpb.Lanchonete.model.Funcionario;

import java.util.Arrays;

public class GerenciaFuncionario <T>{

    private T[] funcionarios;
    int quantidade;

    public GerenciaFuncionario(){
        funcionarios = (T[]) new Funcionario[2];
        quantidade = 0;
    }

    private void aumentarArray(){
        funcionarios = Arrays.copyOf(funcionarios, funcionarios.length*2);
    }

    private boolean isFull(){
        if(quantidade > funcionarios.length){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean adicionarFuncionario(T funcionario){
        if(isFull()){
            aumentarArray();
        }
        funcionarios[quantidade++] = funcionario;
        return true;
    }


    public int buscarPosicao(T funcionario){
        for(int i = 0; i<funcionarios.length; i++){
            if(funcionarios[i].equals(funcionario)){
                return i;
            }
        }
        return -1;
    }


    public boolean deletaFuncionario(T funcionario){
           int posicao = buscarPosicao(funcionario);
           if(posicao<0){
               return false;
           }
           for(int i = posicao; i<quantidade; i--){
               funcionarios[i] = funcionarios[i+1];
           }
           quantidade--;
           return true;
    }

    public T buscarFuncionario(T funcionario){

        for(int i = 0; i<funcionarios.length; i++){
            if(funcionarios[i].equals(funcionario)){
                return funcionario;
            }
        }

        return null;

    }

    public boolean atualizarFuncionario(T funcionario){
        int posicao = buscarPosicao(funcionario);

        if(posicao<0){
            return false;
        }

        funcionarios[posicao] = funcionario;
        return true;
    }

    public T[] listarFuncionarios(){
        return Arrays.copyOfRange(funcionarios, 0, quantidade);
    }

}
