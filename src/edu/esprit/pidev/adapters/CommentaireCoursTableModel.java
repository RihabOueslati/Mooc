
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.adapters;

import edu.esprit.pidev.dao.classes.CommentaireDao;
import edu.esprit.pidev.entities.Commentaire;
import edu.esprit.pidev.entities.Cours;
import edu.esprit.pidev.entities.User;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rihab
 */
public class CommentaireCoursTableModel extends AbstractTableModel {
    
   
    String[] column={"User","description","date"};
    List<Commentaire> commentaires;
    List<Cours> cours;
    
    public CommentaireCoursTableModel(int idCours){
        
        CommentaireDao dao= new CommentaireDao();
        commentaires = dao.findCommentByIdCours(idCours);
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
             return commentaires.get(rowIndex).getUser().getUsername();
        case 1:
            return commentaires.get(rowIndex).getDescription();
        case 2:
            return commentaires.get(rowIndex).getDate();
      
      
           default: return null;
    }
    }
    
}
