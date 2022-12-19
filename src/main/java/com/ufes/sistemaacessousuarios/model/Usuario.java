package com.ufes.sistemaacessousuarios.model;

public class Usuario {
    protected long id;
    protected String nome;
    protected String senha;
    protected String email;

    public Usuario(String nome, String senha, String email) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }

    public Usuario(long id, String nome, String senha, String email) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    @Override
    public String toString() {
        return "\nid=" + id + ", \nnome=" + nome + ", \nsenha=" + senha + ", \nemail=" + email;
    }
    
    
    
}
