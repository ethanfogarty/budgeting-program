package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import model.WordGuessGame;
import view.WordGuessPanel;

public class WordGuessListener implements ActionListener{

    private WordGuessPanel panel;

    public WordGuessListener(WordGuessPanel panel){
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if(button == panel.getNewButton()){
            var guessGame = new WordGuessGame();
            panel.setGuessGame(guessGame);
            panel.setGameState(WordGuessPanel.GameState.PLAYING);
            String key = guessGame.getWord();
            String guess = ".".repeat(key.length());
            panel.getKeyField().setText(key);    
            panel.getGuessField().setText(guess);

            for(var b: panel.getAlphabetButtons()){
                b.setEnabled(true);
            }
            panel.getGuessCanvas().setHealthLevel(guessGame.getHealthLevel());    // Code here and below needs updated from baseball
            panel.getGuessCanvas().repaint();
        } else{
            //Alphabet buttons a-z
            button.setEnabled(false);

            JTextField guessField = panel.getGuessField();
            WordGuessGame guessGame = panel.getGuessGame();
            char character = (button.getText().charAt(0));
            int[] indices = guessGame.findLetter(character);

            if(indices.length == 0) {
                guessGame.setHealthLevel(guessGame.getHealthLevel() - 1);
                if (guessGame.getHealthLevel() == 0) {
                    panel.setGameState(WordGuessPanel.GameState.LOST);
                    for(var b: panel.getAlphabetButtons()){
                        b.setEnabled(false);
                    }
                }
                panel.getGuessCanvas().repaint();
            } else {
                // Set guess string dots to correct letter guessed based on index
                StringBuilder guess = new StringBuilder(guessField.getText());
                for(int i: indices){
                    guess.setCharAt(i, character);
                }
                guessField.setText(guess.toString());
                if(guess.indexOf(".") == -1){
                    panel.setGameState(WordGuessPanel.GameState.WON);
                    for(var b: panel.getAlphabetButtons()){
                        b.setEnabled(false);
                    }
                    panel.getGuessCanvas().repaint();
                }
            }

            // if(clicks == 3){
            //     guessGame.computeBallsStrikes();
            //     int balls = guessGame.getBallCount();
            //     int strikes = guessGame.getStrikeCount();
            //     panel.getCanvas().setBallStrikeCount(balls, strikes);

            //     if(strikes == 3){
            //         panel.setGameState(WordGuessPanel.GameState.GAMEOVER);
            //         for(var b: panel.getDigitButtons()){
            //             b.setEnabled(false);
            //         }
            //     } else{
            //         for(var b: panel.getDigitButtons()){
            //             b.setEnabled(true);
            //         }
            //     }
            //    
            //}
        }
    }
    
}
