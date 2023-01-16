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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ManterUsuarioPresenter {
    
    private ManterUsuarioView view;
    private IUsuarioService usuarioService;
    private ManterUsuarioPresenterState estado;
    private Usuario usuario;
    private String mensagemSalvarSucesso;
    private List<ManterUsuarioObserver> manterUsuarioObservers;
    
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
        carregarCampos();
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
                }catch(SQLException | NullPointerException ex){
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
    
    public Usuario lerCampos() throws NullPointerException{
        String nome = view.getTxtNome().getText();
        String login = view.getTxtUserName().getText();
        String email = view.getTxtEmail().getText();
        String senha = "";
        char[] senhaChar = this.view.getPsSenha().getPassword();
        for(char c : senhaChar){
            senha += String.valueOf(c);
        }  
        
        if(nome.isBlank())
            throw new NullPointerException("nome inválido");
        
        if(login.isBlank())
            throw new NullPointerException("username inválido");
        
        if(email.isBlank())
            throw new NullPointerException("email inválido");
        
        if(senha.isBlank())
            throw new NullPointerException("senha inválida");
            
        return new Usuario(
            nome,
            login,
            senha,
            email, 
            view.getCbAdmin().isSelected(),
            view.getCbAutorizado().isSelected(),
            LocalDateTime.now(),
            LocalDate.now()
        );
    }
    
    public Usuario lerCamposAtualizacao() throws NullPointerException{
        String nome = view.getTxtNome().getText();
        String login = view.getTxtUserName().getText();
        String email = view.getTxtEmail().getText();

        if(nome.isBlank())
            throw new NullPointerException("nome inválido");
        
        if(login.isBlank())
            throw new NullPointerException("username inválido");
        
        if(email.isBlank())
            throw new NullPointerException("email inválido");
        
        
        return new Usuario(
            usuario.getId(),
            nome,
            login,
            "",
            email, 
            view.getCbAdmin().isSelected(),
            view.getCbAutorizado().isSelected(),
            LocalDateTime.now(),
            null
        );
    }
    
    private void carregarCampos(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        view.getTxtId().setText(String.valueOf(usuario.getId()));
        view.getTxtNome().setText(usuario.getNome());
        view.getTxtUserName().setText(usuario.getLogin());
        view.getTxtEmail().setText(usuario.getEmail());
        view.getCbAdmin().setSelected(usuario.isAdmin());
        view.getCbAutorizado().setSelected(usuario.isAutorizado());
        view.getLblDataCriacao().setText(usuario.getDataCadastro().format(formatter));
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        view.getLblDataModificacao().setText(usuario.getDataModificacao().format(formatter));
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
        manterUsuarioObservers = new ArrayList<>();
        this.usuarioService = new UsuarioService();
    }
    
    public void notificar(){
        if(!manterUsuarioObservers.isEmpty()){
            for(ManterUsuarioObserver observer: manterUsuarioObservers)
            observer.atualizarUsuario();
        }
    }
    
    public void subscribe(ManterUsuarioObserver observer){
        if(!this.manterUsuarioObservers.contains(observer))
            this.manterUsuarioObservers.add(observer);
        else
            throw new RuntimeException("Observador já foi inscrito");
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
