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

    public NotificacaoDTO(LocalDateTime idNotificacao, Long idRemetente, String remetenteUsername, Long idDestinatario, String DestinatarioUsername, boolean flLida, LocalDateTime dataVisualizacao, LocalDateTime dataEnvio) {
        this.idNotificacao = idNotificacao;
        this.idRemetente = idRemetente;
        this.remetenteUsername = remetenteUsername;
        this.idDestinatario = idDestinatario;
        this.DestinatarioUsername = DestinatarioUsername;
        this.flLida = flLida;
        this.dataVisualizacao = dataVisualizacao;
        this.dataEnvio = dataEnvio;
    }

    public LocalDateTime getIdNotificacao() {
        return idNotificacao;
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
