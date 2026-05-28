package Windows;

import Simulation.Cell;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GridPanel extends JPanel {

    private final int gridWidth, gridHeight, cellSize;
    private ArrayList<Cell> grid;

    public GridPanel(int gridWidth, int gridHeight, int cellSize){

        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        this.cellSize = cellSize;

        setPreferredSize(new Dimension(gridWidth * cellSize, gridHeight * cellSize));
        setBackground(Color.BLACK);

    }

    public void updateGrid(ArrayList<Cell> grid){

        this.grid = grid;
        repaint();

    }

    @Override
    protected void paintComponent(Graphics g){

        super.paintComponent(g);
        if(grid == null) return;

        Graphics2D g2d = (Graphics2D) g;

        for(int y = 0 ; y < gridHeight; y++){
            for(int x = 0; x < gridWidth; x++){

                Cell cell = grid.get( y * gridWidth + x);
                int posX = x * cellSize;
                int posY = y * cellSize;

                g2d.setColor(getCellColor(cell));
                g2d.fillRect(posX, posY, cellSize, cellSize);

                g2d.setColor(new Color(40,40,40));
                g2d.drawRect(posX, posY, cellSize, cellSize);

            }
        }
    }

    private Color getCellColor(Cell cell){
        return Color.WHITE;
    }

}
