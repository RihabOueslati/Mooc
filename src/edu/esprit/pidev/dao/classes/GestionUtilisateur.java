/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.dao.classes;

import edu.esprit.pidev.entities.User;
import edu.esprit.pidev.util.MyConnection;
import java.sql.Connection;
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
public class GestionUtilisateur {

    private Connection connection;

    public GestionUtilisateur() {
        connection = MyConnection.getInstance().getConnection();

    }

    public void ModifierPhotoDeProfil(int id, String path) {
        Statement st;
        ResultSet rs;

        String sql = "Update user set image='" + path + "' where id='" + id + "'";
        try {
            st = MyConnection.getInstance().getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean ModifierPassword(int id, String pwd) {
        Statement st;
        ResultSet rs;
        boolean y = false;

        String sql = "Update user set pwd='" + pwd + "' where id='" + id + "'";
        try {
            st = MyConnection.getInstance().getConnection().createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }

    }

    public User DisplayOrganisme(int id) {
        Statement st;
        ResultSet rs;

        User user = new User();
        String sql = "select * from user where id=" + id;
        try {
            st = MyConnection.getInstance().getConnection().createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {

                user.setId(rs.getInt(1));
                user.setNom(rs.getString(2));
                user.setPrenom(rs.getString(3));
                user.setDateNaiss(rs.getString(7));
                user.setSexe(rs.getString(8));
                user.setNbrReclamation(rs.getInt(10));
                user.setLatitude(rs.getDouble(18));
                user.setLongitude(rs.getDouble(19));
                user.setUsername(rs.getString(21));
                user.setPassword(rs.getString(27));
                user.setEmail(rs.getString(23));
                user.setRoles(rs.getString(34));

            }
          
            
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
     public void RefuserFormateur(int id) {
        Statement st;
        ResultSet rs;
        boolean y = false;

        String sql = "Update user set etat=-1 where id='" + id + "'";
        try {
            st = MyConnection.getInstance().getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     
 public User DisplayFormateur(int id) {
        Statement st;
        ResultSet rs;

        User user = new User();
        String sql = "select * from user where id=" + id;
        try {
            st = MyConnection.getInstance().getConnection().createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {

                user.setId(rs.getInt(1));
                    user.setNom(rs.getString(2));
                    user.setPrenom(rs.getString(3));
                    user.setDateNaiss(rs.getString(4));
                    user.setSexe(rs.getString(5));

                    user.setLatitude(rs.getDouble(14));
                    user.setLongitude(rs.getDouble(15));
                    user.setUsername(rs.getString(17));
                    user.setPassword(rs.getString(23));
                    user.setEmail(rs.getString(19));
                    user.setRoles(rs.getString(30));

            }

            return user;
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
public void AccepteFormateur(int id) {
        Statement st;
        ResultSet rs;
        boolean y = false;

        String sql = "Update user set enabled=1 where id='" + id + "'";
        try {
            st = MyConnection.getInstance().getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public List<User> DisplayOrganisme() {
        Statement st;
        ResultSet rs;

        List<User> users = new ArrayList<>();
        String sql = "select * from user";
        try {
            st = MyConnection.getInstance().getConnection().createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                if ((rs.getString(34).equals("a:1:{i:0;s:14:\"ROLE_ORGANISME\";}")) && (rs.getInt(13) == 0)) {
                    User user = new User();
                    user.setId(rs.getInt(1));
                    user.setNom(rs.getString(2));
                    user.setPrenom(rs.getString(3));
                    user.setDateNaiss(rs.getString(7));
                    user.setSexe(rs.getString(8));
                    user.setNbrReclamation(rs.getInt(10));
                    user.setLatitude(rs.getDouble(18));
                    user.setLongitude(rs.getDouble(19));
                    user.setUsername(rs.getString(21));
                    user.setPassword(rs.getString(27));
                    user.setEmail(rs.getString(23));
                    user.setRoles(rs.getString(34));
                    users.add(user);
                }
            }
            return users;
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void AccepterFormateur(int id) {
        Statement st;
        ResultSet rs;
        boolean y = false;

        String sql = "Update user set etat=1 where id='" + id + "'";
        try {
            st = MyConnection.getInstance().getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    

    public void RefuserOrganisme(int id) {
        Statement st;
        ResultSet rs;
        boolean y = false;

        String sql = "Update user set etat=-1 where id='" + id + "'";
        try {
            st = MyConnection.getInstance().getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void AccepterOrganisme(int id) {
        Statement st;
        ResultSet rs;
        boolean y = false;

        String sql = "Update user set etat=1 where id='" + id + "'";
        try {
            st = MyConnection.getInstance().getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

   /* public List<User> DisplayMembers() {
        Statement st;
        ResultSet rs;

        List<User> listUser = new ArrayList<User>();
        String sql = "select * from user";
        try {
            st = MyConnection.getInstance().getConnection().createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                if((rs.getString(30).equals("a:1:{i:0;s:14:\"ROLE_APPRENANT\";}"))&&(rs.getInt(21)==1))
                {
                    User user = new User();
                    user.setId(rs.getInt(1));
                    user.setNom(rs.getString(2));
                    user.setPrenom(rs.getString(3));
                    user.setDateNaiss(rs.getString(7));
                    user.setSexe(rs.getString(8));
                    
                    
                    user.setNbrReclamation(rs.getInt(10));
                    user.setAdresse(rs.getString(20));
                    user.setUsername(rs.getString(21));
                    user.setPassword(rs.getString(27));
                    user.setEmail(rs.getString(23));
                    user.setRoles(rs.getString(34));
                    listUser.add(user);
                }
            }
            return listUser;
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }*/

    public List<User> RechercheAvancee(String log, String role) {
        Statement st;
        ResultSet rs;

        List<User> listUser = new ArrayList<User>();

        try {
            String sql = "SELECT * FROM `user` WHERE `username` like '%" + log + "%'";
            st = MyConnection.getInstance().getConnection().createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                if (rs.getString(9).equals(role)) {

                    User user = new User();

                    user.setNom(rs.getString(2));
                    user.setPrenom(rs.getString(3));
                    user.setEmail(rs.getString(23));

                    user.setTelephone(rs.getInt(17));
                    listUser.add(user);
                }

            }
            return listUser;
        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du login" + ex.getMessage());
            return null;
        }

    }

    public List<User> DisplayUserBySig() {
        Statement st;
        ResultSet rs;

        List<User> listUser = new ArrayList<User>();
        String sql = "select * from user";
        try {
            st = MyConnection.getInstance().getConnection().createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                if ((rs.getInt(14) >= 3) && (rs.getInt(13) == 1)) {
                    User user = new User();
                    user.setId(rs.getInt(1));
                    user.setNom(rs.getString(2));
                    user.setPrenom(rs.getString(3));
                    user.setDateNaiss(rs.getString(7));
                    user.setSexe(rs.getString(8));
                    user.setNbrReclamation(rs.getInt(10));
                    user.setAdresse(rs.getString(20));
                    user.setUsername(rs.getString(21));
                    user.setPassword(rs.getString(27));
                    user.setEmail(rs.getString(23));
                    user.setRoles(rs.getString(34));
                    listUser.add(user);
                }
            }
            return listUser;
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

   public List<User> DisplayFormateur() {
        Statement st;
        ResultSet rs;

        List<User> users = new ArrayList<>();
        String sql = "select * from user where roles like '%ROLE_Formateur%' AND enabled=1";
        try {
            st = MyConnection.getInstance().getConnection().createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                {
                    User user = new User();
                    user.setId(rs.getInt(1));
                    user.setNom(rs.getString(2));
                    user.setPrenom(rs.getString(3));
                    user.setDateNaiss(rs.getString(4));
                    user.setSexe(rs.getString(5));

                    user.setLatitude(rs.getDouble(14));
                    user.setLongitude(rs.getDouble(15));
                    user.setUsername(rs.getString(17));
                    user.setPassword(rs.getString(23));
                    user.setEmail(rs.getString(19));
                    user.setRoles(rs.getString(30));
                   
                    users.add(user);
                }
            }
            return users;
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
   
   
   
  public List<User> DisplayFormateurR() {
        Statement st;
        ResultSet rs;

        List<User> users = new ArrayList<>();
        String sql = "select * from user where roles like '%ROLE_Formateur%' AND enabled=0";
        try {
            st = MyConnection.getInstance().getConnection().createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                {
                    User user = new User();
                    user.setId(rs.getInt(1));
                    user.setNom(rs.getString(2));
                    user.setPrenom(rs.getString(3));
                    user.setDateNaiss(rs.getString(4));
                    user.setSexe(rs.getString(5));

                    user.setLatitude(rs.getDouble(14));
                    user.setLongitude(rs.getDouble(15));
                    user.setUsername(rs.getString(17));
                    user.setPassword(rs.getString(23));
                    user.setEmail(rs.getString(19));
                    user.setRoles(rs.getString(30));
                   
                    users.add(user);
                }
            }
            return users;
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
   
   
   
}
