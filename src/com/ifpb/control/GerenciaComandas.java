package com.ifpb.control;

import com.ifpb.model.Comanda;
import com.ifpb.model.Pedido;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GerenciaComandas {

    private List<Comanda> comandas = new ArrayList<>();

    private boolean isPresente(Comanda comanda){
        for(Comanda c : comandas){
            if(c.equals(comanda)){
                return true;
            }
        }
        return false;
    }

    private Comanda buscarComanda(int numComanda){
        for(Comanda c : comandas){
            if(c.getNumeroComanda() == numComanda){
                return c;
            }
        }
        return null;
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

    public List<Pedido> listRequests(int numComanda){
        Comanda c = buscarComanda(numComanda);
        List<Pedido> listaPedidos  = c.list();
        return listaPedidos;
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