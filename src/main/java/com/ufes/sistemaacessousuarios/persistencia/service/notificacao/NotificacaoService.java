package com.ufes.sistemaacessousuarios.persistencia.service.notificacao;

import com.ufes.sistemaacessousuarios.model.Notificacao;
import com.ufes.sistemaacessousuarios.model.NotificacaoDTO;
import com.ufes.sistemaacessousuarios.model.Usuario;
import com.ufes.sistemaacessousuarios.persistencia.repository.notificacao.INotificacaoRepository;
import com.ufes.sistemaacessousuarios.persistencia.repository.notificacao.NotificacaoRepository;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import org.mockito.internal.matchers.Not;


public class NotificacaoService implements INotificacaoService{
    private INotificacaoRepository notificacaoRepository;

    public NotificacaoService() {
        notificacaoRepository = new NotificacaoRepository();
    }
    
    @Override
    public void notificarNovoUsuario(Usuario remetenteSemId) throws SQLException {
        if(notificacaoRepository.buscarTodos().size() > 1 && !remetenteSemId.isAdmin()){
            Usuario remetente = notificacaoRepository.buscarPorUsername(remetenteSemId.getLogin());
            List<Usuario> admins = notificacaoRepository.buscarAdmins();

            if(remetente == null)
                throw new SQLException("Remetente não encontrado!");
            if(admins.isEmpty())
                throw new SQLException("Não existe admins cadastrados");

            String mensagem = ""
                .concat("Solicitação de autorização de uso do sistema do usuário: ")
                .concat(remetente.getLogin());

            Notificacao notificacao = new Notificacao(mensagem, LocalDateTime.now(), 1);

            notificacaoRepository.salvar(notificacao);
            notificacaoRepository.notificarNovoUsuario(remetente, admins, notificacao);
        }
    }

    @Override
    public void salvar(Notificacao notificacao) throws SQLException {
        notificacaoRepository.salvar(notificacao);
    }

    @Override
    public List<Usuario> buscarAdmins() throws SQLException {
         return notificacaoRepository.buscarAdmins();
    }

    @Override
    public Usuario buscarPorUsername(String username) throws SQLException {
        return notificacaoRepository.buscarPorUsername(username);
    }

    @Override
    public List<NotificacaoDTO> buscarTodasNotificacoes() throws SQLException {
        return notificacaoRepository.buscarTodasNotificacoes();
    }

    @Override
    public List<NotificacaoDTO> buscarNotificacoesPorUsername(String username) throws SQLException {
        return notificacaoRepository.buscarNotificacoesPorUsername(username);
    }

    @Override
    public int totalNotificacoes(String username) throws SQLException {
        return notificacaoRepository.totalNotificacoes(username);
    }

    @Override
    public NotificacaoDTO buscarNotificacaoPorID(String idNotificacao) throws SQLException {
        return notificacaoRepository.buscarNotificacaoPorID(idNotificacao);
    }

    @Override
    public void visualizarNotificacao(String idNotificacao) throws SQLException {
        notificacaoRepository.visualizarNotificacao(idNotificacao);
    }
}
