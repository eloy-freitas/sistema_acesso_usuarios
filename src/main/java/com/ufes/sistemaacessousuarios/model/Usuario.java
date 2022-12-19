package com.ufes.sistemaacessousuarios.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Usuario {
    protected long id;
    protected String nome;
    protected String login;
    protected String senha;
    protected String email;
    protected boolean isAdmin;
    protected boolean isAutorizado;
    protected LocalDateTime dataModificacao;
    protected LocalDateTime dataLogin;
    protected LocalDate dataCadastro;

    public Usuario(long id, String nome, String login, String senha, String email, boolean isAdmin, boolean isAutorizado, LocalDateTime dataModificacao, LocalDate dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.isAdmin = isAdmin;
        this.isAutorizado = isAutorizado;
        this.dataModificacao = dataModificacao;
        this.dataCadastro = dataCadastro;
    }
    
    public Usuario(long id, String nome, String login, String senha, String email, boolean isAdmin, boolean isAutorizado, LocalDateTime dataModificacao, LocalDateTime dataLogin, LocalDate dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.isAdmin = isAdmin;
        this.isAutorizado = isAutorizado;
        this.dataModificacao = dataModificacao;
        this.dataLogin = dataLogin;
        this.dataCadastro = dataCadastro;
    }

    public Usuario(String nome, String login, String senha, String email, boolean isAdmin, boolean isAutorizado, LocalDateTime dataModificacao, LocalDateTime dataLogin, LocalDate dataCadastro) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.isAdmin = isAdmin;
        this.isAutorizado = isAutorizado;
        this.dataModificacao = dataModificacao;
        this.dataLogin = dataLogin;
        this.dataCadastro = dataCadastro;
    }

    

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean isAutorizado() {
        return isAutorizado;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", senha=" + senha + ", email=" + email + ", dataCadastro=" + dataCadastro + '}';
    }
}
