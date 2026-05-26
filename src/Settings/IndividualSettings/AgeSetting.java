package Settings.IndividualSettings;

import Settings.Setting;
import Simulation.*;

public class AgeSetting extends Setting {

    public AgeSetting(){
        super("Fertility", 1, "Age limit", 1.0, 50.0, 10.0);
    }

    @Override
    public void ApplyTo(Cell cell){
        double currentAge = cell.getAge();
        double newFertility = cell.isAlive()
                ? 1.0 / ( 1.0 + Math.exp(0.8 * (currentAge - 45)))
                : 0.0;
        cell.setWeight(name, newFertility);
    }
}
