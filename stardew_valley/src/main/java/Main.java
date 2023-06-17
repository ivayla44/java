package main.java;

import main.java.farm.Farm;
import main.java.inventory.BagOfSeeds;
import main.java.inventory.Inventory;
import main.java.inventory.tools.*;

import static main.java.Vector2.*;


public class Main {
    public static void main(String[] args) throws Exception {
        Farm farm = new Farm();

        Vector2 position = new Vector2(0, 0);
        Vector2 position2 = new Vector2(0, 0);

        Inventory playerInventory = new Inventory();
        Hand player = new Hand("IvaEFermer?");

        Axe axe = new Axe();
        Hoe hoe = new Hoe();

        playerInventory.addItem(axe);
        playerInventory.addItem(hoe);

        BagOfSeeds sunflowerSeeds = new BagOfSeeds("Sunflower", 20, 10);
        BagOfSeeds eggplantSeeds = new BagOfSeeds("Eggplant", 15, 12);
        BagOfSeeds moreEggplantSeeds = new BagOfSeeds("Eggplant", 15, 12);

        playerInventory.addItem(sunflowerSeeds);
        playerInventory.addItem(eggplantSeeds);
        playerInventory.addItem(moreEggplantSeeds);

        for(int i = 0; i < 5; i++) {
            playerInventory.getItemByName("Hoe").use(farm, position);
            position.addDirection(right);
        }

        for(int i = 0; i < 5; i++) {
            playerInventory.getItemByName("Sunflower").use(farm, position2);
            position2.addDirection(right);
        }

    }
}