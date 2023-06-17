package main.java.map.tile;

import main.java.game.Hero;
import main.java.map.Map;

public abstract class Tile {
    Map map;
    int x, y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean containsHero(Hero hero) {
        return (this instanceof Army && ((Army) this).isNeutral() && ((Army) this).getHero() == hero);
    }

    public abstract void activate(Object entity) throws Exception;

    public abstract String toString();

}
