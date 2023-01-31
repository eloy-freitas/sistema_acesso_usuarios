package com.ufes.sistemaacessousuarios.principalpresenter.command;

import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;
import com.ufes.sistemaacessousuarios.view.PrincipalView;


public abstract class PrincipalPresenterCommand {
    protected PrincipalPresenter presenter;
    protected PrincipalView principalView;

    public PrincipalPresenterCommand(PrincipalPresenter presenter, PrincipalView principalView) {
        this.presenter = presenter;
        this.principalView = principalView;
    }
    
    public abstract void executar();
}
