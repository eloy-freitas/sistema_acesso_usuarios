package com.ufes.sistemaacessousuarios.principalpresenter.command;

import com.ufes.sistemaacessousuarios.manterusuariopresenter.state.VisualizarUsuarioState;
import com.ufes.sistemaacessousuarios.model.Usuario;
import com.ufes.sistemaacessousuarios.presenter.BuscarUsuarioPresenter;
import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;
import com.ufes.sistemaacessousuarios.view.PrincipalView;


public class VisualizarUsuarioCommand extends PrincipalPresenterCommand{
    private BuscarUsuarioPresenter buscarUsuarioPresenter;
    private Usuario usuario;

    public VisualizarUsuarioCommand(
            BuscarUsuarioPresenter buscarUsuarioPresenter, 
            Usuario usuario, 
            PrincipalPresenter presenter, 
            PrincipalView principalView) 
    {
        super(presenter, principalView);
        this.buscarUsuarioPresenter = buscarUsuarioPresenter;
        this.usuario = usuario;
    }
    
    
    @Override
    public void executar() {
        ManterUsuarioPresenter manterUsuarioPresenter;
        manterUsuarioPresenter = new ManterUsuarioPresenter(usuario);
        buscarUsuarioPresenter.subscribe(manterUsuarioPresenter);
        manterUsuarioPresenter.subscribeManterUsuarioObserver(buscarUsuarioPresenter);
        manterUsuarioPresenter.setEstado(new VisualizarUsuarioState(manterUsuarioPresenter));
        principalView.getDpMenu().add(manterUsuarioPresenter.getView());
        manterUsuarioPresenter.getView().setVisible(true);
    }
     
     
    
}
