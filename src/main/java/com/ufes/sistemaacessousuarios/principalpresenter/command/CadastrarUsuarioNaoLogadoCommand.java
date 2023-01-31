package com.ufes.sistemaacessousuarios.principalpresenter.command;

import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;
import com.ufes.sistemaacessousuarios.view.PrincipalView;


public class CadastrarUsuarioNaoLogadoCommand extends PrincipalPresenterCommand{
    private ManterUsuarioPresenter manterUsuarioPresenter;
            
    public CadastrarUsuarioNaoLogadoCommand(
            PrincipalPresenter presenter, 
            PrincipalView principalView, 
            ManterUsuarioPresenter manterUsuarioPresenter) 
    {
        super(presenter, principalView);
        this.manterUsuarioPresenter = manterUsuarioPresenter;
    }

    @Override
    public void executar() {
        manterUsuarioPresenter.limparCampos();
        principalView.getDpMenu().remove(manterUsuarioPresenter.getView());
        principalView.getDpMenu().add(manterUsuarioPresenter.getView());
        manterUsuarioPresenter.getView().setVisible(true);
    }
    
    
}
