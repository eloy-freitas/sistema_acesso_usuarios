package com.ufes.sistemaacessousuarios.presenter.command;

import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import java.sql.SQLException;


public abstract class ManterUsuarioCommand {
    protected ManterUsuarioPresenter presenter;

    public ManterUsuarioCommand(ManterUsuarioPresenter presenter) {
        this.presenter = presenter;
    }
    
    public abstract void executar() throws SQLException;

    
}
