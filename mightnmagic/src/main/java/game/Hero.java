package main.java.game;

import java.util.Random;

public class Hero implements Comparable {
    String name;
    Player player;
    int level;
    double armyPower;
    int stepsPerMove;

    public Hero(String name, double armyPower, int stepsPerMove) {
        this.name = name;
        this.level = 0;
        this.armyPower = armyPower;
        this.stepsPerMove = stepsPerMove;
    }

    public double getArmyPower() {
        return armyPower;
    }

    public int getStepsPerMove() {
        return stepsPerMove;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", armyPower=" + armyPower +
                ", stepsPerMove=" + stepsPerMove +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        double thisPower = this.armyPower * (Math.pow(1.1, this.level));
        double enemyPower = ((Hero)o).getArmyPower() * (Math.pow(1.1, ((Hero)o).getArmyPower()));
        return Double.compare(thisPower, enemyPower);
    }

    public int compareArmies(Hero enemy) {
        return this.compareTo(enemy);
    }

    public void addLevel() {
        this.level++;
    }

    public void takeDamage(Hero enemy) {
        Random random = new Random();
        double c = random.nextDouble(0, 5 * this.armyPower/enemy.armyPower - 5);
        if(this.armyPower * c/100 < this.armyPower) {
            this.armyPower -= this.armyPower * c/100;
        }
        else {
            this.armyPower = 0;
        }
    }
}
