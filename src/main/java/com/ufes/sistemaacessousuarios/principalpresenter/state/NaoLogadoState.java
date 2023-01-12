package com.ufes.sistemaacessousuarios.principalpresenter.state;

import com.ufes.sistemaacessousuarios.presenter.LoginPresenter;
import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;
import com.ufes.sistemaacessousuarios.view.LoginView;


public class NaoLogadoState extends PrincipalPresenterState{
    private LoginPresenter loginPresenter;
    
    public NaoLogadoState(PrincipalPresenter presenter) {
        super(presenter);
        loginPresenter = new LoginPresenter();
        loginPresenter.subscribe(presenter);
        initComponents();
    }
    
     @Override
    public void initComponents(){
        presenter.getPrincipalView().getMiLogin().setEnabled(true);
        presenter.getPrincipalView().getMiCadastrar().setEnabled(true);
    }
    
    @Override
    public void sair(){
        presenter.getPrincipalView().dispose();
    }
    
    @Override
    public void login(){ 
        LoginView loginView = loginPresenter.getView();
        if(!loginView.isVisible()){
            presenter.getPrincipalView().getDpMenu().add(loginView);
            loginView.setVisible(true);
        }  
    }
    
    @Override
    public void cadastrar(){
        presenter.setManterUsuarioPresenter(new ManterUsuarioPresenter());
        presenter.getPrincipalView().getDpMenu().add(presenter.getManterUsuarioPresenter().getView());
        presenter.getManterUsuarioPresenter().getView().setVisible(true);
    }
}
