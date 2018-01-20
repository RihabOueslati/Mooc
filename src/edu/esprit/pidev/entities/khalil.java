/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.entities;

import java.util.Objects;

/**
 *
 * @author jihene
 */
public class khalil {

    private int Nombre;
    private String role;

    public khalil(int Nombre, String role) {
        this.Nombre = Nombre;
        this.role = role;
    }

    public khalil() {
    }

    public int getNombre() {
        return Nombre;
    }

    public void setNombre(int Nombre) {
        this.Nombre = Nombre;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.role);
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
        final khalil other = (khalil) obj;
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return "khalil{" + "Nombre=" + Nombre + ", role=" + role + '}';
    }
    
    
}
