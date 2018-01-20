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
public class Test {
    private int idTest;
    private int idChapitre;
    private String badge;
    private String resultat;
    private String type;
    private int nbr_question;

    public Test(int idTest, int idChapitre, String badge, String resultat, String type, int nbre_question) {
        this.idTest = idTest;
        this.idChapitre = idChapitre;
        this.badge = badge;
        this.resultat = resultat;
        this.type = type;
        this.nbr_question=nbre_question;
    }

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    public int getIdChapitre() {
        return idChapitre;
    }

    public void setIdChapitre(int idChapitre) {
        this.idChapitre = idChapitre;
    }

    public int getNbr_question() {
        return nbr_question;
    }

    public String getBadge() {
        return badge;
    }

    public void setNbr_question(int nbr_question) {
        this.nbr_question = nbr_question;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.idTest;
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
        final Test other = (Test) obj;
        if (this.idTest != other.idTest) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Test{" + "idTest=" + idTest + ", idChapitre=" + idChapitre + ", badge=" + badge + ", resultat=" + resultat + ", type=" + type + '}';
    }
    
    
}
