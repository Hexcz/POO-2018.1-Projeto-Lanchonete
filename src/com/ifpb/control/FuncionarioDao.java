package com.ifpb.control;

import com.ifpb.exceptions.CampoNuloException;
import com.ifpb.exceptions.IdadeInvalidaException;
import com.ifpb.model.Funcionario;

import java.io.IOException;
import java.util.Set;

public interface FuncionarioDao {
    boolean salvar(Funcionario f) throws IOException, ClassNotFoundException, CampoNuloException, IdadeInvalidaException;
    boolean deletarPorUsername(String username) throws IOException, ClassNotFoundException;
    boolean atualizar(Funcionario f) throws IOException, ClassNotFoundException;
    Funcionario buscarPorUsername(String username) throws IOException, ClassNotFoundException;
    Funcionario buscarPorCpf(String cpf) throws IOException, ClassNotFoundException;
    Funcionario buscarPorEmail(String email) throws IOException, ClassNotFoundException;
    Set<Funcionario> getFuncionarios() throws IOException, ClassNotFoundException;
}
