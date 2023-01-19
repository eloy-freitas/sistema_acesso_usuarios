package com.ufes.sistemaacessousuarios.model;

import java.time.LocalDateTime;
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
    protected LocalDateTime dataCadastro;

    public Usuario(long id, String nome, String login, String senha, String email, boolean isAdmin, boolean isAutorizado, LocalDateTime dataModificacao, LocalDateTime dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.isAdmin = isAdmin;
        this.isAutorizado = isAutorizado;
        this.dataModificacao = dataModificacao;
        this.dataLogin = null;
        this.dataCadastro = dataCadastro;
    }
    
    public Usuario(long id, String nome, String login, String senha, String email, boolean isAdmin, boolean isAutorizado, LocalDateTime dataModificacao, LocalDateTime dataLogin, LocalDateTime dataCadastro) {
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

    public Usuario(String nome, String login, String senha, String email, boolean isAdmin, boolean isAutorizado, LocalDateTime dataModificacao, LocalDateTime dataCadastro) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.isAdmin = isAdmin;
        this.isAutorizado = isAutorizado;
        this.dataModificacao = dataModificacao;
        this.dataLogin = null;
        this.dataCadastro = dataCadastro;
    }

    public void setIsAutorizado(boolean isAutorizado) {
        this.isAutorizado = isAutorizado;
    }
    
    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
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

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public boolean isIsAutorizado() {
        return isAutorizado;
    }

    public LocalDateTime getDataLogin() {
        return dataLogin;
    }

    
    
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", senha=" + senha + ", email=" + email + ", dataCadastro=" + dataCadastro + '}';
    }
}
