/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.dao.classes;

import edu.esprit.pidev.entities.Cours;
import edu.esprit.pidev.entities.Notification;
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
public class NotificationDAO 
{
     private Connection connection; 
        
        public  NotificationDAO ()
        {
        connection = MyConnection.getInstance().getConnection();
  
        }
        
    public void add_notification ( String msg ,String date , int id_user, int id_cours ) 
    {
        String req = "INSERT INTO notification( message, date ,id_user, id_cours) VALUES (?,?,?,?)";
    try {
          PreparedStatement ps = connection.prepareStatement(req);
          ps.setString(1,msg);
          ps.setString(2,date);
          ps.setInt(3,id_user);
          ps.setInt(4,id_cours);
          ps.executeUpdate();

            System.out.println("notification ajouté ");
            
        } catch (SQLException ex) {

            System.out.println("erreur insertion notification "+ex.getMessage());
            
        }
    
    
    }
 
    
    
     public List<Notification> display_All_Notification() {
 ArrayList<Notification> listeNot = new ArrayList<Notification>();

        String requete = "select * from notification";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet rs = statement.executeQuery(requete);

            while(rs.next()){
                Notification not=new Notification();
               not.setId_notification(rs.getInt(1));
               not.setMessage(rs.getString(2));
               not.setDate(rs.getString(3));


                listeNot.add(not);
            }
            
            return listeNot;
            
        } catch (SQLException ex) {

            System.out.println("erreur  "+ex.getMessage());
            return null;
        }    }

 
    
}
