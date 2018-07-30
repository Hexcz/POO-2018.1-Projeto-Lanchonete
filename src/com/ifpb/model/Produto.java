package com.ifpb.Lanchonete.model;

public class Produto {

    private int Codigo;
    private double Preço;
    private String Nome;
    private String Descricao;
    private String Categoria;

    public Produto(int Codigo, double Preço, String Nome, String Descricao, String Categoria){
        this.Codigo = Codigo;
        this.Preço = Preço;
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

    public double getPreço() {
        return Preço;
    }

    public void setPreço(double preço) {
        Preço = preço;
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
