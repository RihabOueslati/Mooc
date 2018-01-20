package edu.esprit.pidev.GUI.Apprenant;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import edu.esprit.pidev.GUI.Comite.ByebyeWindow;
import edu.esprit.pidev.GUI.Comite.ConnectionWindow;
import edu.esprit.pidev.GUI.Comite.MessageAdminWindow;
import edu.esprit.pidev.GUI.Formateur.DernierCours;
import static edu.esprit.pidev.GUI.GuiCommite.setTheme;
import edu.esprit.pidev.entities.User;


import edu.esprit.pidev.dao.classes.UtilisateurDAO;
import edu.esprit.pidev.dao.interfaces.IUtilisateurDAO;

import edu.esprit.pidev.entities.CompteApprenant;
import edu.esprit.pidev.entities.Cours;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import static jdk.nashorn.internal.runtime.Debug.id;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;


/**
 *
 * @author soumaya
 */
public class GuiApprenant extends javax.swing.JFrame {
    
   
    private User user ;
    private ProfilPanel profilPanel;
    private static int id_user ;
   private static Cours cours;
   Image image;
    
    public GuiApprenant(int id_user) {
        
        this.id_user=id_user ;
        this.cours=cours;
        UtilisateurDAO usdao=new UtilisateurDAO();
        //user = userdao.DisplayUser(id_user);
        user=usdao.findUtilisateurByID(id_user);
  
             setTheme();
        initComponents();
       // Image im =  Toolkit.getDefaultToolkit().getImage("src\\Presentation\\img\\logo32.png");//icone
       // setIconImage(im);
        setTitle("MOOC - Compte Apprenant");
	setLocationRelativeTo(null);
        setSize(getToolkit().getScreenSize().width,getToolkit().getScreenSize().height); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setVisible(true);
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGlobal = new javax.swing.JPanel();
        menuTab = new javax.swing.JTabbedPane(JTabbedPane.LEFT);
        jToolBar1 = new javax.swing.JToolBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(485, 57));

        panelGlobal.setLayout(new java.awt.BorderLayout());

        menuTab.addTab("MENU N 1",new ProfilPanel(id_user));
        JLabel profileLab = new JLabel("Gestion du compte");
        profileLab.setHorizontalTextPosition(JLabel.TRAILING);
        profileLab.setPreferredSize(new java.awt.Dimension(180, 50));

        profileLab.setIcon(new ImageIcon("src/edu/esprit/pidev/Presentation/img/ajoutCompte50.png"));
        menuTab.setTabComponentAt(0, profileLab);

        menuTab.addTab("MENU N 4",new EmailPanel(user));
        JLabel profileLab1 = new JLabel("Contacter Formateur ");
        profileLab1.setPreferredSize(new java.awt.Dimension(180, 50));
        profileLab1.setHorizontalTextPosition(JLabel.TRAILING);
        profileLab1.setIcon(new ImageIcon("src/edu/esprit/pidev/Presentation/img/msg2.png"));
        menuTab.setTabComponentAt(1, profileLab1);

        menuTab.addTab("MENU N 2",new DernierCours(cours,user));
        JLabel profileLab2 = new JLabel("Consulter cours");
        profileLab2.setHorizontalTextPosition(JLabel.TRAILING);
        profileLab2.setPreferredSize(new java.awt.Dimension(180, 50));
        profileLab2.setIcon(new ImageIcon("src/edu/esprit/pidev/Presentation/img/menuBar/layer12.png"));
        menuTab.setTabComponentAt(2, profileLab2);

        menuTab.addTab("MENU N 3",new RechercheAvanceePanel());
        JLabel profileLab3 = new JLabel("Chercher cours");
        profileLab3.setHorizontalTextPosition(JLabel.TRAILING);
        profileLab3.setPreferredSize(new java.awt.Dimension(180, 50));
        profileLab3.setIcon(new ImageIcon("src/edu/esprit/pidev/Presentation/img/menuBar/search.png"));
        menuTab.setTabComponentAt(3, profileLab3);

        //****************************

