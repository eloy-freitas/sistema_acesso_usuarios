package com.ufes.sistemaacessousuarios.principalpresenter.state;

import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;
import com.ufes.sistemaacessousuarios.view.ManterUsuarioView;
import com.ufes.sistemaacessousuarios.view.NaoAutorizadoView;


public class LoginNaoAutorizadoState extends PrincipalPresenterState{
    private NaoAutorizadoView naoAutorizadoView;
    
    public LoginNaoAutorizadoState(PrincipalPresenter presenter) {
        super(presenter);
        principalView = presenter.getPrincipalView();
        naoAutorizadoView = new NaoAutorizadoView();
        initComponents();
    }
    
    @Override
    public void initComponents(){
        decorarInfoUsuario();
        principalView.getMiLogin().setEnabled(false);
        principalView.getMiAlterarSenha().setEnabled(true);
        principalView.getMiCadastrar().setEnabled(false);
        principalView.getBtnNotificacoes().setVisible(false);
        principalView.getLblInfoUsuario().setVisible(true);
        presenter.getPrincipalView().getDpMenu().add(naoAutorizadoView);
        principalView.getMiBuscarUsuarios().setEnabled(false);
        principalView.getMiBuscarUsuarios().setVisible(false);
        naoAutorizadoView.setVisible(true);
        
    }
    
    @Override
    public void alterarSenha(){
        if(manterUsuarioPresenter == null)
            manterUsuarioPresenter = new ManterUsuarioPresenter(presenter.getUsuario());
        ManterUsuarioView manterUsuarioView = manterUsuarioPresenter.getView();
        if(!manterUsuarioView.isVisible()){
            principalView.getDpMenu().add(manterUsuarioView);
            manterUsuarioView.setVisible(true);
        }  
    }
    
    @Override
    public void sair(){
        if(naoAutorizadoView.isVisible())
            naoAutorizadoView.dispose();
        presenter.setEstado(new NaoLogadoState(presenter));
    }
    
    
}
