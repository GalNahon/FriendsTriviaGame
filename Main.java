package com.company;
import javax.swing.*;
import java.util.*;


import java.lang.*;
import java.io.FileNotFoundException;

public class Main {
    final static String friendsFilePath
            = "C:\\mmn13_q2\\src\\com\\company\\FriendsQuestionsFile.txt";




    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<QuestionAndAnswers> FriendsFile = ReadQAFromFile.HashMapFromTextFile(friendsFilePath);
        if(FriendsFile.isEmpty())
            JOptionPane.showMessageDialog(null, "error in reading questions and answers file! ", "File error", JOptionPane.ERROR_MESSAGE);
        TriviaGame.firstGame(FriendsFile);
    }
}
