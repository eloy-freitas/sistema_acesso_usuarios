package com.ufes.sistemaacessousuarios.principalpresenter.command;

import com.ufes.sistemaacessousuarios.presenter.LoginPresenter;
import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;
import com.ufes.sistemaacessousuarios.view.PrincipalView;


public class LoginCommand extends PrincipalPresenterCommand{
    private LoginPresenter loginPresenter;

    public LoginCommand(
            LoginPresenter loginPresenter, 
            PrincipalPresenter presenter, 
            PrincipalView principalView) 
    {
        super(presenter, principalView);
        this.loginPresenter = loginPresenter;
    }
    

    @Override
    public void executar() {
        loginPresenter.limparCampos();
        principalView.getDpMenu().remove(loginPresenter.getView());
        principalView.getDpMenu().add(loginPresenter.getView());
        loginPresenter.getView().setVisible(true);
    }
    
    
}
