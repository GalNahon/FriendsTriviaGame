package com.company;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;




public class Buttons {
    protected static JButton cmdStartNewGame, cmdEndGame;
    protected static JRadioButton cmdSubmitFirstAnswer, cmdSubmitSecondAnswer, cmdSubmitThirdAnswer, cmdSubmitFourthAnswer;
    private static String answerLabel;
    static ArrayList<String> stringAnswersList = new ArrayList<>();
    static ArrayList<JRadioButton> answersButtonList = new ArrayList<>();

    public Buttons() {
        cmdSubmitFirstAnswer = new JRadioButton();
        cmdSubmitSecondAnswer = new JRadioButton();
        cmdSubmitThirdAnswer = new JRadioButton();
        cmdSubmitFourthAnswer = new JRadioButton();


        fillAnswerButtonsWithRandomAnswer(GUI.currentTriviaRound);


        cmdStartNewGame = new JButton("Start new game");
        cmdEndGame = new JButton("End game");

       for (JRadioButton button: answersButtonList) {
           button.addActionListener(new ButtonListener());

       }

       cmdEndGame.addActionListener(new ButtonListener());
       cmdStartNewGame.addActionListener(new ButtonListener());
    }


        private static class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            GameTimer.roundTimer.stop();
            if (e.getSource() == cmdSubmitFirstAnswer || e.getSource() == cmdSubmitSecondAnswer || e.getSource() == cmdSubmitThirdAnswer ||e.getSource() == cmdSubmitFourthAnswer) {
                if (e.getActionCommand().equals(GUI.currentTriviaRound.correctAnswer)) {
                    GUI.currentScore = GUI.currentScore + 10;
                    JOptionPane.showMessageDialog(null, "Correct Answer!\n Current Score Is: " + GUI.currentScore, "Correct Answer", JOptionPane.INFORMATION_MESSAGE);
                }else if (e.getActionCommand().equals(GUI.currentTriviaRound.wrongAnswer1) || e.getActionCommand().equals(GUI.currentTriviaRound.wrongAnswer2) || e.getActionCommand().equals(GUI.currentTriviaRound.wrongAnswer3)){
                    GUI.currentScore = GUI.currentScore - 5;
                    JOptionPane.showMessageDialog(null, "Wrong Answer!\nThe correct Answer Was " + GUI.currentTriviaRound.correctAnswer +
                        "\nCurrent Score Is: "  + GUI.currentScore, "Wrong Answer", JOptionPane.ERROR_MESSAGE);
                }
                JOptionPane.showMessageDialog(null, "The round is over,\n you can choose to play another game or stop the game", "Game Options", JOptionPane.INFORMATION_MESSAGE);
            }

            if (e.getActionCommand().equals("Start new game")) {
                GUI.clearPanel();
                Buttons.clearLists();
                TriviaGame.newGame();

            }

            if (e.getActionCommand().equals("End game"))
                System.exit(0);

        }
    }

    private static void clearLists() {
        stringAnswersList.clear();
        answersButtonList.clear();
    }


    public static void fillAnswerButtonsWithRandomAnswer(QuestionAndAnswers answers) {

        answersButtonList.add(cmdSubmitFirstAnswer);
        answersButtonList.add(cmdSubmitSecondAnswer);
        answersButtonList.add(cmdSubmitThirdAnswer);
        answersButtonList.add(cmdSubmitFourthAnswer);

        stringAnswersList.add(answers.correctAnswer);
        stringAnswersList.add(answers.wrongAnswer1);
        stringAnswersList.add(answers.wrongAnswer2);
        stringAnswersList.add(answers.wrongAnswer3);

        Random random = new Random();
        for (JRadioButton answerButton : answersButtonList) {
            int index = random.nextInt(stringAnswersList.size());
            answerLabel = stringAnswersList.get(index);
            answerButton.setText(answerLabel);
            stringAnswersList.remove(index);
        }

    }
}



