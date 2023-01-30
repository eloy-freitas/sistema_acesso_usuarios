package com.ufes.sistemaacessousuarios.model;

import java.time.LocalDateTime;


public class Notificacao {
    private String mensagem;
    private LocalDateTime idNotificacao;
    private int tipo;

    public Notificacao(String mensagem, LocalDateTime idNotificacao, int tipo) {
        this.mensagem = mensagem;
        this.idNotificacao = idNotificacao;
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getIdNotificacao() {
        return idNotificacao;
    }
    
    
}
