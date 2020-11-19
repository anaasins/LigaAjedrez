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
import ligaajedrez.modelo.Fachada;
import ligaajedrez.modelo.Usuario;

/**
 *
 * @author jbeltran
 */
public class BorrarGerente extends javax.swing.JFrame {
    private Usuario usuario;
    private JFrame previousView;
    
    /**
     * Creates new form BorrarEntrenador
     */
    public BorrarGerente(Usuario usuario, JFrame previousView) {
        initComponents();
        this.usuario = usuario;
        this.previousView = previousView;
        
        mostrarGerentes();
        
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
        jList1 = new javax.swing.JList<>();
        deleteBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jList1);

        deleteBtn.setText("Borrar gerente");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccionar un gerente:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        boolean ok;
        Object gerente = jList1.getSelectedValue();
        ok=Fachada.eliminarGerente(gerente);
        if(!ok)
            JOptionPane.showMessageDialog(this, "No se ha podido eliminar el gerente seleccionado.");
        
        previousView.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_deleteBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<Object> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void mostrarGerentes() {
         ArrayList gerentesAux;
       gerentesAux = Fachada.getGerentes(); 
       DefaultListModel modeloLista = new DefaultListModel();
       jList1.setModel(modeloLista); 
       
       if (!gerentesAux.isEmpty()){
            for(Object j:gerentesAux)
            {
                modeloLista.addElement(j);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "No hay jugadores para mostrar en estos momentos.");
        }
    }
}
