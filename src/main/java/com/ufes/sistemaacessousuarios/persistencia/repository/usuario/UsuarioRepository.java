package com.ufes.sistemaacessousuarios.persistencia.repository.usuario;

import com.ufes.sistemaacessousuarios.persistencia.dao.usuario.IUsuarioDAO;
import com.ufes.sistemaacessousuarios.persistencia.dao.usuario.UsuarioDAO;
import com.ufes.sistemaacessousuarios.model.Usuario;
import java.sql.SQLException;
import java.util.List;


public class UsuarioRepository implements IUsuarioRepository{
    private IUsuarioDAO usuarioDAO;
    
    public UsuarioRepository() {
        this.usuarioDAO = new UsuarioDAO();
    }

    @Override
    public void salvar(Usuario usuario) throws SQLException {
        this.usuarioDAO.save(usuario);
    }

    @Override
    public void atualizarSenha(Usuario usuario) throws SQLException {
        this.usuarioDAO.updateSenha(usuario);
    }

    @Override
    public void deletar(long id) throws SQLException {
       this.usuarioDAO.delete(id);
    }

    @Override
    public Usuario buscarPorID(long id) throws SQLException {
        return this.usuarioDAO.getByID(id);
    }

    @Override
    public List<Usuario> buscarTodos() throws SQLException {
        return this.usuarioDAO.getAll();
    }

    @Override
    public void autorizarUsuario(long id) throws SQLException {
        this.usuarioDAO.autorizeUsuario(id);
    }

    @Override
    public List<Usuario> buscarTodosPorFlagAutorizado(boolean isAutorizado) throws SQLException {
        return this.usuarioDAO.getAllByFlagAutorizado(isAutorizado);
    }

    @Override
    public List<Usuario> buscarTodosPorFlagAdmin(boolean isAdmin) throws SQLException {
        return this.usuarioDAO.getAllByFlagAdmin(isAdmin);
    }

    @Override
    public boolean isAdmin(Usuario usuario) throws SQLException {
        return this.usuarioDAO.isAdmin(usuario);
    }
}
