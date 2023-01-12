package com.ufes.sistemaacessousuarios.persistencia.repository.usuario;

import com.ufes.sistemaacessousuarios.model.Usuario;
import java.sql.SQLException;
import java.util.List;


public interface IUsuarioRepository {
    void salvar(Usuario usuario) throws SQLException;
    void atualizarSenha(Usuario usuario) throws SQLException;
    void deletar(long id) throws SQLException;
    Usuario buscarPorID(long id) throws SQLException;
    List<Usuario> buscarTodos() throws SQLException;
    void autorizarUsuario(long id) throws SQLException;
    List<Usuario> buscarTodosPorFlagAutorizado(boolean isAutorizado) throws SQLException;
    List<Usuario> buscarTodosPorFlagAdmin(boolean isAdmin) throws SQLException;  
    boolean isAdmin(Usuario usuario) throws SQLException;
    boolean isAutorizado(Usuario usuario) throws SQLException;
    Usuario login(String login, String senha) throws SQLException;
    int buscarTotalNotificacoes(Usuario usuario) throws SQLException;
}
