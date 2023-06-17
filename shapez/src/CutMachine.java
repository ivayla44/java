import java.util.ArrayList;
import java.util.List;

public class CutMachine extends Machine {
    public CutMachine() {
        super();
    }

    public CutMachine(List<Shape> in, List<Shape> out) {
        super(in, out);
    }

    public void cut(boolean direction) { // false - horizontal, true - vertical
        List<String> segments1 = new ArrayList<String>();
        List<String> segments2 = new ArrayList<String>();

        if(!direction) {
            segments1.add(in.get(0).segments.get(0));
            segments1.add(in.get(0).segments.get(1));
            segments1.add("Empty");
            segments1.add("Empty");

            segments2.add("Empty");
            segments2.add("Empty");
            segments2.add(in.get(0).segments.get(2));
            segments2.add(in.get(0).segments.get(3));
        }
        else {
            segments1.add(in.get(0).segments.get(0));
            segments1.add("Empty");
            segments1.add(in.get(0).segments.get(2));
            segments1.add("Empty");

            segments2.add("Empty");
            segments2.add(in.get(0).segments.get(1));
            segments2.add("Empty");
            segments2.add(in.get(0).segments.get(3));
        }
        Shape shape1 = new Shape(segments1);
        Shape shape2 = new Shape(segments2);
        System.out.println("Shape cut!");
        in.remove(0);
        out.add(shape1);
        out.add(shape2);
    }
}
