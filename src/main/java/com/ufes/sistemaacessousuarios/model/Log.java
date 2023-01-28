package com.ufes.sistemaacessousuarios.model;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


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
    
    private String formatarHora(LocalTime hora){
        DateTimeFormatter horaFormater = DateTimeFormatter.ofPattern("HH:mm:ss");
        return horaFormater.format(hora);
    }
    
    private String formatarData(LocalDate data){
        DateTimeFormatter dataFormater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataFormater.format(data);
    }
    
    public void setUsuario(String usuario) {
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

    public String getData() {
        return formatarData(data);
    }

    public String getHora() {
        return formatarHora(hora);
    }

    public String getUsuario() {
        return usuario;
    }
    
    
}
