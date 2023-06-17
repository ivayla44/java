import java.util.ArrayList;
import java.util.List;

public class Shape {
    List<String> segments; // 0 up left, 1 up right, 2 down left, 3 down right

    public Shape(String[] segments) {
        this.segments = new ArrayList<String>();
        this.segments.addAll(List.of(segments));
    }

    public Shape(List<String> segments) {
        this.segments = segments;
    }

    public List<String> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "segments = " + segments +
                '}';
    }
}