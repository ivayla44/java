import java.util.ArrayList;
import java.util.List;

public class Machine {
    List<Shape> in;
    List<Shape> out;

    public Machine() {
        this.in = new ArrayList<Shape>();
        this.out = new ArrayList<Shape>();
    }

    public Machine(List<Shape> in, List<Shape> out) {
        this.in = in;
        this.out = out;
    }

    public void push(Shape shape) {
        in.add(shape);
        System.out.println("Shape pushed: " + in.get(in.size()-1).toString());
    }

    public Shape pull() {
        System.out.println("Shape pulled: " + out.get(0).toString());
        Shape shape = out.get(0);
        out.remove(0);
        return shape;
    }
}