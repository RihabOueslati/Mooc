/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.GUI.Formateur;

import edu.esprit.pidev.dao.classes.ChapitreDAO;
import edu.esprit.pidev.dao.classes.CoursDAO;
import edu.esprit.pidev.entities.Chapitre;
import edu.esprit.pidev.entities.Cours;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ahmed
 */
public class AfficheChapitre extends AbstractTableModel{
         
       
    ChapitreDAO chapitreDao = new ChapitreDAO();

     private final Vector<Chapitre> chapitre;
     
   
     private final String [] column = {"Titre","Numero"};

     
     public AfficheChapitre (int idCours){
    super();
        this.chapitre = chapitreDao.AfficherChapitre(idCours);
        }
    
     
     @Override
    public int getRowCount() {
return chapitre.size();
        }

    @Override
    public int getColumnCount() {
return column.length;
        }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
  switch(columnIndex){
            case 0 :
                return  chapitre.get(rowIndex).getTitre();    
            case 1 : 
                 return chapitre.get(rowIndex).getIdChapitre();
            default:
                return null;
        }    }
    @Override
    public String getColumnName(int columnindex) {
        return column [columnindex];
}
}
