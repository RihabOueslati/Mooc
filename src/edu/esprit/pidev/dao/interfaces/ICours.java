/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.dao.interfaces;

import edu.esprit.pidev.entities.Cours;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Rihab
 */
public interface ICours {
    abstract void AjouterCours(Cours c)throws SQLException ;
    abstract void ModifierCours(Cours c,String d)throws SQLException ;
    abstract void SupprimerCours(int id)throws SQLException ;
    abstract void SupprimerCours(Cours c)throws SQLException ;
    abstract Vector<Cours> AfficherCours()throws SQLException ;
    abstract Vector<Cours> AfficherCoursByCategory(String cat);
        int findByTitle(String titre) throws SQLException;
        Cours GetCourByTitle(String titre) throws SQLException;
        void valider (int id);
}
