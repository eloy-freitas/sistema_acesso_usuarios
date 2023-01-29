package com.ufes.sistemaacessousuarios.principalpresenter.state;

import com.ufes.sistemaacessousuarios.manterusuariopresenter.state.AlterarSenhaState;
import com.ufes.sistemaacessousuarios.manterusuariopresenter.state.VisualizarUsuarioState;
import com.ufes.sistemaacessousuarios.model.Usuario;
import com.ufes.sistemaacessousuarios.presenter.BuscarUsuarioObserver;
import com.ufes.sistemaacessousuarios.presenter.BuscarUsuarioPresenter;
import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;
import com.ufes.sistemaacessousuarios.presenter.VisualizarNotificacoesPresenter;


public class LoginAdminState extends PrincipalPresenterState implements BuscarUsuarioObserver{
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
        if(!buscarUsuarioPresenter.getView().isVisible()){
            buscarUsuarioPresenter.subscribe(this);
            principalView.getDpMenu().add(buscarUsuarioPresenter.getView());
            buscarUsuarioPresenter.getView().setVisible(true);
        }  
    }

    @Override
    public void visualizarUsuario(Usuario usuario) {
        manterUsuarioPresenter = new ManterUsuarioPresenter(usuario);
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
