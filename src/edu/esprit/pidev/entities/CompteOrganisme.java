/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.entities;

/**
 *
 * @author Asus
 */
public class CompteOrganisme  extends User{
    
    //************************ CONSTRUCTEURS *************************
    public CompteOrganisme(String nom, String prenom, String login, String pwd, String mail, String role,String Adresse) {
        super(nom, prenom, login, pwd, mail, role, Adresse);
    }

    public CompteOrganisme(String login, String nom, String prenom, String mail, String role) {
        super(login, nom, prenom, mail, role);
    }

   

    public CompteOrganisme() {
    }
    
}
