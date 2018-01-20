/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.pidev.entities;

import java.util.List;

/**
 *
 * @author khalil
 */
public class QuizEntrainment {

    private int id_QuizEntrainment;
    private String nomQuizEntrainment;
    private int id_Formateur_QuizEntrainment;
    private int id_Cours_QuizEntrainment;
    private List<QuestionQuizEntrainment> list_QuizEntrainment;

    public QuizEntrainment() {
    }

    public QuizEntrainment(int id_QuizEntrainment, String nomQuizEntrainment, int id_Formateur_QuizEntrainment, int id_Cours_QuizEntrainment, List<QuestionQuizEntrainment> list_QuizEntrainment) {
        this.id_QuizEntrainment = id_QuizEntrainment;
        this.nomQuizEntrainment = nomQuizEntrainment;
        this.id_Formateur_QuizEntrainment = id_Formateur_QuizEntrainment;
        this.id_Cours_QuizEntrainment = id_Cours_QuizEntrainment;
        this.list_QuizEntrainment = list_QuizEntrainment;
    }

    public int getId_QuizEntrainment() {
        return id_QuizEntrainment;
    }

    public String getNomQuizEntrainment() {
        return nomQuizEntrainment;
    }

    public int getId_Formateur_QuizEntrainment() {
        return id_Formateur_QuizEntrainment;
    }

    public int getId_Cours_QuizEntrainment() {
        return id_Cours_QuizEntrainment;
    }

    public List<QuestionQuizEntrainment> getList_QuizEntrainment() {
        return list_QuizEntrainment;
    }

    public void setId_QuizEntrainment(int id_QuizEntrainment) {
        this.id_QuizEntrainment = id_QuizEntrainment;
    }

    public void setNomQuizEntrainment(String nomQuizEntrainment) {
        this.nomQuizEntrainment = nomQuizEntrainment;
    }

    public void setId_Formateur_QuizEntrainment(int id_Formateur_QuizEntrainment) {
        this.id_Formateur_QuizEntrainment = id_Formateur_QuizEntrainment;
    }

    public void setId_Cours_QuizEntrainment(int id_Cours_QuizEntrainment) {
        this.id_Cours_QuizEntrainment = id_Cours_QuizEntrainment;
    }

    public void setList_QuizEntrainment(List<QuestionQuizEntrainment> list_QuizEntrainment) {
        this.list_QuizEntrainment = list_QuizEntrainment;
    }

    @Override
    public String toString() {
        return "QuizEntrainment{" + "id_QuizEntrainment=" + id_QuizEntrainment + ", nomQuizEntrainment=" + nomQuizEntrainment + ", id_Formateur_QuizEntrainment=" + id_Formateur_QuizEntrainment + ", id_Cours_QuizEntrainment=" + id_Cours_QuizEntrainment + ", list_QuizEntrainment=" + list_QuizEntrainment + '}';
    }
    
    
    
}
