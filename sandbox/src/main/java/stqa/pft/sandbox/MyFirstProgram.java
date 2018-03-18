package stqa.pft.sandbox;

import java.util.*;
import java.util.stream.Collectors;

public class MyFirstProgram {

    public static void main(String[] args) {
        System.out.println("Hello, world!");

        int[] numbers = {10, 6, 15, 4, 8, 20, 2};
        int a = 27;
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
//        List<int[]> matrix = new ArrayList<>();

        System.out.println(matrix.toString());
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 1; j < numbers.length; j++) {
                ArrayList<Integer> row = new ArrayList<Integer>(Arrays
                        .asList(numbers[i] + numbers[j], numbers[i], numbers[j]));
                matrix.add(row);
            }
        }
        System.out.println(matrix.toString());
        findSum(matrix, a);

//        Point p1 = new Point(1, 3);
//        Point p2 = new Point(4, 2);
//        System.out.println("Calling a func: Distance between p1 and p2 = " + distance(p1, p2));
//        System.out.println("Calling a method: Distance between p1 and p2 =  " + p1.distance(p2));
//        System.out.println("Calling a method: Distance between p2 and p1 =  " + p2.distance(p1));
    }

    private static List<Integer> findSum(ArrayList<ArrayList<Integer>> matrix, int a) {
        List<List<Integer>> m = new ArrayList<>();
        List<List<Integer>> p = new ArrayList<>();
        for (List<Integer> list : matrix) {
            if (list.get(0).equals(a)) {
                return list;
            } else if (list.get(0) - a < 0) {
                m.add(list);
            } else if (list.get(0) - a > 0) {
                p.add(list);
            }
        }
        System.out.println(p.toString());
        int max = m.stream().mapToInt((g) -> g.get(0)).max().getAsInt();
        int min = p.stream().mapToInt((g) -> g.get(0)).min().getAsInt();
        System.out.println(min + "sss");
        System.out.println(max + "sss");
        List<List<Integer>> collect = p.stream().filter((g) -> g.get(0).equals(min)).collect(Collectors.toList());
        List<List<Integer>> collect1 = m.stream().filter((g) -> g.get(0).equals(max)).collect(Collectors.toList());


        List<List<Integer>> collect2 = new ArrayList<>();
        collect2.add(collect.get(0));
        collect2.add(collect1.get(0));
        System.out.println(collect.get(0) + "+" + collect1.get(0));
        return collect2.get(0);
    }

    public static double distance(Point p1, Point p2) {
        double g = 2;
        double f = (p2.a - p1.a);
        double s = (p2.b - p1.b);
        return Math.sqrt(Math.pow(f, g) + Math.pow(s, g));
    }

}