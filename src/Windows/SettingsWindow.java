package Windows;

import Settings.SimulationConfig;

import javax.swing.*;

public class SettingsWindow extends JDialog {

    private SimulationConfig config;

    public SettingsWindow(SimulationConfig config, JFrame parent){
        super(parent, "Settings", true);
        setSize(400, 500);
        setLocationRelativeTo(parent);

        this.config = config;

        //actual settingsUI

        setVisible(true);
    }

    private void showAllSettings(){



    }

    private void makeSetting(){

    }
}
