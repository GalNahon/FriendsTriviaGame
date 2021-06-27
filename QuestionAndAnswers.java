package com.company;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import static com.company.GUI.currentTriviaRound;

public class QuestionAndAnswers {
    public String question;

    public  String correctAnswer;
    public  String wrongAnswer1;
    public  String wrongAnswer2;
    public  String wrongAnswer3;

    public QuestionAndAnswers() {
    }

    public static QuestionAndAnswers getNewRandomQuestionAndAnswers(ArrayList<QuestionAndAnswers> arrayList){
        Random random = new Random();
        int index = random.nextInt(arrayList.size());
        QuestionAndAnswers question = arrayList.get(index);
        arrayList.remove(index);
        return question;
    }








}
