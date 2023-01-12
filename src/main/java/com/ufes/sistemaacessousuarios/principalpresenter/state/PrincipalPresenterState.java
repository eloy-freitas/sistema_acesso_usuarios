package com.ufes.sistemaacessousuarios.principalpresenter.state;

import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;


public abstract class PrincipalPresenterState {
    protected PrincipalPresenter presenter;

    public PrincipalPresenterState(PrincipalPresenter presenter) {
        this.presenter = presenter;
    }
    
    public void initComponents(){
        throw new RuntimeException("Operação inválida para o estado atual");
    }
    
    public void login(){
        throw new RuntimeException("Operação inválida para o estado atual");
    }
    
    public void cadastrar(){
        throw new RuntimeException("Operação inválida para o estado atual");
    }
    
    public void sair(){
        throw new RuntimeException("Operação inválida para o estado atual");
    }
}
