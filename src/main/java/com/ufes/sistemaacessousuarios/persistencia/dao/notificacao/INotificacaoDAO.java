package com.ufes.sistemaacessousuarios.persistencia.dao.notificacao;

import com.ufes.sistemaacessousuarios.model.Notificacao;
import com.ufes.sistemaacessousuarios.model.NotificacaoDTO;
import com.ufes.sistemaacessousuarios.model.Usuario;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;


public interface INotificacaoDAO {
    void notifyNewUser(Usuario remetente, List<Usuario> destinatarios, Notificacao notificacao) throws SQLException;
    void save(Notificacao notificacao) throws SQLException;
    List<NotificacaoDTO> getAllNotifies() throws SQLException;
    List<NotificacaoDTO> getNotifiesByUsername(String username) throws SQLException;
    int getTotalNotifies(String username) throws SQLException;
    NotificacaoDTO getNotficacaoByID(String idNotificacao) throws SQLException;
    void readNotificacao(String idNotificacao) throws SQLException;
}
