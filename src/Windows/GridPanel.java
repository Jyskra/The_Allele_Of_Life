package Windows;

import Simulation.Cell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
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

        mouseEnabling();
    }

    private void mouseEnabling(){

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                if (grid == null) return;
                int x = e.getX() / cellSize;
                int y = e.getY() / cellSize;
                if (x < 0 || x >= gridWidth || y < 0 || y >= gridHeight) return;
                Cell cell = grid.get(y * gridWidth + x);
                cell.setAlive(!cell.isAlive());
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {

                if (grid == null) return;
                int x = e.getX() / cellSize;
                int y = e.getY() / cellSize;
                if (x < 0 || x >= gridWidth || y < 0 || y >= gridHeight) return;
                grid.get(y * gridWidth + x).setAlive(true); // drag always sets alive
                repaint();
            }
        });

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
        if(cell.isAlive()){
            return Color.BLACK;
        }else{
            return Color.WHITE;
        }
    }

}
