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

    private ArrayList<Cell> neighbourBuffer = new ArrayList<>();
    private HashMap<String, Double> weightBuffer = new HashMap<>();

    private SimulationWindow window;
    private final GridPanel gridPanel;

    private boolean running = false;
    private Timer gameLoop;

    public Simulation(SimulationConfig config, JFrame mainMenu){
        this.config = config;
        this.gridWidth = 30;
        this.gridHeight = 30;
        this.cellSize = 15;

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
        gameLoop = new Timer(500, e -> tick()); //TODO tick timer setting
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

        randomize(0.3);
    }

    private void tick(){

        System.out.println("tick");
        //TODO balance out settings and add more

        for(int pos = 0; pos < grid.size(); pos++){

            Cell currentCell = grid.get(pos);

            getNeighbours(pos);
            int alives = calculateNeighbouringWeights();

            double totalWeights = 0.0;
            double weightRangeMin = 0, weightRangeMax = 100;

            for(Setting s : config.getSettings()){

                if(s.isEnabled()){

                    if(s.getContributesToCalculations()){

                        s.ApplyTo(currentCell, weightBuffer.get(s.getName()), alives);

                        totalWeights += s.Contribute(currentCell);
                        System.out.println(totalWeights);

                    }

                    if (s.getName().equalsIgnoreCase("weightrangemin")){weightRangeMin = s.getSliderValue();}
                    if (s.getName().equalsIgnoreCase("weightrangemax")){weightRangeMax = s.getSliderValue();}

                }

            }

            currentCell.setNextAlive(totalWeights >= weightRangeMin && totalWeights <= weightRangeMax);

            currentCell.flush();
        }

        gridPanel.updateGrid(grid);
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

            numberOfNeighbours++;

            HashMap<String, Double> weights = neighbour.getWeights();

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
