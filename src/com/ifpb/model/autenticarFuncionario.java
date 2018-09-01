package com.ifpb.model;

public interface autenticarFuncionario {

    /**
     * Interface criada para auxiliar na verificação e autenticação do login.
     * Conta com três funções.
     * */

    boolean verifyUsername(String username);
    boolean verifyPassword(String senha);
    boolean verifyLogin(String username, String senha);

}
