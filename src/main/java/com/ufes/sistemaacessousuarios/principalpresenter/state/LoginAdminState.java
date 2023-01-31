package com.ufes.sistemaacessousuarios.principalpresenter.state;

import com.ufes.sistemaacessousuarios.model.Usuario;
import com.ufes.sistemaacessousuarios.presenter.BuscarUsuarioPresenter;
import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;
import com.ufes.sistemaacessousuarios.presenter.VisualizarNotificacoesPresenter;
import com.ufes.sistemaacessousuarios.presenter.VisualizarUsuarioObserver;
import com.ufes.sistemaacessousuarios.principalpresenter.command.AlterarSenhaCommand;
import com.ufes.sistemaacessousuarios.principalpresenter.command.BuscarUsuarioCommand;
import com.ufes.sistemaacessousuarios.principalpresenter.command.CadastrarUsuarioAdminCommand;
import com.ufes.sistemaacessousuarios.principalpresenter.command.PrincipalPresenterCommand;
import com.ufes.sistemaacessousuarios.principalpresenter.command.VisualizarNotificacoesCommand;
import com.ufes.sistemaacessousuarios.principalpresenter.command.VisualizarUsuarioCommand;


public class LoginAdminState extends PrincipalPresenterState implements VisualizarUsuarioObserver{
    private BuscarUsuarioPresenter buscarUsuarioPresenter;
    private PrincipalPresenterCommand command;
    
    public LoginAdminState(PrincipalPresenter presenter) {
        super(presenter);
        manterUsuarioPresenter = new ManterUsuarioPresenter(
            presenter.getUsuario()
        );
        visualizarNotificacoesPresenter = new VisualizarNotificacoesPresenter(
                presenter.getUsuario()
        );
        visualizarNotificacoesPresenter.subscribeNotificacaoObserver(
                presenter
        );
        buscarUsuarioPresenter = new BuscarUsuarioPresenter();
        buscarUsuarioPresenter.subscribe(this);
        
        initComponents();
    }
    
    @Override
    public void initComponents(){
        decorarBotaoNotificacoes();
        decorarInfoUsuario();
        principalView.getDpMenu().add(manterUsuarioPresenter.getView());
        principalView.getDpMenu().add(visualizarNotificacoesPresenter.getView());
        principalView.getDpMenu().add(buscarUsuarioPresenter.getView());
        principalView.getMiLogin().setEnabled(false);
        principalView.getMiCadastrar().setEnabled(true);
        principalView.getBtnNotificacoes().setVisible(true);
        principalView.getLblInfoUsuario().setVisible(true);
        principalView.getMiAlterarSenha().setEnabled(true);
        principalView.getMiBuscarUsuarios().setEnabled(true);
        principalView.getMiBuscarUsuarios().setVisible(true);
    }
    
    @Override
    public void sair(){
        presenter.fecharJanelasInternas();
        presenter.setEstado(new NaoLogadoState(presenter));
    }
    
    @Override
    public void alterarSenha(){
        command = new AlterarSenhaCommand(
            manterUsuarioPresenter, 
            presenter, 
            principalView,
            presenter.getUsuario()
        );
        command.executar();
    }
    
    @Override
    public void cadastrar(){
        command = new CadastrarUsuarioAdminCommand(
            buscarUsuarioPresenter, 
            presenter, 
            principalView
        );
        command.executar();
    }
    
    @Override
    public void buscarUsuarios(){
        command = new BuscarUsuarioCommand(
            buscarUsuarioPresenter, 
            presenter,
            principalView
        );
        command.executar();
        
    }

    @Override
    public void visualizarUsuario(Usuario usuario) {
        command = new VisualizarUsuarioCommand(
            buscarUsuarioPresenter, 
            usuario, 
            presenter, 
            principalView
        );
        
        command.executar();
    }
    
    @Override
    public void visualizarNotificacoes(){
        command = new VisualizarNotificacoesCommand(
            presenter, 
            principalView, 
            visualizarNotificacoesPresenter
        );
        command.executar();
    }

}
