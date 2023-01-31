package com.ufes.sistemaacessousuarios.principalpresenter.state;

import com.ufes.sistemaacessousuarios.manterusuariopresenter.state.AlterarSenhaState;
import com.ufes.sistemaacessousuarios.manterusuariopresenter.state.VisualizarUsuarioState;
import com.ufes.sistemaacessousuarios.model.Usuario;
import com.ufes.sistemaacessousuarios.presenter.BuscarUsuarioPresenter;
import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;
import com.ufes.sistemaacessousuarios.presenter.VisualizarNotificacoesPresenter;
import com.ufes.sistemaacessousuarios.presenter.VisualizarUsuarioObserver;
import com.ufes.sistemaacessousuarios.principalpresenter.command.AlterarSenhaCommand;
import com.ufes.sistemaacessousuarios.principalpresenter.command.PrincipalPresenterCommand;
import com.ufes.sistemaacessousuarios.principalpresenter.command.VisualizarNotificacoesCommand;


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
        command = new AlterarSenhaCommand(manterUsuarioPresenter, presenter, principalView);
        command.executar();
    }
    
    @Override
    public void cadastrar(){
        ManterUsuarioPresenter manterUsuarioPresenter;
        manterUsuarioPresenter = new ManterUsuarioPresenter();
        manterUsuarioPresenter.subscribeNotificarUsuarioObserver(presenter);
        manterUsuarioPresenter.subscribeManterUsuarioObserver(buscarUsuarioPresenter);
        principalView.getDpMenu().add(manterUsuarioPresenter.getView());
        manterUsuarioPresenter.getView().setVisible(true);
    }
    
    @Override
    public void buscarUsuarios(){
        buscarUsuarioPresenter.fechar();
        principalView.getDpMenu().remove(buscarUsuarioPresenter.getView());
        buscarUsuarioPresenter.atualizarTabela();
        principalView.getDpMenu().add(buscarUsuarioPresenter.getView());
        buscarUsuarioPresenter.getView().setVisible(true);
        
    }

    @Override
    public void visualizarUsuario(Usuario usuario) {
        ManterUsuarioPresenter manterUsuarioPresenter;
        manterUsuarioPresenter = new ManterUsuarioPresenter(usuario);
        buscarUsuarioPresenter.subscribe(manterUsuarioPresenter);
        manterUsuarioPresenter.subscribeManterUsuarioObserver(buscarUsuarioPresenter);
        manterUsuarioPresenter.setEstado(new VisualizarUsuarioState(manterUsuarioPresenter));
        principalView.getDpMenu().add(manterUsuarioPresenter.getView());
        manterUsuarioPresenter.getView().setVisible(true);
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
