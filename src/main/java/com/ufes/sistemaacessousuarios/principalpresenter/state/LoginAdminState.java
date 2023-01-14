package com.ufes.sistemaacessousuarios.principalpresenter.state;

import com.ufes.sistemaacessousuarios.manterusuariopresenter.state.VisualizarUsuarioState;
import com.ufes.sistemaacessousuarios.model.Usuario;
import com.ufes.sistemaacessousuarios.presenter.BuscarUsuarioObserver;
import com.ufes.sistemaacessousuarios.presenter.BuscarUsuarioPresenter;
import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;
import com.ufes.sistemaacessousuarios.view.BuscarUsuarioView;
import com.ufes.sistemaacessousuarios.view.ManterUsuarioView;


public class LoginAdminState extends PrincipalPresenterState implements BuscarUsuarioObserver{
    private BuscarUsuarioPresenter buscarUsuarioPresenter;
    
    public LoginAdminState(PrincipalPresenter presenter) {
        super(presenter);
        principalView = presenter.getPrincipalView();
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
        presenter.setEstado(new NaoLogadoState(presenter));
    }
    
    @Override
    public void alterarSenha(){
        manterUsuarioPresenter = new ManterUsuarioPresenter(presenter.getUsuario());
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
    
    @Override
    public void buscarUsuarios(){
        buscarUsuarioPresenter = new BuscarUsuarioPresenter();
        buscarUsuarioPresenter.subscribe(this);
        BuscarUsuarioView buscarUsuarioView = buscarUsuarioPresenter.getView();
        if(!buscarUsuarioView.isVisible()){
            principalView.getDpMenu().add(buscarUsuarioView);
            buscarUsuarioView.setVisible(true);
        }  
    }

    @Override
    public void visualizarUsuario(Usuario usuario) {
        manterUsuarioPresenter = new ManterUsuarioPresenter(usuario);
        manterUsuarioPresenter.setEstado(new VisualizarUsuarioState(manterUsuarioPresenter));
        ManterUsuarioView manterUsuarioView = manterUsuarioPresenter.getView();
        principalView.getDpMenu().add(manterUsuarioView);
        manterUsuarioView.setVisible(true);
    }

}
