package Simulation;

import java.util.HashMap;

public class Cell {
    private int age;
    private boolean alive;
    private boolean nextAlive;
    private HashMap<String, Double> currentWeights = new HashMap<>();

    public Cell(){

    }

    public double getWeight(String weightName){
        return currentWeights.get(weightName);
    }

    public void setWeight(String weightName, double weight){
        currentWeights.put(weightName, weight);
    }

    public int getAge(){
        return this.age;
    }

    public void setAlive(boolean alive){
        this.alive = alive;
    }

    public void setNextAlive(boolean nextAlive){
        this.nextAlive = nextAlive;
    }

    public HashMap<String, Double> getWeights(){return currentWeights;}

    public boolean isAlive(){
        return this.alive;
    }

    public void addSetting(String name, double initialWeight){
        currentWeights.put(name, initialWeight);
    }

    public void flush(){

        this.age++;
        this.alive = this.nextAlive;
        if (!this.alive) {
            this.age = 0;
        }

    }

    @Override
    public String toString() {
        return "Cell{" +
                "age=" + age +
                ", alive=" + alive +
                ", currentWeights=" + currentWeights +
                '}';
    }
}
