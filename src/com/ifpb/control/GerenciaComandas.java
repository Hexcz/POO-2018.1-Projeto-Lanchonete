package com.ifpb.control;

import com.ifpb.model.Comanda;
import com.ifpb.model.Pedido;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Esta classe controla as entradas e saídas de dados referentes às comandas do sistema da lanchonete.
 * @author Hezcz
 * @author lethiciacl
 * @version 1.0
 * @since 1.0
 * */

public class GerenciaComandas {

    private Set<Comanda> comandas;

    /**
     * CONSTRUTORES.
     * */

    public GerenciaComandas(){
        comandas = new HashSet<>();
    }

    /**
     * Esta função tem por objetivo encontrar uma comanda na lista com base no seu número.
     * @param numComanda - a função recebe como parâmetro um inteiro que corresponde ao identificador da comanda.
     * @return c - caso encontre a comanda cujo numero corresponde a algum presente na lista.
     * @return null - caso não encontre nenhuma comanda correspondente.
     * */

    private Comanda findComanda(int numComanda){
        for(Comanda c : comandas){
            if(c.getNumeroComanda() == numComanda){
                return c;
            }
        }
        return null;
    }

    /**
     * Esta função tem por objetivo criar uma nova comanda.
     * @param novaComanda - recebe um objeto do tipo Comanda.
     * @return true - se a adição foi feita com sucesso.
     * @return false - se a adição não foi feita com sucesso.
     * */

    public boolean create(Comanda novaComanda){
        return comandas.add(novaComanda);
    }

    /**
     * Esta função tem por objetivo fechar uma comanda em aberto.
     * @param comanda - recebe a comanda que se deseja fechar.
     * @return true - se a exclusão foi feita com sucesso.
     * @return false - se a exclusão não foi feita com sucesso.
     * */

    public boolean closeComanda(Comanda comanda){
        if(comandas.contains(comanda)){
            comanda.setComandaAberta(false);
            return true;
        }
        return false;
    }

    /**
     * Esta função tem por objetivo listar todas as comandas armazenadas na lista de comandas.
     * @param numComanda - recebe um inteiro que corresponde ao identificador da comanda.
     * @return list - retorna uma lista de Pedidos.
     * */

    public Set<Pedido> listPedidos(int numComanda){
        Comanda c = findComanda(numComanda);
        Set<Pedido> listaPedidos  = c.list();
        return listaPedidos;
    }

    /**
     * Esta função tem por objetivo retornar uma lista de Comandas de um dado intervalo de tempo.
     * @param dataInicio - recebe um LocalDate que indica a data mais antiga que a comanda deve ter para ser selecionada.
     * @param dataFim - recebe um LocalDate que indica a data mais recente que a comanda deve ter para ser selecionada.
     * @return list - retorna uma lista de Comandas.
     * */

    public Set<Comanda> betweenDates(LocalDate dataInicio, LocalDate dataFim){
        Set<Comanda> tempoCmd = new HashSet<>();

        for(Comanda comanda : comandas){
            if(comanda.getData().compareTo(dataInicio)>=0 && comanda.getData().compareTo(dataFim)<=0){
                tempoCmd.add(comanda);
            }
        }
        return tempoCmd;
    }

}