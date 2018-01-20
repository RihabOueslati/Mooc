/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.pidev.adapters;


import edu.esprit.pidev.dao.classes.CoursDAO;
import edu.esprit.pidev.entities.Cours;
import edu.esprit.pidev.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rihab
 */
public class JTableModelCoursValide extends AbstractTableModel {


    String entete[]={"TITRE","Categorie","Description","difficulté","Nombre des Chapitres"};
    //ajout du test d'acceptation

    
    List<Cours> listcours=new ArrayList<Cours>();

    public JTableModelCoursValide(User user ) {
        CoursDAO cd = new CoursDAO();
       
        listcours = cd.DisplayValide();
   
        
    }
    
     public JTableModelCoursValide(List<Cours> listProjet) {
       this.listcours=listcours;
    }
    
    public int getIDCours(int rowIndex)
    {
        Cours c2=null;
      for(Cours c:listcours)
      {
         c2=listcours.get(rowIndex);
      }
      return c2.getIdCours();
    }
    
    @Override
    public int getRowCount() {
       return listcours.size();
       
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
                return listcours.get(rowIndex).getTitre();
                   
            case 1:
                return listcours.get(rowIndex).getCategorie();
            case 2:
                return listcours.get(rowIndex).getDescription();
            case 3:
                return listcours.get(rowIndex).getDifficult();
            case 4:
                return listcours.get(rowIndex).getNbrChapitre();    
          
            default:
                return null;
         }
    }

    public List<Cours> getListCours() {
        return listcours;
    }

    public void setListProjet(List<Cours> listCours) {
        this.listcours = listCours;
    }
}