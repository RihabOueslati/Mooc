/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.pidev.entities;

import edu.esprit.pidev.dao.interfaces.*;
import edu.esprit.pidev.entities.QuestionQuizEntrainment;
import java.util.List;

/**
 *
 * @author khalil
 */
public interface IQuestionQuizEntrainment {
    public void addQuestionQuizEntrainment(QuestionQuizEntrainment question);
    public void removeQuestionQuizEntrainment(int id_Question);
    public List<QuestionQuizEntrainment> findAllQuestionByIdQuiz(int id_Quiz);
}
