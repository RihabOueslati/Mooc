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

public class Notification 
{
    private int id_notification;
    private String message;
    private String Date;
    private  Cours  id_cours;
    private User id_user;

    public Notification(int id_notification, String message, String Date, Cours id_cours, User id_user) 
    {
        this.id_notification = id_notification;
        this.message = message;
        this.Date = Date;
        this.id_cours = id_cours;
        this.id_user = id_user;
    }

    public Notification() 
    {
    }

    public int getId_notification() {
        return id_notification;
    }

    public void setId_notification(int id_notification) {
        this.id_notification = id_notification;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public Cours getId_cours() {
        return id_cours;
    }

    public void setId_cours(Cours id_cours) {
        this.id_cours = id_cours;
    }

    public User getId_user() {
        return id_user;
    }

    public void setId_user(User id_user) {
        this.id_user = id_user;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.id_notification;
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
        final Notification other = (Notification) obj;
        if (this.id_notification != other.id_notification) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Notification{" + "id_notification=" + id_notification + ", message=" + message + ", Date=" + Date + 
                ", id_cours=" + id_cours + ", id_user=" + id_user + '}';
    }
    
    
   
    
}
