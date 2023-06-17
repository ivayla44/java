package main.java.controllers;

import main.java.game.Hero;
import main.java.game.Player;
import main.java.map.Map;
import main.java.map.tile.*;

import java.util.ArrayList;
import java.util.List;

public abstract class PlayerController implements Runnable {
    Player activePlayer;
    Map map;
    List<Player> players;

    public PlayerController(Player player, Map map) {
        this.activePlayer = player;
        this.map = map;
        this.players = new ArrayList<>();
    }

    public void setActivePlayer(Player activePlayer) {
        this.activePlayer = activePlayer;
    }

    public Tile findClosest(int x, int y, Tile start, List<Tile> neighbours) {
        Tile closest = null;
        for(Tile neighbour : neighbours) {
            if(!(neighbour instanceof Empty)) continue;
            if(closest == null) closest = neighbour;
            else {
                if(Math.abs(x-neighbour.getX()) <= start.getX() && Math.abs(y-neighbour.getY()) <= start.getY() && Math.abs(x-neighbour.getX()) <= Math.abs(x-closest.getX()) && Math.abs(y-neighbour.getY()) <= Math.abs(y-closest.getX())) {
                    closest = neighbour;
                }
            }
        }
        return closest;
    }

    public List<Tile> findPathTo(Hero hero, int x, int y) throws Exception {
        if((this.map.getTile(x, y) instanceof Wall)) throw new Exception("Tile is not available!");

        Tile start = map.findHero(hero);

        List<Tile> path = new ArrayList<>();

        Tile tryNeighbour = null;

        while(true) {
            List<Tile> neighbours = map.findNeighbours(start.getX(), start.getY());
            if(neighbours.isEmpty()) throw new Exception("Path to this tile isn't available.");

            Tile closest = findClosest(x, y, start, neighbours);

            if(closest != null) tryNeighbour = closest;
            else {
                neighbours.remove(tryNeighbour);
                path.clear();
                closest = findClosest(tryNeighbour.getX(), tryNeighbour.getY(), start, neighbours);
            }
            path.add(closest);

            if(x - closest.getX() == 0 && y - closest.getY() == 0) break;

            // nqma da raboti ama e leko kusno i ne mi se misli :/
            // ideqta e tam prosto shte e hubavo da go napravq rekursivno
        }

        return path;
    }

    public void moveHero(Hero hero, int x, int y) throws Exception {
        if(!activePlayer.getHeroes().contains(hero)) throw new Exception("Hero does not belong to this player!");
        Tile targetTile = map.getTile(x, y); // will return exc if tile doesn't exist
        List<Tile> path = findPathTo(hero, x, y); // same here
        int steps = hero.getStepsPerMove();
        while(steps != 0) {
            path.remove(0);
            if(path.isEmpty()) {
                // remove hero from old tile
                Tile oldTile = map.findHero(hero);
                map.setTile(oldTile.getX(), oldTile.getY(), new Empty());
                if (targetTile instanceof Mine) {
                    targetTile.activate(activePlayer);
                } else targetTile.activate(hero);
                // place hero on target tile
                map.setTile(targetTile.getX(), targetTile.getY(), new Army(true, hero));
            }
            steps--;
        }
    }

    public abstract void startTurn(Player activePlayer);

    @Override
    public void run() {
        this.startTurn(activePlayer);
    }
}
