package Simulation;

import Settings.IndividualSettings.*;
import Settings.SimulationConfig;

public class Initialization {
    public static void init(){
        SimulationConfig sc = new SimulationConfig();
        MainMenu mm = new MainMenu(sc);

        AgeSetting as = new AgeSetting();
        OverCrowdednessSetting ocs = new OverCrowdednessSetting();
        WeightRangeMax wr = new WeightRangeMax();
        WeightRangeMin wrm = new WeightRangeMin();
        SettingContributionSetting scs = new SettingContributionSetting();

        sc.addSetting(as);
        sc.addSetting(ocs);
        sc.addSetting(wr);
        sc.addSetting(wrm);
        sc.addSetting(scs);
    }
}
