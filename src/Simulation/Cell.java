package Simulation;

import java.util.HashMap;

public class Cell {
    private int age;
    private boolean alive;
    private HashMap<String, Double> currentWeights = new HashMap<>();
    private HashMap<String, Double> proximityWeightAverages = new HashMap<>();

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

    public HashMap<String, Double> getWeights(){return currentWeights;}

    public boolean isAlive(){
        return this.alive;
    }

    public void setAge(int newAge){
        this.age = newAge;
    }

    public void addSetting(String name, double initialWeight){
        currentWeights.put(name, initialWeight);
    }

    @Override
    public String toString() {
        return "Cell{" +
                "age=" + age +
                ", alive=" + alive +
                ", currentWeights=" + currentWeights +
                ", proximityWeightAverages=" + proximityWeightAverages +
                '}';
    }
}
