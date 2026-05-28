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
    private final boolean contributesToCalculations;
    private boolean enabled = false;

    public Setting(String name, boolean contributesToCalculations){
        this.contributesToCalculations = contributesToCalculations;
        this.controlType = SettingControlType.TOGGLE;
    }

    public Setting(String name, String sliderLabel, double sliderMin, double sliderMax, double sliderValue, boolean contributesToCalculations) {
        this.name = name;
        this.sliderLabel = sliderLabel;
        this.sliderMin = sliderMin;
        this.sliderMax = sliderMax;
        this.sliderValue = sliderValue;
        this.controlType = SettingControlType.TOGGLE_WITH_SLIDEBAR;
        this.contributesToCalculations = contributesToCalculations;
    }

    public void turnOffToggle(){
        controlType = SettingControlType.SLIDEBAR;
    }

    public void setEnabled(boolean enabled){
        this.enabled = enabled;
    }

    public boolean isEnabled(){
        return enabled;
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

    public SettingControlType getControlType() {
        return controlType;
    }

    public void setSliderValue(double sliderValue) {
        this.sliderValue = sliderValue;
    }

    public boolean getContributesToCalculations() {return this.contributesToCalculations;}

    public abstract void ApplyTo(Cell cell, double nearbyAverage, int neighbourCount);
    public abstract double Contribute(Cell cell);
}
