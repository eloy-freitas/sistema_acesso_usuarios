package com.ufes.sistemaacessousuarios.presenter.state;

import com.ufes.sistemaacessousuarios.model.Usuario;
import com.ufes.sistemaacessousuarios.presenter.LoginPresenter;
import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import com.ufes.sistemaacessousuarios.presenter.command.ManterUsuarioCommand;
import com.ufes.sistemaacessousuarios.presenter.command.SalvarUsuarioCommand;
import java.sql.SQLException;


public class CadastroUsuarioState extends ManterUsuarioPresenterState{
    
    private ManterUsuarioCommand command;
    
    public CadastroUsuarioState(ManterUsuarioPresenter presenter) {
        super(presenter);
        setViewComponents();
    }
    
    @Override
    public void setViewComponents(){
        this.presenter.getView().getBtnEditar().setEnabled(false);
        this.presenter.getView().getBtnExcluir().setEnabled(false);
        this.presenter.getView().getCbAdmin().setVisible(false);
        this.presenter.getView().getCbAutorizado().setVisible(false);
        this.presenter.getView().getLblDataCriacao().setVisible(false);
        this.presenter.getView().getLblDataModificacao().setVisible(false);
        this.presenter.getView().getTxtId().setEditable(false);
    }
    
    @Override
    public void salvar() throws SQLException{
        Usuario usuario = presenter.lerCampos();
        presenter.setUsuario(usuario);
        this.command = new SalvarUsuarioCommand(presenter);
        this.command.executar();
        this.presenter.fechar();
        new LoginPresenter();
    }
    
    @Override
    public void cancelar(){
        presenter.fechar();
        new LoginPresenter();
    }
}
