package main.java.inventory.tools;

import main.java.farm.Tile;
import main.java.farm.crops.FarmCrop;
import main.java.farm.crops.FarmTree;
import main.java.inventory.IUsableItem;
import main.java.inventory.Inventory;
import main.java.inventory.Item;

public class Hand extends Item implements IUsableItem {
    private Inventory playerInventory;

    public Hand(String playerName) {
        super(playerName);
        this.playerInventory = new Inventory();
    }

    @Override
    public void use(Tile tile) throws Exception {
        if(tile.hasCrop() instanceof FarmCrop) {
            if(tile.hasCrop().isRipe()) {
                System.out.println("1 " + tile.hasCrop().getName() + " has been harvested!");
                playerInventory.addItem(new Item(tile.hasCrop().getName()));
                tile.clearCrop();
            }
            else throw new Exception("This crop isn't ready to be harvested yet!");
        }
        if(tile.hasCrop() instanceof FarmTree) {
            if(tile.hasCrop().isRipe()) {
                System.out.println("1 " + tile.hasCrop().getName() + " has been harvested!");
                playerInventory.addItem(new Item(tile.hasCrop().getName()));
                for(int i = 0; i < tile.hasCrop().getRipeAge() - 3; i++) {
                    tile.hasCrop().processNextDay();
                }
            }
            else throw new Exception("The fruit on this tree isn't ready to be harvested yet!");
        }
    }
}
