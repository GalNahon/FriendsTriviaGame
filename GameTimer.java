package com.company;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameTimer extends JPanel {
    protected static Timer roundTimer;
    private static int timeLeft;
    public static JLabel lblTimeLeft;
    private static final int secondInMillisecond = 1000;

    public GameTimer() {
        roundTimer = new Timer(secondInMillisecond, new GameTimer.TimerListener());
        roundTimer.stop();
        timeLeft = 10;
        roundTimer.start();
        lblTimeLeft = new JLabel();
        lblTimeLeft.setText(String.valueOf(timeLeft));
    }



   private static class TimerListener implements ActionListener {

       public void actionPerformed(ActionEvent e) {
           if (timeLeft == 0){
               roundTimer.stop();
               timeLeft = 10;
               JOptionPane.showMessageDialog(null, "Time is up!\ncurrent score: " + GUI.currentScore, "Time is up", JOptionPane.ERROR_MESSAGE);
           } else{
               timeLeft --;
           }
           lblTimeLeft.setText(String.valueOf(timeLeft));
       }
    }
}

