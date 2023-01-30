package com.ufes.sistemaacessousuarios.principalpresenter.state;

import com.ufes.sistemaacessousuarios.manterusuariopresenter.state.AlterarSenhaState;
import com.ufes.sistemaacessousuarios.manterusuariopresenter.state.VisualizarUsuarioState;
import com.ufes.sistemaacessousuarios.model.Usuario;
import com.ufes.sistemaacessousuarios.presenter.BuscarUsuarioPresenter;
import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;
import com.ufes.sistemaacessousuarios.presenter.VisualizarNotificacoesPresenter;
import com.ufes.sistemaacessousuarios.presenter.VisualizarUsuarioObserver;


public class LoginAdminState extends PrincipalPresenterState implements VisualizarUsuarioObserver{
    private BuscarUsuarioPresenter buscarUsuarioPresenter;
    
    public LoginAdminState(PrincipalPresenter presenter) {
        super(presenter);
        buscarUsuarioPresenter = new BuscarUsuarioPresenter();
        initComponents();
    }
    
    @Override
    public void initComponents(){
        decorarBotaoNotificacoes();
        decorarInfoUsuario();
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
        manterUsuarioPresenter = new ManterUsuarioPresenter(presenter.getUsuario());
        manterUsuarioPresenter.setEstado(new AlterarSenhaState(manterUsuarioPresenter));
        if(!manterUsuarioPresenter.getView().isVisible()){
            principalView.getDpMenu().add(manterUsuarioPresenter.getView());
            manterUsuarioPresenter.getView().setVisible(true);
        }  
    }
    
    @Override
    public void cadastrar(){
        ManterUsuarioPresenter manterUsuarioPresenter;
        manterUsuarioPresenter = new ManterUsuarioPresenter();
        manterUsuarioPresenter.subscribeNotificarUsuarioObserver(presenter);
        manterUsuarioPresenter.subscribeManterUsuarioObserver(buscarUsuarioPresenter);
        if(!manterUsuarioPresenter.getView().isVisible()){
            principalView.getDpMenu().add(manterUsuarioPresenter.getView());
            manterUsuarioPresenter.getView().setVisible(true);
        }   
    }
    
    @Override
    public void buscarUsuarios(){
        buscarUsuarioPresenter.fechar();
        buscarUsuarioPresenter = new BuscarUsuarioPresenter();
        buscarUsuarioPresenter.atualizarTabela();
        if(!buscarUsuarioPresenter.getView().isVisible()){
            buscarUsuarioPresenter.subscribe(this);
            principalView.getDpMenu().add(buscarUsuarioPresenter.getView());
            buscarUsuarioPresenter.getView().setVisible(true);
        }  
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
        VisualizarNotificacoesPresenter visualizarNotificacoesPresenter;
        visualizarNotificacoesPresenter = new VisualizarNotificacoesPresenter(presenter.getUsuario());
        visualizarNotificacoesPresenter.subscribeNotificacaoObserver(presenter);
        principalView.getDpMenu().add(visualizarNotificacoesPresenter.getView());
        visualizarNotificacoesPresenter.getView().setVisible(true);
    }

}
