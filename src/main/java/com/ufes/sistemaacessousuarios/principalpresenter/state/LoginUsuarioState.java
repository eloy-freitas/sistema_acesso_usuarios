package com.ufes.sistemaacessousuarios.principalpresenter.state;

import com.ufes.sistemaacessousuarios.manterusuariopresenter.state.AlterarSenhaState;
import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;
import com.ufes.sistemaacessousuarios.presenter.VisualizarNotificacoesPresenter;

public class LoginUsuarioState extends PrincipalPresenterState{
    public LoginUsuarioState(PrincipalPresenter presenter) {
        super(presenter);
        manterUsuarioPresenter = new ManterUsuarioPresenter(
            presenter.getUsuario()
        );
        initComponents();
    }
    
    @Override
    public void initComponents() {
        decorarInfoUsuario();
        decorarBotaoNotificacoes();
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
        manterUsuarioPresenter = new ManterUsuarioPresenter(presenter.getUsuario());
        manterUsuarioPresenter.setEstado(new AlterarSenhaState(manterUsuarioPresenter));
        if(!manterUsuarioPresenter.getView().isVisible()){
            principalView.getDpMenu().add(manterUsuarioPresenter.getView());
            manterUsuarioPresenter.getView().setVisible(true);
        }  
    }
    
    @Override
    public void visualizarNotificacoes(){
        VisualizarNotificacoesPresenter visualizarNotificacoesPresenter;
        visualizarNotificacoesPresenter = new VisualizarNotificacoesPresenter(presenter.getUsuario());
        visualizarNotificacoesPresenter.subscribeNotificacaoObserver(presenter);
        principalView.getDpMenu().add(visualizarNotificacoesPresenter.getView());
        visualizarNotificacoesPresenter.getView().setVisible(true);
    }
}
