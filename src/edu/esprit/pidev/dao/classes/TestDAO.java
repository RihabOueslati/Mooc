/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.pidev.dao.classes;

import edu.esprit.pidev.dao.interfaces.ITest;
import edu.esprit.pidev.entities.Test;
import edu.esprit.pidev.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khalil
 */
public class TestDAO implements ITest{
     private Connection connection;
    
    public TestDAO(){
   connection = MyConnection.getInstance().getConnection();
}


    @Override
    public void addTesteva(Test t) {
         String req ="INSERT INTO `test`(`idchapitre`,`type`)   VALUES (?,?)";
     
             PreparedStatement ps;
        try {
            ps = connection.prepareStatement(req);
       

                                ps.setInt(1, t.getIdChapitre());
  
                                ps.setString(2, t.getType());
                               
       
            ps.executeUpdate();
            System.out.println("Ajout effectué avec succès");
                                 
           } catch (SQLException ex) {
            Logger.getLogger(Rendez_vousDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
       
       
    }
    
}
