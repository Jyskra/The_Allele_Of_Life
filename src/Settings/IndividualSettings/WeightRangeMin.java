package Settings.IndividualSettings;

import Settings.Setting;
import Simulation.Cell;

public class WeightRangeMin extends Setting {

    public WeightRangeMin(){
        super("WeightRangeMin", "Weight Range Min", 0, 50, 10, true);
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
