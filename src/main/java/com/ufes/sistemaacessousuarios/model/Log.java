package com.ufes.sistemaacessousuarios.model;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;


public class Log {
    private String operacao;
    private String nome;
    private LocalDate data;
    private LocalTime hora;
    private String usuario;
    private String mensagem;

    public Log(String operacao, String nome, LocalDate data, LocalTime hora, String usuario, String mensagem) {
        this.operacao = operacao;
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.usuario = usuario;
        this.mensagem = mensagem;
    }

    public Log(String operacao, String nome, LocalDate data, LocalTime hora, String usuario) {
        this.operacao = operacao;
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.usuario = usuario;
    }

    public String getMensagem() {
        return mensagem;
    }
    
    public String getOperacao() {
        return operacao;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getUsuario() {
        return usuario;
    }
    
    
}
