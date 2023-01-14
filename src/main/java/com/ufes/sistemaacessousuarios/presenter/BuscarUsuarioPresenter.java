package com.ufes.sistemaacessousuarios.presenter;

import com.ufes.sistemaacessousuarios.model.Usuario;
import com.ufes.sistemaacessousuarios.persistencia.service.usuario.IUsuarioService;
import com.ufes.sistemaacessousuarios.persistencia.service.usuario.UsuarioService;
import com.ufes.sistemaacessousuarios.view.BuscarUsuarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.ListIterator;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


public class BuscarUsuarioPresenter {
    private BuscarUsuarioView view;
    private IUsuarioService usuarioService;
    private DefaultTableModel tmUsuarios;
    private List<Usuario> usuarios;
    
    public BuscarUsuarioPresenter() {
        view = new BuscarUsuarioView();
        initServices();
        try {
            usuarios = usuarioService.buscarTodos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view,
                    "Erro ao listar os usuários.\n\n"
                    + ex.getMessage(),
                    "ERRO",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        initTabela();
        popularTabela();
        initListeners();
    }
    
    private void initServices(){
        usuarioService = new UsuarioService();
    }
    
    private void initListeners(){
        view.getBtnBuscar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        view.getBtnVisualizar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                visualizarDetalhesUsuarios();
            }
            
        });
    }
    
    private void limpaTabela() {
        int rowCount = tmUsuarios.getRowCount();
        if (rowCount > 0) {
            for (int i = rowCount - 1; i >= 0; i--) {
                tmUsuarios.removeRow(i);
            }
        }
    }

    private void popularTabela() {
        limpaTabela();
        if(!usuarios.isEmpty()){
            ListIterator<Usuario> iterator = this.usuarios.listIterator();
            while (iterator.hasNext()) {
                Usuario usuario = iterator.next();
                tmUsuarios.addRow(new Object[]{
                    usuario.getId(),
                    usuario.getNome(),
                    usuario.getLogin(),
                    usuario.getEmail(),
                    usuario.isAdmin(),
                    usuario.isAutorizado()
                });
            }
        }
    }
    
    private void initTabela() {
        JTable tabela = view.getTblUsuarios();
        tmUsuarios = new DefaultTableModel(
                new Object[][]{},
                new String[]{"id", "nome", "username", "email", "admin", "autorizado"}
        ){
            Class[] types = new Class [] {
                java.lang.Long.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.Boolean.class, 
                java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
        tmUsuarios.setNumRows(0);

        tabela.setModel(tmUsuarios);

    }

    public BuscarUsuarioView getView() {
        return view;
    }
    
    private void visualizarDetalhesUsuarios() {
        JTable tabela = view.getTblUsuarios();
        int linha = tabela.getSelectedRow();
        Usuario usuario;
        try {
            Object id = tabela.getModel().getValueAt(linha, 0);
            usuario = usuarioService.buscarPorID(Long.parseLong(id.toString()));
            new ManterUsuarioPresenter(usuario);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view,
                    "Erro ao buscar funcionário.\n\n"
                    + ex.getMessage(),
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        } catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(view,
                    "Você deve selecionar um funcionário.\n\n",
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
