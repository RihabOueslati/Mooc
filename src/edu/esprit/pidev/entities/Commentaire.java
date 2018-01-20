/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.entities;

/**
 *
 * @author Rihab
 */
public class Commentaire {
    
    private int id;
    private String Description ;
    private String date;
    private int idUser;
    private int idCours ;
    private int fk_chapitre ;
    private User user ;
    
    

    public Commentaire() {
    }

    public Commentaire(int id, String Description, String date, int idUser, int idCours,int fk_chapitre, User user) {
        this.id= id;
        this.Description = Description;
        this.date = date;
        this.idUser = idUser;
        this.idCours = idCours;
        this.fk_chapitre=fk_chapitre;
        this.user = user;
    }

    public Commentaire(int id, String Description, String date) {
        this.id = id;
        this.Description = Description;
        this.date = date;
    }

    public Commentaire(int id, String Description) {
        this.id = id;
        this.Description = Description;
    }
    
    
    
    

    public int getId() {
        return id;
    }

    public String getDescription() {
        return Description;
    }

    public String getDate() {
        return date;
    }

   

    public int getFk_cours() {
        return idUser;
    }
     public int getFk_chapitre() {
        return fk_chapitre;
    }

    public User getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setDate(String date) {
        this.date = date;
    }

   

   
    
      public void setFk_chapitre(int fk_chapitre) {
        this.fk_chapitre = fk_chapitre;
    }

    public void setFk_cours(int fk_cours) {
        this.idUser= fk_cours;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ", Description=" + Description + ", date=" + date + ", fk_user=" + idUser + ", fk_cours=" + idUser + ", fk_chapitre=" + fk_chapitre + ", user=" + user + '}';
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdCours() {
        return idCours;
    }

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

 
    
    
    
}