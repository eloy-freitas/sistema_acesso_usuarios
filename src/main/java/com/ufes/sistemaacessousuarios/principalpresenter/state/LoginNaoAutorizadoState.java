package com.ufes.sistemaacessousuarios.principalpresenter.state;

import com.ufes.sistemaacessousuarios.manterusuariopresenter.state.AlterarSenhaState;
import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;
import com.ufes.sistemaacessousuarios.principalpresenter.command.AlterarSenhaCommand;
import com.ufes.sistemaacessousuarios.principalpresenter.command.PrincipalPresenterCommand;
import com.ufes.sistemaacessousuarios.view.NaoAutorizadoView;


public class LoginNaoAutorizadoState extends PrincipalPresenterState{
    private NaoAutorizadoView naoAutorizadoView;
    private PrincipalPresenterCommand command;
    
    public LoginNaoAutorizadoState(PrincipalPresenter presenter) {
        super(presenter);
        manterUsuarioPresenter = new ManterUsuarioPresenter(
            presenter.getUsuario()
        );
        naoAutorizadoView = new NaoAutorizadoView();
        initComponents();
    }
    
    @Override
    public void initComponents(){
        decorarInfoUsuario();
        principalView.getDpMenu().add(manterUsuarioPresenter.getView());
        presenter.getPrincipalView().getDpMenu().add(naoAutorizadoView);
        principalView.getMiLogin().setEnabled(false);
        principalView.getMiAlterarSenha().setEnabled(true);
        principalView.getMiCadastrar().setEnabled(false);
        principalView.getBtnNotificacoes().setVisible(false);
        principalView.getLblInfoUsuario().setVisible(true);
        principalView.getMiBuscarUsuarios().setEnabled(false);
        principalView.getMiBuscarUsuarios().setVisible(false);
        naoAutorizadoView.setVisible(true);
    }
    
    @Override
    public void alterarSenha(){
        command = new AlterarSenhaCommand(manterUsuarioPresenter, presenter, principalView);
        command.executar();
    }
    
    @Override
    public void sair(){
        presenter.fecharJanelasInternas();
        presenter.setEstado(new NaoLogadoState(presenter));
    }
}
