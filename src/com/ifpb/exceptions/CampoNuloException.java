package com.ifpb.exceptions;

public class CampoNuloException extends Exception {
    private String mensagem;

    public CampoNuloException(String mensagem){
        super(mensagem);
        this.mensagem = mensagem;
    }
    public String getMensagem(){
        return mensagem;
    }
}
