/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.dao.interfaces;

import java.util.List;


/**
 *
 * @author Rihab
 */
public interface IDAOM <M> {
    void addmessage(M m);
    void updatemesage (M m);
    void deletmessage (M m);
   // M findById(int id);
    List<M> DisplayAll();
    
}
