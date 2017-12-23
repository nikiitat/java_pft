public class MyFirstProgram {

    public static void main(String[] args) {
        System.out.println("Hello, world!");

        Point p1 = new Point(1, 3);
        Point p2 = new Point(4, 2);
        System.out.println("Calling a func: Distance between p1 and p2 = " + distance(p1, p2));
        System.out.println("Calling a method: Distance between p1 and p2 =  " + p1.distance(p2));
        System.out.println("Calling a method: Distance between p2 and p1 =  " + p2.distance(p1));
    }

    public static double distance(Point p1, Point p2) {
        double g = 2;
        double f = (p2.a - p1.a);
        double s = (p2.b - p1.b);
        return Math.sqrt(Math.pow(f, g) + Math.pow(s, g));
    }

}