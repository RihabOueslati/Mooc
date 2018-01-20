/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.dao.classes;

import edu.esprit.pidev.dao.interfaces.IUtilisateurDAO;
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
public class UtilisateurDAO implements IUtilisateurDAO
{
        private Connection connection; 
         private Statement stat= null ;
        public UtilisateurDAO() 
        {
        connection = MyConnection.getInstance().getConnection();
  
        }

    public void addApprenant(User user) 
    {
        try {
               if(user.getRoles().equals("a:1:{i:0;s:14:\"ROLE_APPRENANT\";}"))
               {
               String req = "insert into user (nom,prenom,dateNaiss,sexe,etat,username,username_canonical,email,email_canonical,"
                       + "enabled,salt, password,roles) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(req);
                ps.setString(1,user.getNom());
                ps.setString(2,user.getPrenom());
                ps.setString(3,user.getDateNaiss());
                ps.setString(4,user.getSexe());
                ps.setInt(5,user.getEtat());
                ps.setString(6,user.getUsername());
                ps.setString(7,user.getUsername_canonical());  
                ps.setString(8,user.getEmail());
                ps.setString(9,user.getEmail_canonical()); 
                ps.setInt(10,user.getEnabled());
                ps.setString(11,user.getSalt());
                ps.setString(12,user.getPassword());
                ps.setString(13,user.getRoles());

                ps.executeUpdate();
               }
               if(user.getRoles().equals("a:1:{i:0;s:14:\"ROLE_FORMATEUR\";}"))
               {
                                  String req = "insert into user (nom,prenom,dateNaiss,sexe,etat,username,username_canonical,email,email_canonical,"
                       + "enabled,salt, password,roles,cvFormateur) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                PreparedStatement ps = connection.prepareStatement(req);
                ps.setString(1,user.getNom());
                ps.setString(2,user.getPrenom());
                ps.setString(3,user.getDateNaiss());
                ps.setString(4,user.getSexe());
                ps.setInt(5,user.getEtat());
                ps.setString(6,user.getUsername());
                ps.setString(7,user.getUsername_canonical());  
                ps.setString(8,user.getEmail());
                ps.setString(9,user.getEmail_canonical());
                   ps.setInt(10,user.getEnabled());
                ps.setString(11,user.getSalt());
                ps.setString(12,user.getPassword());
                ps.setString(13,user.getRoles());
                ps.setString(14,user.getCvFormateur());
               
                
                ps.executeUpdate();
               }
                if(user.getRoles().equals("a:1:{i:0;s:14:\"ROLE_ORGANISME\";}"))
               {

                String req = "insert into user (nom,prenom,dateNaiss,sexe,etat,username,username_canonical,email,email_canonical,"
                       + "enabled,salt, password,roles) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(req);
                ps.setString(1,user.getNom());
                ps.setString(2,user.getPrenom());
                ps.setString(3,user.getDateNaiss());
                ps.setString(4,user.getSexe());
                ps.setInt(5,user.getEtat());
                ps.setString(6,user.getUsername());
                ps.setString(7,user.getUsername_canonical());  
                ps.setString(8,user.getEmail());
                ps.setString(9,user.getEmail_canonical());
                ps.setInt(10,user.getEnabled());
                ps.setString(11,user.getSalt());
                ps.setString(12,user.getPassword());
                ps.setString(13,user.getRoles());
               
               
                
                ps.executeUpdate();
               }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    
    
     public ArrayList<User> GetAllUser (){

       ArrayList<User> listeUser = new ArrayList<User>();

        String requete = "select * from `user`";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                User US =new User();
                
                US.setUsername(resultat.getString(21));
                US.setPassword(resultat.getString(27));
                US.setSalt(resultat.getString(26));
                US.setEtat(resultat.getInt(13));

                listeUser.add(US);
            }
            
            return listeUser;
            
        } catch (SQLException ex) {

            System.out.println("erreur  "+ex.getMessage());
            return null;
        }
    } 
     
     public int findUserByLogin (String log) {
        String requete = "SELECT * FROM `user` WHERE `username` ='"+log+"' ;";
        int id = 0;
        try {
             Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
           while (resultat.next()) {
             id =resultat.getInt(1);   
             
           } 
           return id ;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du login" + ex.getMessage());
            return 0;
        }
        
       
    } 
     
