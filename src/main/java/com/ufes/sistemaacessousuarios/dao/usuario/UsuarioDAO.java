package com.ufes.sistemaacessousuarios.dao.usuario;

import com.ufes.sistemaacessousuarios.conexao.ConexaoSQLite;
import com.ufes.sistemaacessousuarios.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    public void updateSenha(Usuario usuario) throws SQLException {
        PreparedStatement ps = null;
        String query = ""
                .concat("\n UPDATE usuario SET")
                .concat("\n ds_senha = ?")
                .concat("\n , dt_modificacao = ?")
                .concat("\n WHERE id_usuario = ?;");
        try {
            conexao = ConexaoSQLite.getConnection();
            ps = conexao.prepareStatement(query);
            ps.setString(1, usuario.getSenha());
            ps.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            ps.setLong(3, usuario.getId());
            System.out.println(ps.toString());
            ps.executeUpdate();  
        } catch (SQLException ex) {
            throw new SQLException("Erro ao atualizar senha.\n" + ex.getMessage());
        } finally {
            ConexaoSQLite.closeConnection(conexao, ps);
        }
    }

    @Override
    public void delete(long id) throws SQLException {
        PreparedStatement ps = null;
        
        try {
            String query = ""
                .concat("\n DELETE FROM usuario")
                .concat("\n WHERE id_usuario = ?;");
            
            conexao = ConexaoSQLite.getConnection();
            
            ps = conexao.prepareStatement(query);
            ps.setLong(1, id);
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao excluir usuário.\n"
                    + ex.getMessage());
        } finally {
            ConexaoSQLite.closeConnection(conexao, ps);
        }
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
            throw new SQLException("Erro ao buscar usuário.\n"
                    + ex.getMessage());
        } finally {
            ConexaoSQLite.closeConnection(conexao, ps, rs);
        }
    }

    @Override
    public List<Usuario> getAll() throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            String query = ""
                .concat("\n SELECT ")
                .concat("\n     u.id_usuario")
                .concat("\n     , u.nm_usuario")
                .concat("\n     , u.ds_senha")
                .concat("\n     , u.ds_email")
                .concat("\n FROM usuario u ");
            
            conexao = ConexaoSQLite.getConnection();
            
            ps = conexao.prepareStatement(query);
            
            rs = ps.executeQuery();
            
            if (!rs.next()) {
                throw new SQLException("Não há usuários cadastrados");
            }
            
            do{
                Long id = rs.getLong(1);
                String nome = rs.getString(2);
                String senha = rs.getString(3);
                String email = rs.getString(4);
                
                usuarios.add(new Usuario(id, nome, senha, email));
            }while(rs.next());
   
            return usuarios;
        } catch (SQLException ex) {
            throw new SQLException("Erro ao buscar usuário.\n"
                    + ex.getMessage());
        } finally {
            ConexaoSQLite.closeConnection(conexao, ps, rs);
        }
    }  
}
