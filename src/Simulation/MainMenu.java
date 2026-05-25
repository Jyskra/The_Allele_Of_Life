package Simulation;

import Settings.SimulationConfig;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
    private final SimulationConfig config;

    public MainMenu(SimulationConfig config){
        this.config = config;

        setTitle("The Allele Of Life - Main menu");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        initUI();

        setVisible(true);
    }


    private void initUI(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("The Allele Of Life");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton startButton    = new JButton("Start Simulation");
        JButton settingsButton = new JButton("Settings");
        JButton helpButton     = new JButton("Help");

        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        settingsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        helpButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalGlue()); // pushes content to center
        panel.add(title);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // spacing
        panel.add(startButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(settingsButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(helpButton);
        panel.add(Box.createVerticalGlue());

        add(panel);

        //add listeners
    }

}
