package Simulation;

import Settings.Setting;
import Settings.SimulationConfig;
import Windows.GridPanel;
import Windows.SimulationWindow;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Simulation {
    private ArrayList<Cell> grid = new ArrayList<>();
    private SimulationConfig config;
    private final int gridWidth, gridHeight, cellSize;

    private int tickCount;

    private ArrayList<Cell> neighbourBuffer = new ArrayList<>();
    private HashMap<String, Double> weightBuffer = new HashMap<>();

    private SimulationWindow window;
    private final GridPanel gridPanel;

    private boolean running = false;
    private Timer gameLoop;
    private int tickTime = 500;
    private double settingsInfluence = 0.1;

    public Simulation(SimulationConfig config, JFrame mainMenu){
        this.config = config;
        this.gridWidth = 30;
        this.gridHeight = 30;
        this.cellSize = 15;
        this.tickCount = 0;

        window = new SimulationWindow(mainMenu, gridWidth, gridHeight, cellSize, config, this);
        gridPanel = window.getGridPanel();

        initializeGrid();

        window.setVisible(true);
    }

    public void randomize(double density){
        for(Cell cell : grid){

            cell.setAlive(Math.random() < density);

        }
        gridPanel.updateGrid(grid);
    }

    public void start(){
        running = true;
        for(Setting s : config.getSettings()){
            if(s.getName().equalsIgnoreCase("ticktime")){
                tickTime = (int) s.getSliderValue() * 10;
            }
        }
        gameLoop = new Timer(tickTime, e -> tick());
        gameLoop.start();
    }

    public void stop(){
        running = false;
        if(gameLoop != null) gameLoop.stop();
    }


    private void initializeGrid(){
        for(int i = 0; i < gridHeight * gridWidth; i++){

            Cell c = new Cell();

            for(Setting s : config.getSettings()){

                c.addSetting(s.getName(), s.getInitialWeight());

            }

            grid.add(c);
        }

        gridPanel.updateGrid(grid);
    }

    private void tick(){

        System.out.println("Tick");

        double averageWeights = 0.0;
        double averageAge = 0.0;

        for(int pos = 0; pos < grid.size(); pos++){

            Cell currentCell = grid.get(pos);

            averageAge += currentCell.getAge();

            getNeighbours(pos);
            int alives = calculateNeighbouringWeights();

            double weightRangeMin = 0, weightRangeMax = 100;

            boolean baseAlive;
            if(currentCell.isAlive()){
                baseAlive = alives == 2 || alives == 3;
            }else{
                baseAlive = alives == 3;
            }

            double totalWeights = 0.0;

            for(Setting s : config.getSettings()){

                if(s.isEnabled()){

                    if(s.getContributesToCalculations()){

                        s.ApplyTo(currentCell, weightBuffer.get(s.getName()), alives);

                        totalWeights += s.Contribute(currentCell);

                    }

                }
                if (s.getName().equalsIgnoreCase("settingcontribution")) {settingsInfluence = s.isEnabled() ? s.getSliderValue() / 100 : 0.0;}

            }

            double clampledTotal = Math.clamp(totalWeights, -1.0, 1.0);

            double survivalChance = (baseAlive ? 1.0 : 0.0) + clampledTotal * settingsInfluence;
            survivalChance = Math.clamp(survivalChance, 0.0, 1.0);

            currentCell.setNextAlive(Math.random() < survivalChance);

            averageWeights += totalWeights;

        }

        for(Cell c : grid){
            c.flush();
        }

        window.getSidebar().updateAverageWeight(averageWeights / grid.size());
        window.getSidebar().updateAverageAge(averageAge / grid.size());

        gridPanel.updateGrid(grid);

        tickCount++;
        window.getSidebar().updateTickCount(tickCount);
    }

    private void getNeighbours(int pos){

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
                    neighbourBuffer.add(grid.get(y * gridWidth + x));
                }
            }
        }

    }

    private int calculateNeighbouringWeights(){

        weightBuffer.clear();

        int numberOfNeighbours = 0;

        for(Cell neighbour : neighbourBuffer){

            HashMap<String, Double> weights = neighbour.getWeights();

            if(neighbour.isAlive()){numberOfNeighbours++;}

            for(String key : weights.keySet()){

                double newWeight = weights.get(key);

                if(weightBuffer.containsKey(key)){
                    newWeight = weightBuffer.get(key) + weights.get(key);
                }

                weightBuffer.put(key, newWeight);
            }

        }

        for(String key : weightBuffer.keySet()){

            weightBuffer.put(key, weightBuffer.get(key)/numberOfNeighbours);

        }

        return numberOfNeighbours;

    }
}
