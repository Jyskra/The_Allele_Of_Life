package Settings.IndividualSettings;

import Settings.Setting;
import Simulation.Cell;

/**
 * a setting that says how much the actual base game of life is influenced by the custom settings
 */
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