     public String findadressebylogin (String log) {
        String requete = "SELECT * FROM `user` WHERE `username` ='"+log+"' ;";
        String adresse = "";
        try {
             Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
           while (resultat.next()) {
             adresse =resultat.getString(6);   
             
           } 
           return adresse ;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du adresse" + ex.getMessage());
            return null;
        }
       
    } 
     
    
     public int findUserByNom (String nom) {
        String requete = "SELECT * FROM `user` WHERE `nom` ='"+nom+"' ;";
        int id = 0;
        try {
             Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
           while (resultat.next()) {
             id =resultat.getInt(1);   
             
           } 
           return id ;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche par nom" + ex.getMessage());
            return 0;
        }

    } 
    
    
    
    public User findUtilisateurByID(int id_user) {
        User utilisateur = new User();
        String requete = "SELECT * FROM `user` WHERE `id` = "+id_user;
        
        try {
            
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
            while (resultat.next()) {
                 utilisateur.setId(resultat.getInt(1));
                utilisateur.setNom(resultat.getString(2));
                utilisateur.setPrenom(resultat.getString(3));
                utilisateur.setDateNaiss(resultat.getString(7));
                utilisateur.setEmail(resultat.getString(23));
               utilisateur.setUsername(resultat.getString(21));
               utilisateur.setPassword(resultat.getString(27));
            }
            return utilisateur;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du utilisateur by id" + ex.getMessage());
            return null;
        }
    }
    
    
    public String findRoleByLogin (String log) {
        String requete = "SELECT * FROM `user` WHERE `username` ='"+log+"' ;";
        String role = "";
        try {
             Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
           while (resultat.next()) {
             role =resultat.getString(34);   
             
           } 
           return role ;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du login" + ex.getMessage());
            return null;
        }
        
       
    } 
    
   
    
        
       
