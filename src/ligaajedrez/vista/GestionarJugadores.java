/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.vista;

import javax.swing.JFrame;
import ligaajedrez.modelo.Administrador;

/**
 *
 * @author asins
 */
public class GestionarJugadores extends javax.swing.JFrame {
    private Administrador administrador;
    private JFrame previousView;
    /**
     * Creates new form GestionarJugadores
     */
    public GestionarJugadores(Administrador administrador, JFrame previousView) {
        initComponents();
        this.administrador = administrador;
        this.previousView = previousView;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        eliminarJugadorButton = new javax.swing.JButton();
        nuevoJugadorButton = new javax.swing.JButton();
        registrarMorosoButton = new javax.swing.JButton();
        consultarJugadoresButton = new javax.swing.JButton();
        modificarJugadorButton = new javax.swing.JButton();
        atrasButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        eliminarJugadorButton.setText("Eliminar jugador");
        eliminarJugadorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarJugadorButtonActionPerformed(evt);
            }
        });

        nuevoJugadorButton.setText("Nuevo jugador");
        nuevoJugadorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoJugadorButtonActionPerformed(evt);
            }
        });

        registrarMorosoButton.setText("Registrar moroso");
        registrarMorosoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarMorosoButtonActionPerformed(evt);
            }
        });

        consultarJugadoresButton.setText("Consultar jugadores");
        consultarJugadoresButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarJugadoresButtonActionPerformed(evt);
            }
        });

        modificarJugadorButton.setText("Modificar Jugador");
        modificarJugadorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarJugadorButtonActionPerformed(evt);
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
                    .addComponent(modificarJugadorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consultarJugadoresButton, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registrarMorosoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nuevoJugadorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminarJugadorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(atrasButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nuevoJugadorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminarJugadorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registrarMorosoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(consultarJugadoresButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modificarJugadorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(atrasButton, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atrasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasButtonActionPerformed
        // TODO add your handling code here:
        previousView.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_atrasButtonActionPerformed

    private void eliminarJugadorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarJugadorButtonActionPerformed
        // TODO add your handling code here:
        new EliminarJugador().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_eliminarJugadorButtonActionPerformed

    private void registrarMorosoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarMorosoButtonActionPerformed
        // TODO add your handling code here:
        new RegistrarMoroso().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_registrarMorosoButtonActionPerformed

    private void consultarJugadoresButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarJugadoresButtonActionPerformed
        // TODO add your handling code here:
        new ConsultarJugadores().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_consultarJugadoresButtonActionPerformed

    private void modificarJugadorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarJugadorButtonActionPerformed
        // TODO add your handling code here:
        new ModificarJugador().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_modificarJugadorButtonActionPerformed

    private void nuevoJugadorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoJugadorButtonActionPerformed
        // TODO add your handling code here:
        new ModificarJugador(administrador, this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_nuevoJugadorButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atrasButton;
    private javax.swing.JButton consultarJugadoresButton;
    private javax.swing.JButton eliminarJugadorButton;
    private javax.swing.JButton modificarJugadorButton;
    private javax.swing.JButton nuevoJugadorButton;
    private javax.swing.JButton registrarMorosoButton;
    // End of variables declaration//GEN-END:variables
}
