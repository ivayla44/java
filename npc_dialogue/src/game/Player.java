package game;

import java.util.ArrayList;
import java.util.List;

public class Player {
    int HP;
    int STR;
    int CHA;
    int GOLD;
    List<String> inventory = new ArrayList<>();

    public Player(int HP, int STR, int CHA, int GOLD, List<String> inventory) {
        this.HP = HP;
        this.STR = STR;
        this.CHA = CHA;
        this.GOLD = GOLD;
        this.inventory = inventory;
    }

    public int getHP() {
        return HP;
    }

    public int getSTR() {
        return STR;
    }

    public void setSTR(int str) {
        this.STR = str;
    }

    public int getCHA() {
        return CHA;
    }

    public int getGOLD() {
        return GOLD;
    }

    public void setGOLD(int GOLD) {
        this.GOLD = GOLD;
    }

    public List<String> getInventory() {
        return inventory;
    }

    public void addToInventory(String item) {
        this.inventory.add(item);
    }
}
