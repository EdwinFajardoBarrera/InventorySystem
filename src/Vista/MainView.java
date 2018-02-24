/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Edwin Fajardo
 */
public class MainView extends javax.swing.JFrame {

    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JBCompras = new javax.swing.JButton();
        JLFondo = new javax.swing.JLabel();
        JBProduccion = new javax.swing.JButton();
        JBRegistroInsumos = new javax.swing.JButton();
        JBInventarios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JBCompras.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JBCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Icons/Compras.png"))); // NOI18N
        JBCompras.setText("COMPRAS");

        JLFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Icons/Background.png"))); // NOI18N

        JBProduccion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JBProduccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Icons/Ventas.png"))); // NOI18N
        JBProduccion.setText("PRODUCCIÓN");

        JBRegistroInsumos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JBRegistroInsumos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Icons/Registro.png"))); // NOI18N
        JBRegistroInsumos.setText("REGISTRO DE INSUMOS");
        JBRegistroInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBRegistroInsumosActionPerformed(evt);
            }
        });

        JBInventarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JBInventarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Icons/Inventario.png"))); // NOI18N
        JBInventarios.setText("INVENTARIOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBCompras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBProduccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBRegistroInsumos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBInventarios))
                    .addComponent(JLFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 1190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBProduccion)
                    .addComponent(JBCompras)
                    .addComponent(JBRegistroInsumos)
                    .addComponent(JBInventarios))
                .addGap(23, 23, 23)
                .addComponent(JLFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBRegistroInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBRegistroInsumosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JBRegistroInsumosActionPerformed

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
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    //Getters and setters
    public JButton getJBCompras() {
        return JBCompras;
    }

    public void setJBCompras(JButton JBCompras) {
        this.JBCompras = JBCompras;
    }

    public JButton getJBVentas() {
        return JBProduccion;
    }

    public void setJBVentas(JButton JBVentas) {
        this.JBProduccion = JBVentas;
    }

    public JButton getJBRegistroInsumos() {
        return JBRegistroInsumos;
    }

    public void setJBRegistroInsumos(JButton JBRegistroInsumos) {
        this.JBRegistroInsumos = JBRegistroInsumos;
    }
    
    public JLabel getJLFondo() {
        return JLFondo;
    }

    public void setJLFondo(JLabel JLFondo) {
        this.JLFondo = JLFondo;
    }

    public JButton getJBInventarios() {
        return JBInventarios;
    }

    public void setJBInventarios(JButton JBInventarios) {
        this.JBInventarios = JBInventarios;
    }
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton JBCompras;
    public javax.swing.JButton JBInventarios;
    public javax.swing.JButton JBProduccion;
    public javax.swing.JButton JBRegistroInsumos;
    public javax.swing.JLabel JLFondo;
    // End of variables declaration//GEN-END:variables
}