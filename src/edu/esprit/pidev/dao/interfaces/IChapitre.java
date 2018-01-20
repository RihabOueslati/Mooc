/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.dao.interfaces;

import edu.esprit.pidev.entities.Chapitre;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Ahmed
 */
public interface IChapitre {
      abstract void AjouterChapitre(Chapitre c)throws SQLException ;
    abstract void ModifierChapitre(Chapitre c,String d)throws SQLException ;
    abstract void SupprimerChapitre(Chapitre c)throws SQLException ;
    abstract Vector<Chapitre> AfficherChapitre()throws SQLException ;
        int findByTitle(String titre) throws SQLException;
    
}
