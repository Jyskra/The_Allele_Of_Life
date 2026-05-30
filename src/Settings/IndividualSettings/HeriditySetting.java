package Settings.IndividualSettings;

import Settings.Setting;
import Simulation.Cell;

public class HeriditySetting extends Setting {
    public HeriditySetting() {
        super("Heredity", "Heredity strength", 0, 50, 10, true);
    }

    @Override
    public void ApplyTo(Cell cell, double neighbourAvgFertility, int alives) {
        if (!cell.isAlive()) {

            double current = cell.getWeight("Fertility");
            double blended = current + (neighbourAvgFertility - current) * (getSliderValue() / 50.0);
            cell.setWeight("Fertility", blended);
        }
    }

    @Override
    public double Contribute(Cell cell) { return 0; }
}