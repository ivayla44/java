package shape;

public class Square extends Rectangle{
    double a;

    public Square(String name, double x, double y, double a) {
        super(name, x, y, a, a);
    }
}
