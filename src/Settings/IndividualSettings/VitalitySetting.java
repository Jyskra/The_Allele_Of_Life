package Settings.IndividualSettings;

import Settings.Setting;
import Simulation.*;

public class VitalitySetting extends Setting {
    public VitalitySetting() {
        super("Vitality", "Vitality bonus", 0, 50, 10, true);
    }

    @Override
    public void ApplyTo(Cell cell, double n, int alives) {
        if (cell.isAlive()) {
            double vitality = Math.min(1.0, cell.getAge() / 100.0); // caps at 1.0
            cell.setWeight(name, vitality);
        } else {
            cell.setWeight(name, 0.0);
        }
    }

    @Override
    public double Contribute(Cell cell) {
        return getSliderValue() * cell.getWeight(name); // positive = harder to kill
    }
}