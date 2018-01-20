/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.dao.classes;

import edu.esprit.pidev.dao.interfaces.IDAO;
import edu.esprit.pidev.entities.Chapitre;
import edu.esprit.pidev.entities.Commentaire;
import edu.esprit.pidev.entities.Cours;
import edu.esprit.pidev.entities.User;
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

/**
 *
 * @author Rihab
 */
public class CommentaireDao implements IDAO<Commentaire> {
    
     Connection connection;
      Statement ste;
      PreparedStatement pst;

    public CommentaireDao() {
        connection = MyConnection.getInstance().getConnection();

    }

    @Override
    public void addCommentaire(Commentaire c) {
          String req="insert into Commentaire(Description,fk_user,fk_cours,date,fk_chapitre) values (?,?,?,sysdate(),?);";
        
          try {
          
            pst=connection.prepareStatement(req);
            pst.setString(1, c.getDescription());
            pst.setString(2, c.getUser().getUsername());
            pst.setInt(3,c.getFk_cours());
            pst.setInt(5,c.getFk_chapitre());
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void updateCommentaire(Commentaire c) {
        
         String requete = "update commentaire set description=? where id=?";
      
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            pst.setInt(1, c.getId());
            pst.setString(2, c.getDescription());
            ps.executeUpdate();
            System.out.println("Mise ‡ jour effectuÈe avec succËs");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise ‡ jour " + ex.getMessage());
        }     
    }

    @Override
    public void remove(Commentaire c) {
        
        Commentaire commentaire = new Commentaire();
        String sql = "DELETE FROM  Commentaire WHERE idCommentaire=?";
   
        try {
           pst = connection.prepareStatement(sql);
            pst.setInt(1, Integer.valueOf(c.getId()));
 
         int rowsDeleted = pst.executeUpdate();
         if (rowsDeleted > 0) {
         System.out.println("A comment was deleted successfully!");
}    
    }      catch (SQLException ex) {
            Logger.getLogger(CommentaireDao.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("error when deleting this comment " + ex.getMessage());
    }
    }

    @Override
    public List<Commentaire> displayAll() {
        List<Commentaire> listcommentaires = new ArrayList<>();
    
        String requete = "select * from commentaire";
        try {
          Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            IDAO commentaireDAO = new CommentaireDao();
            while (resultat.next()) {
              Commentaire c = new Commentaire();
              c.setId(resultat.getInt(1));
              c.setDescription(resultat.getString(2));
              c.setDate(resultat.getString(3));
      
                listcommentaires.add(c);
            }
            return listcommentaires;
        } catch (SQLException ex) {
            //Logger.getLogger(CommentaireDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur " + ex.getMessage());
            return null;
        }        
    }

    @Override
    public Commentaire findCommentbyIdUser(int id) {
        Commentaire comment = new Commentaire();
        User user  = null;
        
        String requete = "SELECT * FROM commentaire WHERE  fk_user=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1,id);
  
              ResultSet rslt = ps.executeQuery();
         
            while (rslt.next()) {
                UtilisateurDAO userdao = new UtilisateurDAO();
                user = userdao.findUtilisateurByID(rslt.getInt("id"));
              
         System.out.println(user.getId());
               System.out.println(user.getUsername());

       comment = new Commentaire(rslt.getInt("id"), rslt.getString("description"), rslt.getString("date"));
                
            }
            System.out.println("selection effectuÈe avec succËs");
            return comment;
        } catch (SQLException ex) {
            //Logger.getLogger(CommentaireDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de selection " + ex.getMessage());
            return comment;
        }  
} 
    
    
      public List<Commentaire> findAllCommentaire() {
     List<Commentaire> coms=null;
     String requete= "SELECT * FROM commentaire WHERE 1";
     Commentaire comment=null;
     try {
            PreparedStatement ps = connection.prepareStatement(requete);
            coms=new ArrayList<>();
		
           ResultSet rslt= ps.executeQuery();
           
           while(rslt.next())
           {
             
             comment=new Commentaire(rslt.getInt("id"),rslt.getString("description"));
              coms.add(comment);
           }
            System.out.println("selection effectuÈe avec succËs");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de selection " + ex.getMessage());
            return coms;
        }
        return coms;

          
          
    }
      
      
      public List<Commentaire> findCommentByIdCours(int idCours) {
        
        List<Commentaire> coms = new ArrayList<>();
        Cours cours = null;
        
        String requete = "SELECT * FROM commentaire WHERE  idCours=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1,idCours);
  
           

              ResultSet rslt = ps.executeQuery();
         
            while (rslt.next()) {
               //// CoursDao coursdao = new CoursDao();
              ///  cours = CoursDao.findcoursById(rslt.getInt("id"));
               
        //     System.out.println(user.getId());
               // System.out.println(abonne.getNom_user());
                
              
                Commentaire comment = new Commentaire(rslt.getInt("idUser"), rslt.getString("description"), rslt.getString("date"));
                coms.add(comment);
            }
            System.out.println("selection effectuÈe avec succËs");
            return coms;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de selection " + ex.getMessage());
            return coms;
        }  
    }
      
       public List<Commentaire> findCommentByIdChapitre(int id) {
        
        List<Commentaire> coms = new ArrayList<>();
        Chapitre chapitre = null;
        
        String requete = "SELECT * FROM commentaire WHERE  fk_chapitre=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1,id);
           

              ResultSet rslt = ps.executeQuery();
         
            while (rslt.next()) {
               /// ChapitreDao elementdao = new ChapitreDao();
              ///  chapitre = chapitredao.findChapitreById(rslt.getInt("id"));
               
        //     System.out.println(user.getId());
               // System.out.println(user.getNom_user());
                
              
                Commentaire comment = new Commentaire(rslt.getInt("id"), rslt.getString("description"), rslt.getString("date"));
                coms.add(comment);
            }
            System.out.println("selection effectuÈe avec succËs");
            return coms;
        } catch (SQLException ex) {
            //Logger.getLogger(CommentaireDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de selection " + ex.getMessage());
            return coms;
        }  
}
}

   