package mySwing;

import javax.swing.*;
import java.awt.*;

public class Swing03JLabel {
    public static void createGUI(){
        JFrame frame = new JFrame("Swing Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container ctn = frame.getContentPane();
        frame.setLayout(new FlowLayout());

        JLabel jl1 = new JLabel("Test");
        ctn.add(jl1);
        jl1.setText("sadpd");
        jl1.setFont(new Font(Font.DIALOG, 0,20));//style设置粗体下划线什么的
        jl1.setForeground(Color.BLUE);
        jl1.setToolTipText("wdggg");

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