/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.GUI.Formateur;

import edu.esprit.pidev.dao.classes.CoursDAO;
import edu.esprit.pidev.entities.Cours;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author AhMeD
 */
public class AfficherCours2 extends AbstractTableModel{
        private  Vector<Cours> livres=new Vector<Cours>();

    CoursDAO coursDao = new CoursDAO();

     private final Vector<Cours> cours;
     
   
     private final String [] column = {"titre","difficult"};

     
     public AfficherCours2 (String cat){
    super();
    
        this.cours = coursDao.AfficherCoursByCategory(cat);
        }
    
     
     @Override
    public int getRowCount() {
return cours.size();
        }

    @Override
    public int getColumnCount() {
return column.length;
        }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
  switch(columnIndex){
            case 0 :
                return  cours.get(rowIndex).getTitre();
            case 1: 
                return cours.get(rowIndex).getDifficult();
          
                
                default:
                return null;
        }    }
    @Override
    public String getColumnName(int columnindex) {
        return column [columnindex];
}
    
    public Vector<Cours> getLivres() {
        return cours;
    }
    
    }
