package com.ifpb.model;

import java.io.Serializable;
import java.io.SerializablePermission;
import java.util.Objects;

/**
 * Esta função tem por objetivo modelar a entidade Produto do sistema da Lanchonete.
 * @author Hexcz
 * @author lethiciacl
 * @version 1.0
 * @since 1.0
 * */

public class Produto implements Serializable {

    private String codigo;
    private double preco;
    private String nome;
    private String descricao;

    /**
     * CONSTRUTORES.
     * */

    public Produto(String codigo, double preco, String nome, String descricao) {
        this.codigo = codigo;
        this.preco = preco;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Produto(String codigo){
        this.codigo = codigo;
    }

    /**
     * GETTERS AND SETTERS.
     * */

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;

        Produto produto = (Produto) o;

        return getCodigo().equals(produto.getCodigo());
    }

    @Override
    public int hashCode() {
        return getCodigo().hashCode();
    }

    /**
     * MÉTODOS SOBRESCRITOS.
     * */



    @Override
    public String toString() {
        return ":.:.:.:.:Produto:.:.:.:.:" +
                "\ncodigo: " + codigo +
                "\npreco: " + preco +
                "\nnome: " + nome + '\'' +
                "\ndescricao: " + descricao + '\'';
    }
}
