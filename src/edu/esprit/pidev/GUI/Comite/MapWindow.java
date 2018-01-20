
package edu.esprit.pidev.GUI.Comite;



import static edu.esprit.pidev.GUI.GuiCommite.setTheme;
import edu.esprit.pidev.adapters.Verif;
import edu.esprit.pidev.dao.classes.UtilisateurDAO;
import edu.esprit.pidev.entities.User;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

/**
 *
 * @author Rihab
 */
public class MapWindow extends JFrame{
    
    private JButton btnZoomIn;
    private JButton btnZoomOut;
    private JButton btnActualiser;
    private JButton btnType;
    private JLabel adresseLabel;
    private JTextField adrsField;
    private JButton btnAppliquer;
    private JFrame frame;
    private JFrame frameParent;
    private GestionComptePanel comptePanel;
    private int zoom ;
    private Map map;
    private User compte;
    private String typeMap;
    
    public MapWindow (User compte,GestionComptePanel comptePanel){
        this.comptePanel = comptePanel;
        frame= this;
        this.compte = compte;
        zoom=15;//zoom par default
        typeMap = "roadmap";
        btnAppliquer = new JButton("Appliquer");
        btnActualiser = new JButton("Actualiser");
        btnZoomIn = new JButton("Zoom avant");
        btnZoomOut = new JButton("Zoom arriere");
        btnType = new JButton("Vue Satellite/Rues");
        adresseLabel = new JLabel("Adresse");
        adrsField = new JTextField(120);
        System.out.println(compte.getAdresse());
        adrsField.setText(compte.getAdresse());
        map = new Map(adrsField.getText(),zoom,typeMap);
        
        
        Image im = Toolkit.getDefaultToolkit().getImage("src/Presentation/img/type48.png");//icone
        setIconImage(im);
		
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700,600);
        setTitle("Localiser votre adresse ");
        setDesign();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
    //**********************************************************************************
    //*************************************** DESIGN ***********************************
    //**********************************************************************************
    public void setDesign(){
        
        setLayout(new BorderLayout());
        
        
        //************** SOUTH PANEL *****************
        JPanel southPanel = new JPanel(new GridBagLayout());
        
        //**********Boutons du premier ligne******************
            //BOUTON ZOOM IN
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new java.awt.Insets(12, 12, 12, 12);
            gbc.gridx = 0;
            gbc.gridy = 0;
            btnZoomIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentation/img/zoomIn48.png"))); // NOI18N

            btnZoomIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    zoom ++;
                    getContentPane().remove(1);
                Map map = new Map(adrsField.getText(),zoom,typeMap);
                frame.getContentPane().add(map);
                frame.revalidate();
             }
            });
            southPanel.add(btnZoomIn,gbc);
            
            
              // BOUTON ZOOM OUT
            gbc.gridx = 1;
            gbc.gridy = 0;
            btnZoomOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentation/img/zoomOut48.png"))); // NOI18N
            btnZoomOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    zoom --;
                    getContentPane().remove(1);
                Map map = new Map(adrsField.getText(),zoom,typeMap);
                frame.getContentPane().add(map);
                frame.revalidate();
             }
            });
            southPanel.add(btnZoomOut,gbc);
            
              // BOUTON TYPE
            gbc.gridx =2;
            gbc.gridy = 0;
            btnType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentation/img/type48.png"))); // NOI18N
            btnType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if (typeMap.equals("roadmap")) setTypeMap("satellite");
                    else setTypeMap("roadmap");
                    getContentPane().remove(1);
                Map map = new Map(adrsField.getText(),zoom,typeMap);
                frame.getContentPane().add(map);
                frame.revalidate();
             }
            });
            southPanel.add(btnType,gbc);
         //******************Dernier Ligne ***********************
            gbc = new GridBagConstraints();
            gbc.insets = new java.awt.Insets(12, 12, 12, 12);
            gbc.gridx = 0;
            gbc.gridy = 1;
            southPanel.add(adresseLabel,gbc);
            
            gbc.ipadx = 180;
            gbc.gridx =1;
            southPanel.add(adrsField,gbc);
            
            gbc = new GridBagConstraints();
            gbc.insets = new java.awt.Insets(12, 12, 12, 12);gbc.ipadx = 40;
            gbc.gridx =2;
            gbc.gridy = 1;
            btnActualiser.addActionListener(new ActionListener() {
            // Bouton actualiser
            @Override 
            public void actionPerformed(ActionEvent e) {
                    
                getContentPane().remove(1);
                Map map = new Map(adrsField.getText(),zoom,typeMap);
                frame.getContentPane().add(map);
                frame.revalidate();   
             }
            });
            southPanel.add(btnActualiser,gbc);
            
            
             // Bouton APPLIQUER
            gbc.gridx =3;
            btnAppliquer.setUI (new BEButtonUI (). setNormalColor (BEButtonUI.NormalColor.green));
            btnAppliquer.setForeground(Color.WHITE);
            btnAppliquer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                try { 
                    Map map = new Map(adrsField.getText(),zoom,typeMap);
                    map.setSizeInternalMap("300x210");
                    map.repaint();
                    String url = map.getUrl();
                    String filePath0 = new File("").getAbsolutePath().concat("/src/Presentation/img/usersLocation/"+compte.getUsername()+".png"); 
                    ImageIO.write(ImageIO.read(new URL(url)), "png",new File(filePath0));
                    //Changement de la nouvelle adresse
                  
                    /*UtilisateurDAO cda = new UtilisateurDAO();
                    cda.modifCompte(compte.getUsername(),user.,compte.getTitre(), adrsField.getText(), compte.getEmail(), compte.getNom(), compte.getPrenom(), compte.getSexe());
                    
                    */
                    
                    
                    comptePanel.setAdrsField(adrsField);
                    JOptionPane.showMessageDialog(null,"Localisation enregistrée ","Changement effectué ! ",JOptionPane.INFORMATION_MESSAGE);
                    
                    
                } catch (IOException ex) {
                    Logger.getLogger(MapWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            });
            southPanel.add(btnAppliquer,gbc);
            
            southPanel.setBorder(new TitledBorder("Informations sur l'adresse"));
           
            
            
            
        //************** CENTER PANEL *****************
        this.add(southPanel,BorderLayout.SOUTH);
        getContentPane().add(map);
    }

    public String getTypeMap() {
        return typeMap;
    }

    public void setTypeMap(String typeMap) {
        this.typeMap = typeMap;
    }
    
    /*
    public static void main (String args[]){
        setTheme();
        //Juste pour le test
        Compte c = new Compte("","","Iskander", "Jaiem","iskanderjaiem@gmail.com","Administrateur","sousse,tunisie","H","admin");
        new MapWindow(c);
    }*/

    public JButton getBtnType() {
        return btnType;
    }

    public void setBtnType(JButton btnType) {
        this.btnType = btnType;
    }
}






