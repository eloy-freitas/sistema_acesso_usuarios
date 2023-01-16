package com.ufes.sistemaacessousuarios.manterusuariopresenter.state;

import com.ufes.sistemaacessousuarios.model.Usuario;
import com.ufes.sistemaacessousuarios.presenter.LoginPresenter;
import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import com.ufes.sistemaacessousuarios.manterusuariopresenter.command.ManterUsuarioCommand;
import com.ufes.sistemaacessousuarios.manterusuariopresenter.command.SalvarUsuarioCommand;
import java.sql.SQLException;


public class CadastroUsuarioState extends ManterUsuarioPresenterState{
    
    private ManterUsuarioCommand command;
    
    public CadastroUsuarioState(ManterUsuarioPresenter presenter) {
        super(presenter);
        this.command = new SalvarUsuarioCommand(presenter);
        initComponents();
    }
    
    @Override
    public void initComponents(){
        presenter.setMensagemSalvarSucesso("Usuário cadastrado com sucesso!");
        manterUsuarioView.setTitle("Cadastrar Usuário");
        manterUsuarioView.getBtnEditar().setEnabled(false);
        manterUsuarioView.getBtnExcluir().setEnabled(false);
        manterUsuarioView.getCbAdmin().setVisible(false);
        manterUsuarioView.getCbAutorizado().setVisible(false);
        manterUsuarioView.getLblDataCriacao().setVisible(false);
        manterUsuarioView.getLblDataModificacao().setVisible(false);
        manterUsuarioView.getTxtId().setEditable(false);
        manterUsuarioView.getLblDescDataCriacao().setVisible(false);
        manterUsuarioView.getLblDescDataModificacao().setVisible(false);
    }
    
    @Override
    public void salvar() throws SQLException{
        Usuario usuario = presenter.lerCampos();
        presenter.setUsuario(usuario);
        this.command.executar();
        this.presenter.fechar();
    }
    
    @Override
    public void cancelar(){
        presenter.fechar();
    }
}
