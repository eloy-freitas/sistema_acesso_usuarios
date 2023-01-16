package com.ufes.sistemaacessousuarios.principalpresenter.state;

import com.ufes.sistemaacessousuarios.model.Usuario;
import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;
import com.ufes.sistemaacessousuarios.view.PrincipalView;
import java.sql.SQLException;


public abstract class PrincipalPresenterState {
    protected PrincipalPresenter presenter;
    protected PrincipalView principalView;
    protected ManterUsuarioPresenter manterUsuarioPresenter;

    public PrincipalPresenterState(PrincipalPresenter presenter) {
        this.presenter = presenter;
    }
    
    public void initComponents(){
        throw new RuntimeException("Operação inválida para o estado atual");
    }
    
    public void login(){
        throw new RuntimeException("Operação inválida para o estado atual");
    }
    
    public void cadastrar(){
        throw new RuntimeException("Operação inválida para o estado atual");
    }
    
    public void sair(){
        throw new RuntimeException("Operação inválida para o estado atual");
    }
    
    public void alterarSenha(){
        throw new RuntimeException("Operação inválida para o estado atual");
    }
    
    public void buscarUsuarios(){
        throw new RuntimeException("Operação inválida para o estado atual");
    }
    
    public final String criarInfoUsuario(Usuario usuario){
        String texto = ""
                .concat((usuario.isAdmin()) ? "Administrador: " : "Usuário: ")
                .concat(usuario.getLogin()); 
        return texto;
    }
    
    public final void decorarInfoUsuario(){
        principalView.getLblInfoUsuario().setText(criarInfoUsuario(presenter.getUsuario()));
    }
    
    public int totalNotificacoes() throws SQLException{
        return presenter.getUsuarioService().buscarTotalNotificacoes(presenter.getUsuario());
    }
    
    public void decorarBotaoNotificacoes(){
        int total = 0;
        try{
            total = totalNotificacoes();
        }catch(SQLException ex){
            total = 0;
        }
        
        principalView.getBtnNotificacoes().setText(total + " Notificações");
    }
}
