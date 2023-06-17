import quad_tree.*;
import shape.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Qt_node root = new Qt_node("root", -1000, +1000, -1000, +1000);
//        String filepath = "file.txt";
//        try {
//            FileInputStream fis = new FileInputStream(filepath);
//            Scanner sc = new Scanner(fis);
//            int sq_i = 1, rect_i = 1, trap_i = 1, circ_i = 1;
//            while(sc.hasNext()) {
//                String type = sc.nextLine();
//                switch (type) {
//                    case "square" -> {
//                        double x, y, a;
//                        x = sc.nextDouble();
//                        y = sc.nextDouble();
//                        a = sc.nextDouble();
//
//                        root.add_shape(new Square("square" + sq_i, x, y, a));
//                        sq_i++;
//                    }
//                    case "rectangle" -> {
//                        double x, y, a, b;
//                        x = sc.nextDouble();
//                        y = sc.nextDouble();
//                        a = sc.nextDouble();
//                        b = sc.nextDouble();
//
//                        root.add_shape(new Rectangle("rectangle" + rect_i, x, y, a, b));
//                        rect_i++;
//                    }
//                    case "circle" -> {
//                        double x, y, r;
//                        x = sc.nextDouble();
//                        y = sc.nextDouble();
//                        r = sc.nextDouble();
//
//                        root.add_shape(new Circle("circle" + circ_i, x, y, r));
//                        circ_i++;
//                    }
//                    case "trapezoid" -> {
//                        double x, y, a, b, h;
//                        x = sc.nextDouble();
//                        y = sc.nextDouble();
//                        a = sc.nextDouble();
//                        b = sc.nextDouble();
//                        h = sc.nextDouble();
//
//                        root.add_shape(new Trapezoid("trapezoid" + trap_i, x, y, a, b, h));
//                        trap_i++;
//                    }
//                }
//            }
//  ne bachka s file, ne sum sigurna tochno zashto

            root.add_shape(new Square("square1", 7.5, 7.5, 5));
            root.add_shape(new Rectangle("rectangle1", 2.5, 5, 6, 3));
            root.add_shape(new Circle("circle1", 0, 7, 3));

            List<Pair> pairs = root.find_overlaps();
            for(Pair pair : pairs) {
                System.out.println(pair.toString());
            }
//        }
//        catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}