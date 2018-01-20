/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.dao.interfaces;

import static java.awt.PageAttributes.MediaType.C;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface IDAO<C> {
    
    
    void addCommentaire (C c );
    void updateCommentaire (C c );
    void remove ( C c );
    List<C> displayAll ();
    C findCommentbyIdUser (int id );
    
}
