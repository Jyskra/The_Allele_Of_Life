package Simulation;

import Settings.Setting;
import Settings.SimulationConfig;
import Windows.GridPanel;
import Windows.SimulationWindow;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Simulation {
    private ArrayList<Cell> grid = new ArrayList<>();
    private SimulationConfig config;
    private final int gridWidth, gridHeight, cellSize;

    private ArrayList<Cell> neighbourBuffer = new ArrayList<>();
    private HashMap<String, Double> weightBuffer = new HashMap<>();

    private SimulationWindow window;
    private final GridPanel gridPanel;

    public Simulation(SimulationConfig config, JFrame mainMenu){
        this.config = config;
        this.gridWidth = 30;
        this.gridHeight = 30;
        this.cellSize = 15;

        window = new SimulationWindow(mainMenu, gridWidth, gridHeight, cellSize, config);
        gridPanel = window.getGridPanel();

        initializeGrid();

        window.setVisible(true);
    }

    private void initializeGrid(){
        for(int i = 0; i < gridHeight * gridWidth; i++){

            Cell c = new Cell();

            for(Setting s : config.getSettings()){

                c.addSetting(s.getName(), s.getInitialWeight());

            }

            grid.add(c);
        }

        System.out.println(grid);
        gridPanel.updateGrid(grid);

//        for(int i = 0; i<60; i++){
//            tick();
//        }

        calculateNeighbouringWeights();
    }

    private void tick(){
        for(int i = 0; i < gridHeight * gridWidth; i++){

            Cell currentCell = grid.get(i);

            for(Setting s : config.getSettings()){
                s.ApplyTo(currentCell);
            }

            currentCell.setAge(currentCell.getAge() + 1);

            System.out.println(grid);
        }
    }

    private void getNeighbours(){

        for(int pos = 0; pos < gridHeight * gridWidth ; pos++){
            //implement radius setting
            int radius = 1;

            neighbourBuffer.clear();

            int cellX = pos % gridWidth;
            int cellY = pos / gridWidth;

            int minX = Math.max(0, cellX - radius);
            int maxX = Math.min(gridWidth - 1, cellX + radius);
            int minY = Math.max(0, cellY - radius);
            int maxY = Math.min(gridHeight - 1, cellY + radius);

            for(int y = minY; y <= maxY; y++){
                for(int x = minX; x <= maxX; x++){
                    if(!(x == cellX && y == cellY)){
                        neighbourBuffer.add(grid.get(x * gridWidth + y * gridHeight));
                    }
                }
            }

        }

    }

    private void calculateNeighbouringWeights(){

        weightBuffer.clear();

        int numberOfNeighbours = neighbourBuffer.size();

        for(Cell neighbour : neighbourBuffer){

            numberOfNeighbours++;

            HashMap<String, Double> weights = neighbour.getWeights();

            for(String key : weights.keySet()){

                double newWeight = weightBuffer.get(key) + weights.get(key);
                weightBuffer.put(key, newWeight);
            }

        }

        for(String key : weightBuffer.keySet()){

            weightBuffer.put(key, weightBuffer.get(key)/numberOfNeighbours);

        }

    }

}
