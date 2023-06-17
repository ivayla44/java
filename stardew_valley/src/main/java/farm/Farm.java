package main.java.farm;

import main.java.Vector2;

public class Farm {
    private Tile[][] farm;

    public Farm() {
        this.farm = new Tile[10][10];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                farm[i][j] = new Tile();
            }
        }
    }

    public Tile getCell(Vector2 position) throws Exception {
        if(position.getX() < 0 || position.getX() > 9 || position.getY() < 0 || position.getY() > 9) {
            return null;
        }
        else return farm[position.getX()][position.getY()];
    }
}
