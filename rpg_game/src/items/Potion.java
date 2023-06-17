package items;

public class Potion extends Item{
    public Potion(String name) {
        super(name);
    }

    @Override
    public void use(Object target) throws Exception {
        if(this instanceof HealingPotion) {
            ((HealingPotion)this).use(target);
        }
        else ((DamagingPotion)this).use(target);
    }
}
