/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.dao.classes;

import edu.esprit.pidev.dao.interfaces.IChapitre;
import edu.esprit.pidev.entities.Chapitre;
import edu.esprit.pidev.entities.Cours;
import edu.esprit.pidev.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Ahmed
 */
public class ChapitreDAO implements IChapitre{
    
     private Connection connection; 

         public ChapitreDAO() 
        {
        connection = MyConnection.getInstance().getConnection();
        
  
        }

    @Override
    public void AjouterChapitre(Chapitre c) throws SQLException  {
        String requete = "insert into chapitre (titre,URL,idCours) values (?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            //          ps.setInt(3, c.getId_Cours().getIdCours());

         // ps.setInt(3, c.getId_Cours().getIdCours());
            ps.setString(1,c.getTitre());
            ps.setString(2,c.getURL());
            ps.setInt(3,c.getId_Cours().getIdCours());
            
            ps.executeUpdate();

            
            System.out.println("Ajout effectué ,avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }    }

    public void ModifierCours(Chapitre c, String d) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void SupprimerCours(Chapitre c) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Vector<Chapitre> AfficherChapitre(int idCours)  {
 Vector<Chapitre>listchapitre =new Vector<Chapitre>();

        String requete = "select * from `chapitre`  WHERE `idCours` ='"+idCours+"' ;";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(requete);

            while(rs.next()){
                Chapitre chapitre = new Chapitre();
                chapitre.setIdChapitre(rs.getInt(1));
                chapitre.setTitre(rs.getString(2));
                chapitre.setURL(rs.getString(3));


                listchapitre.add(chapitre);
            }
            
            return listchapitre;
            
        } catch (SQLException ex) {

            System.out.println("erreur  "+ex.getMessage());
            return null;
        }    
    
    }

    @Override
    public int findByTitle(String categorie) throws SQLException {
 String requete = "SELECT * FROM `cours` WHERE `categorie` ='"+categorie+"' ;";
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
    
    public String findURL(int idChapitre) throws SQLException {
 String requete = "SELECT URL FROM `chapitre` WHERE `idChapitre` ='"+idChapitre+"' ;";
        String URL = null;
        try {
             Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
           while (resultat.next()) {
             URL =resultat.getString(1);
             
           } 
           return URL ;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche d'ID" + ex.getMessage());
            return "";
        }    }    


    @Override
    public void ModifierChapitre(Chapitre c, String d) throws SQLException {

    
    }

    @Override
    public void SupprimerChapitre(Chapitre c) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector<Chapitre> AfficherChapitre() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
