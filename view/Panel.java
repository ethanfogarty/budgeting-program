package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Listener;

public class Panel {
    
    private JFrame window;

    private JButton addBillButton = new JButton("Add Bill");
    private JButton addPersonButton = new JButton("Add Person");
    private JButton exitButton = new JButton("Exit");

    private Canvas canvas;

    public Panel(JFrame window){
        this.window = window;
    }

    public void init(){
        Container cp = window.getContentPane();

        canvas = new Canvas(this);
        cp.add(BorderLayout.CENTER, canvas);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(1, 3));

        Listener listener = new Listener(this);
        addBillButton.addActionListener(listener);
        addPersonButton.addActionListener(listener);
        exitButton.addActionListener(listener);

        southPanel.add(addPersonButton);
        southPanel.add(addBillButton);
        southPanel.add(exitButton);
        cp.add(BorderLayout.SOUTH, southPanel);
    }

    public JFrame getWindow() {
        return window;
    }

    public Canvas getCanvas(){
        return canvas;
    }

    public JButton getAddPersonButton() {
        return addPersonButton;
    }

    public JButton getAddBillButton() {
        return addBillButton;
    }

}

