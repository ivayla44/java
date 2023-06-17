import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Mine mine = new Mine();
        TurnMachine turnMachine = new TurnMachine();
        CutMachine cutMachine = new CutMachine();
        JoinMachine joinMachine = new JoinMachine();

        Shape shape0 = new Shape(new String[]{"Green", "Blue", "Empty", "Empty"});
        Shape shape1 = new Shape(new String[]{"Green", "Red", "Blue", "Yellow"});
        Shape shape2 = new Shape(new String[]{"Green", "Empty", "Blue", "Empty"});
        Shape shape3 = new Shape(new String[]{"Empty", "Red", "Empty", "Yellow"});

        turnMachine.push(shape1);
        turnMachine.turn(false);
        Shape shape4 = turnMachine.pull();

        turnMachine.push(shape1);
        turnMachine.turn(true);
        Shape shape5 = turnMachine.pull();

        cutMachine.push(shape1);
        cutMachine.cut(false);
        Shape shape6 = cutMachine.pull();
        Shape shape7 = cutMachine.pull();

        cutMachine.push(shape1);
        cutMachine.cut(true);
        Shape shape8 = cutMachine.pull();
        Shape shape9 = cutMachine.pull();

        joinMachine.push(shape2);
        joinMachine.push(shape3);
        joinMachine.join();
        Shape shape10 = joinMachine.pull();

        joinMachine.push(shape0);
        joinMachine.push(shape3);
        joinMachine.join();
        Shape shape11 = joinMachine.pull();

        System.out.println("\n");

        List<Integer> int1 = new ArrayList<Integer>();
        int1.add(0); int1.add(1); int1.add(2);
        List<Integer> int2 = new ArrayList<Integer>();
        int2.add(1); int2.add(2);
        List<Integer> int3 = new ArrayList<Integer>();
        int3.add(1); int3.add(3);
        List<Integer> int4 = new ArrayList<Integer>();
        int4.add(3);

        mine.generate(int1, "Green");
        mine.generate(int2, "Red");
        mine.generate(int3, "Blue");
        mine.generate(int4, "Yellow");

        Shape green = mine.pull();
        Shape red = mine.pull();
        Shape blue = mine.pull();
        Shape yellow = mine.pull();

        turnMachine.push(blue);
        turnMachine.turn(true);
        joinMachine.push(blue);
        joinMachine.push(turnMachine.pull());
        joinMachine.join();
        joinMachine.push(green);
        joinMachine.push(joinMachine.pull());
        joinMachine.join();
        joinMachine.push(joinMachine.pull());
        joinMachine.push(yellow);
        joinMachine.join();
        Shape first_shape = joinMachine.pull(); // rotate twice and it will be right side up

        turnMachine.push(red);
        turnMachine.turn(false);
        joinMachine.push(red);
        joinMachine.push(turnMachine.pull());
        joinMachine.join();
        Shape red2 = joinMachine.pull();
        turnMachine.push(yellow);
        turnMachine.turn(false);
        joinMachine.push(yellow);
        joinMachine.push(turnMachine.pull());
        joinMachine.join();
        joinMachine.push(red2);
        joinMachine.push(joinMachine.pull());
        joinMachine.join();
        Shape second_shape = joinMachine.pull();

        joinMachine.push(green);
        joinMachine.push(red);
        joinMachine.join();
        turnMachine.push(blue);
        turnMachine.turn(true);
        joinMachine.push(joinMachine.pull());
        joinMachine.push(turnMachine.pull());
        joinMachine.join();
        joinMachine.push(joinMachine.pull());
        joinMachine.push(yellow);
        joinMachine.join();
        Shape third_shape = joinMachine.pull();

        turnMachine.push(red);
        turnMachine.turn(false);
        joinMachine.push(green);
        joinMachine.push(turnMachine.pull());
        joinMachine.join();
        joinMachine.push(joinMachine.pull());
        joinMachine.push(yellow);
        joinMachine.join();
        Shape fourth_shape = joinMachine.pull(); // rotate twice and it will be right side up
    }
}