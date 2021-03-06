/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.GUI.Formateur;

import edu.esprit.pidev.GUI.Admin.*;
import edu.esprit.pidev.dao.classes.GestionUtilisateur;
import edu.esprit.pidev.dao.classes.UtilisateurDAO;
import edu.esprit.pidev.entities.User;
import java.awt.Dimension;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;



/**
 *
 * @author jihene
 */
public class ProfilPanel extends javax.swing.JPanel {

    /**
     * Creates new form ProfilPanel
     */
    int id;
    UtilisateurDAO userdao = new UtilisateurDAO();
    User user;
        
    public ProfilPanel(int id) {
        this.setOpaque(false);
        this.id = id;
        System.out.println("mon id est :"+id);
        user = userdao.DisplayUser(id);
        initComponents();
        setSize(new Dimension(810, 601));
        repaint();
        revalidate();
        System.out.println(getHeight());

        
        titreField.setText(user.getRoles());
       
        emailField.setText(user.getEmail());
        nomField.setText(user.getNom());
        prenomField.setText(user.getPrenom());
        typeLabel.setText(user.getRoles());
        if (user.getSexe()!=null){
        String sexe = user.getSexe();
             if (sexe.equals("")) genderBox.setSelectedIndex(0);
        else if (sexe.equals("Homme")) genderBox.setSelectedIndex(1);
        else if (sexe.equals("Femme")) genderBox.setSelectedIndex(2);
        }
        if(user.getImage()!=null)
        {
        ImageIcon background = new ImageIcon(user.getImage());
        imgProfile.setBounds(0, 0, 300, 300);
        imgProfile.setIcon(background);
        imgProfile.repaint();
        imgProfile.revalidate();
//        fenetre.repaint();
//        fenetre.revalidate();
        }
        
    }

    public ProfilPanel() {
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
        java.awt.GridBagConstraints gridBagConstraints;

        basicInfoPanel = new javax.swing.JPanel();
        photoPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        imgProfile = new javax.swing.JLabel();
        TopRightPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        typeLabel = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnDeco = new javax.swing.JLabel();
        modifPanel = new javax.swing.JPanel();
        modifPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        titreField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        genderBox = new javax.swing.JComboBox();
        nomField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        prenomField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        modifBtn1 = new javax.swing.JButton();
        modifPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        oldPassField = new javax.swing.JPasswordField();
        newPassField = new javax.swing.JPasswordField();
        newPassField2 = new javax.swing.JPasswordField();
        modifBtn2 = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(600, 400));

        basicInfoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Informations de base"));
        basicInfoPanel.setLayout(new java.awt.BorderLayout());

        photoPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        photoPanel.setLayout(new java.awt.GridBagLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Photo de profil");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.insets = new java.awt.Insets(15, 20, 5, 10);
        photoPanel.add(jLabel1, gridBagConstraints);

        jButton2.setText("Supprimer la photo de profil");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.insets = new java.awt.Insets(50, 60, 0, 44);
        photoPanel.add(jButton2, gridBagConstraints);

        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Uploader une nouvelle photo");
        jButton1.setUI (new BEButtonUI (). setNormalColor (BEButtonUI.NormalColor.lightBlue));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1modifPictureActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.weighty = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(0, 60, 50, 44);
        photoPanel.add(jButton1, gridBagConstraints);

        imgProfile.setBackground(new java.awt.Color(204, 204, 204));
        imgProfile.setForeground(new java.awt.Color(204, 204, 204));
        String filePath = new File("").getAbsolutePath().concat("/edu/esprit/pidev/images/"+user.getNom()+".png");
        File dest = new File(filePath);
        imgProfile.setIcon(new javax.swing.ImageIcon(dest.toString()));
        imgProfile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 5));
        imgProfile.setPreferredSize(new java.awt.Dimension(105, 105));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 10);
        photoPanel.add(imgProfile, gridBagConstraints);

        basicInfoPanel.add(photoPanel, java.awt.BorderLayout.WEST);

        TopRightPanel.setLayout(new java.awt.BorderLayout());

        jPanel1.setForeground(new java.awt.Color(0, 102, 204));
        jPanel1.setMinimumSize(new java.awt.Dimension(20, 20));
        jPanel1.setPreferredSize(new java.awt.Dimension(5, 5));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 204));
        jLabel8.setText(" !");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 10, 14);
        jPanel1.add(jLabel8, gridBagConstraints);

        usernameLabel.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(0, 102, 204));
        usernameLabel.setText("     ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 10, 5);
        jPanel1.add(usernameLabel, gridBagConstraints);

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 204));
        jLabel17.setText("Bienvenue ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(8, 17, 10, 4);
        jPanel1.add(jLabel17, gridBagConstraints);

        TopRightPanel.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setMinimumSize(new java.awt.Dimension(50, 50));
        jPanel2.setPreferredSize(new java.awt.Dimension(246, 70));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        typeLabel.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        typeLabel.setForeground(new java.awt.Color(0, 102, 204));
        typeLabel.setText("     ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 32, 0);
        jPanel2.add(typeLabel, gridBagConstraints);

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 204));
        jLabel18.setText("Vous êtes connecté en tant que ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 32, 0);
        jPanel2.add(jLabel18, gridBagConstraints);

        TopRightPanel.add(jPanel2, java.awt.BorderLayout.SOUTH);

        jPanel3.setLayout(new java.awt.BorderLayout());

        btnDeco.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnDeco.setForeground(new java.awt.Color(0, 102, 204));
        btnDeco.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnDeco.setToolTipText("Déconnexion");
        btnDeco.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel3.add(btnDeco, java.awt.BorderLayout.EAST);

        TopRightPanel.add(jPanel3, java.awt.BorderLayout.NORTH);

        basicInfoPanel.add(TopRightPanel, java.awt.BorderLayout.CENTER);

        modifPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Modifier mes informations"));
        modifPanel.setMinimumSize(getMaximumSize());
        modifPanel.setPreferredSize(getMaximumSize());
        modifPanel.setLayout(new java.awt.GridBagLayout());

        modifPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informations"));
        modifPanel1.setMinimumSize(new java.awt.Dimension(254, 233));
        modifPanel1.setPreferredSize(new java.awt.Dimension(275, 253));
        modifPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel9.setText("Titre de mon profil ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(27, 10, 0, 9);
        modifPanel1.add(jLabel9, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 73;
        gridBagConstraints.insets = new java.awt.Insets(30, 24, 0, 19);
        modifPanel1.add(titreField, gridBagConstraints);

        jLabel12.setText("Sexe");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 40, 9);
        modifPanel1.add(jLabel12, gridBagConstraints);

        genderBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "selectionner","Homme", "Femme" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 73;
        gridBagConstraints.insets = new java.awt.Insets(13, 24, 40, 19);
        modifPanel1.add(genderBox, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 73;
        gridBagConstraints.insets = new java.awt.Insets(13, 24, 0, 19);
        modifPanel1.add(nomField, gridBagConstraints);

        jLabel10.setText("Nom ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 9);
        modifPanel1.add(jLabel10, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 73;
        gridBagConstraints.insets = new java.awt.Insets(13, 24, 0, 19);
        modifPanel1.add(prenomField, gridBagConstraints);

        jLabel13.setText("Prenom ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 9);
        modifPanel1.add(jLabel13, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(13, 24, 0, 19);
        modifPanel1.add(emailField, gridBagConstraints);

        jLabel6.setText("Email ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 9);
        modifPanel1.add(jLabel6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 82;
        gridBagConstraints.insets = new java.awt.Insets(23, 10, 19, 10);
        modifPanel.add(modifPanel1, gridBagConstraints);

        modifBtn1.setForeground(new java.awt.Color(255, 255, 255));
        modifBtn1.setText("Modifier mes informations");
        modifBtn1.setUI (new BEButtonUI (). setNormalColor (BEButtonUI.NormalColor.green));
        modifBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifBtn1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.insets = new java.awt.Insets(13, 0, 12, 0);
        modifPanel.add(modifBtn1, gridBagConstraints);

        modifPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Mot de passe"));
        modifPanel2.setMinimumSize(new java.awt.Dimension(328, 173));
        modifPanel2.setPreferredSize(new java.awt.Dimension(320, 173));
        modifPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel11.setText("Ancien mot de passe");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 27, 0, 9);
        modifPanel2.add(jLabel11, gridBagConstraints);

        jLabel15.setText("Nouveau mot de passe");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 27, 0, 9);
        modifPanel2.add(jLabel15, gridBagConstraints);

        jLabel16.setText("Nouveau mot de passe");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 27, 0, 9);
        modifPanel2.add(jLabel16, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 36);
        modifPanel2.add(oldPassField, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 36);
        modifPanel2.add(newPassField, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 36);
        modifPanel2.add(newPassField2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(23, 10, 19, 10);
        modifPanel.add(modifPanel2, gridBagConstraints);

        modifBtn2.setForeground(new java.awt.Color(255, 255, 255));
        modifBtn2.setText("Modifier mon mot de passe");
        modifBtn2.setUI (new BEButtonUI (). setNormalColor (BEButtonUI.NormalColor.green));
        modifBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifBtn2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.insets = new java.awt.Insets(13, 0, 12, 0);
        modifPanel.add(modifBtn2, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1097, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(basicInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1097, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(modifPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1097, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(basicInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(modifPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        add(basicInfoPanel, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents
 public void resetPicture(){
     
        try {
            
            String filename = "src/edu/esprit/pidev/images/usersAvatar/avatar.png";

            ImageIcon background = new ImageIcon(filename);
            
            imgProfile.setBounds(0, 0, 300, 300);
            imgProfile.setIcon(background);
            imgProfile.repaint();
            imgProfile.revalidate();

           
            GestionUtilisateur GS = new GestionUtilisateur();
            System.out.println(filename);
            GS.ModifierPhotoDeProfil(id, filename.replace("\\", "\\\\"));
            
        } catch (Exception ex) {
        }
 
    }
public void modifPicture(){
       
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            String filename = f.getAbsolutePath();

            ImageIcon background = new ImageIcon(filename);
            
            imgProfile.setBounds(0, 0, 300, 300);
            imgProfile.setIcon(background);
            imgProfile.repaint();
            imgProfile.revalidate();

           
            GestionUtilisateur GS = new GestionUtilisateur();
            System.out.println(filename);
            GS.ModifierPhotoDeProfil(id, filename.replace("\\", "\\\\"));
            
        } catch (Exception ex) {
        }
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        resetPicture();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void modifBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifBtn1ActionPerformed
      
        String sexe = user.getSexe();
        if (genderBox.getSelectedIndex() ==0) sexe="";
        else if (genderBox.getSelectedIndex() == 1) sexe="Homme";
        else if (genderBox.getSelectedIndex() ==2)sexe="Femme";
       user.setNom(nomField.getText());
       user.setPrenom(prenomField.getText());
       
       user.setEmail(emailField.getText());
       user.setSexe(sexe);
        userdao.modifierUser(user);
        if (Verif.isValidEMail(emailField.getText()))//email valide
        JOptionPane.showMessageDialog(null,"Vos informations ont été changées ! ","Informations changées ! ",JOptionPane.INFORMATION_MESSAGE);
        else //email non valide
        JOptionPane.showMessageDialog(null,"Email non valide !","Informations non changées ! ",JOptionPane.WARNING_MESSAGE);
       
    }//GEN-LAST:event_modifBtn1ActionPerformed

    private void modifBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifBtn2ActionPerformed
        //Si les nouveaux mot de passe saisies sont egaux
        if (newPassField.getText().equals(newPassField2.getText()))
        {
            user = userdao.DisplayUser(id);
            //Si l'ancien mot de passe du compte est correcte
            if (user.getPassword().equals(oldPassField.getText()))
            { user.setPassword(newPassField.getText());
                userdao.modifierUser(user);
            JOptionPane.showMessageDialog(null,"Votre mot de passe a été changé avec succès ! ","Mot de passe changé ! ",JOptionPane.INFORMATION_MESSAGE);
            }else //Sinon
            JOptionPane.showMessageDialog(null,"L'ancien mot de passe est incorrect ! ","Mot de passe non changé ! ",JOptionPane.WARNING_MESSAGE);

        }else{
            JOptionPane.showMessageDialog(null,"Les deux nouveaux mot de passe ne sont pas identiques ! ","Mot de passe non identiques",JOptionPane.WARNING_MESSAGE);
        }
        newPassField.setText("");
        newPassField2.setText("");
        oldPassField.setText("");
    }//GEN-LAST:event_modifBtn2ActionPerformed

    private void jButton1modifPictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1modifPictureActionPerformed
        modifPicture();
    }//GEN-LAST:event_jButton1modifPictureActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TopRightPanel;
    private javax.swing.JPanel basicInfoPanel;
    private javax.swing.JLabel btnDeco;
    private javax.swing.JTextField emailField;
    private javax.swing.JComboBox genderBox;
    private javax.swing.JLabel imgProfile;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton modifBtn1;
    private javax.swing.JButton modifBtn2;
    private javax.swing.JPanel modifPanel;
    private javax.swing.JPanel modifPanel1;
    private javax.swing.JPanel modifPanel2;
    private javax.swing.JPasswordField newPassField;
    private javax.swing.JPasswordField newPassField2;
    private javax.swing.JTextField nomField;
    private javax.swing.JPasswordField oldPassField;
    private javax.swing.JPanel photoPanel;
    private javax.swing.JTextField prenomField;
    private javax.swing.JTextField titreField;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
