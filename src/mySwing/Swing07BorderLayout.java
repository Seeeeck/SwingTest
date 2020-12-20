package mySwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * 边界布局
 */
public class Swing07BorderLayout {
    private JFrame frame;
    private Container ctn;

    public Swing07BorderLayout(){
        frame = new JFrame("TestJCheckBox");
        ctn = frame.getContentPane();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(500,400);
        frame.setVisible(true);

        JLabel a1 = new ColorLabel("1",Color.RED);
        JLabel a2 = new ColorLabel("2",Color.BLUE);
        JLabel a3 = new ColorLabel("3",Color.YELLOW);
        JLabel a4 = new ColorLabel("4",Color.PINK);
        JLabel a5 = new ColorLabel("5",Color.CYAN);
        //上下边界只能调节高度
        a1.setPreferredSize(new Dimension(0,80));
        //左右边界只能调节宽度
        a3.setPreferredSize(new Dimension(100,0));

        ctn.add(a1,BorderLayout.PAGE_START);
        ctn.add(a2,BorderLayout.PAGE_END);
        ctn.add(a3,BorderLayout.LINE_START);
        ctn.add(a4,BorderLayout.LINE_END);
        ctn.add(a5,BorderLayout.CENTER);





    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Swing07BorderLayout();
            }
        });
    }

}