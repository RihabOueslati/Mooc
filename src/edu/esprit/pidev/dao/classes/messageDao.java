/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.dao.classes;

import edu.esprit.pidev.dao.interfaces.IDAOM;
import edu.esprit.pidev.entities.User;
import edu.esprit.pidev.entities.message;
import edu.esprit.pidev.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.ParseConversionEvent;

/**
 *
 * @author Rihab
 */
public class messageDao implements IDAOM<message>{
    
      Connection connection;

    public messageDao() {
        connection = MyConnection.getInstance().getConnection();
        
    }

    @Override
    public void addmessage(message m) {
        
        String requete = "insert into message (description,date,fk_destinataire,fk_recepteur,objet) values (?,sysdate(),?,?,?)";
        
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            
            ps.setString(2, m.getDescription());
            ps.setString(3, m.getDate());
            
            ps.setInt(4, m.getFk_destinataire().getId());
           ps.setInt(5, m.getFk_recepteur().getId());
           ps.setString(6,m.getObjet());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(messageDao.class.getName()).log(Level.SEVERE, null, ex);
        }             }
        
    

    @Override
    public void updatemesage(message m) {
        
        String requete = "update commentaire set description=? where id=?";
      
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
           
            ps.setInt(1,m.getId());
            ps.setString(2, m.getDescription());
            ps.executeUpdate();
            System.out.println("Mise ‡ jour effectuÈe avec succËs");
        } catch (SQLException ex) {
            //Logger.getLogger(messageDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise ‡ jour " + ex.getMessage());
        }         }
    

    @Override
    public void deletmessage(message m) {
        
        String requete = "delete from message where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
             ps.setInt(1,m.getId());
            ps.executeUpdate();
            System.out.println("message supprimÈ");
        } catch (SQLException ex) {
            //Logger.getLogger(messageDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }      
        
    }
    
    

    public boolean insertMessage(String titre, String message, String type,String login) {
        
      String requete = "insert into message (titre,contenue,type,emetteur) values ('"+titre+"','"+message+"',CURDATE(),'"+type+"','"+login+"')";

        
       // String requete = "insert into message (titre,description,type) values (?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'envoi " + ex.getMessage());
            return false;
        }
    }

    @Override
    public List<message> DisplayAll() {
        
        List<message> listmessages = new ArrayList<>();

        String requete = "select * from message";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            IDAOM messageDao = new messageDao();
            while (resultat.next()) {
                message c = new message();
              c.setId(resultat.getInt(1));
              c.setDescription(resultat.getString(2));
              c.setDate(resultat.getString(3));
              c.setObjet(resultat.getString(6));
                listmessages.add(c);
            }
            return listmessages;
        } catch (SQLException ex) {
            //Logger.getLogger(messageDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des auto ecoles " + ex.getMessage());
            return null;
        }          
    }

     public List<message> findMessageByIdDestinataire(String login) {
        
        List<message> mess = new ArrayList<>();
        message message = null;
       // Artiste artiste=null;
        
        String requete = "SELECT * FROM message WHERE  fk_destinataire=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1,login);
           
              ResultSet rslt = ps.executeQuery();
             
            while (rslt.next()) {
              
               
        //     System.out.println(user.getId());
               // System.out.println(user.getNom_abonne());
                
              User u = new  User(); 
              UtilisateurDAO udao = new UtilisateurDAO();
              u = udao.findUtilisateurByID(rslt.getInt("fk_destinataire"));
              u= udao.findUtilisateurByID(rslt.getInt("fk_recepteur"));
            message = new message(rslt.getInt("id"), rslt.getString("description"), rslt.getString("date"),u,u,rslt.getString("objet"));
             mess.add(message);
            }
            System.out.println("selection effectuÈe avec succËs");
            return mess;
        } catch (SQLException ex) {
            //Logger.getLogger(messageDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de selection " + ex.getMessage());
            return mess;
        }  
}
    
     public List<message> findMessageByIdRecepteur(int id) {
        
        List<message> mess = new ArrayList<>();
        message message = new message();
       // Artiste artiste=null;
        
        String requete = "SELECT * FROM message WHERE recepteur=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1,id);
           
              ResultSet resultat = ps.executeQuery();
           
            while (resultat.next()) {
              
              message c = new message();
              c.setId(resultat.getInt(1));
              c.setDescription(resultat.getString(2));
              c.setDate(resultat.getString(3));
              c.setObjet(resultat.getString(6));
              mess.add(c);
            }
            System.out.println("selection effectuÈe avec succËs");
            return mess;
        } catch (SQLException ex) {
            //Logger.getLogger(messageDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de selection " + ex.getMessage());
            return null;
        }  
}
    
  public message findMessageByObjet (String objet) {
        
       
        message msg= new message();
       // Artiste artiste=null;
        
        String requete = "SELECT * FROM message WHERE  objet=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1,objet);
           
              ResultSet rslt = ps.executeQuery();
           
            while (rslt.next()) {
              
        //     System.out.println(user.getId());
         // System.out.println(user.getNom_abonne());
                msg.setId(rslt.getInt("id"));
              msg.setDescription(rslt.getString(2));
                
               User u = new  User(); 
              UtilisateurDAO udao = new UtilisateurDAO();
              u = udao.findUtilisateurByID(rslt.getInt("destinataire"));
              msg.setFk_destinataire(u);
              u= udao.findUtilisateurByID(rslt.getInt("recepteur"));
              msg.setFk_recepteur(u);
//              msg = new message(rslt.getInt("id"), rslt.getString("description"), rslt.getString("date"),u,u,rslt.getString("objet"));
             
            }
            System.out.println("selection effectuÈe avec succËs");
            return msg;
        } catch (SQLException ex) {
            //Logger.getLogger(messageDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de selection " + ex.getMessage());
            return null;
        }  
}   
   
}
