package com.ufes.sistemaacessousuarios.presenter;

import com.ufes.sistemaacessousuarios.model.Usuario;
import com.ufes.sistemaacessousuarios.persistencia.service.usuario.UsuarioService;
import com.ufes.sistemaacessousuarios.principalpresenter.state.LoginAdminState;
import com.ufes.sistemaacessousuarios.principalpresenter.state.LoginNaoAutorizadoState;
import com.ufes.sistemaacessousuarios.principalpresenter.state.LoginUsuarioState;
import com.ufes.sistemaacessousuarios.principalpresenter.state.NaoLogadoState;
import com.ufes.sistemaacessousuarios.principalpresenter.state.PrincipalPresenterState;
import com.ufes.sistemaacessousuarios.view.BuscarUsuarioView;
import com.ufes.sistemaacessousuarios.view.PrincipalView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PrincipalPresenter implements LoginObserver{
    private PrincipalView principalView;
    private ManterUsuarioPresenter manterUsuarioPresenter;
    private PrincipalPresenterState estado;
    private UsuarioService usuarioService;
    private Usuario usuario;
    private int totalNotificacoes;
    
    public PrincipalPresenter() {
        this.usuario = null;
        principalView = new PrincipalView();
        principalView.setVisible(true);
        initListeners();
        initServices();
        totalNotificacoes = 0;
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
        
        this.principalView.getMiAlterarSenha().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                alterarSenha();
            }
            
        });
        
        this.principalView.getMiBuscarUsuarios().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscarUsuarioView buscarUsuarioView = new BuscarUsuarioView();
                principalView.getDpMenu().add(buscarUsuarioView);
                buscarUsuarioView.setVisible(true);
            }
            
        });
        

    }
    
    public void initServices(){
        this.usuarioService = new UsuarioService();
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
    
    public void alterarSenha(){
        estado.alterarSenha();
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
        if(usuario.isAdmin()){
            this.estado = new LoginAdminState(this);
        }else if(usuario.isAutorizado()){
            this.estado = new LoginUsuarioState(this);
        }else{
            this.estado = new LoginNaoAutorizadoState(this);
        }
    }
   
    public void setEstado(PrincipalPresenterState estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public int getTotalNotificacoes() {
        return totalNotificacoes;
    }

    public void setTotalNotificacoes(int totalNotificacoes) {
        this.totalNotificacoes = totalNotificacoes;
    }
    
    
    
}