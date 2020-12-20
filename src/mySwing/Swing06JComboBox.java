package mySwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * 下拉选择列表
 */
public class Swing06JComboBox {
    private JFrame frame;
    private Container ctn;
    private JComboBox<String> colorList;
    private JLabel label;

    public Swing06JComboBox(){
        frame = new JFrame("TestJCheckBox");
        ctn = frame.getContentPane();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(500,400);
        frame.setVisible(true);

        colorList = new JComboBox<>();
        colorList.addItem("Black");
        colorList.addItem("Blue");
        colorList.addItem("Red");
        colorList.setSelectedItem("Black");
        label = new JLabel("This is a sample");
        ctn.add(colorList);
        ctn.add(label);
        colorList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(colorList.getSelectedIndex()){
                    case 0:
                        label.setForeground(Color.BLACK);
                        break;
                    case 1:
                        label.setForeground(Color.BLUE);
                        break;
                    case 2:
                        label.setForeground(Color.RED);
                        break;
                }
            }
        });

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Swing06JComboBox a =new Swing06JComboBox();
            }
        });
    }

}