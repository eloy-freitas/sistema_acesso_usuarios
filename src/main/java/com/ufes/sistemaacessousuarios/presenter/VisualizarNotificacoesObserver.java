package com.ufes.sistemaacessousuarios.presenter;

import com.ufes.sistemaacessousuarios.model.NotificacaoDTO;


public interface VisualizarNotificacoesObserver {
    void visualizarNotificacao(NotificacaoDTO dto);
}
