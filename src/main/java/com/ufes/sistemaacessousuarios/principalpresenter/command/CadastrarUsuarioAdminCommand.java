package com.ufes.sistemaacessousuarios.principalpresenter.command;

import com.ufes.sistemaacessousuarios.presenter.BuscarUsuarioPresenter;
import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;
import com.ufes.sistemaacessousuarios.view.PrincipalView;


public class CadastrarUsuarioAdminCommand extends PrincipalPresenterCommand{
     private BuscarUsuarioPresenter buscarUsuarioPresenter;

    public CadastrarUsuarioAdminCommand(
            BuscarUsuarioPresenter buscarUsuarioPresenter, 
            PrincipalPresenter presenter, 
            PrincipalView principalView
    ) {
        super(presenter, principalView);
        this.buscarUsuarioPresenter = buscarUsuarioPresenter;
    }

    @Override
    public void executar() {
        ManterUsuarioPresenter manterUsuarioPresenter;
        manterUsuarioPresenter = new ManterUsuarioPresenter();
        manterUsuarioPresenter.subscribeNotificarUsuarioObserver(presenter);
        manterUsuarioPresenter.subscribeManterUsuarioObserver(buscarUsuarioPresenter);
        principalView.getDpMenu().add(manterUsuarioPresenter.getView());
        manterUsuarioPresenter.getView().setVisible(true);
    }
     
    
}
