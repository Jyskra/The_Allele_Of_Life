package Settings;

import java.util.ArrayList;
import java.util.List;

public class SimulationConfig {
    private final List<Setting> currentSettings = new ArrayList<>();
    private int neighbourRadius;
    private int windowWidth = 1280;
    private int windowHeight = 720;

    private List<Setting> getSettings(){
        return this.currentSettings;
    }

    private void addSetting(Setting setting){
        currentSettings.add(setting);
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

    public void configure(Setting setting, boolean added){
        if(added){
            currentSettings.add(setting);
        }else{
            currentSettings.remove(setting);
        }
    }

    public void setNeighbourRadius(int neighbourRadius) {
        this.neighbourRadius = neighbourRadius;
    }
}
