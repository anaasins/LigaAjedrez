/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.vista;

import javax.swing.JOptionPane;
import ligaajedrez.modelo.Fachada;
import ligaajedrez.modelo.Jugador;
import ligaajedrez.modelo.Usuario;

/**
 *
 * @author Olaf
 */
public class MenuJugador extends javax.swing.JFrame {
    private Usuario usuario;
    
    /**
     * Creates new form MenuJugador
     */
    public MenuJugador(Usuario usuario) {
        initComponents();
        this.usuario = usuario;
        
        modifyMenuForMoroso();
        
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                usuario.saveData();
                e.getWindow().dispose();
            }
        });
    }
    
    public void modifyMenuForMoroso() {
        if (usuario.isMoroso()) {
            payBtn.setEnabled(true);
            ResSede.setEnabled(false);
            InResPartida.setEnabled(false);
            ModDatos.setEnabled(false);
            apuntarTorneo.setEnabled(false);
            tarjetaButton.setEnabled(false);
        } else {
            payBtn.setEnabled(false);
            ResSede.setEnabled(true);
            InResPartida.setEnabled(true);
            ModDatos.setEnabled(true);
            apuntarTorneo.setEnabled(true);
            tarjetaButton.setEnabled(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ResSede = new javax.swing.JButton();
        InResPartida = new javax.swing.JButton();
        ModDatos = new javax.swing.JButton();
        apuntarTorneo = new javax.swing.JButton();
        tarjetaButton = new javax.swing.JButton();
        payBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ResSede.setText("Reservar Sede Entrenamiento");
        ResSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResSedeActionPerformed(evt);
            }
        });

        InResPartida.setText("Introducir Resultados Partida");
        InResPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InResPartidaActionPerformed(evt);
            }
        });

        ModDatos.setText("Modificar Datos");
        ModDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModDatosActionPerformed(evt);
            }
        });

        apuntarTorneo.setText("Apuntarme a torneo");
        apuntarTorneo.setActionCommand("apuntarTorneo");
        apuntarTorneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apuntarTorneoActionPerformed(evt);
            }
        });

        tarjetaButton.setText("Solicitar tarjeta jugador");
        tarjetaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tarjetaButtonActionPerformed(evt);
            }
        });

        payBtn.setText("Pagar multa");
        payBtn.setEnabled(false);
        payBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tarjetaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(apuntarTorneo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ModDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(InResPartida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ResSede, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(payBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(ResSede, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InResPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ModDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(apuntarTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tarjetaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(payBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ResSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResSedeActionPerformed
        // TODO add your handling code here:
         ReservarSedeEntrenamiento reservar;
         reservar = new ReservarSedeEntrenamiento(usuario, this);
         reservar.setVisible(true);
         this.setVisible(false);
         
    }//GEN-LAST:event_ResSedeActionPerformed

    private void InResPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InResPartidaActionPerformed
        // TODO add your handling code here:
        IntroducirResultadosPartida introducir;
        introducir = new IntroducirResultadosPartida(usuario, this);
        introducir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_InResPartidaActionPerformed

    private void ModDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModDatosActionPerformed
        // TODO add your handling code here:
        ModificarJugador modificar;
        modificar = new ModificarJugador(usuario, usuario.getPlayer(), this);
        modificar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ModDatosActionPerformed

    private void apuntarTorneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apuntarTorneoActionPerformed
        // TODO add your handling code here:
        new ApuntarmeTorneo(usuario, this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_apuntarTorneoActionPerformed

    private void tarjetaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tarjetaButtonActionPerformed
        // TODO add your handling code here:
        if(!usuario.getPlayer().getMoroso())
        {
            JOptionPane.showMessageDialog(this, "Nombre: "+usuario.getPlayer().getName()+"\nEdad: "+usuario.getPlayer().getAge()+"\nCategoría: "+usuario.getPlayer().getCategory().name()+"\nELO: "+usuario.getPlayer().getElo(), "Tarjeta de jugador.", JOptionPane.OK_OPTION);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Tarjeta no disponible por moroso.");
        }
    }//GEN-LAST:event_tarjetaButtonActionPerformed

    private void payBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payBtnActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Desea pagar la multa pendiente de " + ((Jugador)usuario).getMulta() + " €", "Pago multa pendiente",JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            Fachada.pagarMulta();
            modifyMenuForMoroso();
        }
    }//GEN-LAST:event_payBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton InResPartida;
    private javax.swing.JButton ModDatos;
    private javax.swing.JButton ResSede;
    private javax.swing.JButton apuntarTorneo;
    private javax.swing.JButton payBtn;
    private javax.swing.JButton tarjetaButton;
    // End of variables declaration//GEN-END:variables
}
