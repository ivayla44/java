package shape;

public abstract class Shape extends Point{
    String name;

    public Shape(String name, double x, double y) {
        super(x, y);
        this.name = name;
    }
   public abstract boolean in_bounds(Point point);

    @Override
    public String toString() {
        return name +
                "(x = " + x +
                ", y = " + y + ")";
    }
}
