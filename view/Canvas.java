package view;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Bill;
import model.Noun;
import model.Person;

public class Canvas extends JPanel{

    public static int WIDTH = 700;
    public static int HEIGHT = 500;

    ArrayList<Noun> objects = new ArrayList<Noun>();

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
        
        Person p1 = new Person("Ethan", 12f, "Freddy's", 18f, 200, 100);
        Person p2 = new Person("Sunny", 16f, "Sam's", 30f, 200, 200);
        Bill b1 = new Bill(364f, "Versa Payment", "8", 200, 300, Color.green);

        objects.add(p1);
        objects.add(p2);
        objects.add(b1);

        for(var o: objects){
            o.render(g2);
        }
        
    }

}
