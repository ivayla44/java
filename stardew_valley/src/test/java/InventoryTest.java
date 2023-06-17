package test.java;

import main.java.inventory.BagOfSeeds;
import main.java.inventory.Inventory;
import main.java.inventory.Item;
import main.java.inventory.tools.Axe;
import main.java.inventory.tools.Hoe;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {
    private Inventory inventory;
    private Item hoe;
    private Item hoe2;
    private Item axe;
    private Item bagOfCornSeeds;
    private Item secondBagOfCornSeeds;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
        hoe = new Hoe();
        hoe2 = new Hoe();
        axe = new Axe();
        bagOfCornSeeds = new BagOfSeeds("Corn", 10, 6);
        secondBagOfCornSeeds = new BagOfSeeds("Corn", 5, 6);
    }

    @AfterEach
    void tearDown() {
        inventory = null;
    }

    @Test
    void addSecondOfTool() throws Exception {
        inventory.addItem(hoe);
        Exception thrown = assertThrows(Exception.class, () -> inventory.addItem(hoe2));
        assertEquals(thrown.getMessage(), "This tool is already in your inventory!");
    }

    @Test
    void getItem() throws Exception {
        inventory.addItem(hoe);
        assertEquals(inventory.getItem(0), hoe);
    }

    @Test
    void addSeeds() throws Exception {
        inventory.addItem(hoe);
        inventory.addItem(bagOfCornSeeds);
        inventory.addItem(secondBagOfCornSeeds);
        BagOfSeeds cornSeeds = (BagOfSeeds) inventory.getItem(1);
        assertEquals(cornSeeds.getNumberOfSeeds(), 15);
    }
}