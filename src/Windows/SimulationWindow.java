package Windows;

import javax.swing.*;
import java.awt.*;

public class SimulationWindow extends JDialog {

    private final int windowWidth = 1280;
    private final int windowHeight = 720;

    private final int gridWidth, gridHeight, cellSize;

    private final GridPanel gridPanel;

    public SimulationWindow(JFrame mainMenu, int gridWidth, int gridHeight, int cellSize){

        super(mainMenu, "Simulation", false);
        setSize(windowWidth, gridHeight);
        setLocationRelativeTo(mainMenu);

        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        this.cellSize = cellSize;

        gridPanel = new GridPanel(gridWidth, gridHeight, cellSize);

        add(gridPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public GridPanel getGridPanel(){
        System.out.println(this.gridPanel + "gridPAnel");
        return this.gridPanel;
    }

}
