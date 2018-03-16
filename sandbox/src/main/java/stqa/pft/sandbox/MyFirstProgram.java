package stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.List;

public class MyFirstProgram {

    public static void main(String[] args) {
        System.out.println("Hello, world!");

        int[] numbers = {10, 6, 15, 4, 8, 20, 2};
        int a = 27;
        List<Integer> sum = new ArrayList<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 1; j < numbers.length; j++) {
                sum.add(numbers[i] + numbers[j]);
                System.out.println(sum);
            }
        }
//        findSum();

//        Point p1 = new Point(1, 3);
//        Point p2 = new Point(4, 2);
//        System.out.println("Calling a func: Distance between p1 and p2 = " + distance(p1, p2));
//        System.out.println("Calling a method: Distance between p1 and p2 =  " + p1.distance(p2));
//        System.out.println("Calling a method: Distance between p2 and p1 =  " + p2.distance(p1));
    }

    public static int findSum(List<Integer> sum, int a) {
        for (int c : sum) {
            int i = a - c;
            if (i == 0) {
                return i;
            }
        }
        return a;
    }

    public static double distance(Point p1, Point p2) {
        double g = 2;
        double f = (p2.a - p1.a);
        double s = (p2.b - p1.b);
        return Math.sqrt(Math.pow(f, g) + Math.pow(s, g));
    }

}