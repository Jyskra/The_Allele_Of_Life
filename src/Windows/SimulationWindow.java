package Windows;

import Settings.SimulationConfig;
import Simulation.Simulation;

import javax.swing.*;
import java.awt.*;

public class SimulationWindow extends JDialog {

    private final int windowWidth = 1080;
    private final int windowHeight = 600;

    private final int gridWidth, gridHeight, cellSize;

    private final GridPanel gridPanel;

    public SimulationWindow(JFrame mainMenu, int gridWidth, int gridHeight, int cellSize, SimulationConfig config, Simulation simulation){

        super(mainMenu, "Simulation", false);
        setSize(windowWidth, windowHeight);
        setResizable(false);

        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        this.cellSize = cellSize;

        gridPanel = new GridPanel(gridWidth, gridHeight, cellSize);
        sidebarPanel sidebar = new sidebarPanel(config, mainMenu, simulation);

        add(sidebar, BorderLayout.EAST);
        add(gridPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(mainMenu);
        setVisible(true);
    }

    public GridPanel getGridPanel(){
        System.out.println(this.gridPanel + "gridPAnel");
        return this.gridPanel;
    }

}
