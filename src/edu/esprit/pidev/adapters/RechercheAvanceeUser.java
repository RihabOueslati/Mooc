/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.pidev.adapters;

import edu.esprit.pidev.dao.classes.GestionUtilisateur;
import edu.esprit.pidev.entities.User;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rihab
 */
public class RechercheAvanceeUser extends AbstractTableModel{
    GestionUtilisateur GU = new GestionUtilisateur();
     private final List<User> user ;
     String motCle;
     String role;
    private final String[] entetes = {"Nom", "prenom","Mail","Telephone"};
 
    public RechercheAvanceeUser(String motCle,String role) {
        super();
        this.motCle=motCle;
        this.role=role;
        user = GU.RechercheAvancee(motCle, role);
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
                return user.get(rowIndex).getEmail();
            case 3:
                return user.get(rowIndex).getTelephone();
            default:
                return null; //Ne devrait jamais arriver
                
        }
    }
 
    
    
}