    public List<User> findLogin (String log) {
        Statement st;
        ResultSet rs;
        List<User> listUser = new ArrayList<>();
         
           String sql= "select id,nom,prenom,dateNaiss,sexe,nbrReclamation,username,email,password,roles from user where username="+log;
        try 
        {
            st= MyConnection.getInstance().getConnection().createStatement();
            rs=st.executeQuery(sql);
            while (rs.next())
            {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setNom(rs.getString(2));
                user.setPrenom(rs.getString(3));
                user.setDateNaiss(rs.getString(7));
                user.setSexe(rs.getString(8));
                user.setNbrReclamation(rs.getInt(14));
                user.setUsername(rs.getString(21));
                user.setPassword(rs.getString(27));
                user.setEmail(rs.getString(23));
                user.setRoles(rs.getString(34));
                
                listUser.add(user);
                
            }
            return listUser;
        }
         
        catch (SQLException ex) {
           Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
           return null;
        }
    }

    
    public void DeleteCompteUser(int id){
        String requete = "update `user` set enabled='0' where id="+id ; 
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.executeUpdate();
            System.out.println("Utilisateur supprimé"); 
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression : "+ex.getMessage());
        }
    }
    
    public boolean DeleteCompteUser(String login){
        String requete = "Delete from user where username="+login ; 
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.executeUpdate();
            System.out.println("Utilisateur supprimé");
            return true;
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression : "+ex.getMessage());
        }
            return false;
    }
    @Override
    public User DisplayUser(int id) {
 Statement st;
        ResultSet rs;
       
         User user = new User();
           String sql= "select * from user where id="+id;
        try 
        {
            st= MyConnection.getInstance().getConnection().createStatement();
            rs=st.executeQuery(sql);
            while (rs.next())
            {
                
                user.setId(rs.getInt(1));
                user.setNom(rs.getString(2));
                user.setPrenom(rs.getString(3));
                user.setDateNaiss(rs.getString(7));
                user.setSexe(rs.getString(8)); 
                user.setImage(rs.getString(12));
                user.setNbrReclamation(rs.getInt(14));
                user.setUsername(rs.getString(21));
                user.setPassword(rs.getString(27));
                user.setEmail(rs.getString(23));
                user.setRoles(rs.getString(34));
            }
            return user;
        }
        
         
        catch (SQLException ex) {
           Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
           return null;
        }    }
   
    
    
         public List<User> DisplayFormateur() {
        Statement st;
        ResultSet rs;
       
           List<User> listUser = new ArrayList<User>();
           String sql= "select * from user";
        try 
        {
            st= MyConnection.getInstance().getConnection().createStatement();
            rs=st.executeQuery(sql);
            while (rs.next())
            {
                if((rs.getString(34).equals("a:1:{i:0;s:14:\"ROLE_FORMATEUR\";}"))&&(rs.getInt(25)==0))
                {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setNom(rs.getString(2));
                user.setPrenom(rs.getString(3));
                user.setDateNaiss(rs.getString(7));
                user.setSexe(rs.getString(8));
                user.setNbrReclamation(rs.getInt(14));
                user.setUsername(rs.getString(21));
                user.setPassword(rs.getString(27));
                user.setEmail(rs.getString(23));
                user.setRoles(rs.getString(34));
               // user.setAdresse(rs.getString(20));
               listUser.add(user);
                }
            }
            
            return listUser;
        }
         
        catch (SQLException ex) {
           Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
           return null;
        }    }

         
          public List<User> AfficherFormateur() {
        Statement st;
        ResultSet rs;
       
           List<User> listUser = new ArrayList<User>();
           String sql= "select * from user";
        try 
        {
            st= MyConnection.getInstance().getConnection().createStatement();
            rs=st.executeQuery(sql);
            while (rs.next())
            {
                //if((rs.getString(9).equals("formateur"))&&(rs.getInt(13)==1))
                {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setNom(rs.getString(2));
                user.setPrenom(rs.getString(3));
                user.setDateNaiss(rs.getString(7));
                user.setSexe(rs.getString(8));
                user.setNbrReclamation(rs.getInt(14));
                user.setAdresse(rs.getString(20));
                user.setUsername(rs.getString(21));
                user.setPassword(rs.getString(27));
                user.setEmail(rs.getString(23));
                user.setRoles(rs.getString(34));
               listUser.add(user);
                }
            }
            return listUser;
        }
         
        catch (SQLException ex) {
           Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
           return null;
        }    }
          
       public List<User> DisplayOrganisme() {
        Statement st;
        ResultSet rs;
       
           List<User> listUser = new ArrayList<User>();
           String sql= "select * from user";
        try 
        {
            st= MyConnection.getInstance().getConnection().createStatement();
            rs=st.executeQuery(sql);
            while (rs.next())
            {
                if((rs.getString(34).equals("a:1:{i:0;s:14:\"ROLE_ORGANISME\";}"))&&(rs.getInt(25)==1))
                {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setNom(rs.getString(2));
                user.setPrenom(rs.getString(3));
                user.setDateNaiss(rs.getString(7));
                user.setSexe(rs.getString(8));
                user.setNbrReclamation(rs.getInt(14));
                user.setUsername(rs.getString(21));
                user.setPassword(rs.getString(27));
                user.setEmail(rs.getString(23));
                user.setRoles(rs.getString(34));
               listUser.add(user);
                }
            }
            return listUser;
        }
         
        catch (SQLException ex) {
           Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
           return null;
        }    }
       
       
       
      public void modifierUser(User u) {
        Statement st;
  
        User user = DisplayUser(u.getId());
        if(user != null)
        {
        if (!(u.getNom().equals("")))
                {
                   String sql="Update user set nom='"+u.getNom()+"' where id='"+u.getId()+"'";
                    try 
                     {
                         st = MyConnection.getInstance().getConnection().createStatement();
                         st.executeUpdate(sql);
                     } 
                     catch (SQLException ex) 
                     {
                         Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
                     }
                }
        if (!(u.getPrenom().equals("")))
        {
        
                
                   String sql="Update user set prenom='"+u.getPrenom()+"' where id='"+u.getId()+"'";
                    try 
                     {
                         st = MyConnection.getInstance().getConnection().createStatement();
                         st.executeUpdate(sql);
                     } 
                     catch (SQLException ex) 
                     {
                         Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
                     }
                
        }
      
        if (!(u.getPassword().equals("")))
        {
        
                
                   String sql="Update user set password='"+u.getPassword()+"' where id='"+u.getId()+"'";
                    try 
                     {
                         st = MyConnection.getInstance().getConnection().createStatement();
                         st.executeUpdate(sql);
                     } 
                     catch (SQLException ex) 
                     {
                         Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
                     }
                
        }
        if (!(u.getDateNaiss().equals("")))
        {
        
                
                   String sql="Update user set dateNaiss='"+u.getDateNaiss()+"' where id='"+u.getId()+"'";
                    try 
                     {
                         st = MyConnection.getInstance().getConnection().createStatement();
                         st.executeUpdate(sql);
                     } 
                     catch (SQLException ex) 
                     {
                         Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
                     }
                
        }
//         if (!(u.getLogin().equals("")))
//        {
//        
//                   String sql="Update user set login='"+u.getLogin()+"' where id='"+u.getId()+"'";
//                    try 
//                     {
//                         st = MyConnection.getInstance().getConnection().createStatement();
//                         st.executeUpdate(sql);
//                     } 
//                     catch (SQLException ex) 
//                     {
//                         Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
//                     }
//                
//        }
                
        if (!(u.getSexe().equals("")))
        {
       
                
                   String sql="Update user set sexe='"+u.getSexe()+"' where id='"+u.getId()+"'";
                    try 
                     {
                         st = MyConnection.getInstance().getConnection().createStatement();
                         st.executeUpdate(sql);
                     } 
                     catch (SQLException ex) 
                     {
                         Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
                     }
                
        }
         if (u.getTelephone()!=0)
        {
       
                
                   String sql="Update user set telephone='"+u.getTelephone()+"' where id='"+u.getId()+"'";
                    try 
                     {
                         st = MyConnection.getInstance().getConnection().createStatement();
                             st.executeUpdate(sql);
                     } 
                     catch (SQLException ex) 
                     {
                         Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
                     }
                
        }
       System.out.println("Mise à jour effectuée avec succès");
        }
    }
    
          public int recherchelogin(String log)
     {
          int n = 0; 
        String requete = "SELECT count(id) FROM `user` where username='"+log+"' ; ";
          try {   
              
         
          Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
             
            while(resultat.next()){
          
              n= resultat.getInt(1);
              System.out.println("user"+n);
            }
            
            return n;
          }
            
         catch (SQLException ex) {

            System.out.println("erreur  "+ex.getMessage());
               return 0;
        }
                
      }
        
   public int recherchemail(String email)
     {
          int n = 0; 
        String requete = "SELECT count(id) FROM `user` where email='"+email+"' ; ";
          try {   
              
         
         Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
             
            while(resultat.next()){
          
              n= resultat.getInt(1);
              System.out.println("user"+n);
            }
            
            return n;
          }
            
         catch (SQLException ex) {

            System.out.println("erreur  "+ex.getMessage());
               return 0;
        }
                
      }
   
   
     public Integer totalApprenantConnecte() { 
        int test = 0;
        User user= new User();
        if(user.getRoles()=="a:1:{i:0;s:14:\"ROLE_APPRENANT\";}"){
                
    
            try {
                String req = "select count(*) from user where etat_connection=1 ";
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(req);
                while (rs.next()) {
                    test = (Integer) rs.getInt(1);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
             }
            return test;
            }
    
    
      public double getCountApprenantUSers()
    {
        double n = 0; 
        String reqApp = "SELECT count(id) FROM user WHERE roles='a:1:{i:0;s:14:\"ROLE_APPRENANT\";}; ";
       
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(reqApp);
            
            
            while(resultat.next()){
              n= resultat.getInt(1);
            }
         
           return n; 
           
            
        } catch (SQLException ex) {

            System.out.println("erreur  "+ex.getMessage());
                      return 0;
 
        }
    }
    
     public double getCountFormateurUSers()
    {
        double n = 0; 
        String reqApp = "SELECT count(id) FROM user WHERE roles='a:1:{i:0;s:14:\"ROLE_FORMATEUR\";}'; ";
       
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(reqApp);
            
            
            while(resultat.next()){
              n= resultat.getInt(1);
            }
         
           return n; 
           
            
        } catch (SQLException ex) {

            System.out.println("erreur  "+ex.getMessage());
                      return 0;
 
        }
    }
     
     public double getCountOrganismeUSers()
    {
        double n = 0; 
        String reqApp = "SELECT count(id) FROM user WHERE role='a:1:{i:0;s:14:\"ROLE_ORGANISME\";}'; ";
       
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(reqApp);
            
            
            while(resultat.next()){
              n= resultat.getInt(1);
            }
         
           return n; 
           
            
        } catch (SQLException ex) {

            System.out.println("erreur  "+ex.getMessage());
                      return 0;
 
        }
    }
      
      
   public User estCorrect(String login, String pwd) {
        //Chercher le compte dans les 3 tables comptes dans le bd et le retourner 
        UtilisateurDAO uDAO = new UtilisateurDAO();

        //tester l'existance du compte dans chaque table et retourner le compte si ca existe
        User ud = uDAO.estCorrect(login, pwd);
        if (ud != null) {
            return ud;
        }

        return null;
    }


    public boolean estExistantUsername(String username) {
        //Chercher  dans les 3 tables comptes dans la bd
         UtilisateurDAO udao = new UtilisateurDAO();

        //tester l'existance du username dans chaque table et retourner vrai si ca existe
      
        if (udao.estExistantUsername(username)) {
            return true;
        }
     
        return false;
    }

        
    public boolean estExistantEmail(String email) {
        //Chercher  dans les 3 tables comptes dans la bd
         UtilisateurDAO udao = new UtilisateurDAO();
        //tester l'existance du username dans chaque table et retourner vrai si ca existe
        if (udao.estExistantEmail(email)) {
            return true;
        }
        return false;
    }

