package com.ufes.sistemaacessousuarios.presenter;

import com.ufes.sistemaacessousuarios.model.Usuario;
import com.ufes.sistemaacessousuarios.principalpresenter.state.LogadoState;
import com.ufes.sistemaacessousuarios.principalpresenter.state.NaoLogadoState;
import com.ufes.sistemaacessousuarios.principalpresenter.state.PrincipalPresenterState;
import com.ufes.sistemaacessousuarios.view.LoginView;
import com.ufes.sistemaacessousuarios.view.PrincipalView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PrincipalPresenter implements LoginObserver{
    private PrincipalView principalView;
    private ManterUsuarioPresenter manterUsuarioPresenter;
    private PrincipalPresenterState estado;
    private Usuario usuario;
    
    public PrincipalPresenter() {
        this.usuario = null;
        principalView = new PrincipalView();
        principalView.setVisible(true);
        initListeners();
        estado = new NaoLogadoState(this);
        
    }
    
    public void initListeners(){
        this.principalView.getMiSair().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                sair();
            }
        });
        
        this.principalView.getMiLogin().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        
        this.principalView.getMiCadastrar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrar();
            }
            
        });
    }
    
    public void sair(){
        estado.sair();
    }
    
    public void cadastrar(){
        estado.cadastrar();
    }
    
    public void login(){
        estado.login();
    }

    public PrincipalView getPrincipalView() {
        return principalView;
    }

    public ManterUsuarioPresenter getManterUsuarioPresenter() {
        return manterUsuarioPresenter;
    }

    public void setManterUsuarioPresenter(ManterUsuarioPresenter manterUsuarioPresenter) {
        this.manterUsuarioPresenter = manterUsuarioPresenter;
    }

    @Override
    public void updateLogin(Usuario usuario) {
        this.usuario = usuario;
        this.estado = new LogadoState(this);
    }
   
    public void setEstado(PrincipalPresenterState estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    
}