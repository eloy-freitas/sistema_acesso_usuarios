package com.ufes.sistemaacessousuarios.principalpresenter.command;

import com.ufes.sistemaacessousuarios.presenter.BuscarUsuarioPresenter;
import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;
import com.ufes.sistemaacessousuarios.view.PrincipalView;


public class BuscarUsuarioCommand extends PrincipalPresenterCommand{
    private BuscarUsuarioPresenter buscarUsuarioPresenter;

    public BuscarUsuarioCommand(
            BuscarUsuarioPresenter buscarUsuarioPresenter, 
            PrincipalPresenter presenter, 
            PrincipalView principalView
    ) {
        super(presenter, principalView);
        this.buscarUsuarioPresenter = buscarUsuarioPresenter;
    }

    @Override
    public void executar() {
        buscarUsuarioPresenter.fechar();
        principalView.getDpMenu().remove(buscarUsuarioPresenter.getView());
        buscarUsuarioPresenter.atualizarTabela();
        principalView.getDpMenu().add(buscarUsuarioPresenter.getView());
        buscarUsuarioPresenter.getView().setVisible(true);
    }
    
    
}
