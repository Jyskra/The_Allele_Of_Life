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

}
