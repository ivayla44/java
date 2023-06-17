package items;

import monster.Monster;
import player.Player;

public class HealingPotion extends Potion{
    int hpHeal;

    public HealingPotion(String name, int hpHeal) {
        super(name);
        this.hpHeal = hpHeal;
    }

    @Override
    public void use(Object target) throws Exception {
        if(target instanceof Player) ((Player)target).setHp(((Player) target).getHp() + this.hpHeal);
        else throw new Exception("Target of healing potion is not player.");
    }
}
