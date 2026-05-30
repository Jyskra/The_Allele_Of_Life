package Settings.IndividualSettings;

import Settings.Setting;
import Simulation.Cell;

public class TickSetting extends Setting {

    public TickSetting(){
        super("TickTime", "Tick time x10", 25, 100, 50, false);
        turnOffToggle();
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
