package shape;

public class Circle extends Shape {
    double r;

    public Circle(String name, double x, double y, double r) {
        super(name, x, y);
        this.r = r;
    }

    public double getR() {
        return r;
    }

    @Override
    public boolean in_bounds(Point point) {
        return (point.getX() - this.getX()) * (point.getX() - this.getX()) + (point.getY() - this.getY()) * (point.getY() - this.getY()) <= this.getR() * this.getR();
    }

    public boolean circles_overlap(Circle circle) {
        double dist = Math.sqrt((this.getX() - circle.getX()) * (this.getX() - circle.getX()) + (this.getY() - circle.getY()) * (this.getY() - circle.getY()));
        return (dist <= this.getR() - circle.getR() || dist <= circle.getR() - this.getR() || dist <= this.getR() + circle.getR());
    }
}
