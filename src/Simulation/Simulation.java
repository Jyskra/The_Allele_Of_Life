package Simulation;

import Settings.Setting;

import java.util.ArrayList;
import java.util.HashMap;

public class Simulation {
    private ArrayList<Cell> grid = new ArrayList<>();
    private ArrayList<Setting> activeSettings;
    private int gridWidth, gridHeight;

    private ArrayList<Cell> neighbourBuffer = new ArrayList<>();
    private HashMap<String, Double> weightBuffer = new HashMap<>();

    public Simulation(ArrayList<Setting> activeSettings, int width, int height){
        this.activeSettings = activeSettings;
        this.gridWidth = width;
        this.gridHeight = height;

        initializeGrid();
    }

    private void initializeGrid(){
        for(int i = 0; i < gridHeight * gridWidth; i++){

            Cell c = new Cell();

            for(Setting s : activeSettings){

                c.addSetting(s.getName(), s.getInitialWeight());

            }

            grid.add(c);
        }

//        for(int i = 0; i<60; i++){
//            tick();
//        }

        calculateNeighbouringWeights();
    }

    private void tick(){
        for(int i = 0; i < gridHeight * gridWidth; i++){

            Cell currentCell = grid.get(i);

            for(Setting s : activeSettings){
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
