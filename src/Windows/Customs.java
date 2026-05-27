package Windows;

import javax.swing.*;
import java.awt.*;

public class Customs {

    public static void mainMenuButtons(JButton button){
        button.setBackground(new Color(255, 255, 255));
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setPreferredSize(new Dimension(150,50));

        button.setFocusPainted(true);
        button.setBorderPainted(true);

        button.setFocusable(false);
    }

    public static void settingsSlider(JSlider slider){

        slider.setMajorTickSpacing(25);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

    }


    public static void settingsButton(JToggleButton button){

        button.setFont(new Font("Arial", Font.BOLD, 11));
        button.setPreferredSize(new Dimension(60, 30));
        button.setFocusable(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        button.setContentAreaFilled(false);

        updateToggleColor(button);

    }

    public static void updateToggleColor(JToggleButton button){

        if (button.isSelected()) {
            button.setBackground(new Color(50, 255, 0));
            button.setForeground(new Color(0, 0, 0));
        } else {
            button.setBackground(new Color(255, 50, 0));
            button.setForeground(new Color(0, 0, 0)); // muted text
        }
    }

}
