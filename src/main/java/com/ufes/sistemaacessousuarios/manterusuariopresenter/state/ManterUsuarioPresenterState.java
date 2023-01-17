package com.ufes.sistemaacessousuarios.manterusuariopresenter.state;

import com.ufes.sistemaacessousuarios.manterusuariopresenter.command.ManterUsuarioCommand;
import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import com.ufes.sistemaacessousuarios.view.ManterUsuarioView;
import java.sql.SQLException;

public abstract class ManterUsuarioPresenterState {
    
    protected ManterUsuarioPresenter presenter;
    protected ManterUsuarioView manterUsuarioView;
    protected ManterUsuarioCommand command;

    public ManterUsuarioPresenterState(ManterUsuarioPresenter presenter) {
        this.presenter = presenter;
        this.manterUsuarioView = this.presenter.getView();
    }
    
    public void salvar() throws SQLException{
        throw new RuntimeException("Operação inválida para o estado atual");
    }
    
    public void cancelar(){
        throw new RuntimeException("Operação inválida para o estado atual");
    }
    
    public void editar(){
        throw new RuntimeException("Operação inválida para o estado atual");
    }
    
    public void excluir() throws SQLException{
        throw new RuntimeException("Operação inválida para o estado atual");
    }
    
    public void initComponents(){
        throw new RuntimeException("Operação inválida para o estado atual");
    }
}
