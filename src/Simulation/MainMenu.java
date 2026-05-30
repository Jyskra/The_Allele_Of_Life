package Simulation;

import Settings.SimulationConfig;
import Windows.Customs;
import Windows.SettingsWindow;

import javax.swing.*;
import java.awt.*;

/**
 * class that manages the initial title screen and branches off of it
 */
public class MainMenu extends JFrame {
    private final SimulationConfig config;

    /**
     * initializes the title screen
     */
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

    /**
     * initializes the opening button of the simulation
     */
    private void initOpen(JPanel panel){

        JButton startButton = new JButton("Open");

        Customs.mainMenuButtons(startButton);

        panel.add(startButton, BorderLayout.CENTER);

        startButton.addActionListener(e -> startSimulation());

    }

    private void startSimulation(){

        System.out.println("Starting simulation...");

        new Simulation(config, this);

    }

    /**
     * initializes the exit button that quits the game
     */
    private void initExit(JPanel panel){

        JButton ExitButton = new JButton("Exit");

        Customs.mainMenuButtons(ExitButton);

        panel.add(ExitButton, BorderLayout.CENTER);

        ExitButton.addActionListener(e -> exit());

    }

    private void exit(){

        System.out.println("Exiting...");
        System.exit(0);

    }

    /**
     * initializes the button that opens settings
     */
    private void initSettings(JPanel panel){

        JButton settingsButton = new JButton("Settings");

        Customs.mainMenuButtons(settingsButton);

        panel.add(settingsButton, BorderLayout.CENTER);

        settingsButton.addActionListener(e -> openSettings());

    }

    private void openSettings(){

        System.out.println("Opening settings frame...");

        new SettingsWindow(config, this);

    }

    /**
     * initializes the actual game title
     */
    private void initTitle(JPanel container){

        JLabel title = new JLabel("The Allele Of Life", SwingConstants.CENTER);
        title.setFont(new Font("Georgia", Font.BOLD, 52));
        title.setForeground(new Color(99, 202, 183));
        container.add(title, BorderLayout.CENTER);
    }


    /**
     * uses all the above-mentioned methods
     */
    private void initUI(){

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(20, 20, 28));

        initTitle(panel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setBackground(new Color(20, 20, 28));
        initOpen(buttonPanel);
        initSettings(buttonPanel);
        initExit(buttonPanel);

        panel.add(buttonPanel, BorderLayout.SOUTH);
        add(panel);
    }

}
