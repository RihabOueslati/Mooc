/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.pidev.entities;

import java.util.Objects;

/**
 *
 * @author Rihab
 */
public class statchapitre {
    private int NombreChapitre;
    private String titre;

    public statchapitre(int NombreChapitre, String titre) {
        this.NombreChapitre = NombreChapitre;
        this.titre = titre;
    }

    public statchapitre() {
    }

    public int getNombreChapitre() {
        return NombreChapitre;
    }

    public void setNombreChapitre(int NombreChapitre) {
        this.NombreChapitre = NombreChapitre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.titre);
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
        final statchapitre other = (statchapitre) obj;
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "statchapitre{" + "NombreChapitre=" + NombreChapitre + ", titre=" + titre + '}';
    }
    
    
}
