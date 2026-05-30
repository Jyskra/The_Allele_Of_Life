package Windows;

import Settings.SimulationConfig;
import Simulation.Simulation;

import javax.swing.*;
import java.awt.*;

public class sidebarPanel extends JPanel {


    private SimulationConfig config;
    private JFrame mainMenu;
    private final Simulation simulation;

    private JLabel averageAge;
    private JLabel averageWeight;
    private JLabel tickCount;

    public sidebarPanel(SimulationConfig config, JFrame mainMenu, Simulation simulation){

        setPreferredSize(new Dimension(150, 0));
        setBackground(new Color(30,30,30));

        this.config = config;
        this.mainMenu = mainMenu;
        this.simulation = simulation;

        initSidebar();

    }

    private void initTickCount(){

        tickCount = new JLabel("Tick count: 0");
        tickCount.setForeground(Color.WHITE);
        tickCount.setFont(new Font("Arial", Font.PLAIN, 12));
        tickCount.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(tickCount);
        add(Box.createRigidArea(new Dimension(0, 16)));

    }

    public void updateTickCount(int tc){
        tickCount.setText(String.format("Tick count: %d", tc));
    }

    private void initAverageAge(){

        averageAge = new JLabel("Avg age: 0.00");
        averageAge.setForeground(Color.WHITE);
        averageAge.setFont(new Font("Arial", Font.PLAIN, 12));
        averageAge.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(averageAge);
        add(Box.createRigidArea(new Dimension(0, 16)));

    }

    public void updateAverageAge(double average){

        averageAge.setText(String.format("Avg age: %.2f", average));

    }

    private void initExitButton(){

        JButton exitButton = new JButton("Close");

        Customs.sideBarButton(exitButton);
        add(Box.createRigidArea(new Dimension(0, 16)));

        add(exitButton);

        exitButton.addActionListener(e -> exit());

    }

    private void exit(){

        System.out.println("Closing simulation...");

        simulation.stop();
        SwingUtilities.getWindowAncestor(this).dispose();

    }

    private void initRandomizeButton(){

        JButton randomizeButton = new JButton("Random");

        Customs.sideBarButton(randomizeButton);
        add(Box.createRigidArea(new Dimension(0, 16)));

        add(randomizeButton);

        randomizeButton.addActionListener(e -> randomize());

    }

    private void randomize(){

        simulation.randomize(0.3);

    }

    private void initStartButton(){

        JToggleButton startButton = new JToggleButton("Start");

        Customs.startButton(startButton);
        add(Box.createRigidArea(new Dimension(0, 16)));

        Customs.updateStartButton(startButton);

        add(startButton);

        startButton.addActionListener(e -> setStart(startButton));

    }

    private void setStart(JToggleButton startButton){

        Customs.updateStartButton(startButton);

        if(startButton.isSelected()){
            simulation.start();
        }else{
            simulation.stop();
        }

    }

    private void initSettingsButton() {

        JButton settingButton = new JButton("Settings");

        Customs.sideBarButton(settingButton);
        add(Box.createRigidArea(new Dimension(0, 16)));

        add(settingButton);


        settingButton.addActionListener(e -> openSettings());

    }

    private void openSettings(){

        System.out.println("Opening settings...");

        new SettingsWindow(config, mainMenu);

    }

    private void initSidebar(){

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(20, 16, 20 ,16));

        //Buttons
        initStartButton();
        initRandomizeButton();
        initSettingsButton();
        initExitButton();

        //Labels
        initAverageAge();
        initTickCount();

    }

}
