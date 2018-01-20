package edu.esprit.pidev.GUI.Admin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import edu.esprit.pidev.dao.classes.GestionUtilisateur;
import edu.esprit.pidev.dao.classes.UtilisateurDAO;
import edu.esprit.pidev.entities.User;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jihene
 */
public class DisplayMembre extends AbstractTableModel{
    GestionUtilisateur GU = new GestionUtilisateur();
     private final List<User> user ;
     
    private final String[] entetes = {"Nom", "prenom","Login","Email","Nombre de reclamation"};
 
    public DisplayMembre() {
        super();
      
        user = GU.DisplayFormateur();
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
                return user.get(rowIndex).getNom();
            case 1:
                return user.get(rowIndex).getPrenom();
            case 2:
                return user.get(rowIndex).getUsername();
            case 3:
                return user.get(rowIndex).getEmail();
            case 4:
                return user.get(rowIndex).getNbrReclamation();
           
            
            default:
                return null; //Ne devrait jamais arriver
                
        }
    }
 
    

    
}