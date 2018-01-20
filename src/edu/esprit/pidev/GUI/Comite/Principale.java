package edu.esprit.pidev.GUI.Comite;
/* @author Iskander
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

public class Principale {
	// ********* Programme Principale *********

	public static void main(String[] args) {
                
               /******************AJOUT COMPTE*******************
                CompteAdminDAO cDAO = new CompteAdminDAO();
                CompteAdmin c = new CompteAdmin("admin","123","Jaiem","Iskander","iskander@live.fr");
                cDAO.ajout(c);
               /******************TEST VALIDITE COMPTE***********
                Compte c= cDAO.estCorrect("iskander@live.fr","123");
               /**/
            
           
          
                setTheme();
                new ConnectionWindow();

	}

	
	
	
public static void setTheme(){
	  /*
	try {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	} catch (Exception ex) {
	}*/
	try{   
	     // set this attribute will change the window border style definitions 
                
                BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.frameBorderStyle.generalNoTranslucencyShadow;
		UIManager.put("RootPane.setupButtonVisible",false);
                //BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.frameBorderStyle.osLookAndFeelDecorated;
		 org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	   }   
	   catch ( Exception e )   
	   {   
	     // TODO Exception   
	   }   
	
}

/*Projet p1=new Projet("projet1","java","application","20jours","12/01/2015");
        ProjetDAO pdao1=new ProjetDAO();
       pdao1.insertProjet(p1);
      // pdao1.deleteProjet(p1);
       pdao1.afficherProjet();*/
       
       

}
