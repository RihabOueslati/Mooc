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
public class Reponse 
{
    private int idReponse;
    private String description;

    public Reponse(int idReponse, String description) {
        this.idReponse = idReponse;
        this.description = description;
    }

    public int getIdReponse() {
        return idReponse;
    }

    public void setIdReponse(int idReponse) {
        this.idReponse = idReponse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Reponse{" + "idReponse=" + idReponse + ", description=" + description + '}';
    }
    
    
}
