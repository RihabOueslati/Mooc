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

public class RDV 
{
     private int idRdv;
     private String dateRDV;
     private float  Longitude;
     private float duree;
     private float Latitude;
     private User idFormateur;
     private User idOrganisme;

    public RDV(int idRdv, String dateRDV, float Longitude, float duree, float Latitude, User idFormateur, User idOrganisme) 
    {
        this.idRdv = idRdv;
        this.dateRDV = dateRDV;
        this.Longitude = Longitude;
        this.duree = duree;
        this.Latitude = Latitude;
        this.idFormateur = idFormateur;
        this.idOrganisme = idOrganisme;
    }

    public int getIdRdv() {
        return idRdv;
    }

    public void setIdRdv(int idRdv) {
        this.idRdv = idRdv;
    }

    public String getDateRDV() {
        return dateRDV;
    }

    public void setDateRDV(String dateRDV) {
        this.dateRDV = dateRDV;
    }

    public float getLongitude() {
        return Longitude;
    }

    public void setLongitude(float Longitude) {
        this.Longitude = Longitude;
    }

    public float getDuree() {
        return duree;
    }

    public void setDuree(float duree) {
        this.duree = duree;
    }

    public float getLatitude() {
        return Latitude;
    }

    public void setLatitude(float Latitude) {
        this.Latitude = Latitude;
    }

    public User getIdFormateur() {
        return idFormateur;
    }

    public void setIdFormateur(User idFormateur) {
        this.idFormateur = idFormateur;
    }

    public User getIdOrganisme() {
        return idOrganisme;
    }

    public void setIdOrganisme(User idOrganisme) {
        this.idOrganisme = idOrganisme;
    }

    @Override
    public String toString() {
        return "RDV{" + "idRdv=" + idRdv + ", dateRDV=" + dateRDV + ", Longitude=" + Longitude + ", duree=" + duree + ", Latitude=" + Latitude + ", idFormateur=" +
                idFormateur + ", idOrganisme=" + idOrganisme + '}';
    }
    
    
     
     
     
}
