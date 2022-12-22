package com.ufes.sistemaacessousuarios.presenter.command;

import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import java.sql.SQLException;


public class SalvarUsuarioCommand extends ManterUsuarioCommand{

    public SalvarUsuarioCommand(ManterUsuarioPresenter presenter) {
        super(presenter);
    }

    @Override
    public void executar() throws SQLException{
        presenter.getUsuarioService().salvar(presenter.getUsuario());
    }
    
}
