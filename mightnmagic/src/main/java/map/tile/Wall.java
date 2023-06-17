package main.java.map.tile;

public class Wall extends Tile {
    public Wall() {}

    @Override
    public String toString() {
        return "This is a wall.";
    }

    @Override
    public void activate(Object entity) throws Exception {
        ;
    }
}
