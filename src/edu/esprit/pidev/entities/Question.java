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
public class Question {
    private int idQestion;
    private String description;
    private Test idTest;
    private Reponse idReponse;

    public Question(int idQestion, String description, Test idTest, Reponse idReponse) {
        this.idQestion = idQestion;
        this.description = description;
        this.idTest = idTest;
        this.idReponse = idReponse;
    }

    public Question() {
    }

    public int getIdQestion() {
        return idQestion;
    }

    public void setIdQestion(int idQestion) {
        this.idQestion = idQestion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Test getIdTest() {
        return idTest;
    }

    public void setIdTest(Test idTest) {
        this.idTest = idTest;
    }

    public Reponse getIdReponse() {
        return idReponse;
    }

    public void setIdReponse(Reponse idReponse) {
        this.idReponse = idReponse;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.idQestion;
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
        final Question other = (Question) obj;
        if (this.idQestion != other.idQestion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Question{" + "idQestion=" + idQestion + ", description=" + description + ", idTest=" + idTest + ", idReponse=" + idReponse + '}';
    }
    
    
}
