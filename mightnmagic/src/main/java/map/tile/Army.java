package main.java.map.tile;

import main.java.game.Hero;

public class Army extends Tile {
    boolean neutral;
    Hero hero;

    public Army(boolean neutral, Hero hero) {
        this.neutral = neutral;
        this.hero = hero;
    }

    public Hero getHero() {
        return hero;
    }

    public boolean isNeutral() {
        return this.neutral;
    }

    @Override
    public String toString() {
        return "Army{" +
                "neutral=" + neutral +
                ", hero=" + hero.toString() +
                '}';
    }

    @Override
    public void activate(Object entity) throws Exception {
        Hero activeHero = ((Hero) entity);
        if(!neutral) {
            while (activeHero.getArmyPower() != 0 && hero.getArmyPower() != 0) {
                hero.takeDamage(activeHero);
                if(hero.getArmyPower() == 0) {
                    this.hero = activeHero;
                    break;
                }
                activeHero.takeDamage(hero);
                if(activeHero.getArmyPower() == 0) {
                    break;
                }
            }
        }
        // TODO: if army is neutral?
    }
}