//**********************************************************************************
//*************************** MAP COMP**************************
//**********************************************************************************
class Map extends Canvas implements ImageObserver{
    
    private String adrs;
    private Image map;
    private int size=600;
    private int zoom;
    private String typeMap;
    private String sizeInternalMap;
    private String url ;
    public Map(String adrs,int zoom,String typeMap)  {
        //url_image = new URL("http://maps.googleapis.com/maps/api/staticmap?center=New+York=16&size=600x300&maptype=roadmap&markers=color:blue%7Clabel:S%7C40.702147,-74.015794&markers=color:green%7Clabel:G%7C40.711614,-74.012318&markers=color:red%7Ccolor:red%7Clabel:C%7C40.718217,-73.998284&sensor=false");
        this.zoom = zoom;
        this.typeMap = typeMap;
        this.adrs = adrs;
        sizeInternalMap = "620x400";
        url= "http://maps.googleapis.com/maps/api/staticmap?"
                     + "center="+Verif.ReplaceSpaceToPlus(adrs)
                     + "&zoom="+Integer.toString(zoom)
                     + "&size="+sizeInternalMap
                     + "&maptype="+typeMap;
        
        try {
            map = ImageIO.read(new URL(url));
        } catch (IOException ex) {
            Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(adrs);
    }

    public void setSizeInternalMap(String sizeInternalMap) {
        this.sizeInternalMap = sizeInternalMap;
        
        //updateImage
        url= "http://maps.googleapis.com/maps/api/staticmap?"
                     + "center="+Verif.ReplaceSpaceToPlus(adrs)
                     + "&zoom="+Integer.toString(zoom)
                     + "&size="+sizeInternalMap
                     + "&maptype="+typeMap;
         try {
            map = ImageIO.read(new URL(url));
        } catch (IOException ex) {
            Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getUrl(){
        return url;
    }
    
    String url2 = "http://maps.googleapis.com/maps/api/staticmap?"
                    + "center=Brooklyn+Bridge,New+York,NY"
                    + "&zoom=14"
                    + "&size=512x512"
                    + "&maptype=roadmap"
                    + "&markers=color:blue%7Clabel:S%7C40.702147,-74.015794"
                    + "&markers=color:green%7Clabel:G%7C40.711614,-74.012318"
                    + "&markers=color:red%7Ccolor:red%7Clabel:C%7C40.718217,-73.998284"
                    + "&sensor=true"
                    + "&maptype=satellite";
    
    
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0,size, size);
        g.drawImage(map, 30, 10, this);
    }

    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
        if((infoflags&ImageObserver.ALLBITS)!=0){
            repaint();
            return true;
        }
        return false;
    }
   
    public static void main (String args[]){
        setTheme();/*
        //Juste pour le test
        Compte c = new Compte("","","Iskander", "Jaiem","iskanderjaiem@gmail.com","Administrateur","sousse,tunisie","H","admin");
        new MapWindow(c);*/
    }
}