package model;

import java.awt.Color;
import java.awt.Graphics2D;

public class Day extends Noun implements Square{

    Float wantsBudget;
    int dayNumber;
    String weekday;

    public Day(Float wantsBudget, int dayNumber, String weekday, int x, int y, Color color){
        super(x, y, color);
        this.wantsBudget = wantsBudget;
        this.dayNumber = dayNumber;
        this.weekday = weekday;
    }


    @Override
    public void squareDraw(Graphics2D g2) {
    }

    @Override
    public void render(Graphics2D g2) {
    }
    
}
