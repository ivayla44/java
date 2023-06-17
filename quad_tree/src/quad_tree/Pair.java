package quad_tree;

import shape.*;

public class Pair {
    Shape shape1;
    Shape shape2;

    public Pair(Shape shape1, Shape shape2) {
        this.shape1 = shape1;
        this.shape2 = shape2;
    }

    @Override
    public String toString() {
        return shape1.toString() + " - " + shape2.toString();
    }
}
