package com.mlschool.mlschool.dto.exception;

public class ValidationError {

    private String campo;
    private String mensagem;

    public ValidationError() {
    }

    public ValidationError(String mensagem) {
        this.mensagem = mensagem;
    }

    public ValidationError(String campo, String mensagem){
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

}
