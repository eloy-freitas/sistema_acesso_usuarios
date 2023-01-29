package com.ufes.sistemaacessousuarios.presenter;

import com.ufes.sistemaacessousuarios.model.NotificacaoDTO;
import com.ufes.sistemaacessousuarios.model.Usuario;
import com.ufes.sistemaacessousuarios.persistencia.service.notificacao.NotificacaoService;
import com.ufes.sistemaacessousuarios.persistencia.service.usuario.UsuarioService;
import com.ufes.sistemaacessousuarios.view.VisualizarNotificacaoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;


public class VisualizarNotificacaoPresenter {
    private VisualizarNotificacaoView view;
    private NotificacaoDTO dto;
    private UsuarioService usuarioService;
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
        usuarioService = new UsuarioService();
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
                 try {
                     autorizarUsuario(dto.getIdRemetente());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(view,
                        "Erro ao autorizar usuário.\n\n"
                        + ex.getMessage(),
                        "ERRO",
                        JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
        });
    }
    
    public void carregarCampos(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        view.getLblRemetente().setText("remetente: " + dto.getRemetenteUsername());
        view.getLblDataEnvio().setText("data de envio: " + formatter.format(dto.getDataEnvio()));
        view.getTxtMensagem().setText(dto.getMensagem());
        boolean isVisualizada;
        if(dto.getDataVisualizacao() == null){
            isVisualizada = false;
        }
        else{
            isVisualizada = true;
            view.getLblDataVisualizacao().setText(
                "data visualização: " 
                + formatter.format(dto.getDataVisualizacao())
            );
        }
        view.getLblDataVisualizacao().setVisible(isVisualizada);
        
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
    
    public void autorizarUsuario(Long id) throws SQLException{
        usuarioService.autorizarUsuario(id);
    }
}
