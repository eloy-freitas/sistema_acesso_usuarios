package com.ufes.sistemaacessousuarios.principalpresenter.state;

import com.ufes.sistemaacessousuarios.presenter.LoginPresenter;
import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;
import com.ufes.sistemaacessousuarios.view.LoginView;
import com.ufes.sistemaacessousuarios.view.ManterUsuarioView;


public class NaoLogadoState extends PrincipalPresenterState{
    private LoginPresenter loginPresenter;
    private ManterUsuarioPresenter manterUsuarioPresenter;
    
    public NaoLogadoState(PrincipalPresenter presenter) {
        super(presenter);
        loginPresenter = new LoginPresenter();
        manterUsuarioPresenter = new ManterUsuarioPresenter();
        loginPresenter.subscribe(presenter);
        principalView = presenter.getPrincipalView();
        initComponents();
    }
    
     @Override
    public void initComponents(){
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
        LoginView loginView = loginPresenter.getView();
        if(!loginView.isVisible()){
            principalView.getDpMenu().add(loginView);
            loginView.setVisible(true);
        }  
    }
    
    @Override
    public void cadastrar(){
        ManterUsuarioView manterUsuarioView = manterUsuarioPresenter.getView();
        if(!manterUsuarioView.isVisible()){
            principalView.getDpMenu().add(manterUsuarioView);
            manterUsuarioView.setVisible(true);
        }   
    }
}
