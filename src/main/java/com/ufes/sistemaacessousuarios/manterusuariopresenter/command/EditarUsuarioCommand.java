package com.ufes.sistemaacessousuarios.manterusuariopresenter.command;

import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import java.sql.SQLException;


public class EditarUsuarioCommand extends ManterUsuarioCommand{

    public EditarUsuarioCommand(ManterUsuarioPresenter presenter) {
        super(presenter);
    }

    @Override
    public void executar() throws SQLException {
        presenter.getUsuarioService().atualizarUsuario(presenter.getUsuario());
    }
    
    
}
