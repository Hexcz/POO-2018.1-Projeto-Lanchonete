package com.ifpb.control;

import com.ifpb.model.Funcionario;

import java.io.IOException;
import java.util.Set;

public interface FuncionarioDao {
    boolean salvar(Funcionario f) throws IOException, ClassNotFoundException;
    Funcionario buscarPorUsername(String username) throws IOException, ClassNotFoundException;
    boolean deletarPorUsername(String username) throws IOException, ClassNotFoundException;
    boolean atualizar(Funcionario f) throws IOException, ClassNotFoundException;
    Set<Funcionario> getFuncionarios() throws IOException, ClassNotFoundException;
}
