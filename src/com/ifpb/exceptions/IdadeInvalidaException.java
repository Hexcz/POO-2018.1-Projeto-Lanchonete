package com.ifpb.exceptions;

public class IdadeInvalidaException extends Exception {
    private String mensagem;

    public IdadeInvalidaException(String mensagem){
        super(mensagem);
        this.mensagem = mensagem;
    }

    public String getMensagem(){
        return mensagem;
    }
}
