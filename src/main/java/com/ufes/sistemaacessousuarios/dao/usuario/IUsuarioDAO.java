package com.ufes.sistemaacessousuarios.dao.usuario;

import com.ufes.sistemaacessousuarios.model.Usuario;
import java.sql.SQLException;
import java.util.List;


public interface IUsuarioDAO {
    void save(Usuario usuario) throws SQLException;
    void update(Usuario usuario) throws SQLException;
    void delete(long id) throws SQLException;
    Usuario getByID(long id) throws SQLException;
    List<Usuario> getAll() throws SQLException;          
}
