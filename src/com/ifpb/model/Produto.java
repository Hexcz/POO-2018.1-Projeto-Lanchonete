package com.ifpb.model;

public class Produto {

    private int Codigo;
    private double Preco;
    private String Nome;
    private String Descricao;
    private String Categoria;

    public Produto(int Codigo, double Preco, String Nome, String Descricao, String Categoria){
        this.Codigo = Codigo;
        this.Preco = Preco;
        this.Nome = Nome;
        this.Descricao = Descricao;
        this.Categoria = Categoria;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public double getPreco() {
        return Preco;
    }

    public void setPreco(double preco) {
        Preco = preco;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }
}
