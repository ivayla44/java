package monster;

import player.Player;
import weapons.Weapon;

public class Monster {
    String name;
    int hp;

    public Monster(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    void takeHit(Player player) {
        this.setHp(this.getHp() - player.getWeapon().getDamage());
        if(player.getWeapon() instanceof weapons.Mele) System.out.println("Monster returns hit");
    };
}
