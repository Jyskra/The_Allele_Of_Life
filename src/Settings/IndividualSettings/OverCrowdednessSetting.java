package Settings.IndividualSettings;

import Settings.Setting;
import Simulation.Cell;

/**
 * a setting that just makes the cells dislike nearby neighbours the more its turned up
 */
public class OverCrowdednessSetting extends Setting {

    public OverCrowdednessSetting(){
        super("Crowding", "Crowding Multi", 0, 50, 2, true);
    }

    @Override
    public void ApplyTo(Cell cell, double n, int neighbourCount){
        cell.setWeight(name, neighbourCount);
    }

    @Override
    public double Contribute(Cell cell){
        return cell.getWeight(name) < 4 ? 0.0 : -getSliderValue() * cell.getWeight(name);
    }
}
