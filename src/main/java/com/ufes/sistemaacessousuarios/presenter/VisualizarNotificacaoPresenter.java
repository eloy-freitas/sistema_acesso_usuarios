package com.ufes.sistemaacessousuarios.presenter;

import com.ufes.sistemaacessousuarios.model.NotificacaoDTO;
import com.ufes.sistemaacessousuarios.model.Usuario;
import com.ufes.sistemaacessousuarios.persistencia.service.notificacao.NotificacaoService;
import com.ufes.sistemaacessousuarios.view.VisualizarNotificacaoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;


public class VisualizarNotificacaoPresenter {
    private VisualizarNotificacaoView view;
    private NotificacaoDTO dto;
    private NotificacaoService notificacaoService;

    public VisualizarNotificacaoPresenter(NotificacaoDTO dto) {
        view = new VisualizarNotificacaoView();
        this.dto = dto;
        initServices();
        initListeners();
        initComponentes();
        carregarCampos();
    }
    
    private void initServices(){
        notificacaoService = new NotificacaoService();
    }
    
    private void initListeners(){
        view.getBtnCancelar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
            
        });
        
        view.getBtnAutorizar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            }
            
        });
    }
    
    public void carregarCampos(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        view.getLblRemetente().setText("remetente: " + dto.getRemetenteUsername());
        view.getLblDataEnvio().setText("data de envio: " + formatter.format(dto.getDataEnvio()));
        view.getTxtMensagem().setText(dto.getMensagem());
        if(dto.getDataVisualizacao() == null)
            view.getLblDataVisualizacao().setVisible(false);
        else{
            view.getLblDataVisualizacao().setVisible(true);
            view.getLblDataVisualizacao().setText("data visualização: " + formatter.format(dto.getDataVisualizacao()));
        }
        
        
    }
    
    public void initComponentes(){
        view.getTxtMensagem().setEditable(false);
        boolean btnAtorizar;
        if(dto.getTipo() == 1)
            btnAtorizar = true;
        else 
            btnAtorizar = false;
            
        view.getBtnAutorizar().setVisible(btnAtorizar);
    }
    
    public void fechar(){
        view.dispose();
    }

    public VisualizarNotificacaoView getView() {
        return view;
    }
}
