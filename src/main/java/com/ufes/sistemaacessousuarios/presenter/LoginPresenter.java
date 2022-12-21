
package com.ufes.sistemaacessousuarios.presenter;

import com.ufes.sistemaacessousuarios.model.Usuario;
import com.ufes.sistemaacessousuarios.persistencia.service.usuario.UsuarioService;
import com.ufes.sistemaacessousuarios.view.usuario.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class LoginPresenter {
    private LoginView view;
    private UsuarioService usuarioService;
    private String login;
    private String senha;
    
    public LoginPresenter() {
        this.view = new LoginView();
        initServices();
        initListeneres();
        view.setVisible(true);
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
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(
                        view, 
                        "Erro: Usuário não encontrado ou senha inválida!"
                    );
                }
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
        Usuario usuario = this.usuarioService.login(login, senha);
        boolean result = this.usuarioService.isAutorizado(usuario);
        System.out.println(result);
        if(result)
            System.out.println("Login efetuado com sucesso!");
        else
            System.out.println("Aguardando autorização do admin!");
    }
    
}
