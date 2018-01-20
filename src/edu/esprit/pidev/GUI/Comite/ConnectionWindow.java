package edu.esprit.pidev.GUI.Comite;
/* @author Iskander
 */


//import DAO.CompteAdminDAO;

import edu.esprit.pidev.dao.classes.UtilisateurDAO;
import edu.esprit.pidev.entities.User;
import edu.esprit.pidev.entities.CompteApprenant;
import edu.esprit.pidev.entities.CompteCommite;
//import Entities.CompteFreelancer;
//import Entities.CompteJobowner;
//import FACEBOOK.Main;
import edu.esprit.pidev.util.MyConnection;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class ConnectionWindow extends JFrame{
	private String email;
        private String pwd;
        
	public ConnectionWindow(){
		setTitle("PerfectJob v1.0 - Connexion");
		setSize(650,480);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDesign(this);
                Image im = Toolkit.getDefaultToolkit().getImage("src/Presentation/img/logo32.png");//icone
                setIconImage(im);
		setVisible(true);
		
	}
	
	public void setDesign (JFrame frame){
		JPanel globalPanel = new JPanel();
		globalPanel.setLayout(new BorderLayout());
		
	    this.add(new LogoConnectionPanel(),BorderLayout.NORTH);
	    this.add(new MidConnectionPanel(email,pwd,frame),BorderLayout.CENTER);
	    
	}
}


//******************************* LOGO PANEL  *******************
class LogoConnectionPanel extends JPanel{
	private GridBagLayout gbl;
	private GridBagConstraints gbc;
	
	public LogoConnectionPanel(){
		//-------------LAYOUT + CONTENT---------
		setLayout(new BorderLayout());
		JLabel gestionClientImage = new JLabel(new ImageIcon("src/Presentation/img/logo0.png"));
		add(gestionClientImage,BorderLayout.CENTER);
	}
}

//***************************** MIDDLE PANEL *******************
class MidConnectionPanel extends JPanel{
	private GridBagLayout gbl;
	private GridBagConstraints gbc;
	private JLabel nomLabel;
	private JLabel passLabel;
	private JLabel facebook;
	private JTextField nomText;
	private JTextField passText;
	private JButton connexionBtn;
	private JButton inscrBtn;
	//********** INITIALISER LE PANEL **********
	public MidConnectionPanel (String username, String pwd,JFrame frame){
		//------------ INITIALISATION DES COMPOSANTS ----------
		nomLabel = new JLabel("Nom d'utilisateur : ");
		passLabel= new JLabel("Mot de passe      : ");
                
		nomText  = new JTextField(20);
		passText = new JPasswordField(20);
                nomText.setToolTipText("Votre nom d'utilisateur");
                passText.setToolTipText("Votre mot de passe");
                connexionBtn = new JButton("Se connecter");
                inscrBtn = new JButton("S'inscrire");
                facebook = new JLabel(new ImageIcon(getClass().getResource("/edu.esprit.peidev.Presentation/img/fb.png")));
                username = nomText.getText();
                pwd = passText.getText();
                //----------EVENEMENT DU BOUTON 
		connexionBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //Connection + récupération du compte
                        UtilisateurDAO cDAO = new UtilisateurDAO();
                        User  c = cDAO.estCorrect(nomText.getText(),passText.getText());
//                     CompteAdminDAO cADAO= new CompteAdminDAO();
//                     CompteAdmin cA=new CompteAdmin();
                        
                        //TRAITEMENT DES CAS D'ERREUR
                        if (c==null && MyConnection.getInstance()==null )//Si on pas pu se connecter à la bd 
                            JOptionPane.showMessageDialog(null,"Impossible de se connecter à la base de donnée !","Authentification échouée !",JOptionPane.INFORMATION_MESSAGE);
                      
                        else if (c==null && MyConnection.getInstance()!=null )//Si on a pu se connecter à la bd sans avoir un résultat dans compte alors 
                            JOptionPane.showMessageDialog(null,"Email ou mot de passe incorrecte !","Authentification échouée !",JOptionPane.INFORMATION_MESSAGE);
                        else if (c!=null && MyConnection.getInstance()!=null){
                            
                            //********* ADMINISTRATEUR *************
//                            if(c.getClass().getSimpleName().equals("CompteAdmin")){
//                                
//                                new GuiAdmin((CompteAdmin)c);
//                                JOptionPane.showMessageDialog(null,"Bienvenue, votre compte est de type : "+c.getClass().getSimpleName(),"Message",JOptionPane.INFORMATION_MESSAGE);
//                                frame.dispose();
//                            }
                             //********* JOBOWNER *************
//                            else if (c.getClass().getSimpleName().equals("CompteJobowner")){
//                                new GuiJobowner((CompteJobowner)c);
//                                JOptionPane.showMessageDialog(null,"Bienvenue, votre compte est de type : "+c.getClass().getSimpleName(),"Message",JOptionPane.INFORMATION_MESSAGE);
//                                frame.dispose();
//                            } 
                            //********* FREELANCER *************
                            /* if (c.getClass().getSimpleName().equals("CompteApprenant")){
                                new GuiCommite();
                                JOptionPane.showMessageDialog(null,"Bienvenue, votre compte est de type : "+c.getClass().getSimpleName(),"Message",JOptionPane.INFORMATION_MESSAGE);
                                frame.dispose();
                            }*/
                        }
                    }
                });
		
		//-------------LAYOUT---------
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		setLayout(gbl);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(15,0,0,0);
		gbc.gridx=0;
		gbc.gridy=0;
		
		//-------------DESIGN---------
		addDesign();
	}
	
	//********** AJOUTER LES ELEMENTS **********
	public void addDesign(){
		
		//-------------Nom d'utilisateur + Mot de passe + Bouton---------
		
		gbc.gridx=0;
		gbc.gridy++;
		add(nomLabel,gbc);
	
		gbc.gridx++;
		add(nomText,gbc);
		
		gbc.gridx=0;
		gbc.gridy++;
		add(passLabel,gbc);
		
		gbc.gridx++;
		add(passText,gbc);
		
		//------------- Bouton Connexion---------
		gbc.insets = new Insets(15,-200,0,0);
		gbc.gridy++;
                connexionBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR) );
               add(connexionBtn,gbc);

                //------------- Bouton s'inscrire---------
		gbc.insets = new Insets(15,-20,0,0);
                inscrBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR) );
                inscrBtn.setToolTipText("S'inscrire");
                add(inscrBtn,gbc);
                
                //----------- Bouton Facebook ---------
                gbc.insets = new Insets(15,110,0,0);
                facebook.setToolTipText("Se connecter via facebook");
                facebook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR) );
                facebook.addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                      //  Main.loginFacebook();
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        facebook.setIcon(new ImageIcon(getClass().getResource("/Presentation/img/fb2.png")));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        facebook.setIcon(new ImageIcon(getClass().getResource("/Presentation/img/fb.png")));
                    }
                });
		add(facebook,gbc);
		
	}
}