        ;
        //************************
        menuTab.setTabPlacement(JTabbedPane.LEFT);
        menuTab.setRequestFocusEnabled(false);
        panelGlobal.add(menuTab, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelGlobal, java.awt.BorderLayout.CENTER);

        jToolBar1.setRollover(true);

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR) );
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/pidev/images/admin/profil.png"))); // NOI18N
        jLabel2.setText("Profil   ");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.setMaximumSize(new java.awt.Dimension(150, 50));
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 50));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jToolBar1.add(jLabel2);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/pidev/images/admin/msg.png"))); // NOI18N
        jLabel7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR) );
        jLabel7.setText("Messages   ");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.setMaximumSize(new java.awt.Dimension(150, 50));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jToolBar1.add(jLabel7);

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR) );
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/pidev/images/admin/layer12.png"))); // NOI18N
        jLabel3.setText("Cours");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.setMaximumSize(new java.awt.Dimension(170, 50));
        jLabel3.setMinimumSize(new java.awt.Dimension(170, 50));
        jLabel3.setPreferredSize(new java.awt.Dimension(170, 50));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jToolBar1.add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR) );
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/pidev/images/admin/deco.png"))); // NOI18N
        jLabel4.setText("Déconnexion   ");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.setMaximumSize(new java.awt.Dimension(150, 50));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jToolBar1.add(jLabel4);

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/pidev/images/admin/search.png"))); // NOI18N
        jLabel5.setText("Chercher Cours");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.setMaximumSize(new java.awt.Dimension(170, 50));
        jLabel5.setMinimumSize(new java.awt.Dimension(170, 50));
        jLabel5.setPreferredSize(new java.awt.Dimension(170, 50));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jToolBar1.add(jLabel5);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.NORTH);

        jMenu1.setText("Fichier");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Déconnexion");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Quitter");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenu5.setText("Profil");

        jMenuItem3.setText("Changer ma photo de profil");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        jMenuItem5.setText("Supprimer ma photo de profil ");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem5);

        jMenu2.add(jMenu5);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("personaliser");

        jMenu6.setText("Emplacement du menu");

        jMenuItem7.setText("Haut");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem7);

        jMenuItem9.setText("Gauche");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem9);

        jMenuItem10.setText("Droite");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem10);

        jMenuItem8.setText("Bas");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem8);

        jMenu3.add(jMenu6);

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Activer la barre d'outils");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jCheckBoxMenuItem1);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Autres");

        jMenuItem6.setText("Contacter l'administrateur");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuItem11.setText("Désactiver mon compte");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem11);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Connexion1 conn=new Connexion1();
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
   new MessageAdminWindow(user).setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        menuTab.setSelectedIndex(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        menuTab.setSelectedIndex(1);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
       Connexion1 conn= new Connexion1();
        this.dispose();
        conn.setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        menuTab.setTabPlacement(JTabbedPane.BOTTOM);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        menuTab.setTabPlacement(JTabbedPane.RIGHT);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        menuTab.setTabPlacement(JTabbedPane.LEFT);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        menuTab.setTabPlacement(JTabbedPane.TOP);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed

        new UtilisateurDAO().DeleteCompteUser(id_user);
            ImageIcon done = new ImageIcon("src/edu/esprit/pidev/images/cry.png");
        int option = JOptionPane.showConfirmDialog(null, "Vous êtes sur le point de supprimer définitivement votre compte,\\nêtes-vous sûr de vouloir continuer ?!", "Message", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE,done);
        Connexion1 A=new Connexion1();
        this.dispose();
        A.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed
   
    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        if (jCheckBoxMenuItem1.isSelected())
            jToolBar1.setVisible(true);
        else
            jToolBar1.setVisible(false);
        
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
    new EmailPanel(user);       
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new EmailPanel(user);
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        menuTab.setSelectedIndex(2);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

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
            java.util.logging.Logger.getLogger(GuiApprenant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiApprenant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiApprenant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiApprenant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiApprenant(id_user).setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTabbedPane menuTab;
    private javax.swing.JPanel panelGlobal;
    // End of variables declaration//GEN-END:variables

    private static class AfficherCoursCategorie extends Component {

        public AfficherCoursCategorie(User user) {
        }
    }
}
