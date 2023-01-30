package com.ufes.sistemaacessousuarios.principalpresenter.state;

import com.ufes.sistemaacessousuarios.manterusuariopresenter.state.AlterarSenhaState;
import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;
import com.ufes.sistemaacessousuarios.view.NaoAutorizadoView;


public class LoginNaoAutorizadoState extends PrincipalPresenterState{
    private NaoAutorizadoView naoAutorizadoView;
    
    public LoginNaoAutorizadoState(PrincipalPresenter presenter) {
        super(presenter);
        manterUsuarioPresenter = new ManterUsuarioPresenter(
            presenter.getUsuario()
        );
        naoAutorizadoView = new NaoAutorizadoView();
        initComponents();
    }
    
    @Override
    public void initComponents(){
        decorarInfoUsuario();
        presenter.getPrincipalView().getDpMenu().add(naoAutorizadoView);
        principalView.getMiLogin().setEnabled(false);
        principalView.getMiAlterarSenha().setEnabled(true);
        principalView.getMiCadastrar().setEnabled(false);
        principalView.getBtnNotificacoes().setVisible(false);
        principalView.getLblInfoUsuario().setVisible(true);
        principalView.getMiBuscarUsuarios().setEnabled(false);
        principalView.getMiBuscarUsuarios().setVisible(false);
        naoAutorizadoView.setVisible(true);
    }
    
    @Override
    public void alterarSenha(){
        manterUsuarioPresenter = new ManterUsuarioPresenter(presenter.getUsuario());
        manterUsuarioPresenter.setEstado(new AlterarSenhaState(manterUsuarioPresenter));
        if(!manterUsuarioPresenter.getView().isVisible()){
            principalView.getDpMenu().add(manterUsuarioPresenter.getView());
            manterUsuarioPresenter.getView().setVisible(true);
        }  
    }
    
    @Override
    public void sair(){
        presenter.fecharJanelasInternas();
        presenter.setEstado(new NaoLogadoState(presenter));
    }
}
