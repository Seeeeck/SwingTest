package mySwing;

import javax.swing.*;
import java.awt.*;

public class ColorLabel extends JLabel {

    public ColorLabel(String text,  Color color) {
        super(text);
        setOpaque(true);
        setBackground(color);
        setPreferredSize(new Dimension(60,30));
        setHorizontalAlignment(SwingConstants.CENTER);
    }
}
