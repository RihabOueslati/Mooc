/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.dao.interfaces;

import java.util.List;

/**
 *
 * @author Mohamed Salah
 * @param <R>
 */
public interface IReclamationDAO <R>{
  
    void addReclamation(R rec);
    void updateReclamation(R rec, int id);
    void deleteReclamation (int idReclamation);
    List<R> displayAllReclamation();
    R findByIdReclamation(int id);
    
}
    
