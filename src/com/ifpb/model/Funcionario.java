package com.ifpb.model;

import java.time.LocalDate;
import java.util.Objects;

public class Funcionario {

    private String login;
    private String senha;
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private Setor setor;

    public Funcionario(String login, String senha, String cpf, String nome, String email, String telefone, LocalDate dataNascimento, Setor setor) {
        this.login = login;
        this.senha = senha;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.setor = setor;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Funcionario)) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(getLogin(), that.getLogin()) &&
                Objects.equals(getSenha(), that.getSenha()) &&
                Objects.equals(getCpf(), that.getCpf()) &&
                Objects.equals(getNome(), that.getNome()) &&
                Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getTelefone(), that.getTelefone()) &&
                Objects.equals(getDataNascimento(), that.getDataNascimento()) &&
                getSetor() == that.getSetor();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getLogin(), getSenha(), getCpf(), getNome(), getEmail(), getTelefone(), getDataNascimento(), getSetor());
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", setor=" + setor +
                '}';
    }
}