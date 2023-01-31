package com.ufes.sistemaacessousuarios.principalpresenter.command;

import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;
import com.ufes.sistemaacessousuarios.presenter.VisualizarNotificacoesPresenter;
import com.ufes.sistemaacessousuarios.view.PrincipalView;


public class VisualizarNotificacoesCommand extends PrincipalPresenterCommand{
    private VisualizarNotificacoesPresenter notificacoesPresenter;
    
    public VisualizarNotificacoesCommand(
            PrincipalPresenter presenter, 
            PrincipalView principalView, 
            VisualizarNotificacoesPresenter notificacoesPresenter
    ) {
        super(presenter, principalView);
        this.notificacoesPresenter = notificacoesPresenter;
    }

    @Override
    public void executar() {
        principalView.getDpMenu().remove(notificacoesPresenter.getView());
        notificacoesPresenter.atualizarTabela();
        principalView.getDpMenu().add(notificacoesPresenter.getView());
        notificacoesPresenter.getView().setVisible(true);
    }
    
    
}
