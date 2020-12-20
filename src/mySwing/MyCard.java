package mySwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class MyCard extends JFrame {
    private Container ctn;
    private JLabel titleL;
    private JLabel memoL;
    private JButton reSetText;
    private JTextField titleTF;
    private JTextField memoTF;
    private JButton confirm;
    private String memo;

    public MyCard(String title){
        super(title);
        ctn =  getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CardLayout cardLayout = new CardLayout();
        setLayout(cardLayout);
        setVisible(true);
        setSize(300,100);

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        ctn.add(p1,"Text");
        ctn.add(p2,"InPut");
        cardLayout.show(ctn,"InPut");

        //p1
        p1.setLayout(new FlowLayout());
        titleL = new JLabel("");
        memoL = new JLabel("");
        reSetText = new JButton("修正");
        p1.add(titleL);
        p1.add(reSetText);
        p1.add(memoL);
        titleL.setPreferredSize(new Dimension(200,25));
        memoL.setPreferredSize(new Dimension(280,30));
        titleL.setFont(new Font(Font.DIALOG,Font.BOLD,14));
        memoL.setForeground(Color.GRAY);
        /*
        titleL.setOpaque(true);
        memoL.setOpaque(true);
        titleL.setBackground(Color.YELLOW);
        memoL.setBackground(Color.CYAN);

         */
        reSetText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeCard2();
            }
        });

        //p2
        p2.setLayout(new FlowLayout());
        titleTF = new JTextField(13);
        memoTF = new JTextField(20);
        titleTF.setToolTipText("タイトルを入力してください");
        memoTF.setToolTipText("メモです");
        confirm = new JButton("確認");
        p2.add(titleTF);
        p2.add(confirm);
        p2.add(memoTF);

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeCard1();
            }
        });
    }
    //把Text换成InPut
    private void changeCard2(){
        CardLayout clo = (CardLayout)ctn.getLayout();
        clo.show(ctn,"InPut");

    }
    //把InPut换成Text并更换LabelText
    private void changeCard1(){
        CardLayout clo = (CardLayout)ctn.getLayout();
        titleL.setText(titleTF.getText());
        memo = memoTF.getText();
        memoL.setText(fixText(memo));
        clo.show(ctn,"Text");
    }

    public static String fixText(String str){
        if (str.length() >21){
            String str1 = str.substring(0,21);
            String str2 = str.substring(21,str.length());
            return "<html>"+str1+"<br/>"+str2+"</html>";
        }else{
            return str;
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyCard("Mycard");
            }
        });
    }

}
