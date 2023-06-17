package main.java.inventory;

import main.java.farm.Farm;
import main.java.Vector2;

import static main.java.Vector2.*;

public class Item {
    private String name;

    public Item(){}

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void use(Farm farm, Vector2 position) throws Exception {
        farm.getCell(position).applyTool(this);
    }

    public void use(Farm farm, Vector2 position, Vector2 direction, int powerLevel) throws Exception {
        if(powerLevel == 1) {
            this.use(farm, position);
        }
        else if(powerLevel == 2) {
            for(int i = 0; i < 3; i++) {
                if(farm.getCell(position) != null) {
                    farm.getCell(position).applyTool(this);
                }
                position.addDirection(direction);
            }
        }
        else if(powerLevel == 3) {
            Vector2 oppositeDirection = new Vector2(position.getY(), position.getX());
            Vector2 goDirection = new Vector2(-oppositeDirection.getX(), -oppositeDirection.getY());
            position.addDirection(oppositeDirection);
            for(int i = 0; i < 3; i++) {
                this.use(farm, position, direction, 2);
                position.addDirection(goDirection);
            }
        }
        else throw new Exception("Invalid power level!");
    }
}
