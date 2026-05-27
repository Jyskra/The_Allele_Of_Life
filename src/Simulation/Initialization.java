package Simulation;

import Settings.IndividualSettings.AgeSetting;
import Settings.SimulationConfig;

public class Initialization {
    public static void init(){
        SimulationConfig sc = new SimulationConfig();
        MainMenu mm = new MainMenu(sc);

        AgeSetting as = new AgeSetting();
        AgeSetting as1 = new AgeSetting();

        sc.addSetting(as);
        sc.addSetting(as1);
    }
}
