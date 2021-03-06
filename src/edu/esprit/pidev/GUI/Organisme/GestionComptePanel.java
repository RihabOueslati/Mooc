/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.pidev.GUI.Organisme;


import edu.esprit.pidev.GUI.Comite.ConnectionWindow;
import edu.esprit.pidev.adapters.Verif;
import edu.esprit.pidev.dao.classes.UtilisateurDAO;
import edu.esprit.pidev.entities.User;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageFilter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

/**
 *
 * @author Iskander
 */
public class GestionComptePanel extends javax.swing.JPanel {

    public void setModifPanel3(JPanel modifPanel3) {
        this.modifPanel3 = modifPanel3;
    }

    public void setImageMap(JLabel imageMap) {
        this.imageMap = imageMap;
    }

    public JPanel getModifPanel3() {
        return modifPanel3;
    }

    public JLabel getImageMap() {
        return imageMap;
    }
    
    /**
     * Creates new form p1
     */
    
    
    int id;
    UtilisateurDAO userdao = new UtilisateurDAO();
    User user;
        
    public GestionComptePanel(int id) {
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

    public GestionComptePanel() {
        initComponents();
         activBtnDeco();
        initFields();

   
    }
    private ImageIcon iconMap;
  
    private JFrame frame;
    public GestionComptePanel(User user,JFrame currentFrame) {
        this.frame = currentFrame;
        this.user = user; 
        
         iconMap = new ImageIcon("src/Presentation/img/usersLocation/isi.png");
        	
        initComponents();
      //remplissage automatique des champs selon les information sur le compte
        
    }

    public ImageIcon getIconMap() {
        return iconMap;
    }

    public void setIconMap(ImageIcon iconMap) {
        this.iconMap = iconMap;
    }

    public void activBtnDeco(){
        JLabel img = this.imgProfile;
        btnDeco.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new ConnectionWindow();
                frame.dispose();
             }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
           }
        });
                
               
    }
    public void initFields(){
        //usernameLabel.setText(user.getLogin());
//        typeLabel.setText(user.getRole());
//        titreField.setText(user.getNom());
//        nomField.setText(user.getNom());
//        prenomField.setText(user.getPrenom());
//        emailField.setText(user.getMail());
//        adrsField.setText(user.getAdresse());
        
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

        modifPanel = new javax.swing.JPanel();
        modifPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        titreField = new javax.swing.JTextField();
        nomField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        prenomField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        adrsField = new javax.swing.JTextField();
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
        modifBtn3 = new javax.swing.JButton();
        modifBtn2 = new javax.swing.JButton();
        modifPanel3 = new javax.swing.JPanel();
        imageMap = new javax.swing.JLabel();
        basicInfoPanel = new javax.swing.JPanel();
        photoPanel = new javax.swing.JPanel();
        imgProfile = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
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

        setLayout(new java.awt.BorderLayout());

        modifPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Modifier mes informations"));
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

        jLabel21.setText("Adresse ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 9);
        modifPanel1.add(jLabel21, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 73;
        gridBagConstraints.insets = new java.awt.Insets(13, 24, 0, 19);
        modifPanel1.add(adrsField, gridBagConstraints);
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

        modifBtn3.setForeground(new java.awt.Color(255, 255, 255));
        modifBtn3.setText("Localiser mon adresse");
        modifBtn3.setUI (new BEButtonUI (). setNormalColor (BEButtonUI.NormalColor.green));
        modifBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifBtn3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.insets = new java.awt.Insets(13, 0, 12, 0);
        modifPanel.add(modifBtn3, gridBagConstraints);

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

        modifPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Localisation"));
        modifPanel3.setMinimumSize(new java.awt.Dimension(328, 173));
        modifPanel3.setPreferredSize(new java.awt.Dimension(320, 173));
        modifPanel3.setLayout(new java.awt.GridBagLayout());

        URL url = getClass().getResource("/Presentation/img/usersLocation/riri.png");
        if (url != null){
            imageMap.setForeground(new java.awt.Color(153, 153, 153));
            imageMap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            imageMap.setIcon(new ImageIcon("/Presentation/img/usersLocation/isi.png"));
        }
        imageMap.setText("");
        imageMap.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        imageMap.setMaximumSize(new java.awt.Dimension(300, 210));
        imageMap.setMinimumSize(new java.awt.Dimension(300, 210));
        imageMap.setPreferredSize(new java.awt.Dimension(300, 210));
        modifPanel3.add(imageMap, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(23, 10, 19, 10);
        modifPanel.add(modifPanel3, gridBagConstraints);

        add(modifPanel, java.awt.BorderLayout.CENTER);

        basicInfoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Informations de base"));
        basicInfoPanel.setLayout(new java.awt.BorderLayout());

        photoPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        photoPanel.setLayout(new java.awt.GridBagLayout());

        imgProfile.setBackground(new java.awt.Color(204, 204, 204));
        imgProfile.setForeground(new java.awt.Color(204, 204, 204));
        String filePath = new File("").getAbsolutePath().concat("/Presentation/img/usersAvatar/ss.png");
        File dest = new File(filePath);
        imgProfile.setIcon(new javax.swing.ImageIcon(dest.toString()));
        imgProfile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 5));
        imgProfile.setPreferredSize(new java.awt.Dimension(105, 105));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 10);
        photoPanel.add(imgProfile, gridBagConstraints);

        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Uploader une nouvelle photo");
        jButton1.setUI (new BEButtonUI (). setNormalColor (BEButtonUI.NormalColor.lightBlue));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifPictureActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.weighty = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(0, 60, 50, 44);
        photoPanel.add(jButton1, gridBagConstraints);

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
        btnDeco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/pidev/Presentation/img/logoff.png")));
        btnDeco.setToolTipText("Déconnexion");
        btnDeco.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel3.add(btnDeco, java.awt.BorderLayout.EAST);

        TopRightPanel.add(jPanel3, java.awt.BorderLayout.NORTH);

        basicInfoPanel.add(TopRightPanel, java.awt.BorderLayout.CENTER);

        add(basicInfoPanel, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents

    private void modifPictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifPictureActionPerformed
           modifPicture();
    }//GEN-LAST:event_modifPictureActionPerformed
    //***************************** JFILE CHOOSER MODIF PICTURE
    public void modifPicture(){
        JFileChooser fc = new JFileChooser();
           int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("L'utilisateur a accepté la selection.");
            File file = fc.getSelectedFile();
            imgProfile.setIcon(new ImageIcon(file.toString()));
            
            String filePath = new File("").getAbsolutePath().concat("/src/Presentation/img/usersAvatar/"+user.getUsername()+".png");
            File dest = new File(filePath);
           
            FileChannel inputChannel = null;
            FileChannel outputChannel = null;
            try {
                
                inputChannel = new FileInputStream(file).getChannel();
                outputChannel = new FileOutputStream(dest).getChannel();
                try {
                    outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
                } catch (IOException ex) {
                    Logger.getLogger(GestionComptePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {

            } finally {
                try {
                    outputChannel.close();
                } catch (IOException ex) {
                    Logger.getLogger(GestionComptePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else {
            System.out.println("L'utilisateur a annulé la selection.");
        }
    }
    private void modifBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifBtn3ActionPerformed
      // JFrame f = new MapWindow(user,this);
       //Rafraichir le compte pour récupérer la nouvelle adresse si elle est récement ajoutée
       user= new UtilisateurDAO().estCorrect(user.getUsername(),user.getPassword());
       System.out.println("Chemin image \n /Presentation/img/usersLocation/"+user.getUsername()+".png");
      // f.setVisible(true);
    }//GEN-LAST:event_modifBtn3ActionPerformed

    private void modifBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifBtn1ActionPerformed
       UtilisateurDAO userdao = new UtilisateurDAO();
//            
       user.setNom(nomField.getText());
       user.setPrenom(prenomField.getText());  
       user.setEmail(emailField.getText());
       user.setAdresse(adrsField.getText());

        userdao.modifierUser(user);
      if (Verif.isValidEMail(emailField.getText()))//email valide
      JOptionPane.showMessageDialog(null,"Vos informations ont été changées ! ","Informations changées ! ",JOptionPane.INFORMATION_MESSAGE);
            if (Verif.isValidEMail(emailField.getText()))//email valide
                    JOptionPane.showMessageDialog(null,"Vos informations ont été changées ! ","Informations changées ! ",JOptionPane.INFORMATION_MESSAGE);
                else//email non valide
                    JOptionPane.showMessageDialog(null,"Email non valide !","Informations non changées ! ",JOptionPane.WARNING_MESSAGE);
            
    }//GEN-LAST:event_modifBtn1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            resetPicture();
    }//GEN-LAST:event_jButton2ActionPerformed
    //********************* Rinstaliser photo DE PROFIL **************************
    public void resetPicture(){
        String filePath = new File("").getAbsolutePath().concat("/src/Presentation/img/usersAvatar/"+user.getUsername()+".png");
            File dest = new File(filePath);
            
           String filePath0 = new File("").getAbsolutePath().concat("/src/Presentation/img/avatarDefault.png"); 
           File source = new File(filePath0);
           imgProfile.setIcon(new ImageIcon(source.toString()));
            
           
            FileChannel inputChannel = null;
            FileChannel outputChannel = null;
            try {
                inputChannel = new FileInputStream(source).getChannel();
                outputChannel = new FileOutputStream(dest).getChannel();
                try {
                    outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
                    JOptionPane.showMessageDialog(null,"Votre photo a été supprimée ! ","Photo supprimée ! ",JOptionPane.INFORMATION_MESSAGE);
              
                } catch (IOException ex) {
                    Logger.getLogger(GestionComptePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {

            } finally {
                try {
                    outputChannel.close();
                } catch (IOException ex) {
                    Logger.getLogger(GestionComptePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
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


    

    public void setAdrsField(JTextField adrsField) {
        this.adrsField = adrsField;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TopRightPanel;
    private javax.swing.JTextField adrsField;
    private javax.swing.JPanel basicInfoPanel;
    private javax.swing.JLabel btnDeco;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel imageMap;
    private javax.swing.JLabel imgProfile;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton modifBtn1;
    private javax.swing.JButton modifBtn2;
    private javax.swing.JButton modifBtn3;
    private javax.swing.JPanel modifPanel;
    private javax.swing.JPanel modifPanel1;
    private javax.swing.JPanel modifPanel2;
    private javax.swing.JPanel modifPanel3;
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
