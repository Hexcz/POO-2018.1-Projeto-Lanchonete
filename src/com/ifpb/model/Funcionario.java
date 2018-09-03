package com.ifpb.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Hexcz
 * @author Lethícia
 * @version 1.0
 * */

public class Funcionario implements autenticarFuncionario{

    private String username;
    private String senha;
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private Setor setor;

    public Funcionario(String username, String senha, String cpf, String nome, String email, String telefone, LocalDate dataNascimento, Setor setor) {
        this.username = username;
        this.senha = senha;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.setor = setor;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

        if (!getUsername().equals(that.getUsername())) return false;
        if (!getSenha().equals(that.getSenha())) return false;
        if (!getCpf().equals(that.getCpf())) return false;
        if (!getNome().equals(that.getNome())) return false;
        if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) return false;
        if (getTelefone() != null ? !getTelefone().equals(that.getTelefone()) : that.getTelefone() != null)
            return false;
        if (getDataNascimento() != null ? !getDataNascimento().equals(that.getDataNascimento()) : that.getDataNascimento() != null)
            return false;
        return getSetor() == that.getSetor();
    }

    @Override
    public int hashCode() {
        int result = getUsername().hashCode();
        result = 31 * result + getSenha().hashCode();
        result = 31 * result + getCpf().hashCode();
        result = 31 * result + getNome().hashCode();
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getTelefone() != null ? getTelefone().hashCode() : 0);
        result = 31 * result + (getDataNascimento() != null ? getDataNascimento().hashCode() : 0);
        result = 31 * result + getSetor().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return ":.:.:.:Funcionario:.:.:.:" +
                "\nUsername: " + username + '\'' +
                "\nSenha: " + senha + '\'' +
                "\nCPF: " + cpf + '\'' +
                "\nNome: " + nome + '\'' +
                "\nE-mail: " + email + '\'' +
                "\nTelefone: " + telefone + '\'' +
                "\nData de nascimento: " + dataNascimento +
                "\nSetor: " + setor;
    }


    /**
     * Esta função tem por objetivo a verificação de um nome de usuário para autenticação do login.
     * @param username String - recebe uma string que corresponde ao nome de usuário
     * @return boolean - verdadeiro se o username for correspondente ao armazenado e falso se não for.
     * */

    @Override
    public boolean verifyUsername(String username){
        if(username.equals(this.username)){
            return true;
        }
        return false;
    }

    /**
     * Esta função tem por objetivo a verificação de uma senha para a autenticação do login.
     * @param password String - a função recebe uma string que corresponde a chave de segurança da conta.
     * @return boolean - retorna falso caso a senha armazenada e a inserida não sejam compatíveis ou verdadeiro caso elas sejam.
     * */

    @Override
    public boolean verifyPassword(String password){
        if(password.equals(this.senha)){
            return true;
        }
        return false;
    }

    /**
     * Esta função tem por objetivo a verificação que tanto o nome de usuário como a senha estão corretas para efetuação do login.
     * @param username - uma string correspondente ao nome usuário.
     * @param password - uma string correspondente à senha.
     * @return boolean - um boolean que corresponde a verdade se tanto senha como username forem compatíveis e falso caso não sejam.
     * */

    @Override
    public boolean verifyLogin(String username, String password){
        if(verifyUsername(username) && verifyPassword(password)){
            return true;
        }
        else{
            return false;
        }
    }

}