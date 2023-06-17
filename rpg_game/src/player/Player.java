package player;

import items.Item;
import weapons.Weapon;

public class Player {
    String name;
    int hp;
    items.Item[] items;

    weapons.Weapon weapon;

    public Player(String name, int hp, Item[] items) {
        this.name = name;
        this.hp = hp;
        this.items = items;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Weapon getWeapon() {
        return weapon;
    }
}
