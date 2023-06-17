package main.java.inventory;

public class BagOfSeeds extends Item {
    private int numberOfSeeds;
    private int daysNeededToRipen;
    private boolean isFarmCrop;

    public BagOfSeeds(String name, int numberOfSeeds, int daysNeededToRipen) {
        super(name);
        this.numberOfSeeds = numberOfSeeds;
        this.daysNeededToRipen = daysNeededToRipen;
    }

    public boolean isFarmCrop() {
        return isFarmCrop;
    }

    public int getNumberOfSeeds() {
        return numberOfSeeds;
    }

    public int getDaysNeededToRipen() {
        return daysNeededToRipen;
    }

    public void addSeeds(int addSeeds) {
        this.numberOfSeeds = numberOfSeeds + addSeeds;
    }

    public void removeSeed() {
        this.numberOfSeeds--;
    }

}
