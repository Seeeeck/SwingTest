package mySwing;

import javax.swing.*;
import javax.swing.text.html.Option;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * 下拉选择列表
 */
public class Swing06JComboBox02 {
    private JFrame frame;
    private Container ctn;
    private JComboBox<OptionItem> colorList;
    private JLabel label;

    public Swing06JComboBox02(){
        frame = new JFrame("TestJCheckBox");
        ctn = frame.getContentPane();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(500,400);
        frame.setVisible(true);

        colorList = new JComboBox<>();
        colorList.addItem(new OptionItem("Black",Color.BLACK));
        colorList.addItem(new OptionItem("Blue",Color.BLUE));
        colorList.addItem(new OptionItem("Red",Color.RED));
        label = new JLabel("This is a sample");
        ctn.add(colorList);
        ctn.add(label);
        colorList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OptionItem item = (OptionItem)colorList.getSelectedItem();
                label.setForeground(item.color);
            }
        });

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Swing06JComboBox02 a =new Swing06JComboBox02();
            }
        });
    }

}

class OptionItem{
    String text;
    Color color;

    public OptionItem(String text, Color color) {
        this.text = text;
        this.color = color;
    }

    @Override
    public String toString() {
        return this.text;
    }
}