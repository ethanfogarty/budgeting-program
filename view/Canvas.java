package view;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Canvas extends JPanel{

    public static int WIDTH = 700;
    public static int HEIGHT = 500;

    private Panel panel;

    public Canvas(Panel panel) {
        this.panel = panel;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.black);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        
    }

}
