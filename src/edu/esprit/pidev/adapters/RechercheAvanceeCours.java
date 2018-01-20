/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.pidev.adapters;

import edu.esprit.pidev.dao.classes.GestionCours;
import edu.esprit.pidev.dao.classes.GestionUtilisateur;
import edu.esprit.pidev.entities.Cours;
import edu.esprit.pidev.entities.User;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rihab
 */
public class RechercheAvanceeCours extends AbstractTableModel{
    GestionCours GU = new GestionCours();
     private final List<Cours> cours ;
     String motCle;
   
    private final String[] entetes = {"Titre", "Description","URL","Categorie","NbrChapitre"};
 
    public RechercheAvanceeCours(String motCle) {
        super();
        this.motCle=motCle;
        cours = GU.RechercheAvancee(motCle);
    }
 
    public int getRowCount() {
        return cours.size();
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
                return cours.get(rowIndex).getTitre();
            case 1:
                return cours.get(rowIndex).getDescription();
            case 2:
                return cours.get(rowIndex).getURL();
            case 3:
                return cours.get(rowIndex).getCategorie();
            case 4:
                return cours.get(rowIndex).getNbrChapitre();
            default:
                return null; //Ne devrait jamais arriver
                
        }
    }
 
    
    
}
