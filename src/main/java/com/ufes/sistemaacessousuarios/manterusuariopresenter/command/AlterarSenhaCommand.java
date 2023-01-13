package com.ufes.sistemaacessousuarios.manterusuariopresenter.command;

import com.ufes.sistemaacessousuarios.presenter.ManterUsuarioPresenter;
import java.sql.SQLException;


public class AlterarSenhaCommand extends ManterUsuarioCommand{

    public AlterarSenhaCommand(ManterUsuarioPresenter presenter) {
        super(presenter);
    }

    @Override
    public void executar() throws SQLException {
        presenter.getUsuarioService().atualizarSenha(presenter.getUsuario());
    }
    
    
}
