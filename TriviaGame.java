package com.company;

import javax.swing.*;
import java.util.ArrayList;

public class TriviaGame {
    private static int isFirstGame = 1;
    protected static ArrayList<QuestionAndAnswers> friendsQuestionAndAnswersList;

    public static void firstGame(ArrayList<QuestionAndAnswers> questionAndAnswersArrayList){

        QuestionAndAnswers newQuestion = QuestionAndAnswers.getNewRandomQuestionAndAnswers(questionAndAnswersArrayList);
        friendsQuestionAndAnswersList = questionAndAnswersArrayList;
        if(isFirstGame == 1){
            new GUI(isFirstGame, newQuestion);
            isFirstGame = 0;
        }
    }

    public static void newGame(){
        if(friendsQuestionAndAnswersList.size() == 0) {
            JOptionPane.showMessageDialog(null, "Game Over!\nNo more questions\nFinal Score Is: "
                    + GUI.currentScore, "Game Over", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }else {
            QuestionAndAnswers newQuestion = QuestionAndAnswers.getNewRandomQuestionAndAnswers(friendsQuestionAndAnswersList);
            new GUI(isFirstGame, newQuestion);
        }
    }
}


