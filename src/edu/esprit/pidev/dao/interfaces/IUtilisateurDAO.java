/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.dao.interfaces;

import edu.esprit.pidev.entities.User;
import java.util.List;

/**
 *
 * @author Rihab
 */
public interface IUtilisateurDAO 
{
    void addApprenant(User user);
    List<User> GetAllUser ();
    
    int findUserByLogin (String log);
    //int findUserByID (int id_user) ;
    void  DeleteCompteUser(int id);
    //List<utilisateur> findAll();
    List<User> findLogin(String log);
    User DisplayUser(int id);
    
}
