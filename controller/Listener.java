package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.Panel;

public class Listener implements ActionListener{

    private Panel panel;

    public Listener(Panel panel){
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == panel.getExitButton()){
            System.exit(0);
        } else if (button == panel.getAddBillButton()){
            System.out.println("Add Bill Clicked");
        } else if (button == panel.getAddPersonButton()){
            System.out.println("Add Person Clicked");
        }
    }
    
}
