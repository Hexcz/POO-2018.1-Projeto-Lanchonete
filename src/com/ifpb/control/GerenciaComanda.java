package com.ifpb.control;

import com.ifpb.model.Comanda;
import com.ifpb.model.Pedido;
import com.ifpb.model.Produto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GerenciaComanda {

    private List<Comanda> comandas = new ArrayList<>();

    private boolean isPresente(Comanda comanda){
        int numero = comanda.getNumeroComanda();

        for(Comanda c : comandas){
            if(c.getNumeroComanda() == numero){
                return true;
            }
        }
        return false;
    }

    public boolean abrirComanda(Comanda novaComanda){
        if(!isPresente(novaComanda)){
            comandas.add(novaComanda);
            return true;
        }
        return false;
    }

    public boolean fecharComanda(Comanda comanda){
        if(isPresente(comanda)){
            comanda.setComandaAberta(false);
            return true;
        }
            return false;
    }

    public List<Pedido> listarPedidos(List<Pedido> comanda){
        List<Pedido> tempList = new ArrayList<>();
        Produto prod;

        for(Pedido p : comanda){
            tempList.add(p);
        }
        return tempList;
    }

    public Comanda findComanda(Comanda comanda){
        for(Comanda c : comandas){
            if(c.equals(comanda)){
                return c;
            }
        }
        return null;
    }

    public List<Comanda> between(LocalDate dataInicio, LocalDate dataFim){
        List<Comanda> tempoCmd = new ArrayList<>();

        for(Comanda comanda : comandas){
            if(comanda.getData().compareTo(dataInicio)>=0 && comanda.getData().compareTo(dataFim)<=0){
                tempoCmd.add(comanda);
            }
        }
        return tempoCmd;
    }

}
