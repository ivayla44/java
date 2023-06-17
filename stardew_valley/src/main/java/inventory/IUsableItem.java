package main.java.inventory;

import main.java.farm.Tile;

public interface IUsableItem {
    public void use(Tile tile) throws Exception;
}
