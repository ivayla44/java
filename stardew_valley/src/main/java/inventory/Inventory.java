package main.java.inventory;

import main.java.inventory.tools.Axe;
import main.java.inventory.tools.Hoe;

import javax.tools.Tool;
import java.util.Objects;
import java.util.Vector;

public class Inventory {
    private Vector<Item> items;

    public Inventory() {
        this.items = new Vector<>();
    }

    public void addItem(Item item) throws Exception {
        if(item instanceof Hoe || item instanceof Axe) {
            for(Item tool : items) {
                if(tool.getName().equals(item.getName())) {
                    throw new Exception("This tool is already in your inventory!");
                }
            }
        }
        else if(item instanceof BagOfSeeds) {
            for(Item i : items) {
                if(i instanceof BagOfSeeds) {
                    if(i.getName().equals(item.getName())) {
                        ((BagOfSeeds) i).addSeeds(((BagOfSeeds) item).getNumberOfSeeds());
                        return;
                    }
                }
            }
        }
        if(items.size() < 10) {
            items.add(item);
        }
        else throw new Exception("Inventory full!");
    }

    public Item getItem(int index) throws Exception {
        if(index < 0 || index > 9) {
            throw new Exception("Invalid index!");
        }
        else if(Objects.equals(items.get(index), new Item())) {
            throw new Exception("This slot is empty!");
        }
        else return items.get(index);
    }

    public Item getItemByName(String name) throws Exception {
        for(Item item : items) {
            if(item.getName().equals(name)) {
                return item;
            }
        }
        throw new Exception("No such item in your inventory.");
    }
}
