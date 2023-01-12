package com.ufes.sistemaacessousuarios.principalpresenter.state;

import com.ufes.sistemaacessousuarios.model.Usuario;
import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;
import com.ufes.sistemaacessousuarios.view.NaoAutorizadoView;
import java.sql.SQLException;


public class LogadoState extends PrincipalPresenterState{
    private Usuario usuario;
    private NaoAutorizadoView naoAutorizadoView;
    
    public LogadoState(PrincipalPresenter presenter) {
        super(presenter);
        usuario = presenter.getUsuario(); 
        principalView = presenter.getPrincipalView();
        naoAutorizadoView = new NaoAutorizadoView();
        initComponents();
    }
    
    @Override
    public void initComponents() {
        principalView.getMiLogin().setEnabled(false);
        principalView.getMiCadastrar().setEnabled(false);
        principalView.getLblInfoUsuario().setText(criarInfoUsuario(usuario));
        principalView.getLblInfoUsuario().setVisible(true);
        
        if(!usuario.isAutorizado()){
            principalView.getBtnNotificacoes().setVisible(false);
            presenter.getPrincipalView().getDpMenu().add(naoAutorizadoView);
            naoAutorizadoView.setVisible(true);
        }else{
            int totalNotificacoes = 0;
            try{
                 totalNotificacoes = presenter.getUsuarioService().buscarTotalNotificacoes(usuario);
            }catch(SQLException ex){
                throw new RuntimeException("Usuário não encontrado");
            }
            
            principalView.getBtnNotificacoes().setText(totalNotificacoes + " Notificações");
            principalView.getBtnNotificacoes().setVisible(true);
        }
    }
    
    private String criarInfoUsuario(Usuario usuario){
        String texto = ""
                .concat((usuario.isAdmin()) ? "Administrador: " : "Usuário: ")
                .concat(usuario.getLogin()); 
        return texto;
    }
    
    @Override
    public void sair(){
        if(naoAutorizadoView.isVisible())
            naoAutorizadoView.dispose();
        presenter.setEstado(new NaoLogadoState(presenter));
    }
    
}
