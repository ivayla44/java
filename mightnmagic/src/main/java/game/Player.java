package main.java.game;

import main.java.map.tile.Mine;

import java.util.ArrayList;
import java.util.List;

public class Player {
    String name;
    String type;
    List<Hero> heroes;
    List<Mine> mines;
    int coins;

    public Player(String name, String type) {
        this.name = name;
        this.type = type;
        this.heroes = new ArrayList<>();
        this.mines = new ArrayList<>();
        this.coins = 0;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", mines=" + mines +
                ", coins=" + coins +
                '}';
    }

    public void addHero(Hero hero) {
        hero.setPlayer(this);
        this.heroes.add(hero);
    }

    public void addCoins(int newCoins) {
        this.coins += newCoins;
    }

    public void collectMines() {
        for(Mine mine : this.mines) {
            this.addCoins(1000);
        }
    }
}
