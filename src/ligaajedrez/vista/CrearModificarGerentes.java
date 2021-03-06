/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.vista;

import javax.swing.JFrame;
import ligaajedrez.modelo.Fachada;
import ligaajedrez.modelo.GerenteModel;
import ligaajedrez.modelo.Usuario;

/**
 *
 * @author jbeltran
 */
public class CrearModificarGerentes extends javax.swing.JFrame {
    private Usuario usuario;
    private JFrame previousView;
    private GerenteModel gerente;
    
    /**
     * Creates new form CrearModifiarEntrenadors
     */
    public CrearModificarGerentes(Usuario usuario, JFrame previousView) {
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
    
    public CrearModificarGerentes(Usuario usuario,Object gerente, JFrame previousView) {
        initComponents();
        this.usuario = usuario;
        this.previousView = previousView;
        this.gerente = (GerenteModel) gerente;
        
        paintGerente();
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

        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        surnameText = new javax.swing.JTextField();
        surnameLabel = new javax.swing.JLabel();
        birthText = new javax.swing.JTextField();
        birthLabel = new javax.swing.JLabel();
        phonenumberText = new javax.swing.JTextField();
        phonenumberLabel = new javax.swing.JLabel();
        checkBtn = new javax.swing.JToggleButton();
        nominaText = new javax.swing.JTextField();
        nominaLabel = new javax.swing.JLabel();
        irpfText = new javax.swing.JTextField();
        irpfLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nameLabel.setLabelFor(nameField);
        nameLabel.setText("Nombre:");

        surnameLabel.setLabelFor(surnameText);
        surnameLabel.setText("Apellidos:");

        birthLabel.setLabelFor(birthText);
        birthLabel.setText("Fecha nacimiento:");

        phonenumberLabel.setLabelFor(phonenumberText);
        phonenumberLabel.setText("Telefono:");

        checkBtn.setText("Confirmar");
        checkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBtnActionPerformed(evt);
            }
        });

        nominaLabel.setLabelFor(nominaText);
        nominaLabel.setText("Nomina:");

        irpfLabel.setLabelFor(irpfText);
        irpfLabel.setText("IRPF:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(checkBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(surnameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(surnameText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(birthLabel)
                        .addGap(18, 18, 18)
                        .addComponent(birthText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phonenumberLabel)
                            .addComponent(irpfLabel)
                            .addComponent(nominaLabel))
                        .addGap(2, 6, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phonenumberText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(irpfText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(71, 71, 71)
                                    .addComponent(nominaText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(surnameLabel)
                    .addComponent(surnameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(birthLabel)
                    .addComponent(birthText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phonenumberLabel)
                    .addComponent(phonenumberText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nominaLabel)
                    .addComponent(nominaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(irpfLabel)
                    .addComponent(irpfText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkBtn)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBtnActionPerformed
        // TODO add your handling code here:
        if(gerente == null)
            Fachada.nuevoGerente(nameField.getText(), surnameText.getText(), birthText.getText(), phonenumberText.getText(), nominaText.getText(), irpfText.getText());
        else
            Fachada.modificarGerente(nameField.getText(), surnameText.getText(), birthText.getText(), phonenumberText.getText(), nominaText.getText(), irpfText.getText(), gerente);
        previousView.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_checkBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel birthLabel;
    private javax.swing.JTextField birthText;
    private javax.swing.JToggleButton checkBtn;
    private javax.swing.JLabel irpfLabel;
    private javax.swing.JTextField irpfText;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nominaLabel;
    private javax.swing.JTextField nominaText;
    private javax.swing.JLabel phonenumberLabel;
    private javax.swing.JTextField phonenumberText;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JTextField surnameText;
    // End of variables declaration//GEN-END:variables

    private void paintGerente() {
       nameField.setText(gerente.getName());
       surnameText.setText(gerente.getSurname());
       birthText.setText(gerente.getBirth());
       irpfText.setText(gerente.getIrpf());
       nominaText.setText(gerente.getNomina());
       phonenumberText.setText(gerente.getPhone());
    }
}
