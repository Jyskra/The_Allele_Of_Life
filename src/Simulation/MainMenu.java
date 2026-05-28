package Simulation;

import Settings.SimulationConfig;
import Windows.Customs;
import Windows.SettingsWindow;

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


    private void initUI(){

        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setLayout(new BorderLayout());

        JPanel panel = new JPanel();

        backgroundLabel.add(panel, BorderLayout.SOUTH);

        initOpen(panel);
        initSettings(panel);
        initExit(panel);

        add(backgroundLabel);

        //add listeners
    }

}
