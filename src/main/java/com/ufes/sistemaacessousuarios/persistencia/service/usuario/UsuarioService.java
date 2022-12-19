package com.ufes.sistemaacessousuarios.persistencia.service.usuario;

import com.ufes.sistemaacessousuarios.model.Usuario;
import com.ufes.sistemaacessousuarios.persistencia.repository.usuario.IUsuarioRepository;
import com.ufes.sistemaacessousuarios.persistencia.repository.usuario.UsuarioRepository;
import java.sql.SQLException;
import java.util.List;


public class UsuarioService implements IUsuarioService{
    private IUsuarioRepository usuarioRepository;
    
    public UsuarioService() {
        this.usuarioRepository = new UsuarioRepository();
    }

    @Override
    public void salvar(Usuario usuario) throws SQLException {
        this.usuarioRepository.salvar(usuario);
    }

    @Override
    public void atualizarSenha(Usuario usuario) throws SQLException {
        this.usuarioRepository.atualizarSenha(usuario);
    }

    @Override
    public void deletar(long id) throws SQLException {
        this.usuarioRepository.deletar(id);
    }

    @Override
    public Usuario buscarPorID(long id) throws SQLException {
        return this.usuarioRepository.buscarPorID(id);
    }

    @Override
    public List<Usuario> buscarTodos() throws SQLException {
        return this.usuarioRepository.buscarTodos();
    }

    @Override
    public void autorizarUsuario(long id) throws SQLException {
        this.usuarioRepository.autorizarUsuario(id);
    }
}