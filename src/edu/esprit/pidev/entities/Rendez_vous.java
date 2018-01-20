/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.pidev.entities;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Rihab
 */
public class Rendez_vous {
    private double Longitude ;
    private double Latitude ;
    private int id_rendez_vous;
    private String Duree_Rendezvous;
    private Timestamp date_rendez_vous;
    private int id_organisme;
    private int id_user;

    public Rendez_vous(double Longitude, double Latitude, int id_rendez_vous, String Duree_Rendezvous, Timestamp date_rendez_vous, int id_organisme, int id_user) {
        this.Longitude = Longitude;
        this.Latitude = Latitude;
        this.id_rendez_vous = id_rendez_vous;
        this.Duree_Rendezvous = Duree_Rendezvous;
        this.date_rendez_vous = date_rendez_vous;
        this.id_organisme = id_organisme;
        this.id_user = id_user;
    }

    public Rendez_vous(int id_rendez_vous, String Duree_Rendezvous, int id_organisme, int id_user) {
        this.id_rendez_vous = id_rendez_vous;
        this.Duree_Rendezvous = Duree_Rendezvous;
        this.id_organisme = id_organisme;
        this.id_user = id_user;
    }

    public Rendez_vous(double Longitude, double Latitude) {
        this.Longitude = Longitude;
        this.Latitude = Latitude;
    }
    

    public double getLongitude() {
        return Longitude;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLongitude(double Longitude) {
        this.Longitude = Longitude;
    }

    public void setLatitude(double Latitude) {
        this.Latitude = Latitude;
    }

    

    

    public Rendez_vous(int id_rendez_vous) {
        this.id_rendez_vous = id_rendez_vous;
    }

    public Rendez_vous(Timestamp date_rendez_vous, int id_formateur) {
        this.date_rendez_vous = date_rendez_vous;
        this.id_user = id_formateur;
    }

    public Rendez_vous(Timestamp date_rendez_vous) {
        this.date_rendez_vous = date_rendez_vous;
    }

    public Rendez_vous() {
    }

    public int getId_rendez_vous() {
        return id_rendez_vous;
    }

    public Timestamp getDate_rendez_vous() {
        return date_rendez_vous;
    }

    public int getId_organisme() {
        return id_organisme;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_rendez_vous(int id_rendez_vous) {
        this.id_rendez_vous = id_rendez_vous;
    }

    public void setDate_rendez_vous(Timestamp date_rendez_vous) {
        this.date_rendez_vous = date_rendez_vous;
    }

    public void setId_organisme(int id_organisme) {
        this.id_organisme = id_organisme;
    }

    public void setId_user(int id_formateur) {
        this.id_user = id_formateur;
    
    }
    public void setDuree_Rendezvous(String Duree_Rendezvous) {
        this.Duree_Rendezvous = Duree_Rendezvous;
    }

    public String getDuree_Rendezvous() {
        return Duree_Rendezvous;
    }

    public Rendez_vous(String Duree_Rendezvous, int id_organisme, int id_user) {
        this.Duree_Rendezvous = Duree_Rendezvous;
        this.id_organisme = id_organisme;
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return "Rendez_vous{" + "Longitude=" + Longitude + ", Latitude=" + Latitude + ", id_rendez_vous=" + dateFormat.format(date_rendez_vous) + ", Duree_Rendezvous=" + Duree_Rendezvous + ", date_rendez_vous=" + date_rendez_vous + ", id_organisme=" + id_organisme + ", id_formateur=" + id_user + '}';
    }

    
    

    
   
    
   
   
    
}
