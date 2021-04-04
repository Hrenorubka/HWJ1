package hometasks.task1.tests;

import hometasks.task1.solutions.MyPoint;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyPointTest extends Assert {
    private final double DELTA = 1e-15;

    double x;
    double y;
    MyPoint objMyPoint;
    @Before
    public void setUpObjPoint()
    {
        x = 1.0d;
        y = 1.0d;
    }

    @Test
    public void testDistanceWithMyPoint()
    {
        objMyPoint = new MyPoint(x, y);
        MyPoint another = new MyPoint(1.0d, 2.0d);
        assertEquals(1.0d, objMyPoint.distance(another), DELTA);
    }

    @Test
    public void testDistanceWithZero()
    {
        objMyPoint = new MyPoint(x, y);
        assertEquals(Math.sqrt(2), objMyPoint.distance(), DELTA);
    }

    @Test
    public void testDistanceWithTwoDouble()
    {
        objMyPoint = new MyPoint(x, y);
        double anotherX = 3.0d;
        double anotherY = 3.0d;
        assertEquals(Math.sqrt(8), objMyPoint.distance(anotherX, anotherY), DELTA);
    }

    @Test
    public void testToString()
    {
        objMyPoint = new MyPoint(x, y);
        assertEquals('(' + ((Double) x).toString() + ", " + ((Double) y).toString() + ')', objMyPoint.toString());
    }
}
