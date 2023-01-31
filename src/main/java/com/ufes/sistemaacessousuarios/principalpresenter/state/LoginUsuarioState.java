package com.ufes.sistemaacessousuarios.principalpresenter.state;

import com.ufes.sistemaacessousuarios.manterusuariopresenter.state.AlterarSenhaState;
import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;
import com.ufes.sistemaacessousuarios.presenter.VisualizarNotificacoesPresenter;
import com.ufes.sistemaacessousuarios.principalpresenter.command.AlterarSenhaCommand;
import com.ufes.sistemaacessousuarios.principalpresenter.command.PrincipalPresenterCommand;

public class LoginUsuarioState extends PrincipalPresenterState{
    
    private PrincipalPresenterCommand command;
    public LoginUsuarioState(PrincipalPresenter presenter) {
        super(presenter);
        manterUsuarioPresenter = new ManterUsuarioPresenter(
            presenter.getUsuario()
        );
        visualizarNotificacoesPresenter = new VisualizarNotificacoesPresenter(
                presenter.getUsuario()
        );
        visualizarNotificacoesPresenter.subscribeNotificacaoObserver(
                presenter
        );
        initComponents();
    }
    
    @Override
    public void initComponents() {
        decorarInfoUsuario();
        decorarBotaoNotificacoes();
        principalView.getDpMenu().add(manterUsuarioPresenter.getView());
        principalView.getDpMenu().add(visualizarNotificacoesPresenter.getView());
        principalView.getMiLogin().setEnabled(false);
        principalView.getMiCadastrar().setEnabled(false);
        principalView.getLblInfoUsuario().setVisible(true);
        principalView.getBtnNotificacoes().setVisible(true);
        principalView.getMiAlterarSenha().setEnabled(true);
        principalView.getMiBuscarUsuarios().setEnabled(false);
        principalView.getMiBuscarUsuarios().setVisible(false);
    }

    @Override
    public void sair(){
        presenter.fecharJanelasInternas();
        presenter.setEstado(new NaoLogadoState(presenter));
    }
    
    @Override
    public void alterarSenha(){
        command = new AlterarSenhaCommand(manterUsuarioPresenter, presenter, principalView);
        command.executar();
    }
    
    @Override
    public void visualizarNotificacoes(){
        principalView.getDpMenu().remove(visualizarNotificacoesPresenter.getView());
        principalView.getDpMenu().add(visualizarNotificacoesPresenter.getView());
        visualizarNotificacoesPresenter.getView().setVisible(true);
    }
}
