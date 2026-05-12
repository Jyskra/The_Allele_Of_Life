package Settings;
import Simulation.*;

public class Setting {
    protected String name;
    protected int initialWeight;

    public Setting(String name, int initialWeight){
        this.name = name;
        this.initialWeight = initialWeight;
    }

    public String getName(){
        return this.name;
    }

    public int getInitialWeight() {
        return initialWeight;
    }

    public void ApplyTo(Cell cell){

    }
}
