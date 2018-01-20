/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.dao.classes;
import edu.esprit.pidev.dao.interfaces.IReclamationDAO;
import edu.esprit.pidev.entities.CurrentUser;
import static edu.esprit.pidev.entities.CurrentUser.user;
import edu.esprit.pidev.entities.Reclamation;
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
 * @author Mohamed Salah
 */
public class ReclamationDAO implements IReclamationDAO<Reclamation>{
    Connection connection;
    Statement ste;
    PreparedStatement pst;
    ResultSet res;
    
    private final String reqInsert="insert into reclamation (cause,description,idUser) values (?,?,?)";
    private final String reqUpdate="UPDATE reclamation SET cause=?,description=?,idUser=? where id=? ";
    private final String reqDelete="DELETE FROM reclamation WHERE id=? ";
    private final String reqDisplay = "select * from reclamation ";
    
    public ReclamationDAO(){
         connection =(MyConnection.getInstance()).getConnection();
    }
        
    

    @Override
    public void addReclamation(Reclamation rec) {
        try {
             
            pst=connection.prepareStatement(reqInsert);
            pst.setString(1, rec.getCause());
            pst.setString(2, rec.getDescription());
            pst.setInt(3, CurrentUser.user.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateReclamation(Reclamation rec, int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(reqUpdate);
            pst=connection.prepareStatement(reqUpdate);
            pst.setString(1, rec.getCause());
            pst.setString(2, rec.getDescription());
            pst.setInt(3, CurrentUser.user.getId());
            
            preparedStatement.executeUpdate();
            System.out.println("Mise à jour effectuée");
        } catch (SQLException ex) {
            System.out.println("erreur de mise à jours" + ex.getMessage());
        }
    }

    @Override
    public void deleteReclamation(int idReclamation) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(reqDelete);
            preparedStatement.setInt(1, idReclamation);
            preparedStatement.executeUpdate();
            System.out.println("Suppression effectuée");
        } catch (SQLException ex) {
            System.out.println("erreur de suppression" + ex.getMessage());
        }
    }

    @Override
    public List<Reclamation> displayAllReclamation() {
        List<Reclamation> listeReclamation = new ArrayList<>();
        
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(reqDisplay);

            while (resultat.next()) {
                Reclamation rec = new Reclamation();
                rec.setCause(resultat.getString(2));
                rec.setDescription(resultat.getString(3));
                User u = new  User(); 
              UtilisateurDAO udao = new UtilisateurDAO();
              u = udao.findUtilisateurByID(resultat.getInt(4));
              rec.setIdUser(u);
                listeReclamation.add(rec);
            }
            return listeReclamation;
        } catch (SQLException ex) {
            System.out.println("erreur de chargement" + ex.getMessage());
            return null;
        }
    }

    @Override
    public Reclamation findByIdReclamation(int id) {
          Reclamation rec = new Reclamation();
      
        try {
            PreparedStatement ps = connection.prepareStatement(reqDelete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                rec.setIdReclamation(resultat.getInt(1));
              
            }
            return rec;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    }
 public Reclamation findMessageByCause (String cause) {
        
       
        Reclamation rec= new Reclamation();
       // Artiste artiste=null;
        
        String requete = "SELECT * FROM reclamation WHERE  cause=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1,cause);
           
              ResultSet rslt = ps.executeQuery();
           
            while (rslt.next()) {
              rec.setCause(rslt.getString(2));
              rec.setDescription(rslt.getString(3));
              User u = new  User(); 
              UtilisateurDAO udao = new UtilisateurDAO();
              u = udao.findUtilisateurByID(rslt.getInt(4));
              rec.setIdUser(u);
               
            }
            System.out.println("selection effectuÈe avec succËs");
            return rec;
        } catch (SQLException ex) {
            //Logger.getLogger(messageDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de selection " + ex.getMessage());
            return null;
        }  
}   
      
}
