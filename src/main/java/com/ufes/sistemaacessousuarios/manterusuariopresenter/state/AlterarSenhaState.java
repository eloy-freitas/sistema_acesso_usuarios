package com.ufes.sistemaacessousuarios.manterusuariopresenter.state;

import com.ufes.sistemaacessousuarios.manterusuariopresenter.command.AlterarSenhaCommand;
import com.ufes.sistemaacessousuarios.model.Usuario;
import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import java.io.IOException;
import java.sql.SQLException;


public class AlterarSenhaState extends ManterUsuarioPresenterState{

    public AlterarSenhaState(ManterUsuarioPresenter presenter) {
        super(presenter);
        command = new AlterarSenhaCommand(presenter);
        initComponents();
    }
    
    @Override
    public void initComponents(){
        presenter.setMensagemSalvarSucesso("Senha alterda com sucesso!");
        manterUsuarioView.setTitle("Alterar senha");
        manterUsuarioView.getTxtUserName().setEnabled(false);
        manterUsuarioView.getTxtEmail().setEnabled(false);
        manterUsuarioView.getTxtNome().setEnabled(false);
        manterUsuarioView.getBtnEditar().setEnabled(false);
        manterUsuarioView.getBtnExcluir().setEnabled(false);
        manterUsuarioView.getCbAdmin().setVisible(false);
        manterUsuarioView.getCbAutorizado().setVisible(false);
        manterUsuarioView.getLblDataCriacao().setVisible(true);
        manterUsuarioView.getLblDataModificacao().setVisible(true);
        manterUsuarioView.getTxtId().setEditable(false);
        
    }
    
    @Override
    public void salvar() throws SQLException, IOException{
        Usuario usuario;
        try{
            usuario = presenter.lerCamposAtualizacaoSenha();
        }catch(IOException ex){
            throw new IOException(ex);
        }
        presenter.setUsuario(usuario);
        command.executar();
        presenter.fechar();
    }
    
    @Override
    public void cancelar(){
        presenter.fechar();
    }
}
