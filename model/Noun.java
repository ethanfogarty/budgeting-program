package model;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Noun {
    
    public int x;
    public int y;
    public Color color;

    public Noun(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Noun(){
        this(0, 0, Color.white);
    }

    public abstract void render(Graphics2D g2);

}
