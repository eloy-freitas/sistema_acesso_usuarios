package com.ufes.sistemaacessousuarios.principalpresenter.state;


import com.ufes.sistemaacessousuarios.presenter.LoginPresenter;
import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;
import com.ufes.sistemaacessousuarios.principalpresenter.command.CadastrarUsuarioNaoLogadoCommand;
import com.ufes.sistemaacessousuarios.principalpresenter.command.LoginCommand;
import com.ufes.sistemaacessousuarios.principalpresenter.command.PrincipalPresenterCommand;

public class NaoLogadoState extends PrincipalPresenterState{
    private PrincipalPresenterCommand command;
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
        command = new LoginCommand(loginPresenter, presenter, principalView);
        command.executar();
    }
    
    @Override
    public void cadastrar(){
        command = new CadastrarUsuarioNaoLogadoCommand(
            presenter,
            principalView, 
            manterUsuarioPresenter
        );
        
        command.executar();
        
    }
}
