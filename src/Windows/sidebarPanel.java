package Windows;

import Settings.SimulationConfig;

import javax.swing.*;
import java.awt.*;

public class sidebarPanel extends JPanel {


    private SimulationConfig config;
    private JFrame mainMenu;

    public sidebarPanel(int height, SimulationConfig config, JFrame mainMenu){

        setPreferredSize(new Dimension(150, 0));
        setBackground(new Color(30,30,30));

        this.config = config;
        this.mainMenu = mainMenu;

        initSidebar();

    }

    private void initExitButton(){

        JButton exitButton = new JButton("Close");

        Customs.sideBarButton(exitButton);
        add(Box.createRigidArea(new Dimension(0, 16)));

        add(exitButton);

        exitButton.addActionListener(e -> exit());

    }

    private void exit(){

        System.out.println("Closing simulation...");

        SwingUtilities.getWindowAncestor(this).dispose();

    }

    private void initSettingsButton() {

        JButton settingButton = new JButton("Settings");

        Customs.sideBarButton(settingButton);
        add(Box.createRigidArea(new Dimension(0, 16)));

        add(settingButton);

        settingButton.addActionListener(e -> openSettings());

    }

    private void openSettings(){

        System.out.println("Opening settings...");

        new SettingsWindow(config, mainMenu);

    }

    private void initSidebar(){

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(20, 16, 20 ,16));

        initSettingsButton();
        initExitButton();

    }

}
