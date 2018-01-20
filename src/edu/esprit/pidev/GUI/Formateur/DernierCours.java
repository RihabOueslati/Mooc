/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.GUI.Formateur;

import static edu.esprit.pidev.GUI.Formateur.ModifierCoursPanel.S;
import edu.esprit.pidev.dao.classes.CoursDAO;
import edu.esprit.pidev.entities.Cours;
import edu.esprit.pidev.entities.User;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Ahmed
 */
public class DernierCours extends javax.swing.JPanel {
 private Vector<JPanel> panels=new Vector<>();
    private Vector<JButton>bouttoms=new Vector<>();
    private Vector<Cours>cours=new Vector<>();
    private Vector<JLabel> labels=new Vector<>();
    CoursDAO cdao=null;
    private static Cours c;
    private static User utilisateur;
    
     public void Remplir_Composants()
    {
        
//     panels.add(pane1);
//     panels.add(pane2);
//     panels.add(panel3);
//     panels.add(pane4);
//     panels.add(pane5);
//     panels.add(pane6);
//     images.add(img1);
//     images.add(img2);
//     images.add(img3);
//     images.add(img3);
//     images.add(img5);
//     images.add(img6);
     bouttoms.add(jButton1);
     bouttoms.add(jButton2);
     bouttoms.add(jButton3);
     bouttoms.add(jButton4);
     bouttoms.add(jButton5);
     bouttoms.add(jButton6);
     
    }
    /**
     * Creates new form DernierCours
     */
    public DernierCours(Cours c,User utilisateur) {
        this.c=c;
         this.utilisateur=utilisateur;
        initComponents();
        Remplir_Composants();
     
            cdao=new CoursDAO();
            cours=cdao.AfficherCours();
        switch ((cours.get(0)).getCategorie()) {
         case "Développement web":
             jLabel2.setIcon(new ImageIcon("src/edu/esprit/pidev/images/formateur/web.png"));
             break;
         case "Développement mobile":
             jLabel2.setIcon(new ImageIcon("src/edu/esprit/pidev/images/formateur/mobile.png"));
             break;
         default:
             jLabel2.setIcon(new ImageIcon("src/edu/esprit/pidev/images/formateur/desktop.png"));
             break;
     }
//     switch ((cours.get(1)).getCategorie()) {
//         case "Développement web":
//             jLabel3.setIcon(new ImageIcon("src/edu/esprit/pidev/images/formateur/web.png"));
//             break;
//         case "Développement mobile":
//             jLabel3.setIcon(new ImageIcon("src/edu/esprit/pidev/images/formateur/mobile.png"));
//             break;
//         default:
//             jLabel3.setIcon(new ImageIcon("src/edu/esprit/pidev/images/formateur/desktop.png"));
//             break;
//     }
//            
//     switch ((cours.get(2)).getCategorie()) {
//         case "Développement web":
//             jLabel4.setIcon(new ImageIcon("src/edu/esprit/pidev/images/formateur/web.png"));
//               case "Développement mobile":
//             jLabel4.setIcon(new ImageIcon("src/edu/esprit/pidev/images/formateur/mobile.png"));
//             break;
//         default:
//             jLabel4.setIcon(new ImageIcon("src/edu/esprit/pidev/images/formateur/desktop.png"));
//             break;
//     }
//
//     switch ((cours.get(3)).getCategorie()) {
//         case "Développement web":
//             jLabel5.setIcon(new ImageIcon("src/edu/esprit/pidev/images/formateur/web.png"));
//             break;
//         case "Développement mobile":
//             jLabel5.setIcon(new ImageIcon("src/edu/esprit/pidev/images/formateur/mobile.png"));
//             break;
//         default:
//             jLabel5.setIcon(new ImageIcon("src/edu/esprit/pidev/images/formateur/desktop.png"));
//             break;
//     }
//     
//        switch ((cours.get(4)).getCategorie()) {
//         case "Développement web":
//             jLabel6.setIcon(new ImageIcon("src/edu/esprit/pidev/images/formateur/web.png"));
//             break;
//         case "Développement mobile":
//             jLabel6.setIcon(new ImageIcon("src/edu/esprit/pidev/images/formateur/mobile.png"));
//             break;
//         default:
//             jLabel6.setIcon(new ImageIcon("src/edu/esprit/pidev/images/formateur/desktop.png"));
//             break;
//     }
//           switch ((cours.get(5)).getCategorie()) {
//         case "Développement web":
//             jLabel7.setIcon(new ImageIcon("src/edu/esprit/pidev/images/formateur/web.png"));
//             break;
//         case "Développement mobile":
//             jLabel7.setIcon(new ImageIcon("src/edu/esprit/pidev/images/formateur/mobile.png"));
//             break;
//         default:
//             jLabel7.setIcon(new ImageIcon("src/edu/esprit/pidev/images/formateur/desktop.png"));
//             break;
//     }
       
                   titre1.setText((cours.get(0)).getTitre());
//                   titre2.setText((cours.get(1)).getTitre());
//                   titre3.setText((cours.get(2)).getTitre());
//                   titre4.setText((cours.get(3)).getTitre());
//                   titre5.setText((cours.get(4)).getTitre());
//                   titre6.setText((cours.get(5)).getTitre());


            Print_cours(cours);
       
    }
     public void Print_cours(Vector<Cours>cours)
    {   
        if(cours.isEmpty())
        {
       //pubvide.setVisible(true);
        for(int i=0;i<6;i++)
         {    
         panels.get(i).setVisible(false);                       
         bouttoms.get(i).setVisible(false);                 
         }
        
         if(cours.size()<6)
         {
         int i=0;
         for(Cours l:cours)
         {
          panels.get(i).setVisible(true);         
          bouttoms.get(i).setVisible(true);
          
          i++;          
          }
          for(int j=panels.size()-1;j>=cours.size();j--)
          {        
          panels.get(j).setVisible(false);      
          bouttoms.get(j).setVisible(false);
         }
         
         
         }  
         
         
          }}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel13 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        titre1 = new javax.swing.JLabel();
        titre2 = new javax.swing.JLabel();
        titre3 = new javax.swing.JLabel();
        titre4 = new javax.swing.JLabel();
        titre5 = new javax.swing.JLabel();
        titre6 = new javax.swing.JLabel();
        Titre6 = new java.awt.Label();
        Titre11 = new java.awt.Label();
        Titre12 = new java.awt.Label();
        Titre13 = new java.awt.Label();
        Titre14 = new java.awt.Label();
        Titre15 = new java.awt.Label();

