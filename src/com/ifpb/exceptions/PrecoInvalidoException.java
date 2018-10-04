package com.ifpb.exceptions;

public class PrecoInvalidoException extends Exception {
    private String mensagem;

    public PrecoInvalidoException(String mensagem){
        super(mensagem);
        this.mensagem = mensagem;
    }

    public String getMensagem(){
        return mensagem;
    }
}
