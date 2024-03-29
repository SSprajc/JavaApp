/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra;

import hr.algebra.dal.Repository;
import hr.algebra.dal.RepositoryFactory;
import hr.algebra.dal.UserRepository;
import hr.algebra.dal.UserRepositoryFactory;
import hr.algebra.model.Movie;
import hr.algebra.model.MovieArchive;
import hr.algebra.model.User;
import hr.algebra.model.UserAddable;
import hr.algebra.utils.JAXBUtils;
import hr.algebra.utils.MessageUtils;
import java.io.File;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sandr
 */
public class MainForm extends javax.swing.JFrame implements UserAddable{

    private static final String EDIT_ENTITIES = "Edit entities";
    private static final String EDIT_MOVIES = "Edit movies";
    private static final String UPLOAD_MOVIES = "Upload movies";
    private static final String MOVIEARCHIVEXML = "moviearchive.xml";
    
    private static Repository movieRepository;
    private static UserRepository userRepository;
    
    public static final String PICTURES_FILE_PATH = "assets" + File.separator;
    public static final String DEFAULT_IMAGEURL = PICTURES_FILE_PATH + "default_poster.jpg";
    
    private static Optional<User> user = Optional.empty();
    
    /**
     * Creates new form form
     */
    public MainForm() {
        
        try {
            initRepository();
        } catch (Exception ex) {
            MessageUtils.showErrorMessage("Error", "Error getting repository");
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        }
        logIn();
    }
    
    private void initRepository() throws Exception {
        movieRepository = RepositoryFactory.getRepository(Movie.class);
        userRepository = UserRepositoryFactory.getRepository();
    }

    /**
     * This method is called from within the constructor to initialize the MainForm.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpContent = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuJAXB = new javax.swing.JMenu();
        miDownload = new javax.swing.JMenuItem();
        menuApplication = new javax.swing.JMenu();
        miExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuJAXB.setMnemonic('J');
        menuJAXB.setText("JAXB");

        miDownload.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        miDownload.setText("Download");
        miDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDownloadActionPerformed(evt);
            }
        });
        menuJAXB.add(miDownload);

        jMenuBar1.add(menuJAXB);

        menuApplication.setMnemonic('A');
        menuApplication.setText("App");

        miExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        miExit.setText("Exit");
        miExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExitActionPerformed(evt);
            }
        });
        menuApplication.add(miExit);

        jMenuBar1.add(menuApplication);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpContent, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpContent, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void miExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_miExitActionPerformed

    private void miDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDownloadActionPerformed
        new Thread(() -> {
            try {
                JAXBUtils.save(new MovieArchive(movieRepository.selectAll()), MOVIEARCHIVEXML);
            } catch (Exception ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }//GEN-LAST:event_miDownloadActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the MainForm */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuApplication;
    private javax.swing.JMenu menuJAXB;
    private javax.swing.JMenuItem miDownload;
    private javax.swing.JMenuItem miExit;
    private javax.swing.JTabbedPane tpContent;
    // End of variables declaration//GEN-END:variables

    private void configurePanels() {
        if (user.get().isIsAdmin()) {
            tpContent.add(UPLOAD_MOVIES, new UploadMoviesPanel());
        }
        
        tpContent.add(EDIT_MOVIES, new EditMoviesPanel());
        tpContent.add(EDIT_ENTITIES, new EditEntitiesPanel());
    }
    
    
    private void logIn() {
        new LoginDialog(this, true, userRepository).setVisible(true);
        if (!user.isPresent()) {
            System.exit(0);
        }
    }

    @Override
    public boolean addUser(User userr) {
        user = Optional.of(userr);
        initComponents();
        configurePanels();
        return true;
    }
    
}
