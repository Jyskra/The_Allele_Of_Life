package Settings;
import Simulation.*;

public abstract class Setting {
    protected String name;
    protected int initialWeight;
    private String sliderLabel = "Value";
    private double sliderMin = 0.0;
    private double sliderMax = 1.0;
    private double sliderValue = 0.5;
    private SettingControlType controlType;

    public Setting(String name){
        this.controlType = SettingControlType.TOGGLE;
    }

    public Setting(String name, int initialWeight, String sliderLabel, double sliderMin, double sliderMax, double sliderValue) {
        this.name = name;
        this.initialWeight = initialWeight;
        this.sliderLabel = sliderLabel;
        this.sliderMin = sliderMin;
        this.sliderMax = sliderMax;
        this.sliderValue = sliderValue;
        this.controlType = SettingControlType.TOGGLE_WITH_SLIDEBAR;
    }

    public String getName(){
        return this.name;
    }

    public String getSliderLabel() {
        return sliderLabel;
    }

    public double getSliderMin() {
        return sliderMin;
    }

    public double getSliderMax() {
        return sliderMax;
    }

    public double getSliderValue() {
        return sliderValue;
    }

    public int getInitialWeight() {
        return initialWeight;
    }

    public abstract void ApplyTo(Cell cell);
}
