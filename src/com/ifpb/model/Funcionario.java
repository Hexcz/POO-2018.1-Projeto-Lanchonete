package com.ifpb.Lanchonete.model;

import java.time.LocalDate;

public class Funcionario {

    private String CPF;
    private String Nome;
    private String Email;
    private int Numero;
    private LocalDate DataNascimento;
    private String Setor;

    public Funcionario(String CPF, String Nome, String Email, int Numero, LocalDate DataNascimento, String Setor) {
        this.CPF = CPF;
        this.Nome = Nome;
        this.Email = Email;
        this.Numero = Numero;
        this.DataNascimento = DataNascimento;
        this.Setor = Setor;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int numero) {
        Numero = numero;
    }

    public LocalDate getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        DataNascimento = dataNascimento;
    }

    public String getSetor() {
        return Setor;
    }

    public void setSetor(String setor) {
        Setor = setor;
    }


}