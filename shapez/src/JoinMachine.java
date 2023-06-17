import java.util.ArrayList;
import java.util.List;

public class JoinMachine extends Machine {
    public JoinMachine() {
        super();
    }

    public JoinMachine(List<Shape> in, List<Shape> out) {
        super(in, out);
    }

    public void join() {
        List<String> segments = new ArrayList<String>();
        String temp;

        for(int i = 0; i < 4; i++) {
            temp = in.get(0).segments.get(i).equals("Empty") ? in.get(1).segments.get(i) : in.get(1).segments.get(i).equals("Empty") ? in.get(0).segments.get(i) : in.get(1).segments.get(i);
            segments.add(temp);
        }

        Shape shape = new Shape(segments);
        System.out.println("Shapes joined!");
        in.remove(0);
        in.remove(0);
        out.add(shape);
    }
}
