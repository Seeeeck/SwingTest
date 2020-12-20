package mySwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing05JCheckBox {
    private JFrame frame;
    private Container ctn;
    private JCheckBox jcb;
    private JTextField email;

    public Swing05JCheckBox(){
        frame = new JFrame("TestJCheckBox");
        ctn = frame.getContentPane();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(500,400);
        frame.setVisible(true);

        jcb = new JCheckBox("是否订阅邮件");
        email = new JTextField(10);
        email.setForeground(Color.BLUE);
        ctn.add(jcb);
        ctn.add(email);

        jcb.setSelected(true);
        email.setToolTipText("输入email");
        jcb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jcb.isSelected()){
                    email.setEnabled(true);
                }else{
                    email.setEnabled(false);
                }
            }
        });
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Swing05JCheckBox a =new Swing05JCheckBox();
            }
        });
    }

}
