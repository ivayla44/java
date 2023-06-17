package main.java.inventory.tools;

import main.java.farm.Tile;
import main.java.inventory.IUsableItem;
import main.java.inventory.Item;

public class Axe extends Item implements IUsableItem {
    public Axe() {
        super("Axe");
    }

    @Override
    public void use(Tile tile) {
        tile.clearCrop();
    }
}
