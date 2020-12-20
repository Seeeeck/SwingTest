package mySwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyFrame extends JFrame{
    JLabel timeLabel = new JLabel("00:00:00");
    JButton button = new JButton("showtime");

    public MyFrame(String title){
        super(title);

        Container ctn = getContentPane();
        ctn.setLayout(new FlowLayout());

        ctn.add(button);
        ctn.add(timeLabel);
        //匿名内部类
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showtime();
            }
        });
        /*
        //lamda表达
        button.addActionListener((e) -> showtime());
         */
    }

    public void showtime(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String timestr = sdf.format(new Date());
        timeLabel.setText(timestr);
    }

    private class MyButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("按钮被点击");
            MyFrame.this.showtime();
        }
    }
}
