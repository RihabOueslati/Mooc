/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.pidev.entities;

/**
 *
 * @author kenza
 */
public class TestAcceptation {
    
    private String commentaire; 
    private User user;
    private Cours cours;
    private boolean validation= false;
    private int id_testAcceptation; 
    
    ////////////// les getters et les setters
    public int getId_testAcceptation() {
        return id_testAcceptation;
    }

    public void setId_testAcceptation(int id_testAcceptation) {
        this.id_testAcceptation = id_testAcceptation;
    }
    
    
    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public User getUser() {
        return user;
    }

    public Cours getCours() {
        return cours;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

  
    public boolean isValidation() {
        return validation;
    }

    public void setValidation(boolean validation) {
        this.validation = validation;
    }
    
    ////////// constructeurs
    public TestAcceptation() {
    }

    public TestAcceptation(String commentaire,  boolean validation) {
        this.commentaire = commentaire;
        this.validation = validation;
    }

    @Override
    public String toString() {
        return "TestAcceptation{" + "commentaire=" + commentaire + ",user=" + user + ", cours=" + cours + ", validation=" + validation + '}';
    }
    
    
}
