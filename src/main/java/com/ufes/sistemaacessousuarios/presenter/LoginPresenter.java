package com.ufes.sistemaacessousuarios.presenter;

import com.ufes.sistemaacessousuarios.model.Usuario;
import com.ufes.sistemaacessousuarios.persistencia.service.usuario.UsuarioService;
import com.ufes.sistemaacessousuarios.view.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class LoginPresenter {
    private LoginView view;
    private UsuarioService usuarioService;
    private String login;
    private String senha;
    private Usuario usuario;
    private List<LoginObserver> loginObservers;
    
    
    public LoginPresenter() {
        this.view = new LoginView();
        this.usuario = null;
        initServices();
        initListeneres();
        loginObservers = new ArrayList<>();
    }
    
    private void initServices(){
        this.usuarioService = new UsuarioService();
    }
    
    private void initListeneres(){
        this.view.getBtnEntrar().addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    entrar();
                    JOptionPane.showMessageDialog(
                        view, 
                        "Login efetuado com sucesso!"
                    );
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(
                        view, 
                        "Erro: Usuário não encontrado ou senha inválida!"
                    );
                }
            }    
        });
        
        this.view.getBtnCancelar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }   
        });
    }   
    
    private void lerCampos(){
        this.senha = "";
        this.login = "";
        this.login = this.view.getTxtLogin().getText();
        char[] senhaChar = this.view.getPfSenha().getPassword();
        for(char c : senhaChar){
            this.senha += String.valueOf(c);
        }       
    }
    
    private void entrar() throws SQLException{
        lerCampos();
        this.usuario = this.usuarioService.login(login, senha);
        notificar();
        view.dispose();      
    }

    public Usuario getUsuario() {
        return usuario;
    }

    private void fechar(){
        view.dispose();
    }

    public LoginView getView() {
        return view;
    }
    
    private void notificar(){
        for(LoginObserver lo: loginObservers)
            lo.updateLogin(this.usuario);
    }
    
    public void subscribe(LoginObserver observer){
        if(!this.loginObservers.contains(observer))
            this.loginObservers.add(observer);
        else
            throw new RuntimeException("Observador já foi inscrito");
    }
}
