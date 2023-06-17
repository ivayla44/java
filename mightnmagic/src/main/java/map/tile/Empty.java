package main.java.map.tile;

public class Empty extends Tile {

    public Empty(){}

    @Override
    public String toString() {
        return "This tile is empty.";
    }

    @Override
    public void activate(Object entity) throws Exception {
        ;
    }
}
