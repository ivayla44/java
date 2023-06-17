package main.java.farm;

import main.java.farm.crops.Crop;
import main.java.farm.crops.FarmCrop;
import main.java.farm.crops.FarmTree;
import main.java.inventory.BagOfSeeds;
import main.java.inventory.Item;
import main.java.inventory.tools.*;

public class Tile {
    private Farm farm;
    private boolean isFree;
    private boolean isBlocked;
    private boolean isTilled;
    private Crop hasCrop;

    public Tile() {
        this.isFree = true;
        this.isBlocked = false;
        this.isTilled = false;
        this.hasCrop = null;
    }

    public Tile(boolean isFree, boolean isBlocked, boolean isTilled, FarmCrop hasCrop) {
        this.isFree = isFree;
        this.isBlocked = isBlocked;
        this.isTilled = isTilled;
        this.hasCrop = hasCrop;
    }

    public boolean isFree() {
        return this.isFree;
    }

    public Crop hasCrop() {
        return this.hasCrop;
    }

    public void clearCrop() {
        this.hasCrop = null;
        this.isTilled = false;
        this.isFree = true;
    }

    public void block() {
        this.isBlocked = true;
        this.isFree = false;
        this.isTilled = false;
    }

    public void till() {
        this.isFree = false;
        this.isTilled = true;
    }

    public void sowSeed(BagOfSeeds bagOfSeeds) throws Exception {
        if(this.isBlocked) throw new Exception("You can't plant here - this tile is blocked!");
        if(!this.isFree) throw new Exception("You can't plant here - this tile is already taken!");
        if(!this.isTilled) throw new Exception("Tile must first be tilled before you can plant your seed!");
        else {
            this.isFree = false;
            this.hasCrop = new FarmCrop(bagOfSeeds.getName(), bagOfSeeds.getDaysNeededToRipen());
            bagOfSeeds.removeSeed();
            if(bagOfSeeds.getNumberOfSeeds() == 0) {
                throw new Exception("No more seeds!");
            }
        }
    }

    public void plantTree(BagOfSeeds bagOfSeeds) throws Exception {
        if(this.isBlocked) throw new Exception("You can't plant here - this tile is blocked!");
        if(!this.isFree) throw new Exception("You can't plant here - this tile is already taken!");
        else {
            this.isFree = false;
            this.hasCrop = new FarmTree(bagOfSeeds.getName(), bagOfSeeds.getNumberOfSeeds());
        }
    }

    public void applyTool(Item item) throws Exception {
        if(this.isBlocked) throw new Exception("This tile is blocked!");
        if(item instanceof Hoe) {
            if(this.hasCrop instanceof FarmCrop) {
                this.clearCrop();
            }
            if(this.isFree && !this.isTilled) {
                ((Hoe) item).use(this);
            }
            else throw new Exception("You can't use your hoe on this tile.");
        }
        if(item instanceof Axe) {
            if(this.hasCrop != null) {
                ((Axe) item).use(this);
            }
        }
        if(item instanceof BagOfSeeds) {
            if(((BagOfSeeds) item).isFarmCrop()) {
                sowSeed((BagOfSeeds) item);
            }
            else {
                plantTree((BagOfSeeds) item);
            }
        }
    }
}
