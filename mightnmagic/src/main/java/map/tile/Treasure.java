package main.java.map.tile;

import main.java.game.Hero;

public class Treasure extends Tile {
    String type;
    int coins;
    boolean level;

    public Treasure(String type, int coins) {
        this.type = type;
        this.coins = coins;
        this.level = false;
    }

    public Treasure(String type, boolean level) {
        this.type = type;
        this.level = level;
        this.coins = 0;
    }

    @Override
    public String toString() {
        return "Treasure{" +
                "type='" + type + '\'' +
                ", coins=" + coins +
                ", level=" + level +
                '}';
    }

    @Override
    public void activate(Object entity) throws Exception {
        if(this.level) {
            ((Hero) entity).addLevel();
        }
        else {
            ((Hero) entity).getPlayer().addCoins(this.coins);
        }
        this.map.setTile(this.x, this.y, new Empty());
    }
}
