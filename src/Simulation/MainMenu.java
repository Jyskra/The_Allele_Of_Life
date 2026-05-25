package Simulation;

import Settings.SimulationConfig;

import javax.swing.*;

public class MainMenu extends JFrame {
    private final SimulationConfig config;

    public MainMenu(SimulationConfig config){
        this.config = config;

        setTitle("The Allele Of Life - Main menu");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        //initUI
    }


}
