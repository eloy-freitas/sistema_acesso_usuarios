package com.ufes.sistemaacessousuarios.principalpresenter.state;

import com.ufes.sistemaacessousuarios.presenter.LoginPresenter;
import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;

public class NaoLogadoState extends PrincipalPresenterState{
    private LoginPresenter loginPresenter;
    
    public NaoLogadoState(PrincipalPresenter presenter) {
        super(presenter);
        loginPresenter = new LoginPresenter();
        loginPresenter.subscribe(presenter);
        manterUsuarioPresenter = new ManterUsuarioPresenter();
        manterUsuarioPresenter.subscribeNotificarUsuarioObserver(presenter);
        initComponents();
    }
    
     @Override
    public void initComponents(){
        principalView.getDpMenu().add(loginPresenter.getView());
        principalView.getMiLogin().setEnabled(true);
        principalView.getMiCadastrar().setEnabled(true);
        principalView.getBtnNotificacoes().setVisible(false);
        principalView.getLblInfoUsuario().setVisible(false);
        principalView.getMiAlterarSenha().setEnabled(false);
        principalView.getMiBuscarUsuarios().setEnabled(false);
        principalView.getMiBuscarUsuarios().setVisible(false);
    }
    
    @Override
    public void sair(){
        principalView.dispose();
    }
    
    @Override
    public void login(){
        principalView.getDpMenu().remove(loginPresenter.getView());
        principalView.getDpMenu().add(loginPresenter.getView());
        loginPresenter.getView().setVisible(true);
    }
    
    @Override
    public void cadastrar(){
        principalView.getDpMenu().remove(manterUsuarioPresenter.getView());
        principalView.getDpMenu().add(manterUsuarioPresenter.getView());
        manterUsuarioPresenter.getView().setVisible(true);
        
    }
}
