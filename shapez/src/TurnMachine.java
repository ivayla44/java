import java.util.ArrayList;
import java.util.List;

public class TurnMachine extends Machine {
    public TurnMachine() {
        super();
    }

    public TurnMachine(List<Shape> in, List<Shape> out) {
        super(in, out);
    }

    public void turn(boolean direction) { // turn left - false, turn right true
        List<String> segments = new ArrayList<String>();
        if(!direction) {
            segments.add(in.get(0).segments.get(1));
            segments.add(in.get(0).segments.get(3));
            segments.add(in.get(0).segments.get(0));
            segments.add(in.get(0).segments.get(2));
        }
        else {
            segments.add(in.get(0).segments.get(2));
            segments.add(in.get(0).segments.get(0));
            segments.add(in.get(0).segments.get(3));
            segments.add(in.get(0).segments.get(1));
        }
        Shape shape = new Shape(segments);
        System.out.println("Shape turned!");
        this.in.remove(0);
        this.out.add(shape);
    }
}