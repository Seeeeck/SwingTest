package mySwing;

import javax.swing.*;
import java.awt.*;

public class Swing01 {
    public static void createGUI(){
        JFrame frame = new JFrame("Swing Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container ctpane = frame.getContentPane();
        ctpane.setLayout(new FlowLayout());

        ctpane.add(new JLabel("Title"));
        ctpane.add(new JButton("Test"));

        frame.setSize(400,300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGUI();
            }
        });
    }
}