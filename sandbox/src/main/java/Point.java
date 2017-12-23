/**
 * Created by nikitatertytskyi on 23.12.17.
 */
public class Point {
    double a;
    double b;
    double g = 2;

    public Point(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double distance(Point p) {
        double f = (p.a - this.a);
        double s = (p.b - this.b);
        return Math.sqrt(Math.pow(f, g) + Math.pow(s, g));
    }
}
