package main.java.inventory.tools;

import main.java.farm.Tile;
import main.java.inventory.IUsableItem;
import main.java.inventory.Item;

public class Hoe extends Item implements IUsableItem {
    public Hoe() {
        super("Hoe");
    }

    @Override
    public void use(Tile tile) {
        tile.till();
    }
}
