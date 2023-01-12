package com.ufes.sistemaacessousuarios.principalpresenter.state;

import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;
import com.ufes.sistemaacessousuarios.principalpresenter.state.PrincipalPresenterState;


public class LoginAdminState extends PrincipalPresenterState{
    
    public LoginAdminState(PrincipalPresenter presenter) {
        super(presenter);
        principalView = presenter.getPrincipalView();
        initComponents();
    }
    
    @Override
    public void initComponents(){
        decorarBotaoNotificacoes();
        decorarInfoUsuario();
        principalView.getMiLogin().setEnabled(false);
        principalView.getMiCadastrar().setEnabled(true);
        principalView.getBtnNotificacoes().setVisible(true);
        principalView.getLblInfoUsuario().setVisible(true);
    }
    
    @Override
    public void sair(){
        presenter.setEstado(new NaoLogadoState(presenter));
    }
    
}
