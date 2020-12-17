/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.gii.ligaajedrez.vista;

import es.uv.gii.ligaajedrez.modelo.Usuario;

/**
 *
 * @author asins
 */
public class MenuAdministrador extends javax.swing.JFrame {
    private Usuario usuario;
    /**
     * Creates new form MenuAdministrador
     */
    public MenuAdministrador(Usuario usuario) {
        initComponents();
        this.usuario = usuario;
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

        resultadosPartidaButton = new javax.swing.JButton();
        registrarTorneoButton = new javax.swing.JButton();
        registrarPartidaButton = new javax.swing.JButton();
        gestionarJugadoresButton = new javax.swing.JButton();
        gestionarClubsButton = new javax.swing.JButton();
        sedeEntrenamiento5 = new javax.swing.JButton();
        gestionarGerentesButton = new javax.swing.JButton();
        gestionarEntrenadoresButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        resultadosPartidaButton.setText("Introducir resultados partida");
        resultadosPartidaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultadosPartidaButtonActionPerformed(evt);
            }
        });

        registrarTorneoButton.setText("Registrar torneo");
        registrarTorneoButton.setAutoscrolls(true);
        registrarTorneoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarTorneoButtonActionPerformed(evt);
            }
        });

        registrarPartidaButton.setText("Registrar partida");
        registrarPartidaButton.setToolTipText("");
        registrarPartidaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarPartidaButtonActionPerformed(evt);
            }
        });

        gestionarJugadoresButton.setText("Gestionar jugadores");
        gestionarJugadoresButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionarJugadoresButtonActionPerformed(evt);
            }
        });

        gestionarClubsButton.setText("Gestionar clubs");
        gestionarClubsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionarClubsButtonActionPerformed(evt);
            }
        });

        sedeEntrenamiento5.setText("Reservar sede entrenamiento");
        sedeEntrenamiento5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sedeEntrenamiento5ActionPerformed(evt);
            }
        });

        gestionarGerentesButton.setText("Gestionar gerentes");
        gestionarGerentesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionarGerentesButtonActionPerformed(evt);
            }
        });

        gestionarEntrenadoresButton.setText("Gestionar entrenadores");
        gestionarEntrenadoresButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionarEntrenadoresButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sedeEntrenamiento5, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gestionarEntrenadoresButton, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gestionarGerentesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gestionarClubsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gestionarJugadoresButton, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registrarPartidaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registrarTorneoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resultadosPartidaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(sedeEntrenamiento5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resultadosPartidaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registrarTorneoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registrarPartidaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gestionarJugadoresButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gestionarClubsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gestionarEntrenadoresButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(gestionarGerentesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        resultadosPartidaButton.getAccessibleContext().setAccessibleName("entrenam");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gestionarJugadoresButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionarJugadoresButtonActionPerformed
        // TODO add your handling code here:
        new GestionarJugadores(usuario, this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_gestionarJugadoresButtonActionPerformed

    private void gestionarEntrenadoresButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionarEntrenadoresButtonActionPerformed
        // TODO add your handling code here:
        new GestionarEntrenadors(usuario, this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_gestionarEntrenadoresButtonActionPerformed

    private void gestionarGerentesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionarGerentesButtonActionPerformed
        // TODO add your handling code here:
        new GestionarGerentes(usuario, this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_gestionarGerentesButtonActionPerformed

    private void registrarTorneoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarTorneoButtonActionPerformed
        new RegistrarTorneo(usuario, this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_registrarTorneoButtonActionPerformed

    private void registrarPartidaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarPartidaButtonActionPerformed
        new RegistrarPartida(usuario, this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_registrarPartidaButtonActionPerformed

    private void sedeEntrenamiento5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sedeEntrenamiento5ActionPerformed
        ReservarSedeEntrenamiento reservar;
        reservar = new ReservarSedeEntrenamiento(usuario, this);
        reservar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_sedeEntrenamiento5ActionPerformed

    private void resultadosPartidaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultadosPartidaButtonActionPerformed
        IntroducirResultadosPartida introducir;
        introducir = new IntroducirResultadosPartida(usuario, this);
        introducir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_resultadosPartidaButtonActionPerformed

    private void gestionarClubsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionarClubsButtonActionPerformed
        new GestionarClubs(usuario, this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_gestionarClubsButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton gestionarClubsButton;
    private javax.swing.JButton gestionarEntrenadoresButton;
    private javax.swing.JButton gestionarGerentesButton;
    private javax.swing.JButton gestionarJugadoresButton;
    private javax.swing.JButton registrarPartidaButton;
    private javax.swing.JButton registrarTorneoButton;
    private javax.swing.JButton resultadosPartidaButton;
    private javax.swing.JButton sedeEntrenamiento5;
    // End of variables declaration//GEN-END:variables
}