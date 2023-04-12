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

public class Panel {
    
    private JFrame window;

    private JButton[] alphabetButtons; 
    private JButton newButton = new JButton("New");
    private JTextField keyField = new JTextField(20);
    private JTextField guessField = new JTextField(20);

    private Canvas canvas;


    public Panel(JFrame window){
        this.window = window;
    }

    public void init(){
        final int ALPHABET_SIZE = 26;
        Container cp = window.getContentPane();

        canvas = new Canvas(this);
        cp.add(BorderLayout.CENTER, canvas);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(4, 7));

        WordGuessListener wordGuessListener = new WordGuessListener(this);

        newButton.addActionListener(wordGuessListener);
        southPanel.add(newButton);
        cp.add(BorderLayout.SOUTH, southPanel);
    }

    public JFrame getWindow() {
        return window;
    }

    public Canvas getCanvas(){
        return canvas;
    }

    public JButton getNewButton() {
        return newButton;
    }

}

