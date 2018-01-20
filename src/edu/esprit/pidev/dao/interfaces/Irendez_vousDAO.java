/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.pidev.dao.interfaces;

import edu.esprit.pidev.entities.Rendez_vous;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author khalil
 */
public interface Irendez_vousDAO {
     void addRendez_vous(Rendez_vous rdv);
    void removeDAO(int id_rdv);
    void update(Timestamp date_rdv,String d,int id_red);
    List<Rendez_vous> FindAllrendez_vous();
    public  List<Rendez_vous> findRendez_vousByFormateur(int id_formateur) ;
     public  List<Rendez_vous> findRendez_vousByOrganisme(int id_Organisme) ;
    public Rendez_vous FindLonLatByIdRdv(int id_rdv);
 
    
}
