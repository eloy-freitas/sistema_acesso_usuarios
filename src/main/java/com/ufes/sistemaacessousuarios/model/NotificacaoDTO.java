package com.ufes.sistemaacessousuarios.model;

import java.time.LocalDateTime;


public class NotificacaoDTO {
    private LocalDateTime idNotificacao;
    private Long idRemetente;
    private String remetenteUsername;
    private Long idDestinatario;
    private String DestinatarioUsername;
    private boolean flLida;
    private LocalDateTime dataVisualizacao;
    private LocalDateTime dataEnvio;
    private String mensagem;
    private int tipo;

    public NotificacaoDTO(LocalDateTime idNotificacao, Long idRemetente, String remetenteUsername, Long idDestinatario, String DestinatarioUsername, boolean flLida, LocalDateTime dataVisualizacao, LocalDateTime dataEnvio, String mensagem, int tipo) {
        this.idNotificacao = idNotificacao;
        this.idRemetente = idRemetente;
        this.remetenteUsername = remetenteUsername;
        this.idDestinatario = idDestinatario;
        this.DestinatarioUsername = DestinatarioUsername;
        this.flLida = flLida;
        this.dataVisualizacao = dataVisualizacao;
        this.dataEnvio = dataEnvio;
        this.mensagem = mensagem;
        this.tipo = tipo;
    }

    public LocalDateTime getIdNotificacao() {
        return idNotificacao;
    }
    
    public String getMensagem() {
        return mensagem;
    }

    public int getTipo() {
        return tipo;
    }

    public Long getIdRemetente() {
        return idRemetente;
    }

    public String getRemetenteUsername() {
        return remetenteUsername;
    }

    public Long getIdDestinatario() {
        return idDestinatario;
    }

    public String getDestinatarioUsername() {
        return DestinatarioUsername;
    }

    public boolean isFlLida() {
        return flLida;
    }

    public LocalDateTime getDataVisualizacao() {
        return dataVisualizacao;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }
    
    
    
}
