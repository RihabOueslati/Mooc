/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.adapters;

import edu.esprit.pidev.dao.classes.CommentaireDao;
import edu.esprit.pidev.entities.Commentaire;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rihab
 */
public class CommentairechapitreTableModel extends AbstractTableModel  {
    
      String[] column={"description"};
    List<Commentaire> commentaires;
   // List<chapitre> chapitre ;
    public CommentairechapitreTableModel(int id){
        
        CommentaireDao dao= new CommentaireDao();
        commentaires = dao.findCommentByIdChapitre( id);
    }
    
    @Override
    public String getColumnName(int col) {
        return column[col];
    }

    @Override
    public int getRowCount() {
         return commentaires.size();  
    }

    @Override
    public int getColumnCount() {
         return column.length;
 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
    switch(columnIndex){
        case 0:
            return commentaires.get(rowIndex).getDescription();
        case 1:
            return commentaires.get(rowIndex).getDate();
       /* case 2:
            return chapitre.get(rowIndex).getidCours;
        case 3:
            return chapitre.get(rowIndex).getTitre();*/
      
           default: return null;
    }
    }
    
}
