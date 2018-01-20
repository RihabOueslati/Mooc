/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.pidev.dao.interfaces;

import edu.esprit.pidev.entities.QuizEntrainment;
import java.util.List;

/**
 *
 * @author khalil
 */
public interface IQuizEntrainment {
    public void addQuizEntrainment(QuizEntrainment quiz);
    public void removeQuizEntrainment(int id);
    public  QuizEntrainment FindAllQuizEntrainmentByCours(int idCours);
    public int getIdLastQuiz();
}
