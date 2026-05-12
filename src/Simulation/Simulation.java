package Simulation;

import Settings.Setting;

import java.util.ArrayList;

public class Simulation {
    private ArrayList<Cell> grid = new ArrayList<>();
    private ArrayList<Setting> activeSettings;
    private int gridWidth, gridHeight;

    private ArrayList<Cell> neighbourBuffer = new ArrayList<>();

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

            Cell cell = grid.get(pos);

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



    }

}
