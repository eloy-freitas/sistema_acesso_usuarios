package com.ufes.sistemaacessousuarios.presenter;

import com.ufes.sistemaacessousuarios.model.Usuario;
import java.sql.SQLException;


public interface NotificarUsuarioObserver {
    void notificarNovoUsuario(Usuario remetente) throws SQLException;
}
