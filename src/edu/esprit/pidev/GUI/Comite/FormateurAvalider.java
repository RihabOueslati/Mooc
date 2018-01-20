package edu.esprit.pidev.GUI.Comite;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import edu.esprit.pidev.dao.classes.GestionUtilisateur;
import edu.esprit.pidev.dao.classes.UtilisateurDAO;
import edu.esprit.pidev.entities.Rendez_vous;
import edu.esprit.pidev.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jihene
 */
public class FormateurAvalider extends AbstractTableModel{
    GestionUtilisateur GU = new GestionUtilisateur();
     private final List<User> user ;
     
    private final String[] entetes = {"ID","username","Email","CV"};
 
    public FormateurAvalider() {
        super();
      
        user = GU.DisplayFormateurR();
    }
 public int[] TabId(){ 
        
         List<User> rend1 = new ArrayList<>();
         int[] tab_id;
      
          
        rend1 =  GU.DisplayFormateur();
         tab_id = new int[rend1.size()];       
        for (int j=0;j<= rend1.size()-1;j++){
         
            tab_id[j]= rend1.get(j).getId(); 
        
         return tab_id;
        
        }
            
       return null;
        
      
       
    }
    public int getRowCount() {
        return user.size();
    }
 
    public int getColumnCount() {
        return entetes.length;
    }
 
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
 
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
             case 0:
                return user.get(rowIndex).getId();
            case 1:
                return user.get(rowIndex).getUsername();
            case 2:
                return user.get(rowIndex).getEmail();
            case 3:
                return user.get(rowIndex).getCvFormateur();
           
            
            default:
                return null; //Ne devrait jamais arriver
                
        }
    }
 
    

    
}