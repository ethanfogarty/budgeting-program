package view;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;

import javax.swing.JPanel;

public class WordGuessCanvas extends JPanel{

    public static int WIDTH = 500;
    public static int HEIGHT = 500;

    private int healthLevel;

    private WordGuessPanel panel;

    public WordGuessCanvas(WordGuessPanel panel) {
        this.panel = panel;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.white);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        
        // Ready to play
        WordGuessPanel.GameState state = panel.getGameState();
        g2.setColor(Color.blue);
        if (state == WordGuessPanel.GameState.PLAYING){
            g2.setFont(new Font("Courier New", Font.BOLD, 40));
            g2.drawString("Health Level", 60, 70);
            // draw squares
            healthLevel = panel.getGuessGame().getHealthLevel();
            for(int i = 0; i < healthLevel; i++){
                g2.fillRect(60 + 55 * i, 95, 50, 50);
            }

        } else {

            g2.setFont(new Font("Courier New", Font.BOLD, 30));
            g2.drawString("Press <New> to Start", 60, 150);

            g2.setColor(Color.red);

            if (state == WordGuessPanel.GameState.LOST){
                g2.drawString("YOU LOST !!!", 60, 100);
            } else if(state == WordGuessPanel.GameState.WON){
                g2.drawString("YOU WON !!!", 60, 100);
            }
            
        }
    }

    public void setHealthLevel(int healthLevel){
        this.healthLevel = healthLevel;
    }

}