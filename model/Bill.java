package model;

import java.awt.Graphics2D;
import java.util.ArrayList;

import view.RenderText;

import java.awt.Color;

public class Bill extends Noun{

    private Float cost;
    private String name;
    private String dueDate;
    private static final int size = 14;

    public Bill(Float cost, String name, String dueDate, int x, int y, Color color){
        super(x, y, color);
        this.cost = cost;
        this.name = name;
        this.dueDate = dueDate;
    }

    @Override
    public void render(Graphics2D g2) {
        ArrayList<Noun> words = new ArrayList<Noun>();
        RenderText w1 = new RenderText(name, size, x, y, color);
        RenderText w2 = new RenderText(cost.toString(), size, x, y, color);
        RenderText w3 = new RenderText(dueDate, size, x, y, color);
        words.add(w1);
        words.add(w2);
        words.add(w3);
        
        for (var word: words){
            word.render(g2);
        }
    }
    
}
