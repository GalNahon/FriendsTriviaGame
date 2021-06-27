package com.company;

import javax.swing.*;
import java.awt.*;

public class GUI {
    private static JFrame frame;
    private static JPanel pnlQuestionAndAnswers, pnlQuestion, pnlAnswers, pnlTime, gameMode;
    private static JLabel lblQuestion, timeLeft;

    protected static int currentScore;
    protected static QuestionAndAnswers currentTriviaRound;
    private static JPanel panel;



    public GUI(int isFirstGame, QuestionAndAnswers newTriviaQuestion) {
        currentTriviaRound = newTriviaQuestion;

        if (isFirstGame == 1) {
            currentScore = 0;
            frame = new JFrame("Trivia");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 450);
            panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        }
        pnlQuestionAndAnswers = new JPanel();
        pnlQuestion = new JPanel();
        pnlAnswers = new JPanel();

        pnlQuestion.add(new JLabel("question: "));
        pnlQuestion.add(new JLabel(newTriviaQuestion.question));
        panel.add(pnlQuestion);


        pnlAnswers.add(new JLabel("answers: "));
        new Buttons();
        pnlAnswers.add(Buttons.cmdSubmitFirstAnswer);
        pnlAnswers.add(Buttons.cmdSubmitSecondAnswer);
        pnlAnswers.add(Buttons.cmdSubmitThirdAnswer);
        pnlAnswers.add(Buttons.cmdSubmitFourthAnswer);
        panel.add(pnlAnswers);

        pnlTime = new JPanel();
        pnlTime.add(new JLabel("Time Left:"));
        new GameTimer();
        pnlTime.add(GameTimer.lblTimeLeft);
        panel.add(pnlTime);



        gameMode = new JPanel();
        gameMode.add(Buttons.cmdStartNewGame);
        gameMode.add(Buttons.cmdEndGame);

//        paintComponent = new TriviaPaintComponent();
        frame.add(panel, BorderLayout.NORTH);
//        frame.add(paintComponent, BorderLayout.CENTER);
        frame.add(gameMode, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
//
  public static void clearPanel() {
      frame.revalidate();
      frame.repaint();
      panel.removeAll();
      panel.revalidate();
      panel.repaint();
  }
//

}


