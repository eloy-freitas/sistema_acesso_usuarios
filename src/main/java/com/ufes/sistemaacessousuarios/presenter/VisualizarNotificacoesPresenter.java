package com.ufes.sistemaacessousuarios.presenter;

import com.ufes.sistemaacessousuarios.model.NotificacaoDTO;
import com.ufes.sistemaacessousuarios.model.Usuario;
import com.ufes.sistemaacessousuarios.persistencia.service.notificacao.INotificacaoService;
import com.ufes.sistemaacessousuarios.persistencia.service.notificacao.NotificacaoService;
import com.ufes.sistemaacessousuarios.view.VisualizarNotificacoesView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


public class VisualizarNotificacoesPresenter {
    private Usuario usuario;
    private INotificacaoService notificacaoService;
    private List<NotificacaoDTO> notificacoes;
    private VisualizarNotificacoesView view;
    private DefaultTableModel tmNotificacoes;
    private List<VisualizarNotificacoesObserver> notificacoesObservers;

    public VisualizarNotificacoesPresenter(Usuario usuario) {
        this.usuario = usuario;
        view = new VisualizarNotificacoesView();
        initServices();
        initListeners();
        atualizarTabela();
    }
    
    public void initServices(){
        notificacaoService = new NotificacaoService();
        notificacoesObservers = new ArrayList<>();
    }
    
    public void initListeners(){
        view.getBtnAtualizar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarTabela();
            }
            
        });
        
        view.getBtnVisualizar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    visualizarDetalhesNotificacao();
                    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(view,
                            "Erro ao buscar notificação .\n\n"
                            + ex.getMessage(),
                            "ERRO",
                            JOptionPane.ERROR_MESSAGE);
                } catch(ArrayIndexOutOfBoundsException ex){
                    JOptionPane.showMessageDialog(view,
                            "Você deve selecionar uma mensagem.\n\n",
                            "ERRO",
                            JOptionPane.ERROR_MESSAGE);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(view,
                            "Formato de data inválido.\n\n" + ex.getMessage(),
                            "ERRO",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        view.getBtnCancelar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });
    }
    
    public void atualizarTabela(){
        try {
            notificacoes = notificacaoService
                    .buscarNotificacoesPorUsername(usuario.getLogin());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view,
                    "Erro ao listar notificações.\n\n"
                    + ex.getMessage(),
                    "ERRO",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        initTabela();
        popularTabela();
    }
    
    private void popularTabela() {
        limpaTabela();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");
        if(!notificacoes.isEmpty()){
            ListIterator<NotificacaoDTO> iterator = this.notificacoes.listIterator();
            while (iterator.hasNext()) {
                NotificacaoDTO notificacao = iterator.next();
                tmNotificacoes.addRow(new Object[]{
                    formatter.format(notificacao.getIdNotificacao()),
                    notificacao.getIdRemetente(),
                    notificacao.getRemetenteUsername(),
                    notificacao.isFlLida(),
                    formatter.format(notificacao.getDataEnvio())
                });
            }
        }
    }
    
    private void limpaTabela() {
        int rowCount = tmNotificacoes.getRowCount();
        if (rowCount > 0) {
            for (int i = rowCount - 1; i >= 0; i--) {
                tmNotificacoes.removeRow(i);
            }
        }
    }
    
    private void initTabela() { 
        JTable tabela = view.getTblNotificacoes();
        tmNotificacoes = new DefaultTableModel(
                new Object[][]{},
                new String[]{"id_notificacao","id_remetente", "nm_remetente", "fl_lida", "dt_envio"}
        ){
            Class[] types = new Class [] {
                java.lang.Long.class,
                java.lang.Long.class,
                java.lang.String.class,
                java.lang.Boolean.class, 
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tmNotificacoes.setNumRows(0);

        tabela.setModel(tmNotificacoes);

    }

    public VisualizarNotificacoesView getView() {
        return view;
    }
    
    public void fechar(){
        view.dispose();
    }
    
    public void subscribeNotificacaoObserver(VisualizarNotificacoesObserver observer){
        notificacoesObservers.add(observer);
    }
    
    private void visualizarDetalhesNotificacao() throws SQLException, ArrayIndexOutOfBoundsException, ParseException{
        JTable tabela = view.getTblNotificacoes();
        int linha = tabela.getSelectedRow();
        NotificacaoDTO dto;
        Object id = tabela.getModel().getValueAt(linha, 0);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
        Date data = df.parse(id.toString());
        long epoch = data.getTime();
        String strEpoch = String.valueOf(epoch);
        dto = notificacaoService.buscarNotificacaoPorID(strEpoch);
        notificacaoService.visualizarNotificacao(strEpoch);
        atualizarTabela();
        for(VisualizarNotificacoesObserver observer : notificacoesObservers)
            observer.visualizarNotificacao(dto);
    }
}
