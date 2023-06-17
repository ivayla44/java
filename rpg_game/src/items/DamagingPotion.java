package items;

import monster.Monster;

public class DamagingPotion extends Potion{
    int hpDamage;

    public DamagingPotion(String name, int hpDamage) {
        super(name);
        this.hpDamage = hpDamage;
    }

    @Override
    public void use(Object target) throws Exception {
        if(target instanceof Monster) ((Monster)target).setHp(((Monster) target).getHp() - this.hpDamage);
        else throw new Exception("Target of damaging potion is not monster.");
    }
}
