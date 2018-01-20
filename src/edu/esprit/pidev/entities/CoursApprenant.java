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
public class CoursApprenant {
    private int idCoursApp;
    private User idUtilisateur;
    private Cours idCours;
    private String Date;

    public CoursApprenant(int idCoursApp, User idUtilisateur, Cours idCours,String Date) {
        this.idCoursApp = idCoursApp;
        this.idUtilisateur = idUtilisateur;
        this.idCours = idCours;
        this.Date = Date;
    }

   

    public CoursApprenant() {
    }

    public int getIdCoursApp() {
        return idCoursApp;
    }

    public void setIdCoursApp(int idCoursApp) {
        this.idCoursApp = idCoursApp;
    }

    public User getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(User idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Cours getIdCours() {
        return idCours;
    }

    public void setIdCours(Cours idCours) {
        this.idCours = idCours;
    }

    public CoursApprenant(String Date) {
        this.Date = Date;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.idCoursApp;
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
        final CoursApprenant other = (CoursApprenant) obj;
        if (this.idCoursApp != other.idCoursApp) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CoursApprenant{" + "idCoursApp=" + idCoursApp + ", idUtilisateur=" + idUtilisateur + ", idCours=" + idCours + '}';
    }
}
