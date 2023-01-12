package com.ufes.sistemaacessousuarios.principalpresenter.state;

import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;


public class LogadoState extends PrincipalPresenterState{

    public LogadoState(PrincipalPresenter presenter) {
        super(presenter);
        initComponents();
    }
    
    @Override
    public void initComponents(){
        presenter.getPrincipalView().getMiLogin().setEnabled(false);
        presenter.getPrincipalView().getMiCadastrar().setEnabled(false);
    }
    
    @Override
    public void sair(){
        presenter.setEstado(new NaoLogadoState(presenter));
    }
    
}
