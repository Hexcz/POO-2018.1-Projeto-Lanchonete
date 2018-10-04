package com.ifpb.control;

import com.ifpb.model.Comanda;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Set;

public interface ComandaDao {
    boolean salvar(Comanda c) throws ClassNotFoundException, IOException;
    boolean atualizar(Comanda c) throws ClassNotFoundException, IOException;
    boolean deletar(Comanda c) throws ClassNotFoundException, IOException;
    Comanda buscarPorNumero(int numero) throws ClassNotFoundException, IOException;
    Set<Comanda> getComandas() throws ClassNotFoundException, IOException;
    Set<Comanda> buscarEmAberto() throws ClassNotFoundException, IOException;
    Set<Comanda> buscarEmIntervalo(LocalDate inicio, LocalDate fim) throws ClassNotFoundException, IOException;
}
