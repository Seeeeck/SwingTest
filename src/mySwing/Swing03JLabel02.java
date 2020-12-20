package mySwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing03JLabel02 {
    private JFrame frame;
    private Container ctn;
    private JLabel label;


    public Swing03JLabel02(){
        frame = new JFrame("TestJCheckBox");
        ctn = frame.getContentPane();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(500,400);
        frame.setVisible(true);

        label = new JLabel("<html>Hello World!<br/>blahblahblah</html>", SwingConstants.CENTER);
        //设置不透明
        label.setOpaque(true);
        label.setBackground(Color.RED);
        //设置最佳大小
        label.setPreferredSize(new Dimension(90,30));
        //设置居中
        label.setHorizontalAlignment(SwingConstants.CENTER);
        ctn.add(label);

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Swing03JLabel02();
            }
        });
    }

}
