package com.ufes.sistemaacessousuarios.presenter;

import com.ufes.sistemaacessousuarios.manterusuariopresenter.state.AlterarSenhaState;
import com.ufes.sistemaacessousuarios.model.Usuario;
import com.ufes.sistemaacessousuarios.persistencia.service.usuario.IUsuarioService;
import com.ufes.sistemaacessousuarios.persistencia.service.usuario.UsuarioService;
import com.ufes.sistemaacessousuarios.manterusuariopresenter.state.CadastroUsuarioState;
import com.ufes.sistemaacessousuarios.manterusuariopresenter.state.ManterUsuarioPresenterState;
import com.ufes.sistemaacessousuarios.view.ManterUsuarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class ManterUsuarioPresenter {
    
    private ManterUsuarioView view;
    private IUsuarioService usuarioService;
    private ManterUsuarioPresenterState estado;
    private Usuario usuario;
    private String mensagemSalvarSucesso;
    
    public ManterUsuarioPresenter() {
        this.view = new ManterUsuarioView();
        initServices();  
        initListeners();
        estado = new CadastroUsuarioState(this);
    }

    public ManterUsuarioPresenter(Usuario usuario) {
        this.usuario = usuario;
        this.view = new ManterUsuarioView();
        initServices();  
        initListeners();
        estado = new AlterarSenhaState(this);
    }

    private void initListeners(){
        this.view.getBtnSalvar().addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    salvar();
                    JOptionPane.showMessageDialog(
                        view,
                        mensagemSalvarSucesso,
                        "Sucesso!",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(
                        view, 
                        ex, 
                        "ERRO!",
                        JOptionPane.ERROR_MESSAGE
                    );
                }      
            }  
        });
        
        this.view.getBtnCancelar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();
            }
        });
        
        this.view.getBtnExcluir().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                excluir();
            }
        });
        
        this.view.getBtnEditar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                editar();
            }
        });
    }   

    public String getMensagemSalvarSucesso() {
        return mensagemSalvarSucesso;
    }

    public void setMensagemSalvarSucesso(String mensagemSalvarSucesso) {
        this.mensagemSalvarSucesso = mensagemSalvarSucesso;
    }
    
    public Usuario lerCampos(){
        String nome = view.getTxtNome().getText();
        String login = view.getTxtUserName().getText();
        String email = view.getTxtEmail().getText();
        String senha = "";
        char[] senhaChar = this.view.getPsSenha().getPassword();
        for(char c : senhaChar){
            senha += String.valueOf(c);
        }    
        
        return new Usuario(
            nome,
            login,
            senha,
            email, 
            false,
            false,
            LocalDateTime.now(), 
            LocalDate.now()
        );
    }
    
    public Usuario lerCamposAtualizacao(){
        String nome = view.getTxtNome().getText();
        String login = view.getTxtUserName().getText();
        String email = view.getTxtEmail().getText();
        String senha = "";
        char[] senhaChar = this.view.getPsSenha().getPassword();
        for(char c : senhaChar){
            senha += String.valueOf(c);
        }    
        
        return new Usuario(
            usuario.getId(),
            nome,
            login,
            senha,
            email, 
            false,
            false,
            LocalDateTime.now(), 
            LocalDate.now()
        );
    }
    
    public void carregarCampos(){
        view.getTxtId().setText(String.valueOf(usuario.getId()));
        view.getTxtNome().setText(usuario.getNome());
        view.getTxtUserName().setText(usuario.getLogin());
        view.getTxtEmail().setText(usuario.getEmail());
        view.getLblDataCriacao().setText(usuario.getDataCadastro().toString());
        view.getLblDataModificacao().setText(usuario.getDataModificacao().toString());
    }
    
    public void fechar(){
        this.view.dispose();
    }
    
    public ManterUsuarioView getView() {
        return this.view;
    }

    public IUsuarioService getUsuarioService() {
        return usuarioService;
    }
    
    private void salvar() throws SQLException{
        this.estado.salvar();
    }
    
    private void cancelar(){
        this.estado.cancelar();
    }
    
    private void excluir(){
        this.estado.excluir();
    }
    
    private void editar(){
        this.estado.editar();
    }
    
    private void initServices(){
        this.usuarioService = new UsuarioService();
    }
    
    public void setEstado(ManterUsuarioPresenterState estado){
        this.estado = estado;
    } 

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
