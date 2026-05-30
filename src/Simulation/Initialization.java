package Simulation;

import Settings.IndividualSettings.*;
import Settings.SimulationConfig;

public class Initialization {
    public static void init(){
        SimulationConfig sc = new SimulationConfig();
        MainMenu mm = new MainMenu(sc);

        AgeSetting as = new AgeSetting();
        OverCrowdednessSetting ocs = new OverCrowdednessSetting();
        SettingContributionSetting scs = new SettingContributionSetting();
        TickSetting ts = new TickSetting();
        VitalitySetting vs = new VitalitySetting();
        HeriditySetting hs = new HeriditySetting();

        sc.addSetting(ts);
        sc.addSetting(as);
        sc.addSetting(ocs);
        sc.addSetting(scs);
        sc.addSetting(vs);
        sc.addSetting(hs);
    }
}
