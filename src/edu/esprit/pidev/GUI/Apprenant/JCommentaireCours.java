/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.GUI.Apprenant;


import edu.esprit.pidev.GUI.Comite.*;
import edu.esprit.pidev.adapters.CommentaireCoursTableModel;
import edu.esprit.pidev.dao.classes.CommentaireDao;
import edu.esprit.pidev.dao.classes.CoursDAO;
import edu.esprit.pidev.dao.classes.UtilisateurDAO;
import edu.esprit.pidev.entities.Commentaire;
import edu.esprit.pidev.entities.Cours;
import edu.esprit.pidev.entities.User;

/**
 *
 * @author Sabrina
 */
public class JCommentaireCours extends javax.swing.JFrame {
    
    
    
    
    private User user;
    int idCours=41 ;
    int id_user;
   
    /*static Cv_InfoPersonnel cv = new Cv_InfoPersonnel();
    CV_Formation formationCV = new CV_Formation();
    CV_FormationDAO formationCvDAO = new CV_FormationDAO();*/
    
    Commentaire commentaire = new Commentaire ();
   CommentaireDao cmd= new CommentaireDao();
    
   
  
    
    /*
     * Creates new form MisejourCV
     * 
     */
    
    public JCommentaireCours() {
        initComponents();
      
        this.setLocationRelativeTo(this);
       
        
        jTable2.setModel(new CommentaireCoursTableModel(idCours));
        
        this.setVisible(true);
        
        pack();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        supprimerExperience = new javax.swing.JButton();
        ajouterExperience = new javax.swing.JButton();
        modifierExperience = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        username = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        description = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(200, 200));

        jPanel1.setMinimumSize(new java.awt.Dimension(300, 300));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 300));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Liste des Commentaires"));
        jPanel4.setMinimumSize(new java.awt.Dimension(600, 100));
        jPanel4.setPreferredSize(new java.awt.Dimension(800, 250));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 29, 338, 184));

        supprimerExperience.setText("Supprimer Commentaire");
        supprimerExperience.setMaximumSize(new java.awt.Dimension(179, 57));
        supprimerExperience.setMinimumSize(new java.awt.Dimension(179, 57));
        supprimerExperience.setPreferredSize(new java.awt.Dimension(179, 57));
        supprimerExperience.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerExperienceActionPerformed(evt);
            }
        });
        jPanel4.add(supprimerExperience, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 200, 50));

        ajouterExperience.setText("Ajouter Commentaire");
        ajouterExperience.setMaximumSize(new java.awt.Dimension(179, 57));
        ajouterExperience.setMinimumSize(new java.awt.Dimension(179, 57));
        ajouterExperience.setPreferredSize(new java.awt.Dimension(179, 57));
        ajouterExperience.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterExperienceActionPerformed(evt);
            }
        });
        jPanel4.add(ajouterExperience, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 200, 70));

        modifierExperience.setText("Modifier Commentaire");
        modifierExperience.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierExperienceActionPerformed(evt);
            }
        });
        jPanel4.add(modifierExperience, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 20, 200, 50));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.ipady = 150;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 41);
        jPanel1.add(jPanel4, gridBagConstraints);
        jPanel4.getAccessibleContext().setAccessibleName("Liste des commentaires");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel5.setLayout(null);

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        jPanel5.add(username);
        username.setBounds(90, 20, 130, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("Username");
        jPanel5.add(jLabel6);
        jLabel6.setBounds(10, 30, 53, 14);

        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });
        jPanel5.add(date);
        date.setBounds(90, 120, 130, 30);
        jPanel5.add(description);
        description.setBounds(90, 60, 500, 50);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setText("Date");
        jPanel5.add(jLabel8);
        jLabel8.setBounds(20, 120, 40, 20);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setText("Commentaire");
        jPanel5.add(jLabel7);
        jLabel7.setBounds(10, 70, 73, 14);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 599;
        gridBagConstraints.ipady = 159;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 122, 0);
        jPanel1.add(jPanel5, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 852, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(50, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 542, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
       
        int row = jTable2.getSelectedRow();
        
//        username.setText((String) jTable2.getValueAt(row, 0));
        
        description.setText((String) jTable2.getValueAt(row, 1));
        
        date.setText((String) jTable2.getValueAt(row, 2));
        idCours = (int) jTable2.getValueAt(row, 3);   
        System.out.println("hhhhhhh"+idCours);
        
        jTable2.setModel(new CommentaireCoursTableModel(idCours) );
// TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseClicked

    private void supprimerExperienceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerExperienceActionPerformed
         commentaire.setId(idCours);
        cmd.remove(commentaire);
        jTable2.setModel(new CommentaireCoursTableModel(idCours));
    }//GEN-LAST:event_supprimerExperienceActionPerformed

    private void ajouterExperienceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterExperienceActionPerformed
      
        UtilisateurDAO ut = new UtilisateurDAO();
        User u = ut.findUtilisateurByID(id_user);
        commentaire.setDate(date.getText());
        commentaire.setDescription(description.getText());
        commentaire.setUser(username.);
        
      cmd.addCommentaire(commentaire);
       
        
        jTable2.setModel(new CommentaireCoursTableModel(idCours));

        // TODO add your handling code here:
    }//GEN-LAST:event_ajouterExperienceActionPerformed

    private void modifierExperienceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierExperienceActionPerformed
        
        commentaire.setId(idCours);
        commentaire.setFk_user(Integer.parseInt(username.getText()));
        commentaire.setDate(date.getText());
        commentaire.setDescription(description.getText());
       
        cmd.updateCommentaire(commentaire);
        
        jTable2.setModel(new CommentaireCoursTableModel(idCours));
    }//GEN-LAST:event_modifierExperienceActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed

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
            java.util.logging.Logger.getLogger(JCommentaireCours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JCommentaireCours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JCommentaireCours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JCommentaireCours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JCommentaireCours().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouterExperience;
    private javax.swing.JTextField date;
    private javax.swing.JTextField description;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton modifierExperience;
    private javax.swing.JButton supprimerExperience;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}