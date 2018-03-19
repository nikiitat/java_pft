package stqa.pft.sandbox;

import java.util.*;
import java.util.stream.Collectors;

public class MyFirstProgram {
    static int a = 27;
    static int[] numbers = {10, 6, 15, 4, 8, 20, 2};

    public static void main(String[] args) {
        System.out.println("Hello, world!");
        System.out.println(String
                .format("Let's find the sum of 2 numbers from a given set %s that is closest to %s", Arrays.toString(numbers), a));

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 1; j < numbers.length; j++) {
                ArrayList<Integer> row = new ArrayList<Integer>(Arrays
                        .asList(numbers[i] + numbers[j], numbers[i], numbers[j]));
                matrix.add(row);
            }
        }
        System.out.println("Full matrix" + matrix.toString());
        findSum(matrix, a);
    }

    private static List<Integer> findSum(ArrayList<ArrayList<Integer>> matrix, int a) {
        List<List<Integer>> smaller = new ArrayList<>();
        List<List<Integer>> greater = new ArrayList<>();
        for (List<Integer> list : matrix) {
            if (list.get(0).equals(a)) {
                System.out.println(list.toString());
                return list;
            } else if (list.get(0) - a < 0) {
                smaller.add(list);
            } else if (list.get(0) - a > 0) {
                greater.add(list);
            }
        }
        List<List<Integer>> collect = greater.stream()
                .filter((g) -> g.get(0) == greater.stream().mapToInt((s) -> s.get(0)).min().getAsInt())
                .collect(Collectors.toList());
        List<List<Integer>> collect1 = smaller.stream()
                .filter((g) -> g.get(0) == smaller.stream().mapToInt((s) -> s.get(0)).max().getAsInt())
                .collect(Collectors.toList());

        if (a - collect1.get(0).get(0) < collect.get(0).get(0) - a) {
            System.out.println(String
                    .format("Sum of %s and %s equal %s", collect1.get(0).get(1), collect1.get(0).get(2), collect1.get(0).get(0)));
            return collect1.get(0);
        } else {
            System.out.println(String
                    .format("Sum of %s and %s equal %s", collect.get(0).get(1), collect.get(0).get(2), collect.get(0).get(0)));
            return collect.get(0);
        }

    }

    public static double distance(Point p1, Point p2) {
        //        Point p1 = new Point(1, 3);
//        Point p2 = new Point(4, 2);
//        System.out.println("Calling a func: Distance between p1 and p2 = " + distance(p1, p2));
//        System.out.println("Calling a method: Distance between p1 and p2 =  " + p1.distance(p2));
//        System.out.println("Calling a method: Distance between p2 and p1 =  " + p2.distance(p1));
        double g = 2;
        double f = (p2.a - p1.a);
        double s = (p2.b - p1.b);
        return Math.sqrt(Math.pow(f, g) + Math.pow(s, g));
    }

}