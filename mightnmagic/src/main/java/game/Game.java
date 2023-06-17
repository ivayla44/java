package main.java.game;

import main.java.controllers.UserController;
import main.java.map.Map;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> players;
    Player activePlayer;
    Map map;
    CheckForEnd condition;
    UserController userController;

    public Game(int rows, int columns, CheckForEnd condition) {
        this.players = new ArrayList<>();
        this.map = new Map(rows, columns);
        this.condition = condition;
        this.userController = new UserController(activePlayer, map);
    }

    public void addPlayer(Player player) throws Exception {
        if(!this.players.contains(player)) this.players.add(player);
        else throw new Exception("This player already exists!");
    }

    public void startGame() throws Exception {
        if(this.players.isEmpty()) throw new Exception("No players added.");

        int playerIndex = 0;
        do {
            activePlayer = players.get(playerIndex);
            playerIndex++;
            if (playerIndex == players.size()) playerIndex = 0;

            userController.setActivePlayer(activePlayer);
            Thread playerTurn = new Thread(userController);
            playerTurn.start();
            playerTurn.join();

        } while (!this.condition.checkForEnd());

    }

}
