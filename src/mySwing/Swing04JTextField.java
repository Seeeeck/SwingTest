package mySwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing04JTextField {
    JFrame frame;
    Container ctn;
    JLabel label;
    JTextField textfield;
    JButton button;
    public Swing04JTextField(){
        frame = new JFrame("Swing Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ctn = frame.getContentPane();
        frame.setLayout(new FlowLayout());

        label = new JLabel("name:");
        //数字用于计算文字框的显示宽度
        textfield = new JTextField(16);
        button = new JButton("yes");
        ctn.add(label);
        ctn.add(textfield);
        ctn.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onButtonOk();
            }
        });

        frame.setSize(400,300);
        frame.setVisible(true);
    }

    private void onButtonOk(){
        String str = textfield.getText();
        JOptionPane.showMessageDialog(ctn,"输入了:"+str);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Swing04JTextField a = new Swing04JTextField();
            }
        });
    }
}