        jPanel13.setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 204, 255)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel1);
        jPanel1.setBounds(560, 70, 190, 150);

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 204, 255)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel3);
        jPanel3.setBounds(320, 70, 190, 150);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel13.add(jPanel4);
        jPanel4.setBounds(70, 310, 190, 150);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));
        jPanel7.setForeground(new java.awt.Color(102, 204, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel7);
        jPanel7.setBounds(320, 310, 190, 150);

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel8);
        jPanel8.setBounds(64, 66, 190, 150);

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel9);
        jPanel9.setBounds(560, 310, 190, 150);

        jButton1.setText("Consulter ce cours");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton1);
        jButton1.setBounds(90, 250, 130, 23);

        jButton2.setText("Consulter ce cours");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton2);
        jButton2.setBounds(350, 250, 130, 23);

        jButton3.setText("Consulter ce cours");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton3);
        jButton3.setBounds(590, 250, 140, 23);

        jButton4.setText("Consulter ce cours");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton4);
        jButton4.setBounds(90, 500, 130, 23);

        jButton5.setText("Conster ce cours");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton5);
        jButton5.setBounds(350, 500, 130, 23);

        jButton6.setText("Consulter ce Cours");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton6);
        jButton6.setBounds(600, 500, 130, 23);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel14);
        jPanel14.setBounds(830, 0, 680, 640);

        titre1.setText("jLabel1");
        jPanel13.add(titre1);
        titre1.setBounds(150, 220, 60, 20);

        titre2.setText("jLabel1");
        jPanel13.add(titre2);
        titre2.setBounds(420, 220, 60, 20);

        titre3.setText("jLabel1");
        jPanel13.add(titre3);
        titre3.setBounds(650, 220, 60, 20);

        titre4.setText("jLabel1");
        jPanel13.add(titre4);
        titre4.setBounds(150, 470, 60, 20);

        titre5.setText("jLabel1");
        jPanel13.add(titre5);
        titre5.setBounds(400, 470, 60, 20);

        titre6.setText("jLabel1");
        jPanel13.add(titre6);
        titre6.setBounds(670, 470, 60, 20);

        Titre6.setFont(new java.awt.Font("Comic Sans MS", 2, 14)); // NOI18N
        Titre6.setForeground(new java.awt.Color(51, 204, 255));
        Titre6.setText("Titre de cours : ");
        jPanel13.add(Titre6);
        Titre6.setBounds(520, 460, 120, 25);

        Titre11.setFont(new java.awt.Font("Comic Sans MS", 2, 14)); // NOI18N
        Titre11.setForeground(new java.awt.Color(51, 204, 255));
        Titre11.setText("Titre de cours : ");
        jPanel13.add(Titre11);
        Titre11.setBounds(20, 220, 120, 25);

        Titre12.setFont(new java.awt.Font("Comic Sans MS", 2, 14)); // NOI18N
        Titre12.setForeground(new java.awt.Color(51, 204, 255));
        Titre12.setText("Titre de cours : ");
        jPanel13.add(Titre12);
        Titre12.setBounds(290, 220, 120, 25);

        Titre13.setFont(new java.awt.Font("Comic Sans MS", 2, 14)); // NOI18N
        Titre13.setForeground(new java.awt.Color(51, 204, 255));
        Titre13.setText("Titre de cours : ");
        jPanel13.add(Titre13);
        Titre13.setBounds(520, 220, 120, 25);

        Titre14.setFont(new java.awt.Font("Comic Sans MS", 2, 14)); // NOI18N
        Titre14.setForeground(new java.awt.Color(51, 204, 255));
        Titre14.setText("Titre de cours : ");
        jPanel13.add(Titre14);
        Titre14.setBounds(30, 460, 120, 25);

        Titre15.setFont(new java.awt.Font("Comic Sans MS", 2, 14)); // NOI18N
        Titre15.setForeground(new java.awt.Color(51, 204, 255));
        Titre15.setText("Titre de cours : ");
        jPanel13.add(Titre15);
        Titre15.setBounds(280, 460, 120, 25);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 1520, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 jPanel14.removeAll();
        jPanel14.repaint();
        jPanel14.revalidate();
        jPanel14.add(new ConsulterCoursPanel(cours.get(0),utilisateur));
        titre1.setText((cours.get(0)).getTitre());
        jPanel14.repaint();
        jPanel14.revalidate();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        jPanel14.removeAll();
