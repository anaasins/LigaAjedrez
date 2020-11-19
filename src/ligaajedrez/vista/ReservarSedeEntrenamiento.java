/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ligaajedrez.modelo.LigaFachada;
import ligaajedrez.modelo.Usuario;

/**
 *
 * @author Olaf
 */
public class ReservarSedeEntrenamiento extends javax.swing.JFrame {
    private Usuario usuario;
    private JFrame previousView;

    /**
     * Creates new form ReservarSedeEntrenamiento
     */
    public ReservarSedeEntrenamiento(Usuario usuario, JFrame previousView) {
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

        diaLabel = new javax.swing.JLabel();
        horaLabel = new javax.swing.JLabel();
        reservarButton = new javax.swing.JButton();
        atrasResPartida = new javax.swing.JButton();
        dia = new com.toedter.calendar.JDateChooser();
        hora = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        diaLabel.setText("Día");

        horaLabel.setText("Hora");

        reservarButton.setText("Reservar");
        reservarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservarButtonActionPerformed(evt);
            }
        });

        atrasResPartida.setText("Atrás");
        atrasResPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasResPartidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(atrasResPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(reservarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(diaLabel)
                    .addComponent(horaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hora))
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(diaLabel)
                    .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(horaLabel)
                    .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(reservarButton, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(atrasResPartida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reservarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservarButtonActionPerformed
        // TODO add your handling code here:
        if(!usuario.reservarSede(dia.getDate(), (Integer) hora.getValue(), usuario))
        {
            //traure error per pantalla
            JOptionPane.showMessageDialog(this, "Fecha/Hora elegida no disponible. Vuelva a intentarlo.");
        }else
        {
            //traure confirmacio
            
           JOptionPane.showMessageDialog(this, "Sede reservada con exito.");
            previousView.setVisible(true);
            this.setVisible(false);
        } 
    }//GEN-LAST:event_reservarButtonActionPerformed

    private void atrasResPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasResPartidaActionPerformed
        previousView.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_atrasResPartidaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atrasResPartida;
    private com.toedter.calendar.JDateChooser dia;
    private javax.swing.JLabel diaLabel;
    private javax.swing.JSpinner hora;
    private javax.swing.JLabel horaLabel;
    private javax.swing.JButton reservarButton;
    // End of variables declaration//GEN-END:variables
}
