package Windows;

import Settings.SimulationConfig;
import Simulation.Simulation;

import javax.swing.*;
import java.awt.*;

/**
 * the frame that actually holds all the simulation children
 */
public class SimulationWindow extends JDialog {

    private final int windowWidth = 1080;
    private final int windowHeight = 600;

    private final int gridWidth, gridHeight, cellSize;

    private final GridPanel gridPanel;
    private final sidebarPanel sidebar;

    public SimulationWindow(JFrame mainMenu, int gridWidth, int gridHeight, int cellSize, SimulationConfig config, Simulation simulation){

        super(mainMenu, "Simulation", false);
        setSize(windowWidth, windowHeight);
        setResizable(false);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                simulation.stop();
                dispose();
            }
        });

        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        this.cellSize = cellSize;

        gridPanel = new GridPanel(gridWidth, gridHeight, cellSize);
        sidebar = new sidebarPanel(config, mainMenu, simulation);

        add(sidebar, BorderLayout.EAST);
        add(gridPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(mainMenu);
        setVisible(true);
    }

    public GridPanel getGridPanel(){
        return this.gridPanel;
    }

    public sidebarPanel getSidebar(){
        return this.sidebar;
    }

}
