package Settings;

import Settings.IndividualSettings.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * the whole game config, holds every information about the game
 */
public class SimulationConfig {
    private final List<Setting> currentSettings = new ArrayList<>(List.<Setting>of(
            new AgeSetting(),
            new TickSetting(),
            new OverCrowdednessSetting(),
            new SettingContributionSetting(),
            new VitalitySetting(),
            new HeriditySetting()
    )
    );
    private int neighbourRadius;
    private int windowWidth = 1280;
    private int windowHeight = 720;

    public List<Setting> getSettings(){
        return this.currentSettings;
    }


    public int getNeighbourRadius() {
        return neighbourRadius;
    }

    public int getWindowWidth() {
        return windowWidth;
    }

    public int getWindowHeight() {
        return windowHeight;
    }

    public void setNeighbourRadius(int neighbourRadius) {
        this.neighbourRadius = neighbourRadius;
    }
}
