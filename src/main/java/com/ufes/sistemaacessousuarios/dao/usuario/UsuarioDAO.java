package com.ufes.sistemaacessousuarios.dao.usuario;

import com.ufes.sistemaacessousuarios.conexao.ConexaoSQLite;
import com.ufes.sistemaacessousuarios.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;


public class UsuarioDAO implements IUsuarioDAO{
    private Connection conexao;
    
    public UsuarioDAO() {
    
    }

    @Override
    public void save(Usuario usuario) throws SQLException {
        PreparedStatement ps = null;
        String query = ""
                .concat("\n INSERT INTO usuario(")
                .concat("\n nm_usuario")
                .concat("\n , ds_senha")
                .concat("\n , ds_email")
                .concat("\n , dt_modificacao)")
                .concat("\n VALUES (?, ?, ?, ?);");
        try {
            conexao = ConexaoSQLite.getConnection();
            ps = conexao.prepareStatement(query);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getEmail());
            ps.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
            ps.executeUpdate();  
        } catch (SQLException ex) {
            throw new SQLException("Erro ao registrar o funcionário.\n" + ex.getMessage());
        } finally {
            ConexaoSQLite.closeConnection(conexao, ps);
        }
    }

    @Override
    public void update(Usuario usuario) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario getByID(long id) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = ""
                .concat("\n SELECT ")
                .concat("\n     u.nm_usuario")
                .concat("\n     , u.ds_senha")
                .concat("\n     , u.ds_email")
                .concat("\n     , u.dt_modificacao")
                .concat("\n FROM usuario u ")
                .concat("\n WHERE u.id_usuario = ?;");
            conexao = ConexaoSQLite.getConnection();
            ps = conexao.prepareStatement(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                throw new SQLException("Usuário com id "
                        + id + "não encontrado");
            }
            String nome = rs.getString(1);
            String senha = rs.getString(2);
            String email = rs.getString(3);
           
            return new Usuario(id, nome, senha, email);
        } catch (SQLException ex) {
            throw new SQLException("Erro ao buscar funcionário.\n"
                    + ex.getMessage());
        } finally {
            ConexaoSQLite.closeConnection(conexao, ps, rs);
        }
    }

    @Override
    public List<Usuario> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
