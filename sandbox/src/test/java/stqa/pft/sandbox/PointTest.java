package stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by nikitatertytskyi on 24.12.17.
 */
public class PointTest {

    @Test
    public void testPoint() {
        Point p1 = new Point(1, 3);
        Point p2 = new Point(4, 2);
        Assert.assertEquals(p1.distance(p2), 3.1622776601683795);
    }

    @Test
    public void testPoint1() {
        Point p1 = new Point(1, 3);
        Assert.assertEquals(p1.distance(p1), 0.0);
    }
}
