package Simulation;

import Settings.IndividualSettings.AgeSetting;
import Settings.IndividualSettings.OverCrowdednessSetting;
import Settings.IndividualSettings.WeightRangeMax;
import Settings.IndividualSettings.WeightRangeMin;
import Settings.SimulationConfig;

public class Initialization {
    public static void init(){
        SimulationConfig sc = new SimulationConfig();
        MainMenu mm = new MainMenu(sc);

        AgeSetting as = new AgeSetting();
        OverCrowdednessSetting ocs = new OverCrowdednessSetting();
        WeightRangeMax wr = new WeightRangeMax();
        WeightRangeMin wrm = new WeightRangeMin();

        sc.addSetting(as);
        sc.addSetting(ocs);
        sc.addSetting(wr);
        sc.addSetting(wrm);
    }
}
