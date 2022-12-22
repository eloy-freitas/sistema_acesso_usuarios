package com.ufes.sistemaacessousuarios.presenter.state;

import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import java.sql.SQLException;

public abstract class ManterUsuarioPresenterState {
    
    protected ManterUsuarioPresenter presenter;

    public ManterUsuarioPresenterState(ManterUsuarioPresenter presenter) {
        this.presenter = presenter;
    }
    
    public void salvar() throws SQLException{
        throw new RuntimeException("Função inválida para o estado atual!");
    }
    
    public void cancelar(){
        throw new RuntimeException("Função inválida para o estado atual!");
    }
    
    public void editar(){
        throw new RuntimeException("Função inválida para o estado atual!");
    }
    
    public void excluir(){
        throw new RuntimeException("Função inválida para o estado atual!");
    }
    
    public void setViewComponents(){
        throw new RuntimeException("Função inválida para o estado atual!");
    }
}
