package com.ufes.sistemaacessousuarios.persistencia.repository.notificacao;

import com.ufes.sistemaacessousuarios.model.Notificacao;
import com.ufes.sistemaacessousuarios.model.Usuario;
import com.ufes.sistemaacessousuarios.persistencia.dao.notificacao.INotificacaoDAO;
import com.ufes.sistemaacessousuarios.persistencia.dao.notificacao.NotificacaoDAO;
import com.ufes.sistemaacessousuarios.persistencia.dao.usuario.IUsuarioDAO;
import com.ufes.sistemaacessousuarios.persistencia.dao.usuario.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class NotificacaoRepository  implements INotificacaoRepository{
    private IUsuarioDAO usuarioDAO;
    private INotificacaoDAO notificacaoDAO;
    
    public NotificacaoRepository() {
        usuarioDAO = new UsuarioDAO();
        notificacaoDAO = new NotificacaoDAO();
    }
    
    @Override
    public void notificarNovoUsuario(
            Usuario remetente
            , List<Usuario> destinatarios
            , Notificacao notificacao
    ) throws SQLException {      
        notificacaoDAO.notifyNewUser(remetente, destinatarios, notificacao);
    }

    @Override
    public List<Usuario> buscarAdmins() throws SQLException {
        return usuarioDAO.getAllByFlagAdmin(true);
    }

    @Override
    public Usuario buscarPorUsername(String username) throws SQLException {
        return usuarioDAO.getByUsername(username);
    }

    @Override
    public void salvar(Notificacao notificacao) throws SQLException {
        notificacaoDAO.save(notificacao);
    }

    @Override
    public List<Usuario> buscarTodos() throws SQLException {
        return usuarioDAO.getAll();
    }
    
    
    
    
}
