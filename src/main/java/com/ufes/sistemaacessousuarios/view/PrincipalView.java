/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ufes.sistemaacessousuarios.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author eloy
 */
public class PrincipalView extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalView
     */
    public PrincipalView() {
        initComponents();
        /*Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screensize.width, screensize.height);*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        dpMenu = new javax.swing.JDesktopPane();
        lblInfoUsuario = new javax.swing.JLabel();
        btnNotificacoes = new javax.swing.JButton();
        mnToolBar = new javax.swing.JMenuBar();
        mnUsuario = new javax.swing.JMenu();
        miLogin = new javax.swing.JMenuItem();
        miCadastrar = new javax.swing.JMenuItem();
        mnConfiguracoes = new javax.swing.JMenu();
        miAlterarSenha = new javax.swing.JMenuItem();
        mnSair = new javax.swing.JMenu();
        miSair = new javax.swing.JMenuItem();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout dpMenuLayout = new javax.swing.GroupLayout(dpMenu);
        dpMenu.setLayout(dpMenuLayout);
        dpMenuLayout.setHorizontalGroup(
            dpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 771, Short.MAX_VALUE)
        );
        dpMenuLayout.setVerticalGroup(
            dpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 451, Short.MAX_VALUE)
        );

        lblInfoUsuario.setText("<tipo usuário>:<usuário>");

        btnNotificacoes.setText("<Número> Notificações");

        mnUsuario.setText("Usuário");

        miLogin.setText("Login");
        mnUsuario.add(miLogin);

        miCadastrar.setText("Cadastrar");
        mnUsuario.add(miCadastrar);

        mnToolBar.add(mnUsuario);

        mnConfiguracoes.setText("Configurações");

        miAlterarSenha.setText("Alterar senha");
        mnConfiguracoes.add(miAlterarSenha);

        mnToolBar.add(mnConfiguracoes);

        mnSair.setText("Sair");

        miSair.setText("Sair");
        mnSair.add(miSair);

        mnToolBar.add(mnSair);

        setJMenuBar(mnToolBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpMenu)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInfoUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNotificacoes)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dpMenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInfoUsuario)
                    .addComponent(btnNotificacoes))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalView().setVisible(true);
            }
        });
    }

    public JDesktopPane getDpMenu() {
        return dpMenu;
    }

    public JMenuItem getMiCadastrar() {
        return miCadastrar;
    }

    public JMenuItem getMiLogin() {
        return miLogin;
    }

    public JMenuItem getMiSair() {
        return miSair;
    }

    public JMenu getMnSair() {
        return mnSair;
    }
    
    public JMenu getMnUsuario() {
        return mnUsuario;
    }

    public JMenuBar getMnToolBar() {
        return mnToolBar;
    }

    public JButton getBtnNotificacoes() {
        return btnNotificacoes;
    }

    public JLabel getLblInfoUsuario() {
        return lblInfoUsuario;
    }

    public JMenuItem getMiAlterarSenha() {
        return miAlterarSenha;
    }

    public JMenu getMnConfiguracoes() {
        return mnConfiguracoes;
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNotificacoes;
    private javax.swing.JDesktopPane dpMenu;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel lblInfoUsuario;
    private javax.swing.JMenuItem miAlterarSenha;
    private javax.swing.JMenuItem miCadastrar;
    private javax.swing.JMenuItem miLogin;
    private javax.swing.JMenuItem miSair;
    private javax.swing.JMenu mnConfiguracoes;
    private javax.swing.JMenu mnSair;
    private javax.swing.JMenuBar mnToolBar;
    private javax.swing.JMenu mnUsuario;
    // End of variables declaration//GEN-END:variables
}
