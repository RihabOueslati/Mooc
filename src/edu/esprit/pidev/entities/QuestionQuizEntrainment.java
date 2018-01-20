/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.pidev.entities;

/**
 *
 * @author khalil
 */
public class QuestionQuizEntrainment {
    private int id_QuestionQuizEntrainment;
    private int id_QuizEntrainment;
    private String Question;
    private String Reponse1;
    private String Reponse2;
    private String Reponse3;
    private String Reponse4;

    public QuestionQuizEntrainment() {
    }

    public QuestionQuizEntrainment(int id_QuestionQuizEntrainment, int id_QuizEntrainment, String Question, String Reponse1, String Reponse2, String Reponse3, String Reponse4) {
        this.id_QuestionQuizEntrainment = id_QuestionQuizEntrainment;
        this.id_QuizEntrainment = id_QuizEntrainment;
        this.Question = Question;
        this.Reponse1 = Reponse1;
        this.Reponse2 = Reponse2;
        this.Reponse3 = Reponse3;
        this.Reponse4 = Reponse4;
    }

    public int getId_QuestionQuizEntrainment() {
        return id_QuestionQuizEntrainment;
    }

    public int getId_QuizEntrainment() {
        return id_QuizEntrainment;
    }

    public String getQuestion() {
        return Question;
    }

    public String getReponse1() {
        return Reponse1;
    }

    public String getReponse2() {
        return Reponse2;
    }

    public String getReponse3() {
        return Reponse3;
    }

    public String getReponse4() {
        return Reponse4;
    }

    public void setId_QuestionQuizEntrainment(int id_QuestionQuizEntrainment) {
        this.id_QuestionQuizEntrainment = id_QuestionQuizEntrainment;
    }

    public void setId_QuizEntrainment(int id_QuizEntrainment) {
        this.id_QuizEntrainment = id_QuizEntrainment;
    }

    public void setQuestion(String Question) {
        this.Question = Question;
    }

    public void setReponse1(String Reponse1) {
        this.Reponse1 = Reponse1;
    }

    public void setReponse2(String Reponse2) {
        this.Reponse2 = Reponse2;
    }

    public void setReponse3(String Reponse3) {
        this.Reponse3 = Reponse3;
    }

    public void setReponse4(String Reponse4) {
        this.Reponse4 = Reponse4;
    }

    @Override
    public String toString() {
        return "QuestionQuizEntrainment{" + "id_QuestionQuizEntrainment=" + id_QuestionQuizEntrainment + ", id_QuizEntrainment=" + id_QuizEntrainment + ", Question=" + Question + ", Reponse1=" + Reponse1 + ", Reponse2=" + Reponse2 + ", Reponse3=" + Reponse3 + ", Reponse4=" + Reponse4 + '}';
    }
    
    
}
