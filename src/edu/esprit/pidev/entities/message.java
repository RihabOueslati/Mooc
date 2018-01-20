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
public class message {
    private int id;
    private String description;
    private String date;
    private User fk_destinataire;
    private User fk_recepteur;
    private String objet;
    
     public message(int id, String description, String date, User fk_destinataire, User fk_recepteur, String objet) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.fk_destinataire = fk_destinataire;
        this.fk_recepteur = fk_recepteur;
        this.objet=objet;
                
    }

    public message(String libelle_message, User fk_destinataire, User fk_recepteur) {
        this.description = description;
        this.fk_destinataire = fk_destinataire;
        this.fk_recepteur = fk_recepteur;
    }

    public message() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public String getObjet() {
        return objet;
    }
    

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public void setDate(String date_message) {
        this.date = date;
    }

    public User getFk_destinataire() {
        return fk_destinataire;
    }

    public void setFk_destinataire(User fk_destinataire) {
        this.fk_destinataire = fk_destinataire;
    }

    public User getFk_recepteur() {
        return fk_recepteur;
    }

    public void setFk_recepteur(User fk_recepteur) {
        this.fk_recepteur = fk_recepteur;
    }

   
    

    
    
    
}
