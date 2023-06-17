package items;

public abstract class Item {
    String name;

    public Item(String name) {
        this.name = name;
    }

    public abstract void use(Object target) throws Exception;
}
