/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.entities;

import java.util.Objects;

/**
 *
 * @author Ahmed
 */
public class Chapitre {
   private int idChapitre;
   private String titre;
   private String URL;
   private Cours id_Cours;

    public Chapitre() {
    }

    public Chapitre(String titre, String URL, Cours id_Cours) {
        this.titre = titre;
        this.URL = URL;
        this.id_Cours = id_Cours;
    }

    public Chapitre(String titre) {
        this.titre = titre;
    }

   
   
   
    public Chapitre(String titre, String URL) {
        this.titre = titre;
        this.URL = URL;
    }

    public int getIdChapitre() {
        return idChapitre;
    }

    public String getTitre() {
        return titre;
    }

    public String getURL() {
        return URL;
    }

    public Cours getId_Cours() {
        return id_Cours;
    }

  

    public void setIdChapitre(int idChapitre) {
        this.idChapitre = idChapitre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setId_Cours(Cours id_Cours) {
        this.id_Cours = id_Cours;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idChapitre;
        hash = 67 * hash + Objects.hashCode(this.titre);
        hash = 67 * hash + Objects.hashCode(this.URL);
        hash = 67 * hash + Objects.hashCode(this.id_Cours);
        return hash;
    }

 

   

    @Override
    public String toString() {
        return "Chapitre{" + "idChapitre=" + idChapitre + ", titre=" + titre + ", URL=" + URL + ", id_Cours=" + id_Cours + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Chapitre other = (Chapitre) obj;
        if (this.idChapitre != other.idChapitre) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.URL, other.URL)) {
            return false;
        }
        if (this.id_Cours != other.id_Cours) {
            return false;
        }
        return true;
    }
   
   
   
}
