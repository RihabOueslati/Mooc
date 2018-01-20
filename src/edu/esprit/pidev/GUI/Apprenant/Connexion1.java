/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.GUI.Apprenant;


import static edu.esprit.pidev.GUI.Apprenant.Connexion1.id_user;
import static edu.esprit.pidev.GUI.GuiCommite.setTheme;
import edu.esprit.pidev.dao.classes.UtilisateurDAO;
import edu.esprit.pidev.entities.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
/**
 *
 * @author Rihab
 */
public class Connexion1 extends javax.swing.JFrame {
    private User user ;

    
    public static int id_user = 0;
    List<User> listuser = new ArrayList<User>();
    UtilisateurDAO usr = new UtilisateurDAO();
    private Object userDAO;
    /**
     * Creates new form Connexion1
     */
    public Connexion1() {
       
         
        setTheme();
        initComponents();
        
        setTitle("MOOC v1.0 - Connexion");
	setLocationRelativeTo(null);
        //setSize(getToolkit().getScreenSize().width,getToolkit().getScreenSize().height); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        
        setVisible(true);
    
    }

  
    @SuppressWarnings("unchecked")
    
     public int verif() throws SQLException {
        UtilisateurDAO userDAO = new UtilisateurDAO();
        listuser = new ArrayList<User>();
        listuser = userDAO.GetAllUser();
        String passe =null ;
        int etat = 0;
         SymfonyEncoder se = new SymfonyEncoder("SHA-512");
         
        for (User U : listuser) {
            
             
            
             se.setPass_clair(t_pass.getText()); 
             se.setSalt(U.getSalt());
             passe=se.crypterPass();
             System.err.println(U.getUsername()+" "+U.getPassword()+" "+passe); 
            if ((t_log.getText().equals(U.getUsername())) && (se.crypterPass().equals(U.getPassword()))) { 
                
                System.err.println("vrai");
                etat = 1;
                break;
            }
        }
        return etat;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        t_pass = new javax.swing.JPasswordField();
        t_log = new javax.swing.JTextField();
        JB_connect2 = new javax.swing.JButton();
        nonRegister = new javax.swing.JLabel();
        alert11 = new javax.swing.JLabel();
        alert12 = new javax.swing.JLabel();
        JB_Inscrit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Login :");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Password :");

        t_pass.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        t_pass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        t_log.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        t_log.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        JB_connect2.setBackground(new java.awt.Color(0, 153, 153));
        JB_connect2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        JB_connect2.setText("se connecter");
        JB_connect2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_connect2ActionPerformed(evt);
            }
        });

        nonRegister.setText("Non enregistré?");

        alert11.setVisible(false);
        alert11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        alert11.setForeground(new java.awt.Color(255, 0, 0));
        alert11.setText(" Entrez votre identificateur ! ");

        alert12.setVisible(false);
        alert12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        alert12.setForeground(new java.awt.Color(255, 0, 0));
        alert12.setText(" Entrez votre mot de passe ! ");

        JB_Inscrit.setBackground(new java.awt.Color(0, 153, 153));
        JB_Inscrit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        JB_Inscrit.setText("s'inscrire");
        JB_Inscrit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_InscritActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/pidev/Presentation/img/utilisateur.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(alert11, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(354, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(alert12, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_log, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(402, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(JB_connect2)
                        .addGap(41, 41, 41)
                        .addComponent(nonRegister)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JB_Inscrit)
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4)
                        .addGap(395, 395, 395))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alert11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_log, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alert12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_connect2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nonRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JB_Inscrit, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JB_connect2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_connect2ActionPerformed
        UtilisateurDAO userDAO = new UtilisateurDAO();

        
            if (t_log.getText().equals("") && t_pass.getText().equals("")) {
            alert11.setVisible(true);
            alert12.setVisible(true);
            JOptionPane.showMessageDialog(null, "Erreur d'authentification ", "Erreur", JOptionPane.ERROR_MESSAGE);
            alert11.setVisible(false);
            alert12.setVisible(false);

        } else if (t_log.getText().equals("")) {
            alert11.setVisible(true);
            JOptionPane.showMessageDialog(null, "Erreur d'authentification ", "Erreur", JOptionPane.ERROR_MESSAGE);
            alert12.setVisible(false);

        } else if (t_pass.getText().equals("")) {
            alert12.setVisible(true);
            JOptionPane.showMessageDialog(null, "Erreur d'authentification ", "Erreur", JOptionPane.ERROR_MESSAGE);
            alert12.setVisible(false);

        } else {
        
            try {
                System.err.println(verif());
                if (verif() == 1) {
                   
                   
                    
                    id_user = userDAO.findUserByLogin(t_log.getText());
                    System.err.println(id_user);
                    JOptionPane.showMessageDialog(null, "Login correct", " BIENVENUE ", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    
                    String role_user = usr.findRoleByLogin(t_log.getText());
                     if (role_user.equals("a:1:{i:0;s:14:\"ROLE_APPRENANT\";}")) {
                        this.setVisible(false);
                         GuiApprenant FA=new GuiApprenant(id_user);
                         
                    }
                    
                    if (role_user.equals("a:0:{}")) {
                        this.setVisible(false);
//                        GUIAdmin GA = new GUIAdmin(id_user);
                      //  GA.setVisible(true);
                    }
                    
                    if (role_user.equals("a:1:{i:0;s:14:\"ROLE_FORMATEUR\";}")) {
                        this.setVisible(false);
                        //  Frame_ProfilFormateur1 F = new Frame_ProfilFormateur1(id_user);
                       // F.setVisible(true);
                    }
                    
//                     if (role_user.equals("a:1:{i:0;s:14:\"ROLE_ORGANISME\";}")) {
//                        this.setVisible(false);
//                         Frame_ProfilOrganisme F = new Frame_ProfilOrganisme(id_user);
//                        F.setVisible(true);
//                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Login incorrect ", "Erreur", JOptionPane.ERROR_MESSAGE);

                }
            } catch (SQLException ex) {
                Logger.getLogger(Connexion1.class.getName()).log(Level.SEVERE, null, ex);
            

        }

        }  
      
   
    }//GEN-LAST:event_JB_connect2ActionPerformed

    private void JB_InscritActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_InscritActionPerformed
          Inscription A=new  Inscription();
        this.dispose();
        A.setVisible(true);
    }//GEN-LAST:event_JB_InscritActionPerformed

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
            java.util.logging.Logger.getLogger(Connexion1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Connexion1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Connexion1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Connexion1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Connexion1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_Inscrit;
    private javax.swing.JButton JB_connect2;
    private javax.swing.JLabel alert11;
    private javax.swing.JLabel alert12;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nonRegister;
    private javax.swing.JTextField t_log;
    private javax.swing.JPasswordField t_pass;
    // End of variables declaration//GEN-END:variables
}
