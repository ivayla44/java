package main.java.controllers;

import main.java.game.Hero;
import main.java.game.Player;
import main.java.map.Map;
import main.java.map.tile.Tile;

import java.util.Scanner;

import static java.lang.System.exit;

public class UserController extends PlayerController {
    public UserController(Player player, Map map) {
        super(player, map);
    }

    @Override
    public void startTurn(Player activePlayer) {
        Scanner scanner = new Scanner(System.in);
        String[] options = {"1. Select hero", "2. View hero", "3. Move hero", "4. View cell", "5. View self", "6. View player", "7. End turn"};
        System.out.println("Please enter the number of the action you want:");

        Hero activeHero = activePlayer.getHeroes().get(0);

        int option = 0;
        while(option != 7) {
            for(String eachOpt : options) {
                System.out.println(eachOpt);
            }
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1 -> {
                        for(Hero playerHeroes : activePlayer.getHeroes()) {
                            System.out.println(playerHeroes.toString());
                        }
                        System.out.println("Please enter the index of the hero you want to activate (0 - n): ");
                        int selection = scanner.nextInt();
                        activeHero = activePlayer.getHeroes().get(selection);
                    }

                    case 2 -> System.out.println("The current active hero is " + activeHero.toString());

                    case 3 -> {
                        System.out.println("Please enter the coordinates to which you want to move the active hero: ");
                        System.out.println("Enter X value: ");
                        int x = scanner.nextInt();
                        System.out.println("Enter Y value: ");
                        int y = scanner.nextInt();
                        this.moveHero(activeHero, x, y);
                    }

                    case 4 -> {
                        System.out.println("Please enter the coordinates of the cell you want to view the contents of: ");
                        System.out.println("Enter X value: ");
                        int x = scanner.nextInt();
                        System.out.println("Enter Y value: ");
                        int y = scanner.nextInt();
                        Tile tile = map.getTile(x, y);
                        System.out.println(tile.toString());
                    }

                    case 5 -> {
                        System.out.println(activePlayer.toString());
                        System.out.println("heroes=");
                        for(Hero playerHeroes : activePlayer.getHeroes()) {
                            System.out.println(playerHeroes.toString());
                        }
                    }

                    case 6 -> {
                        System.out.println("Please enter the index of the player you want to view (0 - n):");
                        for(Player player : this.players) {
                            System.out.println(player.getName());
                        }
                        int index = scanner.nextInt();
                        System.out.println(this.players.get(index).toString());
                        System.out.println("heroes=");
                        for(Hero hero : players.get(index).getHeroes()) {
                            System.out.println(hero.toString());
                        }
                    }

                    case 7 -> exit(0);
                }
            } catch (Exception e) {
                System.out.println("Wrong input! Please enter valid command (1 - 7)");
                this.startTurn(activePlayer);
            }
        }
    }
}
