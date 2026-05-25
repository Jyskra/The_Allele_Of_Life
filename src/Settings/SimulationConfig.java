package Settings;

import java.util.ArrayList;
import java.util.List;

public class SimulationConfig {
    private final List<Setting> currentSettings = new ArrayList<>();
    private int neighbourRadius;
    private int windowWidth;
    private int windowHeight;

    private List<Setting> getSettings(){
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

    public void setWindowWidth(int windowWidth) {
        this.windowWidth = windowWidth;
    }

    public void setWindowHeight(int windowHeight) {
        this.windowHeight = windowHeight;
    }
}
