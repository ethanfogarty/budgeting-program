package model;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

public class RenderText extends Noun{

    private String text;
    private int size;

    public RenderText(String text, int size, int x, int y, Color color){
        super(x, y, color);
        this.text = text;
        this.size = size;
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(color);
        g2.setFont(new Font("Courier New", Font.BOLD, size));
        g2.drawString(text, x, y);
    }
    
}