//        jPanel14.repaint();
//        jPanel14.revalidate();
//        jPanel14.add(new ConsulterCoursPanel(cours.get(1),utilisateur));
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
jPanel14.removeAll();
//        jPanel14.repaint();
//        jPanel14.revalidate();
//        jPanel14.add(new ConsulterCoursPanel(cours.get(2),utilisateur));
            }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
jPanel14.removeAll();
//        jPanel14.repaint();
//        jPanel14.revalidate();
//        jPanel14.add(new ConsulterCoursPanel(cours.get(3),utilisateur));
            }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
//jPanel14.removeAll();
//        jPanel14.repaint();
//        jPanel14.revalidate();
//        jPanel14.add(new ConsulterCoursPanel(cours.get(4),utilisateur));
            }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
//jPanel14.removeAll();
//        jPanel14.repaint();
//        jPanel14.revalidate();
//        jPanel14.add(new ConsulterCoursPanel(cours.get(5),utilisateur));
            }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label Titre11;
    private java.awt.Label Titre12;
    private java.awt.Label Titre13;
    private java.awt.Label Titre14;
    private java.awt.Label Titre15;
    private java.awt.Label Titre6;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel titre1;
    private javax.swing.JLabel titre2;
    private javax.swing.JLabel titre3;
    private javax.swing.JLabel titre4;
    private javax.swing.JLabel titre5;
    private javax.swing.JLabel titre6;
    // End of variables declaration//GEN-END:variables
}
