package com.company;
import java.io.*;
import java.util.*;

public class ReadQAFromFile {

    public static ArrayList<QuestionAndAnswers> HashMapFromTextFile(String filePath) {
        ArrayList<QuestionAndAnswers> QuestionAndAnswersArrayList = new ArrayList<QuestionAndAnswers>();
            BufferedReader br = null;


            try {

                File file = new File(filePath);
                br = new BufferedReader(new FileReader(file));
                String line = null;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split("\\?");
                    QuestionAndAnswers questionAndAnswers = new QuestionAndAnswers();
                    questionAndAnswers.question = parts[0].trim();
                    String allAnswers = parts[1].trim();
                    String[] answersSplit = allAnswers.split(",");
                    questionAndAnswers.correctAnswer = answersSplit[0].trim();
                    questionAndAnswers.wrongAnswer1 = answersSplit[1].trim();
                    questionAndAnswers.wrongAnswer2 = answersSplit[2].trim();
                    questionAndAnswers.wrongAnswer3 = answersSplit[3].trim();

                    QuestionAndAnswersArrayList.add(questionAndAnswers);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                // Always close the BufferedReader
                if (br != null) {
                    try {
                        br.close();
                    }
                    catch (Exception e) {
                    };
                }
            }
            return QuestionAndAnswersArrayList;
        }

}
