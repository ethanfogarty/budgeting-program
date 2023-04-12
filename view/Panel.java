package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Listener;

public class Panel {
    
    private JFrame window;
    private Canvas canvas;

    private JButton addBillButton = new JButton("Add Bill");
    private JButton addPersonButton = new JButton("Add Person");
    private JButton exitButton = new JButton("Exit");

    public Panel(JFrame window){
        this.window = window;
    }

    public void init(){
        Container cp = window.getContentPane();

        //Adding a canvas to the center of the window
        canvas = new Canvas(this);
        cp.add(BorderLayout.CENTER, canvas);

        //Creating the south panel
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(1, 3));

        //Adding action listeners to the buttons on south panel
        Listener listener = new Listener(this);
        addBillButton.addActionListener(listener);
        addPersonButton.addActionListener(listener);
        exitButton.addActionListener(listener);

        //Removing the ability to focus on buttons when clicked
        addBillButton.setFocusable(false);
        addPersonButton.setFocusable(false);
        exitButton.setFocusable(false);

        // Adding all buttons to South panel
        southPanel.add(addPersonButton);
        southPanel.add(addBillButton);
        southPanel.add(exitButton);
        
        //Adding south panel to the window
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

    public JButton getExitButton() {
        return exitButton;
    }

}

