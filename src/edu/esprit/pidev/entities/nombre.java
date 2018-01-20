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
public class nombre {

    private int etatconnexion;
    private int Userconnecte;

    public nombre(int etatconnexion, int Userconnecte) {
        this.etatconnexion = etatconnexion;
        this.Userconnecte = Userconnecte;
    }

    public nombre() {
    }

    public int getEtatconnexion() {
        return etatconnexion;
    }

    public void setEtatconnexion(int etatconnexion) {
        this.etatconnexion = etatconnexion;
    }

    public int getUserconnecte() {
        return Userconnecte;
    }

    public void setUserconnecte(int Userconnecte) {
        this.Userconnecte = Userconnecte;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.etatconnexion;
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
        final nombre other = (nombre) obj;
        if (this.etatconnexion != other.etatconnexion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nombre{" + "etatconnexion=" + etatconnexion + ", Userconnecte=" + Userconnecte + '}';
    }

}
