package model;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.Color;

public class Bill extends Noun{

    private Float cost;
    private String name;
    private String dueDate;
    private static final int size = 10;
    private static Color color = Color.green;

    public Bill(Float cost, String name, String dueDate, int x, int y){
        super(x, y, color);
        this.cost = cost;
        this.name = name;
        this.dueDate = dueDate;
    }

    @Override
    public void render(Graphics2D g2) {
        ArrayList<Noun> words = new ArrayList<Noun>();
        RenderText w1 = new RenderText(name, size, x, y, color);
        RenderText w2 = new RenderText(cost.toString(), size, x, y + 10, color);
        RenderText w3 = new RenderText(dueDate, size, x, w2.y + 10, color);
        words.add(w1);
        words.add(w2);
        words.add(w3);
        
        for (var word: words){
            word.render(g2);
        }
    }
    
}
