/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.pidev.adapters;


import edu.esprit.pidev.dao.classes.UtilisateurDAO;
import edu.esprit.pidev.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rihab
 */
public class JTableModelFormateurAff extends AbstractTableModel {


    String entete[]={"Login","nom","prenom","email"};
    
    List<User> listCompte=new ArrayList<User>();

    public JTableModelFormateurAff() {
         
        UtilisateurDAO ut = new UtilisateurDAO();
        listCompte = ut.AfficherFormateur();
    
   
        
    }
    
     public JTableModelFormateurAff(List<User> listCompte) {
       this.listCompte=listCompte;
    }
    
    
    
    @Override
    public int getRowCount() {
       return listCompte.size();
       
    }

    @Override
    public int getColumnCount() {
          return entete.length;
    }
    

    @Override
    public String getColumnName(int column){
        return entete[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
     
         switch(columnIndex)
        {
            case 0:
                return listCompte.get(rowIndex).getUsername();
            case 1:
                return listCompte.get(rowIndex).getNom();
            case 2:
                return listCompte.get(rowIndex).getPrenom();
            case 3:
                return listCompte.get(rowIndex).getEmail();
          
            default:
                return null;
        
    }
    }

    public List<User> getListCompte() {
        return listCompte;
    }

    public void setListCompte(List<User> listCompte) {
        this.listCompte = listCompte;
    }
}
 
    

