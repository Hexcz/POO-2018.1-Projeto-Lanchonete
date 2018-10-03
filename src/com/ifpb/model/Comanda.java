package com.ifpb.model;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Esta classe tem por objetivo modelar a entidade comanda do sistema da Lanchonete.
 * @author Hexcz
 * @author lethiciacl
 * @version 1.0
 * @since 1.0
 * */

public class Comanda implements Serializable {

    private Set<Pedido> comanda;
    private static int numeroComanda = 0;
    private boolean comandaAberta;
    private LocalDate data;


    /**
     * CONSTRUTORES.
     * */

    public Comanda() {
        comanda = new HashSet<>();
        this.numeroComanda = numeroComanda++;
        this.comandaAberta = true;
        this.data = data.now();
    }

    /**
     * GETTERS AND SETTERS.
     * */

    public boolean isComandaAberta() {
        return comandaAberta;
    }

    public void setComandaAberta(boolean comandaAberta) {
        this.comandaAberta = comandaAberta;
    }

    public LocalDate getData() {
        return data;
    }

    public int getNumeroComanda(){
        return this.numeroComanda;
    }

   /**
    * Esta função tem por objetivo criar um novo pedido na comanda.
    * @param pedido - recebe um objeto do tipo Pedido.
    * @return true  - se o pedido foi adicionado com sucesso à comanda.
    * @return false - se o pedido não foi adicionado com sucesso à comanda.
    * */

    public boolean create (Pedido pedido){
        return comanda.add(pedido);
    }

    /**
     * Esta função tem por objetivo ler um determinado pedido a partir do seu código.
     * @param codPedido - recebe como parâmetro um inteiro que corresponde ao identificador do pedido.
     * @return p - se encontrar na comanda o pedido cujo código corresponde ao informado.
     * @return null - se não encontrar o pedido correspondente ao código informado.
     * */

    public Pedido read (int codPedido){
        for (Pedido p : comanda) {
            if (codPedido == p.getNumPedido()) {
                return p;
            }
        }
        return null;
    }

    /**
     * Esta função tem por objetivo atualizar um pedido existente na comanda.
     * @param pedido - recebe um objeto do tipo Pedido.
     * @return true - se o pedido foi alterado com sucesso.
     * @return false - se o pedido não foi alterado com sucesso.
     * */

    public boolean update(Pedido pedido){
        for(Pedido p : comanda){
            if(p.getNumPedido() == pedido.getNumPedido()){
                if(!pedido.isAtendido()){
                    comanda.remove(p);
                    return comanda.add(pedido);
                }
            }
        }
                    return false;
    }

    /**
     * Esta função tem por objetivo excluir um pedido da comanda.
     * @param pedido - recebe um objeto do tipo Pedido.
     * @return true - se a exclusão foi feita com sucesso.
     * @return false - se a exclusão não foi feita com sucesso.
     * */

    public boolean delete(Pedido pedido){
        for(Pedido p : comanda){
            if(p.getNumPedido() == pedido.getNumPedido()){
                if(!p.isAtendido()){
                    return comanda.remove(p);
                }
            }
        }
                    return false;
    }

    /**
     * Esta função tem por objetivo listar os pedidos contidos em uma comanda.
     * @return list - retorna uma lista de Pedidos.
     * */

    public Set<Pedido> list(){
        return comanda;
    }

    /***
     * Esta função tem por objetivo calcular o valor total gasto dentro de uma comanda.
     * @return double - a função retorna um double que corresponde ao valor total gasto.
     */

    public double calcTotal(){
        double total = 0;
        for (Pedido p : comanda) {
            if(p.isAtendido()){
                total += p.calcSubTotal();
            }
        }
        return total;
    }

    /**
     * Esta função tem por objetivo comparar duas datas.
     * @param inicio - recebe um LocalDate que equivale a data de início.
     * @param fim - recebe um LocalDate que equivale a data de fim.
     * @return integer - um inteiro que corresponde a diferença entre os dias.
     * */

    public int compareTo(LocalDate inicio, LocalDate fim){
        return fim.getDayOfMonth()-inicio.getDayOfMonth();
    }
}