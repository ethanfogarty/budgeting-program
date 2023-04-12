package model;

import java.awt.Graphics2D;
import java.util.ArrayList;

import view.RenderText;

import java.awt.Color;

public class Person extends Noun{

    private String name;
    private Float pay;
    private String occupation;
    private Float hoursWeekly;
    private static final int size = 14;


    public Person(String name, Float pay, String occupation, Float hoursWeekly, int x, int y){
        super(x, y, Color.green);
        this.name = name;
        this.pay = pay;
        this.occupation = occupation;
        this.hoursWeekly = hoursWeekly;
    }

    @Override
    public void render(Graphics2D g2) {
        ArrayList<Noun> words = new ArrayList<Noun>();
        RenderText w1 = new RenderText(name, size, x, y, color);
        RenderText w2 = new RenderText(pay.toString(), size, x, y, color);
        RenderText w3 = new RenderText(occupation, size, x, y, color);
        RenderText w4 = new RenderText(hoursWeekly.toString(), size, x, y, color);
        words.add(w1);
        words.add(w2);
        words.add(w3);
        words.add(w4);
        
        for (var word: words){
            word.render(g2);
        }

    }
    
}
