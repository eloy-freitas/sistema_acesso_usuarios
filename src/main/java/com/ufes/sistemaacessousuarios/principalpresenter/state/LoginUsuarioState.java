package com.ufes.sistemaacessousuarios.principalpresenter.state;

import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;
import com.ufes.sistemaacessousuarios.view.ManterUsuarioView;


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
        principalView.getMiAlterarSenha().setEnabled(true);
        principalView.getMiBuscarUsuarios().setEnabled(false);
        principalView.getMiBuscarUsuarios().setVisible(false);
    }

    @Override
    public void sair(){
        presenter.setEstado(new NaoLogadoState(presenter));
    }
    
    @Override
    public void alterarSenha(){
        manterUsuarioPresenter = new ManterUsuarioPresenter(presenter.getUsuario());
        manterUsuarioPresenter.carregarCampos();
        ManterUsuarioView manterUsuarioView = manterUsuarioPresenter.getView();
        if(!manterUsuarioView.isVisible()){
            principalView.getDpMenu().add(manterUsuarioView);
            manterUsuarioView.setVisible(true);
        }  
    }
    
    @Override
    public void cadastrar(){
        manterUsuarioPresenter = new ManterUsuarioPresenter();
        ManterUsuarioView manterUsuarioView = manterUsuarioPresenter.getView();
        if(!manterUsuarioView.isVisible()){
            principalView.getDpMenu().add(manterUsuarioView);
            manterUsuarioView.setVisible(true);
        }   
    }
    
}
