package shape;

import java.awt.Polygon;

public class Trapezoid extends Shape implements shwp{
    double a, b, h;

    public Trapezoid(String name, double x, double y, double a, double b, double h) {
        super(name, x, y);
        this.a = a;
        this.b = b;
        this.h = h;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getH() {
        return h;
    }

    @Override
    public Point[] get_points() {
        return new Point[] {
                new Point(x - (a + b) / 4, y - h / 2),
                new Point((x - (a + b) / 4) + b, y - h / 2),
                new Point(x - (a + b) / 4, y + h / 2),
                new Point((x - (a + b) / 4) + a, y + h / 2)
        };
    }

    @Override // znam, che nqma da raboti v nqkoi sluchai, poneje double-ite se cast-vat kum int-ove ama mozukut mi e tvurde izpurjen che da go mislq kak da stane
    public boolean in_bounds(Point point) {
        Polygon polygon = new Polygon();
        Point[] points = this.get_points();
        polygon.addPoint((int)points[0].getX(), (int)points[0].getY());
        polygon.addPoint((int)points[1].getX(), (int)points[1].getY());
        polygon.addPoint((int)points[2].getX(), (int)points[2].getY());
        polygon.addPoint((int)points[3].getX(), (int)points[3].getY());
        return polygon.contains(new java.awt.Point((int)point.getX(), (int)point.getY()));
    }
}
