package com.ufes.sistemaacessousuarios.persistencia.service.notificacao;

import com.ufes.sistemaacessousuarios.model.Notificacao;
import com.ufes.sistemaacessousuarios.model.Usuario;
import java.sql.SQLException;
import java.util.List;


public interface INotificacaoService {
    void notificarNovoUsuario(
            Usuario remetenteSemId
    ) throws SQLException;
    void salvar(Notificacao notificacao) throws SQLException;
    List<Usuario> buscarAdmins() throws SQLException;
    Usuario buscarPorUsername(String username) throws SQLException;
}
