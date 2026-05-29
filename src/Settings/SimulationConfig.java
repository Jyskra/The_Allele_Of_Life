package Settings;

import java.util.ArrayList;
import java.util.List;

public class SimulationConfig {
    private final List<Setting> currentSettings = new ArrayList<>();
    private int neighbourRadius;
    private int windowWidth = 1280;
    private int windowHeight = 720;

    public List<Setting> getSettings(){
        return this.currentSettings;
    }

    public void addSetting(Setting setting){
        currentSettings.add(setting);
        setting.setEnabled(true);
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
