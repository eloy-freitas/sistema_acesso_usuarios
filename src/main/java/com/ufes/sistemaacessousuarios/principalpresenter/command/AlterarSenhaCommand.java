package com.ufes.sistemaacessousuarios.principalpresenter.command;

import com.ufes.sistemaacessousuarios.manterusuariopresenter.state.AlterarSenhaState;
import com.ufes.sistemaacessousuarios.model.Usuario;
import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;
import com.ufes.sistemaacessousuarios.view.PrincipalView;


public class AlterarSenhaCommand extends PrincipalPresenterCommand{
    private ManterUsuarioPresenter manterUsuarioPresenter;

    public AlterarSenhaCommand(
            ManterUsuarioPresenter manterUsuarioPresenter, 
            PrincipalPresenter presenter,
            PrincipalView principalView,
            Usuario usuario
    ) 
    {
        super(presenter, principalView);
        this.manterUsuarioPresenter = manterUsuarioPresenter;
        this.manterUsuarioPresenter.setUsuario(usuario);
    }
    
    @Override
    public void executar() {
        principalView.getDpMenu().remove(manterUsuarioPresenter.getView());
        manterUsuarioPresenter.carregarCampos();
        manterUsuarioPresenter.setEstado(new AlterarSenhaState(manterUsuarioPresenter));
        principalView.getDpMenu().add(manterUsuarioPresenter.getView());
        manterUsuarioPresenter.getView().setVisible(true);
    }
    
    
}
