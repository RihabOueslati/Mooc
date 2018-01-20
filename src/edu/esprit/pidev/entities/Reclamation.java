/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.pidev.entities;

/**
 *
 * @author jihene
 */

public class Reclamation 
{
    private int idReclamation;
    private String cause;
    private String description;
    private User idUser;

    public Reclamation() {
    }

    public Reclamation(int idReclamation, String cause, String description, User idUser) {
        this.idReclamation = idReclamation;
        this.cause = cause;
        this.description = description;
        this.idUser = idUser;
    }

    public int getIdReclamation() {
        return idReclamation;
    }

    public void setIdReclamation(int idReclamation) {
        this.idReclamation = idReclamation;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "idReclamation=" + idReclamation + ", cause=" + cause + ", description=" + description + ", idUser=" + idUser + '}';
    }
    
    
    
}
