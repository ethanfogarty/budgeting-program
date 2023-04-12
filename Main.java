import javax.swing.JFrame;

import view.Panel;

public class Main{

    public static void main(String[] args){

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(400, 100);
        window.setTitle("Budget Program");

        var panel = new Panel(window);
        panel.init();

        window.pack();
        window.setVisible(true);
    }
}