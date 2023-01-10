package com.ufes.sistemaacessousuarios.presenter;

import com.ufes.sistemaacessousuarios.view.LoginView;
import com.ufes.sistemaacessousuarios.view.PrincipalView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PrincipalPresenter {

    private PrincipalView principalView;
    private LoginView loginView;
    private LoginPresenter loginPresenter;
    private ManterUsuarioPresenter manterUsuarioPresenter;
    
    public PrincipalPresenter() {
        principalView = new PrincipalView();
        principalView.setVisible(true);
        loginView = new LoginView();
        initListeners();
    }
    
    
    public void initListeners(){
        this.principalView.getMiSair().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });
        
        this.principalView.getMiLogin().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(loginPresenter == null){
                    loginPresenter = new LoginPresenter();
                    principalView.getDpMenu().add(loginPresenter.getView());
                    loginPresenter.getView().setVisible(true);
                }
            }
        });
        
        this.principalView.getMiCadastrar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                manterUsuarioPresenter = new ManterUsuarioPresenter();
                principalView.add(manterUsuarioPresenter.getView());
                manterUsuarioPresenter.getView().setVisible(true);
            }
            
        });
    }
    
    
    public void fechar(){
        loginPresenter.getView().dispose();
        loginPresenter = null;
    }
    
}
