package Settings.IndividualSettings;

import Settings.Setting;
import Simulation.Cell;

public class SettingContributionSetting extends Setting {

    public SettingContributionSetting(){
        super("SettingContribution", "Settings contribution", 0, 75, 10, false);
    }



    @Override
    public void ApplyTo(Cell cell, double n, int x){
        //pass
    }

    @Override
    public double Contribute(Cell cell){
        return 0.0;
    }
}
