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
public class StatCours {
    private  int Somme;
    private String titre;

    public StatCours(int Somme, String titre) {
        this.Somme = Somme;
        this.titre = titre;
    }

    public StatCours() {
    }

    public int getSomme() {
        return Somme;
    }

    public void setSomme(int Somme) {
        this.Somme = Somme;
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
        hash = 79 * hash + this.Somme;
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
        final StatCours other = (StatCours) obj;
        if (this.Somme != other.Somme) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return "StatCours{" + "Somme=" + Somme + ", titre=" + titre + '}';
    }
    
    
}
