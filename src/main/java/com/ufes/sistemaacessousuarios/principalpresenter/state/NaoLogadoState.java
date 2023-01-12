package com.ufes.sistemaacessousuarios.principalpresenter.state;

import com.ufes.sistemaacessousuarios.presenter.LoginPresenter;
import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;
import com.ufes.sistemaacessousuarios.view.LoginView;
import com.ufes.sistemaacessousuarios.view.PrincipalView;


public class NaoLogadoState extends PrincipalPresenterState{
    private LoginPresenter loginPresenter;
    
    
    public NaoLogadoState(PrincipalPresenter presenter) {
        super(presenter);
        loginPresenter = new LoginPresenter();
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
        presenter.setManterUsuarioPresenter(new ManterUsuarioPresenter());
        principalView.getDpMenu().add(presenter.getManterUsuarioPresenter().getView());
        presenter.getManterUsuarioPresenter().getView().setVisible(true);
    }
}
