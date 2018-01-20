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
public class statcommentaire {
    private int NombreCommentaire;
    private String sujet_forum;

    public statcommentaire(int NombreCommentaire, String sujet_forum) {
        this.NombreCommentaire = NombreCommentaire;
        this.sujet_forum = sujet_forum;
    }

    public statcommentaire() {
    }

    public int getNombreCommentaire() {
        return NombreCommentaire;
    }

    public void setNombreCommentaire(int NombreCommentaire) {
        this.NombreCommentaire = NombreCommentaire;
    }

    public String getSujet_forum() {
        return sujet_forum;
    }

    public void setSujet_forum(String sujet_forum) {
        this.sujet_forum = sujet_forum;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.NombreCommentaire;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final statcommentaire other = (statcommentaire) obj;
        if (this.NombreCommentaire != other.NombreCommentaire) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "statcommentaire{" + "NombreCommentaire=" + NombreCommentaire + ", sujet_forum=" + sujet_forum + '}';
    }
    
    
    
}
