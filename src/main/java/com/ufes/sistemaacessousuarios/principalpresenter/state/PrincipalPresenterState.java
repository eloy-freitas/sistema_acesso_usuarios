package com.ufes.sistemaacessousuarios.principalpresenter.state;

import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;
import com.ufes.sistemaacessousuarios.view.PrincipalView;


public abstract class PrincipalPresenterState {
    protected PrincipalPresenter presenter;
    protected PrincipalView principalView;

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
