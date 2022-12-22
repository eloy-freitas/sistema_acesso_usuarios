package com.ufes.sistemaacessousuarios.presenter.state;

import com.ufes.sistemaacessousuarios.model.Usuario;
import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import java.sql.SQLException;


public class CadastroUsuarioState extends ManterUsuarioPresenterState{

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
        
        presenter.getUsuarioService().salvar(usuario);
    }
    
}