//Changer le mot de passe de username en new pass, si le oldpass est correcte, retourne 1 si le mot de passe est changé, 0 sinon
    public boolean changerMotdepasse(String login, String oldPass, String newPass) {
        boolean changed = false;
        User c = estCorrect(login, oldPass);

        if (c != null) {
            String sql = "UPDATE compte_"+c.getRoles()+" set password='" + newPass + "' where username='" + login+ "' ";
            
            try {
                Statement statement = connection.createStatement();
                int rs = statement.executeUpdate(sql);
                changed = true;
            } catch (SQLException ex) {
                Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
                changed = false;
            }
            System.out.println("Le mot de passe a été changé avec succée ! ");
        }
        return changed;
    }


     
//     public List<User> afficherCompte() {
//        List<User> list = new ArrayList<User>();
//
//        //******************ADMIN *********************
//        String sql = "select * from user ";
//        try {
//            System.out.println("\nOKKK => " + list.toString());
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ResultSet result = ps.executeQuery();
//            while (result.next()) {
//
//                UtilisateurDAO compteDao = new UtilisateurDAO();
//                User c = new User();
//                c = compteDao.getCompte(result.getString(1));
//                list.add(c);
//            }
//            System.out.println("\nListe => " + list.toString());
//            return list;
//            
//        } catch (SQLException ex) {
//            System.out.println("\nListe => " + list.toString());
//            //Logger.getLogger(DepotDAO.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("erreur de la recherche" + ex.getMessage());
//            return list;
//        }
//       
//    }
     
     
   
   public User getFormateurById(int id) {
      User u = null;
  
      
        ResultSet rs = null;
        String sql = "SELECT * FROM user WHERE ( id = '"+id+"' ) and  ; ";
        System.out.println( "***Execution de la requete : "+sql);
        if (stat!=null) // Si il ya une connexion
        try {
            rs = stat.executeQuery(sql);
            rs.next();//premier résultat
            u = new User(rs.getString("username"), rs.getString("password"),rs.getString("nom"), rs.getString("prenom"), rs.getString("email"));
                u.setId(rs.getInt("id"));
                System.out.println( "*** Compte estCorrect => : "+u.toString());
            
        } catch (SQLException ex) {
            System.out.println( "*** Nom d'utilisateur ou mot de passe incorrecte !");
        }
        
       return u;
    }
   
     public User getformateur(String login) {
        User u = null;
        ResultSet rs = null;
        String sql = "";
         Statement stm = null ;
        if (stm != null) // Si il ya une connexion
        {
            try {

                //****************ADMIN ******************
                sql = "SELECT * FROM user WHERE roles='Formateur' and  login = '" + login + "' ; ";
             stm= MyConnection.getInstance().getConnection().createStatement();
            rs=stm.executeQuery(sql);
                rs.next();//premier résultat
               // User u = new User ();
                u = new User(rs.getString("login"), rs.getString("pwd"), rs.getString("nom"), rs.getString("prenom"), rs.getString("mail"));
//                u.setId(rs.getInt("id"));
//                u.setId(rs.getInt(1));
//                u.setNom(rs.getString(2));
//                u.setPrenom(rs.getString(3));
//                u.setLogin(rs.getString(4));
//                u.setPwd(rs.getString(5));
//                u.setMail(rs.getString(6));
//                u.setDateNaiss(rs.getString(7));
//                u.setSexe(rs.getString(8));
//                u.setRole(rs.getString(9));
//                u.setNbrReclamation(rs.getInt(10));
                
                System.out.println("*** Compte estCorrect => : " + u.toString());
             
            } catch (SQLException ex) {
                System.out.println("*** Nom d'utilisateur admin ou mot de passe incorrecte !");
            }

           
       

    } return u;
     }
 
}
        
    
    
    

