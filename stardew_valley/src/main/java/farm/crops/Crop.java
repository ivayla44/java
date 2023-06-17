package main.java.farm.crops;

import main.java.inventory.Item;

public class Crop extends Item {
    private int age;
    private int ripeAge;

    public Crop(String name, int ripeAge) {
        super(name);
        this.age = 0;
        this.ripeAge = ripeAge;
    }

    public Crop(String name, int age, int ripeAge) {
        super(name);
        this.age = age;
        this.ripeAge = ripeAge;
    }

    public int getAge() {
        return age;
    }

    public int getRipeAge() {
        return ripeAge;
    }

    public boolean isRipe() {
        return age == ripeAge;
    }

    public void processNextDay() {
        this.age++;
    }
}
