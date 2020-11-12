/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.vista;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ligaajedrez.modelo.Administrador;
import ligaajedrez.modelo.Usuario;

/**
 *
 * @author asins
 */
public class EliminarJugador extends javax.swing.JFrame {
    private Usuario usuario;
    private JFrame previousView;
    
    /**
     * Creates new form EliminarJugador
     */
    public EliminarJugador(Usuario usuario, JFrame previousView) {
        initComponents();
        this.usuario = usuario;
        this.previousView = previousView;
        mostrarJugadores();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jugadoresList = new javax.swing.JList<>();
        jugadorLabel = new javax.swing.JLabel();
        atrasButton = new javax.swing.JButton();
        eliminarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jugadoresList);

        jugadorLabel.setText("Elegir el jugador a eliminar:");

        atrasButton.setText("Atrás");
        atrasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasButtonActionPerformed(evt);
            }
        });

        eliminarButton.setText("Eliminar");
        eliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jugadorLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(atrasButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(eliminarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jugadorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eliminarButton, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(atrasButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarJugadores()
    {
       ArrayList jugadoresAux;
       jugadoresAux = ((Administrador)usuario).getJugadores(); 
       DefaultListModel modeloLista = new DefaultListModel();
       jugadoresList.setModel(modeloLista); 
       
       if (!jugadoresAux.isEmpty()){
            for(Object j:jugadoresAux)
            {
                modeloLista.addElement(j);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "No hay jugadores para mostrar en estos momentos.");
        }
    }
    
    private void atrasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasButtonActionPerformed
        // TODO add your handling code here:
        previousView.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_atrasButtonActionPerformed

    private void eliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarButtonActionPerformed
        // TODO add your handling code here:
        //puc fer que me torne el index del element seleccionat i anar a liga i eliminar del arraylist el index que me ha tornat?
        boolean ok;
        Object jug = jugadoresList.getSelectedValue();
        ok=((Administrador)usuario).eliminarJugador(jug);
        if(!ok)
            JOptionPane.showMessageDialog(this, "No se ha podido eliminar al jugador seleccionado.");
        previousView.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_eliminarButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atrasButton;
    private javax.swing.JButton eliminarButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jugadorLabel;
    private javax.swing.JList<Object> jugadoresList;
    // End of variables declaration//GEN-END:variables
}
