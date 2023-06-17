package main.java.map;

import main.java.game.Hero;
import main.java.map.tile.Empty;
import main.java.map.tile.Tile;

import java.util.ArrayList;
import java.util.List;

public class Map {
    int rows;
    int columns;
    Tile[][] grid;

    public Map(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.grid = new Tile[rows][columns];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(i % 2 == 1 && j == columns - 1) {
                    this.grid[i][j] = null;
                }
                else this.grid[i][j] = new Empty();
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public boolean checkTile(int x, int y) {
        return this.grid[x][y] != null;
    }

    public Tile findHero(Hero hero) throws Exception {
        Tile at = null;

        for(int i = 0; i < this.getRows(); i++) {
            for(int j = 0; j < this.getColumns(); j++) {
                if(this.getTile(i, j).containsHero(hero)) {
                    at = this.getTile(i, j);
                }
            }
        }
        if(at == null) throw new Exception("Hero isn't on the map.");
        else return at;
    }

    public List<Tile> findNeighbours(int x, int y) throws Exception {
        List<Tile> neighbours = new ArrayList<>();
        if(this.checkTile(x+1, y+1)) neighbours.add(this.getTile(x+1, y));
        if(this.checkTile(x+1, y+1)) neighbours.add(this.getTile(x+1, y+1));
        if(this.checkTile(x+1, y+1)) neighbours.add(this.getTile(x, y-1));
        if(this.checkTile(x+1, y+1)) neighbours.add(this.getTile(x, y+1));
        if(this.checkTile(x+1, y+1)) neighbours.add(this.getTile(x-1, y));
        if(this.checkTile(x+1, y+1)) neighbours.add(this.getTile(x-1, y+1));
        return neighbours;
    }

    public Tile getTile(int x, int y) throws Exception {
        if(this.grid[x][y] != null) {
            return this.grid[x][y];
        }
        else throw new Exception("Tile coordinates invalid!");
    }

    public void setTile(int x, int y, Tile tileType) throws Exception {
        if(this.grid[x][y] == null) throw new Exception("Tile coordinates invalid!");
        else this.grid[x][y] = tileType;
    }

}
