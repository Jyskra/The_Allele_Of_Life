package Settings.IndividualSettings;

import Settings.Setting;
import Simulation.Cell;

public class WeightRangeMax extends Setting {

    public WeightRangeMax(){

        super("WeightRangeMax", "Weight Range Max", 0, 50, 20, false);
        turnOffToggle();

    }

    @Override
    public void ApplyTo(Cell cell, double n, int neighbourCount){
        //pass
    }

    @Override
    public double Contribute(Cell cell){
        return 0.0;
    }
}
