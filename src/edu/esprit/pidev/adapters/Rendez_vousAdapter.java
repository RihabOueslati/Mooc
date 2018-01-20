/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.pidev.adapters;

import edu.esprit.pidev.dao.classes.Rendez_vousDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import edu.esprit.pidev.entities.Rendez_vous;
import edu.esprit.pidev.dao.interfaces.Irendez_vousDAO;

/**
 *
 * @author Rihab
 */
public class Rendez_vousAdapter  extends AbstractTableModel {

   static String role;
    static int id_user ;
    String[] headers = {"date rdv", "duree"};
    List<Rendez_vous> lstrendezvous= new ArrayList<>();
    Irendez_vousDAO rdvDAO;

    public Rendez_vousAdapter(String rol,int id_use) {
        this.role=rol;
        this.id_user=id_use;
        
        System.out.println(role);
        System.out.println(id_user);
    
        if (role.equals("formateur")) {
           rdvDAO = new Rendez_vousDAO();
        lstrendezvous = rdvDAO.findRendez_vousByFormateur(id_user);
            System.out.println(listenerList);
        }
        if (role.equals("organisme")) {
                rdvDAO = new Rendez_vousDAO();
        lstrendezvous = rdvDAO.findRendez_vousByOrganisme(id_user);
            }

    }

    public int[] TabId(){ 
        
         List<Rendez_vous> rend1 = new ArrayList<>();
         int[] tab_id;
        if (role.equals("formateur")) {
          
        rend1 = rdvDAO.findRendez_vousByFormateur(id_user);
         tab_id = new int[rend1.size()];       
        for (int j=0;j<= rend1.size()-1;j++){
         
            tab_id[j]= rend1.get(j).getId_rendez_vous(); 
        }
         return tab_id;
        
        }
            if (role.equals("organisme")) {
              
        rend1 = rdvDAO.findRendez_vousByOrganisme(id_user);
         tab_id = new int[rend1.size()];       
        for (int j=0;j<= rend1.size()-1;j++){
         
            tab_id[j]= rend1.get(j).getId_rendez_vous();
            
        }
        
        return tab_id;
        
          }
       return null;
        
      
       
    }
    @Override
    public int getRowCount() {
        return lstrendezvous.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return lstrendezvous.get(rowIndex).getDate_rendez_vous();
            case 1:
               return lstrendezvous.get(rowIndex).getDuree_Rendezvous();
           
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int i) {
        return headers[i];
    }

    
}
