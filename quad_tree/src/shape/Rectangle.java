package shape;

public class Rectangle extends Shape implements shwp{
    double a, b;

    public Rectangle(String name, double x, double y, double a, double b) {
        super(name, x, y);
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public String getName() {
        return name;
    }

    @Override
    public Point[] get_points() {
        return new Point[] {
                new Point(x - a / 2, y - b / 2),
                new Point(x + a / 2, y - b / 2),
                new Point(x - a / 2, y + b / 2),
                new Point(x + a / 2, y + b / 2),
        };
    }

    @Override
    public boolean in_bounds(Point point) {
        Point[] points = this.get_points();
        return (point.getX() >= points[0].getX()) && (point.getX() <= points[1].getX()) && (point.getY() >= points[1].getY()) && (point.getY() <= points[3].getY());
    }
}
