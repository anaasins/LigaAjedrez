/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.vista;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ligaajedrez.modelo.Administrador;
import ligaajedrez.modelo.JugadorModel;
import ligaajedrez.modelo.enums.CategoriaEnum;

/**
 *
 * @author Olaf
 */
public class ModificarJugador extends javax.swing.JFrame {

    private Administrador administrador;
    private JugadorModel player;
    private JFrame previousView;

    /**
     * Creates new form ModificarJugador
     */
    public ModificarJugador(Administrador administrador, JFrame previousView) {
        initComponents();
        this.administrador = administrador;

        DefaultComboBoxModel model = new DefaultComboBoxModel(CategoriaEnum.names());
        categoryCombo.setModel(model);
        assignationBtn.setText("Añadir");
        this.previousView = previousView;
    }
    
    public ModificarJugador(Administrador administrador, JugadorModel player, JFrame previousView) {
        initComponents();
        this.administrador = administrador;

        DefaultComboBoxModel model = new DefaultComboBoxModel(CategoriaEnum.names());
        categoryCombo.setModel(model);
        this.player = player;
        this.previousView = previousView;
    }

    public ModificarJugador() {
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

        categoryLabel = new javax.swing.JLabel();
        categoryCombo = new javax.swing.JComboBox<>();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        eloLabel = new javax.swing.JLabel();
        eloField = new javax.swing.JTextField();
        clubLabel = new javax.swing.JLabel();
        responsableNameLabel = new javax.swing.JLabel();
        clubName = new javax.swing.JTextField();
        responsableNameField = new javax.swing.JTextField();
        assignationBtn = new javax.swing.JButton();
        AtrasModJ = new javax.swing.JButton();
        ageLabel = new javax.swing.JLabel();
        ageField = new javax.swing.JTextField();
        responsablePhoneNumberLabel = new javax.swing.JLabel();
        responsablePhoneNumberField = new javax.swing.JTextField();
        assignationLabel = new javax.swing.JLabel();
        historyLabel = new javax.swing.JLabel();
        acceptBtn = new javax.swing.JButton();
        historyBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        categoryLabel.setText("Categoria");

        categoryCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Infantil", "Junior", "Senior" }));
        categoryCombo.setEnabled(false);

        nameLabel.setText("Nombre");

        eloLabel.setText("ELO");

        clubLabel.setText("Club");

        responsableNameLabel.setLabelFor(responsableNameField);
        responsableNameLabel.setText("Nombre responsable");

        clubName.setEnabled(false);

        responsableNameField.setEnabled(false);

        assignationBtn.setText("Asignar");
        assignationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignationBtnActionPerformed(evt);
            }
        });

        AtrasModJ.setText("Atrás");
        AtrasModJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasModJActionPerformed(evt);
            }
        });

        ageLabel.setLabelFor(ageField);
        ageLabel.setText("Edad");

        ageField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ageFieldFocusLost(evt);
            }
        });

        responsablePhoneNumberLabel.setLabelFor(responsablePhoneNumberField);
        responsablePhoneNumberLabel.setText("Telefono responsable");

        responsablePhoneNumberField.setEnabled(false);

        assignationLabel.setLabelFor(responsableNameField);
        assignationLabel.setText("Asignar club");

        historyLabel.setLabelFor(responsablePhoneNumberField);
        historyLabel.setText("Historico de clubs");

        acceptBtn.setText("Modificar");
        acceptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptBtnActionPerformed(evt);
            }
        });

        historyBtn.setText("Modificar");
        historyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(AtrasModJ, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(acceptBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(responsableNameLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(ageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(eloLabel, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(categoryLabel)
                    .addComponent(clubLabel)
                    .addComponent(responsablePhoneNumberLabel)
                    .addComponent(assignationLabel)
                    .addComponent(historyLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(responsableNameField)
                    .addComponent(clubName)
                    .addComponent(categoryCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ageField)
                    .addComponent(eloField)
                    .addComponent(nameField)
                    .addComponent(responsablePhoneNumberField)
                    .addComponent(assignationBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(historyBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eloField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eloLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ageLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryLabel)
                    .addComponent(categoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clubName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clubLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(responsableNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(responsableNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(responsablePhoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(responsablePhoneNumberLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assignationLabel)
                    .addComponent(assignationBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(historyLabel)
                    .addComponent(historyBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AtrasModJ, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(acceptBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AtrasModJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasModJActionPerformed
        // TODO add your handling code here:
        MenuJugador menu;
        menu = new MenuJugador();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_AtrasModJActionPerformed

    private void ageFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ageFieldFocusLost
        int age = Integer.parseInt(ageField.getText());
        if (age <= 15) {
            categoryCombo.setSelectedIndex(CategoriaEnum.Infantil.getValue());
            responsableNameField.setEnabled(true);
            responsablePhoneNumberField.setEnabled(true);
        } else if (age <= 18) {
            categoryCombo.setSelectedIndex(CategoriaEnum.Junior.getValue());
            responsableNameField.setEnabled(false);
            responsablePhoneNumberField.setEnabled(false);
        } else {
            categoryCombo.setSelectedIndex(CategoriaEnum.Senior.getValue());
            responsableNameField.setEnabled(false);
            responsablePhoneNumberField.setEnabled(false);
        }
    }//GEN-LAST:event_ageFieldFocusLost

    private void acceptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptBtnActionPerformed
        String name, responsableName, responsableNumber;
        Integer elo, age;

        name = nameField.getText();
        responsableName = responsableNameField.getText();
        responsableNumber = responsablePhoneNumberField.getText();
        elo = null;
        age = null;
        try {
            elo = Integer.parseInt(eloField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showConfirmDialog(null, "El valor introducido para el elo no es correcto", "Fallo valor elo", JOptionPane.OK_OPTION);
        }
        try {
            age = Integer.parseInt(ageField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showConfirmDialog(null, "El valor introducido para la edad no es correcto", "Fallo valor edad", JOptionPane.OK_OPTION);
        }

        if (elo != null && age != null) {
            administrador.crearJugador(name, elo, age, responsableName, responsableNumber);
        }

        previousView.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_acceptBtnActionPerformed

    private void historyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_historyBtnActionPerformed

    private void assignationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignationBtnActionPerformed
        AsignarClub asignarClub = new AsignarClub(administrador, previousView);
        asignarClub.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_assignationBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarJugador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AtrasModJ;
    private javax.swing.JButton acceptBtn;
    private javax.swing.JTextField ageField;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JButton assignationBtn;
    private javax.swing.JLabel assignationLabel;
    private javax.swing.JComboBox<String> categoryCombo;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JLabel clubLabel;
    private javax.swing.JTextField clubName;
    private javax.swing.JTextField eloField;
    private javax.swing.JLabel eloLabel;
    private javax.swing.JButton historyBtn;
    private javax.swing.JLabel historyLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField responsableNameField;
    private javax.swing.JLabel responsableNameLabel;
    private javax.swing.JTextField responsablePhoneNumberField;
    private javax.swing.JLabel responsablePhoneNumberLabel;
    // End of variables declaration//GEN-END:variables
}
