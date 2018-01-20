/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.pidev.dao.classes;

import edu.esprit.pidev.util.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jihene
 */
public class khalilDAO {
    private Connection connection;

    public khalilDAO() {
        connection = MyConnection.getInstance().getConnection();

    }

    public List<Integer> GetNombre() {

        List<Integer> listeStat = new ArrayList<>();

        String requete = "select * from `khalil`";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                listeStat.add(resultat.getInt(2));
            }

            return listeStat;
        } catch (SQLException ex) {
            System.out.println("erreur  " + ex.getMessage());
            return null;
        }
    }

    public List<String> GetRole() {

        List<String> list = new ArrayList<>();

        String requete = "select * from `khalil`";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
               
                list.add(resultat.getString(1));
                
            }
            return list;
        } catch (Exception ex) {

            System.out.println("erreur  " + ex.getMessage());
            return null;
        }
    }
}
