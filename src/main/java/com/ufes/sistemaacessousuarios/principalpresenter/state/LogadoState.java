package com.ufes.sistemaacessousuarios.principalpresenter.state;

import com.ufes.sistemaacessousuarios.model.Usuario;
import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;


public class LogadoState extends PrincipalPresenterState{

    public LogadoState(PrincipalPresenter presenter) {
        super(presenter);
        principalView = presenter.getPrincipalView();
        initComponents();
    }
    
    @Override
    public void initComponents(){
        principalView.getMiLogin().setEnabled(false);
        principalView.getMiCadastrar().setEnabled(false);
        Usuario usuario = presenter.getUsuario();
        principalView.getLblInfoUsuario().setText(criarInfoUsuario(usuario));
        principalView.getLblInfoUsuario().setVisible(true);
        principalView.getBtnNotificacoes().setVisible(true);
    }
    
    private String criarInfoUsuario(Usuario usuario){
        String texto = ""
                .concat((usuario.isAdmin()) ? "Administrador: " : "Usuário: ")
                .concat(usuario.getLogin()); 
        return texto;
    }
    
    @Override
    public void sair(){
        presenter.setEstado(new NaoLogadoState(presenter));
    }
    
}
