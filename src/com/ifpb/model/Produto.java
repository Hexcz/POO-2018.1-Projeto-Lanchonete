package com.ifpb.model;

import java.util.Objects;

public class Produto {

    private int codigo;
    private double preco;
    private String nome;
    private String descricao;
    private CategoriaProduto categoria;

    public Produto(int codigo, double preco, String nome, String descricao, CategoriaProduto categoria) {
        this.codigo = codigo;
        this.preco = preco;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProduto categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return getCodigo() == produto.getCodigo() &&
                Double.compare(produto.getPreco(), getPreco()) == 0 &&
                Objects.equals(getNome(), produto.getNome()) &&
                Objects.equals(getDescricao(), produto.getDescricao()) &&
                getCategoria() == produto.getCategoria();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCodigo(), getPreco(), getNome(), getDescricao(), getCategoria());
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", preco=" + preco +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", categoria=" + categoria +
                '}';
    }
}
