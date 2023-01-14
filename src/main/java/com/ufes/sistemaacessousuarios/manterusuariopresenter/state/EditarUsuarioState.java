package com.ufes.sistemaacessousuarios.manterusuariopresenter.state;

import com.ufes.sistemaacessousuarios.manterusuariopresenter.command.AlterarSenhaCommand;
import com.ufes.sistemaacessousuarios.manterusuariopresenter.command.EditarUsuarioCommand;
import com.ufes.sistemaacessousuarios.model.Usuario;
import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import java.sql.SQLException;


public class EditarUsuarioState extends ManterUsuarioPresenterState{

    public EditarUsuarioState(ManterUsuarioPresenter presenter) {
        super(presenter);
        command = new EditarUsuarioCommand(presenter);
        initComponents();
    }
    
    @Override
    public void initComponents(){
        presenter.setMensagemSalvarSucesso("Usuário atualizado com sucesso!");
        manterUsuarioView.setTitle("Editar usuário: " + presenter.getUsuario().getNome());
        manterUsuarioView.getTxtUserName().setEnabled(true);
        manterUsuarioView.getTxtEmail().setEnabled(true);
        manterUsuarioView.getTxtNome().setEnabled(true);
        manterUsuarioView.getBtnEditar().setEnabled(false);
        manterUsuarioView.getBtnSalvar().setEnabled(true);
        manterUsuarioView.getBtnExcluir().setEnabled(false);
        manterUsuarioView.getPsSenha().setVisible(false);
        manterUsuarioView.getLblSenha().setVisible(false);
        manterUsuarioView.getCbAdmin().setVisible(true);
        manterUsuarioView.getCbAutorizado().setVisible(true);
        manterUsuarioView.getCbAdmin().setEnabled(true);
        manterUsuarioView.getCbAutorizado().setEnabled(true);
        manterUsuarioView.getLblDataCriacao().setVisible(true);
        manterUsuarioView.getLblDataModificacao().setVisible(true);;
        manterUsuarioView.getTxtId().setEditable(false);
        
    }
    
    @Override
    public void salvar() throws SQLException{
        Usuario usuario = presenter.lerCamposAtualizacao();
        presenter.setUsuario(usuario);
        command.executar();
        presenter.notificar();
        presenter.setEstado(new VisualizarUsuarioState(presenter));
    }
    
    @Override
    public void cancelar(){
        presenter.setEstado(new VisualizarUsuarioState(presenter));
    }
    
}
