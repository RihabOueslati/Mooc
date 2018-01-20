/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.dao.classes;

import edu.esprit.pidev.entities.Cours;
import edu.esprit.pidev.util.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class GestionCours {
    
    private Connection connection; 

    public GestionCours() {
        
         connection = MyConnection.getInstance().getConnection();
  
    }
    
    
    
   /* public void AccepterCours(int id) {
        Statement st;
        ResultSet rs;
        boolean y = false;
         
           String sql="Update cours set etat=1 where id='"+id+"'";
                    try 
                     {
                         st = MyConnection.getInstance().getConnection().createStatement();
                         st.executeUpdate(sql);
                     } 
                     catch (SQLException ex) 
                     {
                         Logger.getLogger(CoursDao.class.getName()).log(Level.SEVERE, null, ex);
                     }
         */
    
    
    
    /*
    
     public void RefuserCours(int id) {
        Statement st;
        ResultSet rs;
        boolean y = false;
         
           String sql="Update cours set etat=-1 where id='"+id+"'";
                    try 
                     {
                         st = MyConnection.getInstance().getConnection().createStatement();
                         st.executeUpdate(sql);
                     } 
                     catch (SQLException ex) 
                     {
                         Logger.getLogger(CoursDao.class.getName()).log(Level.SEVERE, null, ex);
                     }
    */
    
   /*  public List<Cours> DisplayCoursByCategorie(String categorie) {
        Statement st;
        ResultSet rs;
       
           List<Cours> listcours = new ArrayList<Cours>();
           String sql= "select * from cours where Ctaegorie="+categorie;
        try 
        {
            st= MyConnection.getInstance().getConnection().createStatement();
            rs=st.executeQuery(sql);
            while (rs.next())
            {
                if(rs.getInt(13)==0)
                {
                Cours cours = new Cours();
                cours.setId(rs.getInt(1));
                cours.setTitre(rs.getString(2));
                cours.setDescription(rs.getString(3));
                cours.setURL(rs.getString(4));
                cours.setCategorie(rs.getString(5));
                cours.setMail(rs.getString(6));
                cours.setNbreChapitre(rs.getInt(7));
                cours.setNote(rs.getString(12));
               
               listCours.add(cour);
                }
            }
            return listCours;
        }
         
        catch (SQLException ex) {
           Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, ex);
           return null;
        }    }*/
    
    
    public  List<Cours> RechercheAvancee(String titre) {
        
         Statement st;
        ResultSet rs;
       
           List<Cours> listcours = new ArrayList<>();
          String sql = "SELECT * FROM `cours` WHERE `titre` like '%"+titre+"%'";
        try 
        {
            
            st= MyConnection.getInstance().getConnection().createStatement();
            rs=st.executeQuery(sql);
            while (rs.next())
            {
                
                Cours cours = new Cours();
                cours.setTitre(rs.getString(2));
                cours.setDescription(rs.getString(3));
                cours.setURL(rs.getString(4));
                cours.setCategorie(rs.getString(5));
                cours.setNbrChapitre(rs.getInt(7));
                    
                listcours.add(cours);
                
            }
            return listcours;
        }
         
        catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du cours" + ex.getMessage());
            return null;
        }
}
}
    

