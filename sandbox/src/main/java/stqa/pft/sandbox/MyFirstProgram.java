package stqa.pft.sandbox;

import java.util.Arrays;
import java.util.List;

public class MyFirstProgram {

    public static void main(String[] args) {
        System.out.println("Hello, world!");

        Point p1 = new Point(1, 3);
        Point p2 = new Point(4, 2);

        List<String> sttttt = Arrays.asList("1", "2", "3", "4");

//        System.out.println(sttttt.stream().);
    }


    public static double distance(Point p1, Point p2) {
        double g = 2;
        double f = (p2.a - p1.a);
        double s = (p2.b - p1.b);
        return Math.sqrt(Math.pow(f, g) + Math.pow(s, g));
    }

}