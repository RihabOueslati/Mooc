/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.dao.classes;

import edu.esprit.pidev.dao.interfaces.ICours;
import edu.esprit.pidev.entities.Cours;
import edu.esprit.pidev.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rihab
 */
public class CoursDAO implements ICours  {
    private Connection connection; 

         public CoursDAO() 
        {
        connection = MyConnection.getInstance().getConnection();
        
  
        }

    @Override
    public void AjouterCours(Cours c) throws SQLException {
        String requete = "insert into cours (titre,categorie ,nbrChapitre,difficult,image,URL,description) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1,c.getTitre());
            ps.setString(2,c.getCategorie());
            ps.setInt(3,c.getNbrChapitre());
            ps.setString(4,c.getDifficult());
            ps.setString(5, c.getImage());
            ps.setString(6,c.getURL());
            ps.setString(7,c.getDescription());
            
            ps.executeUpdate();

            
            System.out.println("Ajout effectué ,avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }    }

    public void ModifierCours(Cours c, String d) throws SQLException {
 String requete = "update cours set titre=?, categorie=?, nbrChapitre=?, difficult=?, image=?, URL=?, description=? where titre=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            
            ps.setString(1,c.getTitre());
            ps.setString(2,c.getCategorie());
            ps.setInt(3,c.getNbrChapitre());
            ps.setString(4,c.getDifficult());
            ps.setString(5, c.getImage());
            ps.setString(6,c.getURL());
            ps.setString(7, c.getDescription());
            ps.setString(8,d);
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }        }

    public void SupprimerCours(String d) throws SQLException {
        String requete = "delete from cours where titre='"+d+"'; ";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.executeUpdate();
            System.out.println("Cours supprimée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression : "+ex.getMessage());
        }

    }

    @Override
    public Vector<Cours> AfficherCours() {
    Vector<Cours>listcours =new Vector<Cours>();

        String requete = "select * from `cours`";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(requete);

            while(rs.next()){
                Cours cours =new Cours();
                cours.setIdCours(rs.getInt(1));
                cours.setTitre(rs.getString(2));
                cours.setURL(rs.getString(4));
                cours.setCategorie(rs.getString(5));
                cours.setDescription(rs.getString(3));
                cours.setDifficult(rs.getString(6));
               

                listcours.add(cours);
            }
            
            return listcours;
            
        } catch (SQLException ex) {

            System.out.println("erreur  "+ex.getMessage());
            return null;
        }    
    
    }
    
        public Vector<Cours> AfficherCoursByCategory(String cat) {
    Vector<Cours>listcours =new Vector<Cours>();

        String requete = "select * from `cours` where `categorie` ='"+cat+"' ;";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(requete);

            while(rs.next()){
                Cours cours =new Cours();
                cours.setTitre(rs.getString(2));
                cours.setURL(rs.getString(4));
                cours.setCategorie(rs.getString(5));
                cours.setDescription(rs.getString(3));
                cours.setDifficult(rs.getString(6));
               

                listcours.add(cours);
            }
            
            return listcours;
            
        } catch (SQLException ex) {

            System.out.println("erreur  "+ex.getMessage());
            return null;
        }    
    
    }

    @Override
    public int findByTitle(String titre) throws SQLException {
 String requete = "SELECT * FROM `cours` WHERE `login` ='"+titre+"' ;";
        int id = 0;
        try {
             Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
           while (resultat.next()) {
             id =resultat.getInt(1);   
             
           } 
           return id ;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche d'ID" + ex.getMessage());
            return 0;
        }    }    

    @Override
    public Cours GetCourByTitle(String titre) throws SQLException {
         String requete = "SELECT * FROM `cours` WHERE `titre` ='"+titre+"' ;";
         Cours c = new Cours();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(requete);

            while(rs.next()){
                Cours cours =new Cours();
                cours.setIdCours(rs.getInt(1));
                cours.setTitre(rs.getString(2));
                cours.setURL(rs.getString(4));
                cours.setCategorie(rs.getString(5));
                cours.setDescription(rs.getString(3));
                cours.setDifficult(rs.getString(6));
               
                c=cours;
                
            }
            
            return c;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche d'ID" + ex.getMessage());
            return null;
        }  
    }

