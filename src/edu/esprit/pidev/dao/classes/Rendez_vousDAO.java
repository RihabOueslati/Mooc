/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.pidev.dao.classes;

import edu.esprit.pidev.entities.Rendez_vous;
import edu.esprit.pidev.dao.interfaces.Irendez_vousDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.esprit.pidev.util.MyConnection; 

/**
 *
 * @author Rihab
 */
public class Rendez_vousDAO implements Irendez_vousDAO{
    
    private Connection connection;
    
    public Rendez_vousDAO(){
   connection = MyConnection.getInstance().getConnection();
}

    @Override
    public void addRendez_vous(Rendez_vous rdv) {
         
            String req ="INSERT INTO `rdv`(`idFormateur`,`idOrganisme`,`duree`,`dateRDV`,`Longitude`,`Latitude`)   VALUES (?,?,?,?,?,?)";
     
             PreparedStatement ps;
        try {
            ps = connection.prepareStatement(req);
       

                                ps.setTimestamp(4, rdv.getDate_rendez_vous());
                                ps.setInt(1, rdv.getId_user());
                                ps.setInt(2, rdv.getId_organisme());
                                ps.setString(3, rdv.getDuree_Rendezvous());
                                ps.setDouble(5, rdv.getLongitude());
                                ps.setDouble(6,rdv.getLatitude());
          
       
            ps.executeUpdate();
            System.out.println("Ajout effectué avec succès");
                                 
           } catch (SQLException ex) {
            Logger.getLogger(Rendez_vousDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
       
       
           
    
    }

    @Override
    public void removeDAO(int id_rdv) {
        String req ="delete from `rdv` where `idRdv` = ?";
            try {
            
           PreparedStatement ps ;
           ps = connection.prepareStatement(req);
           ps.setInt(1,id_rdv);
           ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Rendez_vousDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Timestamp date_rdv,String duree,int id_rend) {
         String req="UPDATE `rdv` SET `dateRDV`=(?),`duree`=(?)  WHERE `idRdv`= (?)";
        try {
            PreparedStatement ps;
        
            ps = connection.prepareStatement(req);
       
           
             ps.setTimestamp(1,date_rdv);
             ps.setString(2,duree);
             ps.setInt(3, id_rend);
             
            
             
            
            ps.executeUpdate();
             } catch (SQLException ex) {
            Logger.getLogger(Rendez_vousDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }

    @Override
    public List<Rendez_vous> FindAllrendez_vous() {
        
        try {
            List<Rendez_vous> ren = new ArrayList<>();
            String req =" select * from rdv";
            
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Rendez_vous rdv = new Rendez_vous();
                
                 Timestamp d = rs.getTimestamp(2);
              //  System.out.println("ddd"+d);
              
                rdv.setDate_rendez_vous(d);
                rdv.setId_rendez_vous(rs.getInt(1));
                rdv.setDuree_Rendezvous(rs.getString(4));
                //rdv.setId_user(rs.getInt(3));
                rdv.setId_organisme(rs.getInt(6));
                rdv.setLatitude(rs.getDouble(7));
                rdv.setLongitude(rs.getDouble(3));
                
                ren.add(rdv);
            }
            return ren ;
        } catch (SQLException ex) {
            Logger.getLogger(Rendez_vousDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
        
    

    @Override
    public List<Rendez_vous> findRendez_vousByFormateur(int id_user) {
        try {
            List<Rendez_vous> ren = new ArrayList<>();
            String req="SELECT * FROM `rdv` WHERE idFormateur = (?)";
            
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1,id_user);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Rendez_vous rdv = new Rendez_vous();
                rdv.setDate_rendez_vous(rs.getTimestamp(2));
               // rdv.setId_organisme(rs.getInt());
                rdv.setDuree_Rendezvous(rs.getString(4));
                
                ren.add(rdv);
            }
            return ren;
        } catch (SQLException ex) {
            Logger.getLogger(Rendez_vousDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null; 
        }
    }

    @Override
    public List<Rendez_vous>  findRendez_vousByOrganisme(int id_Organisme) {
          try {
            List<Rendez_vous> ren = new ArrayList<>();
            String req="SELECT * FROM `rdv` WHERE idOrganisme = (?)";
            
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1,id_Organisme);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Rendez_vous rdv = new Rendez_vous();
                rdv.setDate_rendez_vous(rs.getTimestamp(2));
                rdv.setDuree_Rendezvous(rs.getString(4));
                ren.add(rdv);
            }
            return ren;
        } catch (SQLException ex) {
            Logger.getLogger(Rendez_vousDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null; 
        }
    }

    @Override
    public Rendez_vous FindLonLatByIdRdv(int id_rdv) {
            try {
            List<Rendez_vous> rendez = new ArrayList<>();
            String req="SELECT * FROM `rdv` WHERE idRdv = (?)";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1,id_rdv);
            ResultSet rs = ps.executeQuery();
      
            while (rs.next()) {
                Rendez_vous rdv = new Rendez_vous(rs.getDouble(3),rs.getDouble(7));
                return rdv;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Rendez_vousDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null; 
    }
    
}
