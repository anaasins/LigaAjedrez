/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.gii.ligaajedrez.vista;

import javax.swing.JFrame;
import es.uv.gii.ligaajedrez.modelo.Usuario;

/**
 *
 * @author asins
 */
public class GestionarClubs extends javax.swing.JFrame {
    private Usuario usuario;
    private JFrame previousView;
    
    /**
     * Creates new form GestionarJugadores
     */
    public GestionarClubs(Usuario usuario, JFrame previousView) {
        initComponents();
        this.usuario = usuario;
        this.previousView = previousView;
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                usuario.saveData();
                e.getWindow().dispose();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        eliminarClubButton = new javax.swing.JButton();
        nuevoClubButton = new javax.swing.JButton();
        modificarClubButton = new javax.swing.JButton();
        atrasButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        eliminarClubButton.setText("Eliminar club");
        eliminarClubButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarClubButtonActionPerformed(evt);
            }
        });

        nuevoClubButton.setText("Nuevo club");
        nuevoClubButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoClubButtonActionPerformed(evt);
            }
        });

        modificarClubButton.setText("Modificar club");
        modificarClubButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarClubButtonActionPerformed(evt);
            }
        });

        atrasButton.setText("Atrás");
        atrasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modificarClubButton, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nuevoClubButton, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminarClubButton, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(atrasButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(nuevoClubButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eliminarClubButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modificarClubButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(atrasButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atrasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasButtonActionPerformed
        // TODO add your handling code here:
        previousView.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_atrasButtonActionPerformed

    private void eliminarClubButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarClubButtonActionPerformed
        // TODO add your handling code here:
        new EliminarClub(usuario, this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_eliminarClubButtonActionPerformed

    private void nuevoClubButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoClubButtonActionPerformed
        // TODO add your handling code here:
        new NuevoClub(usuario, this, true).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_nuevoClubButtonActionPerformed

    private void modificarClubButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarClubButtonActionPerformed
        // TODO add your handling code here:
        new NuevoClub(usuario, this, false).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_modificarClubButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atrasButton;
    private javax.swing.JButton eliminarClubButton;
    private javax.swing.JButton modificarClubButton;
    private javax.swing.JButton nuevoClubButton;
    // End of variables declaration//GEN-END:variables
}