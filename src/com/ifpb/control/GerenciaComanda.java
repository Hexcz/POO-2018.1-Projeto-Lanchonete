package com.ifpb.control;

import com.ifpb.model.Comanda;
import com.ifpb.model.Pedido;
import com.ifpb.model.Produto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GerenciaComanda {

    private List<Comanda> comandas = new ArrayList<>();

    //verifica se uma comanda esta contida na lista
    private boolean isPresente(Comanda comanda){
        int numero = comanda.getNumeroComanda();

        for(Comanda c : comandas){
            //para cada comanda c, e comparado seu numero, para verificar se ela pertence a lista verificada
            if(c.getNumeroComanda() == numero){
                return true;
            }
        }
        return false;
    }

    //busca uma comanda a partir do numero da comanda
    private Comanda buscarComanda(int numComanda){
        for(Comanda c : comandas){
            if(c.getNumeroComanda() == numComanda){
                return c;
            }
        }
        return null;
    }


    //essa funçao serve para adicionar uma nova comanda a lista de comandas
    public boolean abrirComanda(Comanda novaComanda){
        if(!isPresente(novaComanda)){
            comandas.add(novaComanda);
            return true;
        }
        return false;
    }

    //essa funcao serve para encerrar uma comanda sem a excluir
    public boolean fecharComanda(Comanda comanda){
        if(isPresente(comanda)){
            comanda.setComandaAberta(false);
            return true;
        }
            return false;
    }

    //retorna uma lista de pedidos que estao contidos numa determinada comanda
    public List<Pedido> listarPedidos(int numComanda){

        Comanda tempPedidos = buscarComanda(numComanda);

        if(tempPedidos == null){
            return null;
        }

        List<Pedido> tempList = new ArrayList<>();
        Produto prod;

        for(Pedido p : tempList){
            tempList.add(p);
        }
        return tempList;
    }

    //busca em uma lista de comandas, aquelas inseridas dentre o intervalo requisitados
    public List<Comanda> between(LocalDate dataInicio, LocalDate dataFim){
        List<Comanda> tempoCmd = new ArrayList<>();

        for(Comanda comanda : comandas){
            //o compareTo foi implementado na classe comanda e aqui e verificado se a data da comanda esta entre o intervalo
            if(comanda.getData().compareTo(dataInicio)>=0 && comanda.getData().compareTo(dataFim)<=0){
                tempoCmd.add(comanda);
            }
        }
        return tempoCmd;
    }

}
