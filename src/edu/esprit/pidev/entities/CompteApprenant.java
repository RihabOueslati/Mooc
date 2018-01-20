/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.entities;

/**
 *
 * @author pc
 */
public class CompteApprenant extends User
{
         //************************ CONSTRUCTEURS *************************
          
    public CompteApprenant(String nom, String prenom, String dateNaiss, String sexe, String username,String username_canonical ,String email,String email_canonical,int enabled,
                  String salt, String password, String roles) {
        super(nom, prenom, dateNaiss, sexe, username,username_canonical,email,email_canonical,enabled,salt, password,roles);
    }

    public CompteApprenant(String username, String nom, String prenom, String email, String roles) {
        super(username, nom, prenom, email, roles);
    }

   

    public CompteApprenant() {
    }
    
    
}
