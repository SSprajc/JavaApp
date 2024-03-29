/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra;

import hr.algebra.model.Genre;
import hr.algebra.model.GenreManagable;
import hr.algebra.utils.MessageUtils;

/**
 *
 * @author sandr
 */
public class AddGenreDialog extends javax.swing.JDialog {

    private final GenreManagable genreAddable;
    private final Genre data;
    
    /**
     * Creates new form AddGenreDialog
     */
    public AddGenreDialog(java.awt.Frame parent, boolean modal, javax.swing.JPanel panelParent) { //
        super(parent, modal);
        genreAddable = (GenreManagable) panelParent;
        initComponents();
        data = new Genre();
    }

    public AddGenreDialog(java.awt.Frame parent, boolean modal, javax.swing.JPanel panelParent, Genre data) {
        super(parent, modal);
        genreAddable = (GenreManagable) panelParent;
        initComponents();
        this.data = data;
        tfName.setText(data.getName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        lbNameError = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Name:");

        lbNameError.setForeground(java.awt.Color.red);

        btnAdd.setText("Save");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbNameError, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNameError, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (formValid()) {
            Genre genre = new Genre(data.getId(), tfName.getText().trim());
            
            if (data.getId() == 0) {
                if (genreAddable.addGenre(genre)) {
                    dispose();
                }else{
                    MessageUtils.showErrorMessage("Cannot add genre", "Genre already exists");
                }
            }else if (genreAddable.updateGenre(genre)) {
                dispose();
            }else{
                MessageUtils.showErrorMessage("Error", "Cannot update genre");
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbNameError;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables

    private boolean formValid() {
        boolean ok = true;
        ok &= !tfName.getText().trim().isEmpty();
        lbNameError.setText(tfName.getText().trim().isEmpty() ? "X" : "");
        return ok;
    }
}
