package com.ufes.sistemaacessousuarios.persistencia.dao.notificacao;

import com.ufes.sistemaacessousuarios.conexao.ConexaoSQLite;
import com.ufes.sistemaacessousuarios.model.Notificacao;
import com.ufes.sistemaacessousuarios.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;


public class NotificacaoDAO implements INotificacaoDAO{
    private Connection conexao;
    
    public NotificacaoDAO() {
    }
    
    @Override
    public void notifyNewUser(Usuario remetente, List<Usuario> destinatarios, Notificacao notificacao) throws SQLException {
        PreparedStatement ps = null;
        try {
            conexao = ConexaoSQLite.getConnection();
            for(Usuario destinatario : destinatarios){
                String query = ""
                    .concat("\n insert into usuarios_notificados (")
                    .concat("\n     id_notificacao")
                    .concat("\n     , id_destinatario")
                    .concat("\n     , id_remetente")
                    .concat("\n     , fl_lida")
                    .concat("\n     , dt_envio")
                    .concat("\n     , dt_visualizacao)")
                    .concat("\n values(?,?,?,?,?,?);");

                ps = conexao.prepareStatement(query);
                ps.setTimestamp(1, Timestamp.valueOf(notificacao.getIdNotificacao()));
                ps.setLong(2, destinatario.getId());
                ps.setLong(3, remetente.getId());
                ps.setBoolean(4, false);
                ps.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
                ps.setTimestamp(6, null);
                ps.executeUpdate();  
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao registrar o usuário.\n" + ex.getMessage());
        } finally {
            ConexaoSQLite.closeConnection(conexao, ps);
        }

    }

    @Override
    public void save(Notificacao notificacao) throws SQLException {
        PreparedStatement ps = null;
        String query = ""
            .concat("\n insert into notificacao(")
            .concat("\n     ds_mensagem")
            .concat("\n     , fl_tipo")
            .concat("\n     , id_notificacao) ")
            .concat("\n values (?, ?, ?);");
        try {
            conexao = ConexaoSQLite.getConnection();
            ps = conexao.prepareStatement(query);
            ps.setString(1, notificacao.getMensagem());
            ps.setInt(2, notificacao.getTipo());
            ps.setTimestamp(3, Timestamp.valueOf(notificacao.getIdNotificacao()));
            ps.executeUpdate();  
        } catch (SQLException ex) {
            throw new SQLException("Erro ao registrar o usuário.\n" + ex.getMessage());
        } finally {
            ConexaoSQLite.closeConnection(conexao, ps);
        }
    }
    
    
}
