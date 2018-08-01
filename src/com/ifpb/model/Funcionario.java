package com.ifpb.model;

import java.time.LocalDate;

public class Funcionario {

    private String Login;
    private String Senha;
    private String CPF;
    private String Nome;
    private String Email;
    private String Telefone;
    private LocalDate DataNascimento;
    private String Setor;

    public Funcionario(String Login, String Senha, String CPF, String Nome, String Email, String Telefone, LocalDate DataNascimento, String Setor) {
        this.Login = Login;
        this.Senha = Senha;
        this.CPF = CPF;
        this.Nome = Nome;
        this.Email = Email;
        this.Telefone = Telefone;
        this.DataNascimento = DataNascimento;
        this.Setor = Setor;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
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

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
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