public Cours findCoursByID(int id) {
 String requete = "SELECT * FROM `cours` WHERE `idCours` ='"+id+"' ;";
       Cours c = new Cours();
        try {
             Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
           while (resultat.next()) {
               
             c.setIdCours(resultat.getInt(1));   
             c.setTitre(resultat.getString(2));
             c.setDescription(resultat.getString(3));
             
           } 
           return c ;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche d'ID" + ex.getMessage());
            return null;
        }    }        
    
     
    public void upDateCours(Cours c) {
        String sql = "UPDATE cours SET titre=? ,categorie=? , description=? ,difficult=?,nbrChapitre=?,etat=? where idcours=?";
        try {
             PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, c.getTitre());
            ps.setString(2, c.getCategorie());
            ps.setString(3, c.getDescription());
            ps.setString(4, c.getDifficult());
            ps.setString(5,String.valueOf( c.getNbrChapitre()));
            ps.setString(6,c.getEtat());
            ps.setInt(7,c.getIdCours());
            
          

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
      public Vector<Cours> DisplayValide() {
    Vector<Cours>listcours =new Vector<Cours>();

        String requete = "select * from `cours` where etat='1'";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(requete);

            while(rs.next()){
                Cours cours =new Cours();
                cours.setTitre(rs.getString(2));
                cours.setURL(rs.getString(4));
                cours.setCategorie(rs.getString(5));
                cours.setDescription(rs.getString(3));
                cours.setDifficult(rs.getString(6));
                cours.setEtat(rs.getString(15));
                cours.setNbrChapitre(rs.getInt(8));
                
               

                listcours.add(cours);
            }
            
            return listcours;
            
        } catch (SQLException ex) {

            System.out.println("erreur  "+ex.getMessage());
            return null;
        }    
    
    }

public Vector<Cours> DisplayAttente() {
    Vector<Cours>listcours =new Vector<Cours>();

        String requete = "select * from `cours` where etat='0'";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(requete);

            while(rs.next()){
                Cours cours =new Cours();
                cours.setTitre(rs.getString(2));
                cours.setURL(rs.getString(4));
                cours.setCategorie(rs.getString(5));
                cours.setDescription(rs.getString(3));
                cours.setDifficult(rs.getString(6));
                cours.setEtat(rs.getString(15));
                cours.setNbrChapitre(rs.getInt(8));

                listcours.add(cours);
            }
            
            return listcours;
            
        } catch (SQLException ex) {

            System.out.println("erreur  "+ex.getMessage());
            return null;
        }    
    
    }

    public void SupprimerCours(int id) {
         
         Statement st;
        ResultSet rs;
        boolean y = false;

        String sql = "delete from cours where idcours="+id;
        try {
            st = MyConnection.getInstance().getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
     public void updateNoteCours(int idCours,int note){
        String requete = "update cours set note=? where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1,note);
            ps.setFloat(2,idCours);
            ps.executeUpdate();
            System.out.println("Mise ‡ jour effectuÈe avec succËs");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise ‡ jour " + ex.getMessage());
        }    }


    @Override
    public void SupprimerCours(Cours c) throws SQLException {
        String sql = "Update cours set etat='refuser' where idcours=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, c.getIdCours());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public void RefuserCours(int id) {
        Statement st;
        ResultSet rs;
        boolean y = false;

        String sql = "Update cours set etat='refuser' where idcours='" + id + "'";
        try {
            st = MyConnection.getInstance().getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
      
       public void AccepterCours(int id) {
        Statement st;
        ResultSet rs;
        boolean y = false;

        String sql = "Update cours set etat='valider' where idcours='" + id + "'";
        try {
            st = MyConnection.getInstance().getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void valider(int id) {
    
         String sql = "UPDATE cours SET etat=? where idcours=?"+id;
        try {
             PreparedStatement ps = connection.prepareStatement(sql);
           
            ps.setString(1,"attente");
           
            
            
          

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
