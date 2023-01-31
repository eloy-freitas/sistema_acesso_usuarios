package com.ufes.sistemaacessousuarios.persistencia.repository.notificacao;

import com.ufes.sistemaacessousuarios.model.Notificacao;
import com.ufes.sistemaacessousuarios.model.NotificacaoDTO;
import com.ufes.sistemaacessousuarios.model.Usuario;
import java.sql.SQLException;
import java.util.List;


public interface INotificacaoRepository {
    void notificarNovoUsuario(
            Usuario remetente
            , List<Usuario> destinatarios
            , Notificacao notificacao
    ) throws SQLException;
    void salvar(Notificacao notificacao) throws SQLException;
    List<Usuario> buscarAdmins() throws SQLException;
    Usuario buscarPorUsername(String username) throws SQLException;
    List<Usuario> buscarTodos() throws SQLException;
    List<NotificacaoDTO> buscarTodasNotificacoes() throws SQLException;
    List<NotificacaoDTO> buscarNotificacoesPorUsername(String username) throws SQLException;
    int totalNotificacoes(String username) throws SQLException;
    NotificacaoDTO buscarNotificacaoPorID(String idNotificacao) throws SQLException;
    void visualizarNotificacao(String idNotificacao) throws SQLException;

}
