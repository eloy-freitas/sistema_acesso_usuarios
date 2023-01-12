package com.ufes.sistemaacessousuarios.principalpresenter.state;

import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;


public class LoginUsuarioState extends PrincipalPresenterState{
    public LoginUsuarioState(PrincipalPresenter presenter) {
        super(presenter);
        principalView = presenter.getPrincipalView();
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
    }

    @Override
    public void sair(){
        presenter.setEstado(new NaoLogadoState(presenter));
    }
    
}
