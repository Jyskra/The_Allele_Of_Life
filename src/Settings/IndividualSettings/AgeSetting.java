package Settings.IndividualSettings;

import Settings.Setting;
import Simulation.*;

public class AgeSetting extends Setting {

    private double contributionMultiplier = 6;

    public AgeSetting(){
        super("Fertility", "Age limit", 0, 50, 10, true);
    }



    @Override
    public void ApplyTo(Cell cell, double n, int x){
        double currentAge = cell.getAge();
        double newFertility = cell.isAlive()
                ? 1.0 / ( 1.0 + Math.exp(0.8 * (currentAge - (50 - getSliderValue()/5))))
                : 0.0;
        cell.setWeight(name, newFertility);
    }

    @Override
    public double Contribute(Cell cell){
        return contributionMultiplier * cell.getWeight(name);
    }
}
