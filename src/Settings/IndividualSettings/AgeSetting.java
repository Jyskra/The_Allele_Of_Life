package Settings.IndividualSettings;

import Settings.Setting;
import Simulation.*;

/**
 * a setting that makes cells less fertile based on how long they are alive
 */
public class AgeSetting extends Setting {

    public AgeSetting(){
        super("Fertility", "Age limit", 0, 50, 10, true);
    }


    /**
     * a sigmoid function that drastically drops to 0 as it approaches the value set in the settings, changing the cells fertility respectively
     * @param cell - influenced cell
     */
    @Override
    public void ApplyTo(Cell cell, double n, int x){
        double currentAge = cell.getAge();

        if (!cell.isAlive() || currentAge < 3) {
            cell.setWeight(name, 0.0);
            return;
        }

        double newFertility = cell.isAlive()
                ? 1.0 / ( 1.0 + Math.exp(0.8 * (currentAge - getSliderValue())))
                : 0.0;
        cell.setWeight(name, newFertility);
    }

    @Override
    public double Contribute(Cell cell){
        return cell.getWeight(name);
    }
}
