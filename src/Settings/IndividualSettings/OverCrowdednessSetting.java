package Settings.IndividualSettings;

import Settings.Setting;
import Simulation.Cell;

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
        return -getSliderValue() * cell.getWeight(name);
    }
}
