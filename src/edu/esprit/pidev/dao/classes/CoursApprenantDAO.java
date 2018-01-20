/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.dao.classes;

import edu.esprit.pidev.entities.Cours;
import edu.esprit.pidev.entities.CoursApprenant;
import edu.esprit.pidev.entities.User;
import edu.esprit.pidev.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class CoursApprenantDAO 
{
    private Connection connection; 
        
        public CoursApprenantDAO() 
        {
        connection = MyConnection.getInstance().getConnection();
  
        }
     public void ajout_coursApprenant (CoursApprenant cr){
        String add_msg ;
        String req = "insert into coursapprenant (idCours,idUtilisateur ,date) values (?,?,?)";
        
        try { 
                PreparedStatement ps = connection.prepareStatement(req);
                  System.err.println(cr.getIdUtilisateur().getUsername());       
                 ps.setInt(1, cr.getIdCours().getIdCours());
                 ps.setInt(2, cr.getIdUtilisateur().getId());
                 ps.setString (3,  cr.getDate());
           
            ps.executeUpdate();        
            add_msg = "inscription effectuée avec succès" ;
//            NotificationDAO ndo=new NotificationDAO();
//            ndo.add_notification("ffff", cr.getIdUtilisateur().getId(), cr.getIdCours().getIdCours());
            System.out.println(add_msg);
        } catch (SQLException ex) {
          add_msg = "erreur lors du l'inscription" ;
            System.out.println(add_msg+ex.getMessage());
        }
               
    }
      public List<CoursApprenant> StatCours()
     {
         List<CoursApprenant> list = new ArrayList<>();
         
          String requete = "SELECT idCours,count(*) FROM `coursapprenant` GROUP BY idCours";
        
        try {
            
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
            while (resultat.next()) {
                 CoursApprenant ca= new CoursApprenant();
                 ca.setIdCoursApp(resultat.getInt(2));
                 
                 Cours c = new  Cours(); 
                 CoursDAO cdao = new CoursDAO();
                 c = cdao.findCoursByID(resultat.getInt("idCours"));
                 ca.setIdCours(c);
                 
                 
                 list.add(ca);
            }
            return list;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du utilisateur by id" + ex.getMessage());
            return null;
        }
    }
     
}
