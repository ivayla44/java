package quad_tree;

import shape.*;
import shape.Circle;

import java.util.ArrayList;
import java.util.List;

public class Qt_node {
    String name;
    Rectangle bounds;
    List<Qt_node> nodes;
    List<Shape> shapes;

    public Qt_node(String name, double x1, double x2, double y1, double y2) {
        this.name = name;
        this.bounds = new Rectangle(name, (x1 + x2) / 2, (y1 + y2) / 2, x1 + x2, y1 + y2);
        this.nodes = new ArrayList<Qt_node>(4);
        this.shapes = new ArrayList<Shape>(10);
    }

    public Qt_node(Rectangle bounds) {
        this.name = bounds.getName();
        this.bounds = bounds;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public List<Qt_node> getNodes() {
        return nodes;
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void init_nodes() {
        this.nodes.add(new Qt_node("Node1", this.bounds.getX() - this.bounds.getA() / 2, this.bounds.getX(), this.bounds.getY(), this.bounds.getY() + this.bounds.getB() / 2));
        this.nodes.add(new Qt_node("Node2", this.bounds.getX(), this.bounds.getX() + this.bounds.getA() / 2, this.bounds.getY(), this.bounds.getY() + this.bounds.getB() / 2));
        this.nodes.add(new Qt_node("Node3", this.bounds.getX() - this.bounds.getA() / 2, this.bounds.getX(), this.bounds.getY() - this.bounds.getB() / 2, this.bounds.getY()));
        this.nodes.add(new Qt_node("Node4", this.bounds.getX(), this.bounds.getX() + this.bounds.getA() / 2, this.bounds.getY() - this.bounds.getB() / 2, this.bounds.getY()));
    }

    public void add_shape(Shape elm) {
        if(this.shapes.size() < 10) {
            System.out.println("adding shape");
            this.shapes.add(elm);
        }
        else {
            this.init_nodes();
            for(Shape shape : this.shapes) {
                Point centre = new Point(shape.getX(), shape.getY());
                for(int i = 0; i < 4; i++) {
                    if(this.nodes.get(i).bounds.in_bounds(centre)) {
                        this.nodes.get(i).add_shape(shape);
                    }
                }
            }
            this.shapes.clear();
        }
    }

    public List<Pair> find_overlaps() {
        if(this.nodes.size() == 4) {
            for(Qt_node node : this.nodes) {
                node.find_overlaps();
            }
        }
        List<Pair> pairs = new ArrayList<Pair>();
        for(Shape shape : this.shapes) {
            if (shape instanceof shwp) {
                Point[] points = ((shwp) shape).get_points();
                for (Shape shape2 : this.shapes) {
                    for (Point point : points) {
                        if (shape2.in_bounds(point) && shape != shape2) {
                            if(!pairs.contains(new Pair(shape2, shape))) pairs.add(new Pair(shape, shape2));
                        }
                    }
                }
            } else if (shape instanceof Circle) {
                for (Shape shape2 : this.shapes) {
                    if (shape2 instanceof shwp) {
                        Point[] points = ((shwp) shape2).get_points();
                        for (Point point : points) {
                            if (shape.in_bounds(point)) {
                                if(!pairs.contains(new Pair(shape2, shape))) pairs.add(new Pair(shape, shape2));
                            }
                        }
                    }
                    if (shape2 instanceof Circle) {
                        if (((Circle) shape).circles_overlap((Circle) shape2) && shape != shape2) {
                            if(!pairs.contains(new Pair(shape2, shape))) pairs.add(new Pair(shape, shape2));
                        }
                    }
                }
            }
        }
        return pairs;
    }
}
