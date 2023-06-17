import java.util.ArrayList;
import java.util.List;

public class Mine {
    List<Shape> out;

    public Mine() {
        this.out = new ArrayList<Shape>();
    }

    public Mine(List<Shape> out) {
        this.out = out;
    }

    public Shape pull() {
        System.out.println("Shape pulled: " + out.get(0).toString());
        Shape shape = out.get(0);
        out.remove(0);
        return shape;
    }

    void generate(List<Integer> not_empty, String colour) {
        List<String> segments = new ArrayList<String>();
        for(int i = 0; i < 4; i++) {
            if(not_empty.contains(i)) segments.add(i, colour);
            else segments.add(i, "Empty");
        }
        Shape shape = new Shape(segments);
        out.add(shape);
        System.out.println("Shape generated: " + out.get(out.size()-1).toString());
    }
}
