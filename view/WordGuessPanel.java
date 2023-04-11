package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.WordGuessListener;
import model.WordGuessGame;

public class WordGuessPanel {

    public enum GameState{
        READY, PLAYING, LOST, WON
    }

    
    private JFrame window;

    private JButton[] alphabetButtons; 
    private JButton newButton = new JButton("New");
    private JTextField keyField = new JTextField(20);
    private JTextField guessField = new JTextField(20);

    private WordGuessCanvas guessCanvas;
    private WordGuessGame guessGame;
    private GameState gameState;


    public WordGuessPanel(JFrame window){
        this.window = window;
    }

    public void init(){
        final int ALPHABET_SIZE = 26;
        Container cp = window.getContentPane();
        JPanel northPanel = new JPanel();

        northPanel.setLayout(new GridLayout(2, 1));
        northPanel.add(keyField);
        northPanel.add(guessField);

        cp.add(BorderLayout.NORTH, northPanel);
        
        keyField.setFont(new Font("Courier New", Font.BOLD, 18));
        keyField.setForeground(Color.red);
        keyField.setEditable(false);
        
        guessField.setFont(new Font("Courier New", Font.BOLD, 18));
        guessField.setForeground(Color.black);
        guessField.setEditable(false);

        guessCanvas = new WordGuessCanvas(this);
        cp.add(BorderLayout.CENTER, guessCanvas);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(4, 7));

        WordGuessListener wordGuessListener = new WordGuessListener(this);

        alphabetButtons = new JButton[ALPHABET_SIZE];
        for(int i = 0; i < ALPHABET_SIZE; i++){
            alphabetButtons[i] = new JButton("" + (char)('a' + i));
            southPanel.add(alphabetButtons[i]);
            alphabetButtons[i].addActionListener(wordGuessListener);
        }

        newButton.addActionListener(wordGuessListener);
        southPanel.add(newButton);
        cp.add(BorderLayout.SOUTH, southPanel);

        for(var b: alphabetButtons){
            b.setEnabled(false);
        }
    }

    public JFrame getWindow() {
        return window;
    }

    public WordGuessCanvas getGuessCanvas(){
        return guessCanvas;
    }

    public JTextField getKeyField(){
        return keyField;
    }

    public JTextField getGuessField(){
        return guessField;
    }

    public JButton[] getAlphabetButtons(){
        return alphabetButtons;
    }

    public JButton getNewButton() {
        return newButton;
    }

    public GameState getGameState(){
        return gameState;
    }

    public void setGameState(GameState state){
        this.gameState = state;
    }

    public WordGuessGame getGuessGame() {
        return guessGame;
    }

    public void setGuessGame(WordGuessGame guessGame){
        this.guessGame = guessGame;
    }

}
