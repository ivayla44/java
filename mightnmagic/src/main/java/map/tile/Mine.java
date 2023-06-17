package main.java.map.tile;

import main.java.game.Player;

public class Mine extends Tile {
    Player owner;

    public Mine(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "Mine{" +
                "owner=" + owner +
                '}';
    }

    @Override
    public void activate(Object entity) throws Exception {
        this.owner = ((Player) entity);
    }
}
