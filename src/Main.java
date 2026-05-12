import Settings.AgeSetting;
import Settings.Setting;
import Simulation.Simulation;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
            ArrayList<Setting> settings = new ArrayList<>(List.of(new AgeSetting()));
            Simulation s = new Simulation(settings, 3, 4);
    }
}